package com.rybin.cybermall.service;

import com.rybin.cybermall.beans.ResultVO;
import org.springframework.stereotype.Service;

@Service
public interface IndexService {
    ResultVO listIndexImgs();
}