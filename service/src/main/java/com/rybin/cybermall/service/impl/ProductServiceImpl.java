package com.rybin.cybermall.service.impl;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ProductVO;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.mapper.ProductDAO;
import com.rybin.cybermall.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDAO productDAO;

    @Override
    public ResultVO listRecommendations() {
        List<ProductVO> productVOS = productDAO.listProductsOrderByDate(3);
        return new ResultVO(ResponseStatus.SUCCESS, "success", productVOS);
    }
}
