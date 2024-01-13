package com.rybin.cybermall.service;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.Orders;

import java.sql.SQLException;

public interface OrderService {
    ResultVO addOrder(String cids, Orders order) throws SQLException;
}
