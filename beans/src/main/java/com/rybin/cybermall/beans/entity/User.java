package com.rybin.cybermall.beans.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 该注解代替了swagger的@ApiModel
@Schema(name = "User", description = "用户的信息")
/* 该注解告诉MyBatis这个实体类对应数据库哪张表，
   如果没有该注解，则MyBatis将实体类名当做表名
 */
@TableName("users")
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String nickname;
    private String realname;
    private String userImg;
    private String userMobile;
    private String userEmail;
    private String userSex;
    private Date userBirth;
    private Date userRegtime;
    private Date userModtime;

    public User(String username, String password, String userImg, Date userRegtime, Date userModtime) {
        this.username = username;
        this.password = password;
        this.userImg = userImg;
        this.userRegtime = userRegtime;
        this.userModtime = userModtime;
    }
}
