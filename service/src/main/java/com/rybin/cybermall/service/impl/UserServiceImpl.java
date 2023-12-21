package com.rybin.cybermall.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.ResultVO;
import com.rybin.cybermall.beans.entity.Users;
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
        Users user = userDAO.selectOne(new QueryWrapper<Users>().eq("username", username));

        if (user == null) {
            user = new Users(
                    username,
                    // 用md5加密密码再存储到数据库
                    MD5Utils.md5(password),
                    "img/default.png",
                    new Date(),
                    new Date()
            );
            if (userDAO.insert(user) > 0) {
                return new ResultVO(ResponseStatus.SUCCESS, "注册成功", user);
            } else {
                return new ResultVO(ResponseStatus.FAIL, "注册失败", null);
            }
        } else {
            return new ResultVO(ResponseStatus.FAIL, "用户名已存在", null);
        }
    }

    @Override
    public ResultVO userLogin(String username, String password) {
        Users user = userDAO.selectOne(new QueryWrapper<Users>().eq("username", username));
        if (user == null) {
            return new ResultVO(ResponseStatus.FAIL, "用户名不存在", null);
        } else {
            if (user.getPassword().equals(MD5Utils.md5(password))) {
                // 如果登陆成功，使用jwt生成验证token
                String token = JWT.create() // 获取builder
                        .withSubject(username) // 设置token携带的数据
                        .withJWTId(user.getUserId() + "") // 设置token id
                        .withIssuedAt(new Date()) // 设置签发时间
                        .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 设置到期时间
                        .sign(Algorithm.HMAC256("cybermall")); // 设置解密的密码并生成token

                return new ResultVO(ResponseStatus.SUCCESS, token, user);
            } else {
                return new ResultVO(ResponseStatus.FAIL, "密码不正确", null);
            }
        }
    }
}
