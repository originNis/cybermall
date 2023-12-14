package com.rybin.cybermall.service;


import com.rybin.cybermall.beans.ResultVO;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    ResultVO userRegist(String username, String password);

    ResultVO userLogin(String username, String password);
}
