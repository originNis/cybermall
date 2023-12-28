package com.rybin.cybermall.service;

import com.rybin.cybermall.beans.VO.ProductVO;
import com.rybin.cybermall.beans.VO.ResultVO;

import java.util.List;

public interface ProductService {
    ResultVO listRecommendations();

    ResultVO getProductInfoById(String pid);
}
