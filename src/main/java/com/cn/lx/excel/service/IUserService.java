package com.cn.lx.excel.service;

import com.cn.lx.excel.entity.User;

import java.util.List;

/**
 * @author StevenLu
 * @date 2019-09-16 13:52
 */
public interface IUserService {

    int insert (User user);

    int insertUsers(List<User> users);
}
