package com.cn.lx.excel.service.impl;

import com.cn.lx.excel.dao.UserMapper;
import com.cn.lx.excel.entity.User;
import com.cn.lx.excel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-09-16 14:07
 */
@Service
public class IUserServiceImpl  implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int insertUsers(List<User> users) {
        return userMapper.insertUsers(users);
    }
}
