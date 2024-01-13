package com.rybin.cybermall.service;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.Orders;

public interface OrderService {
    ResultVO addOrder(String cids, Orders order);
}
