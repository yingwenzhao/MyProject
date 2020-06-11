package dao;

import model.PayInstructionDo;

public interface PayInstructionDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayInstructionDo record);

    int insertSelective(PayInstructionDo record);

    PayInstructionDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PayInstructionDo record);

    int updateByPrimaryKey(PayInstructionDo record);
}