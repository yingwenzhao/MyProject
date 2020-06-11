package dao;

import model.NotifyReceiveDo;

public interface NotifyReceiveDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyReceiveDo record);

    int insertSelective(NotifyReceiveDo record);

    NotifyReceiveDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyReceiveDo record);

    int updateByPrimaryKey(NotifyReceiveDo record);
}