package com.cn.lx.excel.dao;

import com.cn.lx.excel.entity.User;
import org.jboss.logging.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertUsers(List<User> users);

}