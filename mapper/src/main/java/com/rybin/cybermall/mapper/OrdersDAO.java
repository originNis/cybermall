package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersDAO extends BaseMapper<Orders> {
}
