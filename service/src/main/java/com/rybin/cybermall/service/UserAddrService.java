package com.rybin.cybermall.service;

import com.rybin.cybermall.beans.VO.ResultVO;

public interface UserAddrService {
    ResultVO listUserAddrByUserId(Integer userId);
}
