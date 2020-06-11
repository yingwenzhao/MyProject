package com.jintang.schedule;

import com.jintang.daoservice.ScheduleTaskDoMapperService;
import com.jintang.exception.DBException;
import constants.ScheduleStatusEnum;
import constants.SysCodeConstants;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import model.ScheduleTaskDo;
import org.springframework.util.CollectionUtils;
import com.jintang.process.Process;
import util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Setter
public class ScheduleTaskHandler {

    private ScheduleTaskDoMapperService scheduleTaskDoMapperService;
    private Map<String, Process<ScheduleTaskDo, Boolean>> scheduleTaskProcessMap;

    public void handlerScheduleTask(String hostName) {
        List<ScheduleTaskDo> scheduleTaskDos = null;
        try {
            scheduleTaskDos = scheduleTaskDoMapperService.lockScheduleTask(hostName);
        } catch (DBException e) {
            return;
        }

        if (CollectionUtils.isEmpty(scheduleTaskDos)) {
            return;
        }

        for (ScheduleTaskDo task : scheduleTaskDos) {
            boolean executeStatus = false;

            Process<ScheduleTaskDo, Boolean> taskProcess = scheduleTaskProcessMap.get(task.getTaskType());
            if (taskProcess != null) {

                try {
                    ScheduleContext scheduleContext = new ScheduleContext();
                    scheduleContext.setReqBean(task);

                    taskProcess.process(scheduleContext);

                    if (SysCodeConstants.SUCCESS.getCode().equals(scheduleContext.getRespCode())) {
                        executeStatus = true;
                    }
                } catch (Exception e) {
                    log.error("======", e);
                    executeStatus = false;
                }

                updateScheduleTaskStatus(executeStatus, task);

            } else {
                //Cat
                continue;
            }


        }

    }

    void updateScheduleTaskStatus(boolean executeStatus, ScheduleTaskDo task) {

        try {
            task.setUpdateTime(new Date());
            task.setLastRunTime(task.getNextRunTime());

            if (task.getScheduleTimes() == -1) {


                task.setScheduleStatus(ScheduleStatusEnum.INIT.getCode());
                int nextRunInterval = Integer.parseInt(task.getNextRunInterval());//定时任务一般间隔一天 即86400秒
                task.setNextRunTime(DateUtil.addSeconds(task.getNextRunTime(), nextRunInterval));
                String formatDate = DateUtil.format(new Date(), "yyyyMMdd");
                if (executeStatus) {
                    task.setExt(formatDate + "任务执行成功");
                } else {
                    //Cat
                    task.setExt(formatDate + "任务执行失败");
                }


            } else {

                if (executeStatus) {


                    task.setScheduleStatus(ScheduleStatusEnum.SUCCESS.getCode());
                    task.setScheduleDone(task.getScheduleDone() + 1);


                } else {

                    //最大执行次数
                    Integer maxSchedule = task.getScheduleTimes();
                    Integer times = task.getScheduleDone();


                    if (times + 1 >= maxSchedule) {


                        //Cat告警到达最大执行次数还没成功
                        task.setScheduleStatus(ScheduleStatusEnum.STOP.getCode());
                        task.setNextRunTime(new Date());
                        task.setScheduleDone(task.getScheduleDone() + 1);


                    } else {


                        String[] split = task.getNextRunInterval().split(",");//重试间隔时间
                        int nextUpdateTime;
                        if (times > (split.length - 1)) {
                            nextUpdateTime = Integer.parseInt(split[split.length - 1]);
                        } else {
                            nextUpdateTime = Integer.parseInt(split[times]);
                        }
                        task.setScheduleStatus(ScheduleStatusEnum.WAIT_RETRY.getCode());
                        task.setNextRunTime(DateUtil.addSeconds(task.getLastRunTime(), nextUpdateTime));
                        task.setScheduleDone(task.getScheduleDone() + 1);


                    }
                }
            }
            scheduleTaskDoMapperService.updateByPrimaryKey(task);
        } catch (Exception e) {
            log.error("----------",e);
        }

    }

}
