package dao;

import model.PaymentDo;

public interface PaymentDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaymentDo record);

    int insertSelective(PaymentDo record);

    PaymentDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaymentDo record);

    int updateByPrimaryKey(PaymentDo record);
}