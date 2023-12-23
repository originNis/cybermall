package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.entity.Users;
import org.apache.ibatis.annotations.Mapper;


/*
    MP提供了BaseMapper<T>并内置了一些增删改查的通用方法，
    只需要继承它就能方便地使用，极大地简化了编写SQL语句的
    工作。
 */
@Mapper
public interface UserDAO extends BaseMapper<Users> {
}
