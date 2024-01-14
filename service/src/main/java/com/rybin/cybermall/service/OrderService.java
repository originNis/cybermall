package com.rybin.cybermall.service;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.Orders;

import java.sql.SQLException;
import java.util.Map;

public interface OrderService {
    Map<String, String> addOrder(String cids, Orders order) throws SQLException;
}
