package dao;

import model.PayInstructionDefDo;

public interface PayInstructionDefDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayInstructionDefDo record);

    int insertSelective(PayInstructionDefDo record);

    PayInstructionDefDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PayInstructionDefDo record);

    int updateByPrimaryKey(PayInstructionDefDo record);
}