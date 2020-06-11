package dao;

import model.PaytoolsDo;

public interface PaytoolsDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaytoolsDo record);

    int insertSelective(PaytoolsDo record);

    PaytoolsDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaytoolsDo record);

    int updateByPrimaryKey(PaytoolsDo record);
}