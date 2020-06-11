package dao;

import model.NotifySendModel;

public interface NotifySendModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifySendModel record);

    int insertSelective(NotifySendModel record);

    NotifySendModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifySendModel record);

    int updateByPrimaryKey(NotifySendModel record);
}