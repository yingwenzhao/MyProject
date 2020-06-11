package dao;

import model.PaymentRouteCfgDo;

public interface PaymentRouteCfgDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaymentRouteCfgDo record);

    int insertSelective(PaymentRouteCfgDo record);

    PaymentRouteCfgDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaymentRouteCfgDo record);

    int updateByPrimaryKey(PaymentRouteCfgDo record);
}