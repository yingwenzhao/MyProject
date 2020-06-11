package com.jintang.daoservice;

import com.jintang.exception.DBException;
import model.ScheduleTaskDo;

import java.util.List;

public interface ScheduleTaskDoMapperService {

    List<ScheduleTaskDo> lockScheduleTask(String threadNo) throws DBException;

    int updateByPrimaryKey(ScheduleTaskDo taskDo) throws DBException;

}
