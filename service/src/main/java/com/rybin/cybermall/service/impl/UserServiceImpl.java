package com.rybin.cybermall.service.impl;

import com.rybin.cybermall.beans.ResultVO;
import com.rybin.cybermall.beans.entity.User;
import com.rybin.cybermall.mapper.UserDAO;
import com.rybin.cybermall.service.UserService;
import com.rybin.cybermall.utils.MD5Utils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    @Transactional
    public ResultVO userRegist(String username, String password) {
        User user = userDAO.queryUserByName(username);

        if (user == null) {
            user = new User(
                    username,
                    // 用md5加密密码再存储到数据库
                    MD5Utils.md5(password),
                    "img/default.png",
                    new Date(),
                    new Date()
            );
            if (userDAO.insertUser(user) > 0) {
                return new ResultVO(10000, "注册成功", null);
            } else {
                return new ResultVO(10001, "注册失败", null);
            }
        } else {
            return new ResultVO(10002, "用户名已存在", null);
        }
    }

    @Override
    public ResultVO userLogin(String username, String password) {
        User user = userDAO.queryUserByName(username);
        if (user == null) {
            return new ResultVO(10002, "用户名不存在", null);
        } else {
            if (user.getPassword().equals(MD5Utils.md5(password))) {
                return new ResultVO(10004, "登录成功", null);
            } else {
                return new ResultVO(10003, "密码不正确", null);
            }
        }
    }
}
