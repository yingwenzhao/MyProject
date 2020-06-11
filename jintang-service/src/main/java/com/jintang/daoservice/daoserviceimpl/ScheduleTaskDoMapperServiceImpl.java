package com.jintang.daoservice.daoserviceimpl;

import com.jintang.daoservice.ScheduleTaskDoMapperService;
import com.jintang.exception.DBException;
import dao.ScheduleTaskDoMapper;
import lombok.extern.slf4j.Slf4j;
import model.ScheduleTaskDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.OpsUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ScheduleTaskDoMapperServiceImpl implements ScheduleTaskDoMapperService {

    @Autowired
    private ScheduleTaskDoMapper scheduleTaskDoMapper;

    @Transactional(transactionManager = "transactionManager")
    public List<ScheduleTaskDo> lockScheduleTask(String threadNo) throws DBException {

        String batchCount = OpsUtil.getOpsConfig("batchCount");

        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.MINUTE,-1);

        try {
            List<ScheduleTaskDo> scheduleTaskDos = scheduleTaskDoMapper.lockScheduleTask(instance.getTime(), Integer.parseInt(batchCount));
            Date now = new Date();
            scheduleTaskDos.forEach((std)->{
                std.setScheduleStatus("1");
                std.setMachine(threadNo);
                std.setUpdateTime(now);
                scheduleTaskDoMapper.updateByPrimaryKey(std);
            });
            return scheduleTaskDos;
        } catch (Exception e) {
            log.error("{}===error{}",this,e);
            throw new DBException();
        }
    }

    @Override
    public int updateByPrimaryKey(ScheduleTaskDo taskDo) throws DBException {
        return scheduleTaskDoMapper.updateByPrimaryKey(taskDo);
    }


}
