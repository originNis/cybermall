package com.rybin.cybermall.mapper;

import com.rybin.cybermall.beans.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDAO {
    // 用户注册
    @Insert("""
        INSERT users(username, password, user_img, user_regtime, user_modtime)
            VALUES (#{username}, #{password}, #{userImg}, #{userRegtime}, #{userModtime})
    """)
    public int insertUser(User user);

    // 根据用户名查询用户信息
    @Select("""
        SELECT * FROM users WHERE username = #{username}
    """)
    public User queryUserByName(String username);
}
