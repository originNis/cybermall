package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemDAO extends BaseMapper<OrderItem> {
}
