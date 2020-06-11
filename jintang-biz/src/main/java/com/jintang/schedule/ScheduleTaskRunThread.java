package com.jintang.schedule;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import util.HostUtil;
import util.OpsUtil;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ScheduleTaskRunThread implements Runnable {

    private ScheduleTaskHandler scheduleTaskHandler;
    @Setter
    private boolean status;

    public ScheduleTaskRunThread(ScheduleTaskHandler scheduleTaskHandler, boolean status) {
        this.scheduleTaskHandler = scheduleTaskHandler;
        this.status = status;
    }

    void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error(this.toString(), e);
        }
    }


    @Override
    public void run() {
        log.info("ScheduleTaskRunThread run ----------");
        while (status) {
            try {
                String hostName = HostUtil.getHostName();
                String allRunSwitch = OpsUtil.getOpsConfig("allRunSwitch");
                String allRunMachines = OpsUtil.getOpsConfig("allRunMachines");
                List<String> allRunMachinesList = Arrays.asList(StringUtils.split(allRunMachines, ","));

                if ("Y".equals(allRunSwitch) || allRunMachinesList.contains(hostName)) {
                    scheduleTaskHandler.handlerScheduleTask(hostName);
                }

                sleep(Long.parseLong(OpsUtil.getOpsConfig("SLEEP_TIME")));//默认1000
            } catch (Exception e) {
                log.error("当前调度失败");
                sleep(Long.parseLong(OpsUtil.getOpsConfig("ERROR_SLEEP_TIME")));//默认2000
            }

        }
    }
}
