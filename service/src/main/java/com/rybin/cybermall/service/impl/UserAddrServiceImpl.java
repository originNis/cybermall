package com.rybin.cybermall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.UserAddr;
import com.rybin.cybermall.mapper.UserAddrDAO;
import com.rybin.cybermall.service.UserAddrService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddrServiceImpl implements UserAddrService {
    @Resource
    UserAddrDAO userAddrDAO;

    @Override
    public ResultVO listUserAddrByUserId(Integer userId) {
        List<UserAddr> list = userAddrDAO.selectList(new QueryWrapper<UserAddr>()
                .eq("user_id", userId)
                .eq("status", 1)
        );

        return new ResultVO(ResponseStatus.SUCCESS, "success", list);
    }
}
