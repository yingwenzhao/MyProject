package dao;

import model.ScheduleTaskDo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ScheduleTaskDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ScheduleTaskDo record);

    int insertSelective(ScheduleTaskDo record);

    ScheduleTaskDo selectByPrimaryKey(Long id);

    List<ScheduleTaskDo> lockScheduleTask(@Param("delayTime")Date delayTime,@Param("batchCount") Integer batchCount);

    int updateByPrimaryKeySelective(ScheduleTaskDo record);

    int updateByPrimaryKey(ScheduleTaskDo record);
}