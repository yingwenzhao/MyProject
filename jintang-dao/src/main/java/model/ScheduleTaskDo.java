package model;

import java.util.Date;

public class ScheduleTaskDo {
    private Long id;

    private String taskType;

    private String scheduleStatus;

    private Integer scheduleTimes;

    private Integer scheduleDone;

    private Date lastRunTime;

    private Date nextRunTime;

    private String machine;

    private String ext;

    private String nextRunInterval;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus == null ? null : scheduleStatus.trim();
    }

    public Integer getScheduleTimes() {
        return scheduleTimes;
    }

    public void setScheduleTimes(Integer scheduleTimes) {
        this.scheduleTimes = scheduleTimes;
    }

    public Integer getScheduleDone() {
        return scheduleDone;
    }

    public void setScheduleDone(Integer scheduleDone) {
        this.scheduleDone = scheduleDone;
    }

    public Date getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(Date lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public Date getNextRunTime() {
        return nextRunTime;
    }

    public void setNextRunTime(Date nextRunTime) {
        this.nextRunTime = nextRunTime;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }

    public String getNextRunInterval() {
        return nextRunInterval;
    }

    public void setNextRunInterval(String nextRunInterval) {
        this.nextRunInterval = nextRunInterval == null ? null : nextRunInterval.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}