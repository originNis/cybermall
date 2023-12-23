package com.rybin.cybermall.beans.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 用户 
 * </p>
 *
 * @author rybin
 * @since 2023-12-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// 该注解代替了swagger的@ApiModel
@Schema(name = "Users", description = "用户的信息")
/* 该注解告诉MyBatis这个实体类对应数据库哪张表，
   如果没有该注解，则MyBatis将实体类名当做表名
 */
@TableName("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名 用户名
     */
    private String username;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 昵称 昵称
     */
    private String nickname;

    /**
     * 真实姓名 真实姓名
     */
    private String realname;

    /**
     * 头像 头像
     */
    private String userImg;

    /**
     * 手机号 手机号
     */
    private String userMobile;

    /**
     * 邮箱地址 邮箱地址
     */
    private String userEmail;

    /**
     * 性别 M(男) or F(女)
     */
    private String userSex;

    /**
     * 生日 生日
     */
    private Date userBirth;

    /**
     * 注册时间 创建时间
     */
    private Date userRegtime;

    /**
     * 更新时间 更新时间
     */
    private Date userModtime;

    public Users(String username, String password, String userImg, Date userRegtime, Date userModtime) {
        this.username = username;
        this.password = password;
        this.userImg = userImg;
        this.userRegtime = userRegtime;
        this.userModtime = userModtime;
    }
}
