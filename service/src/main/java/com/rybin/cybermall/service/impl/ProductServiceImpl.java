package com.rybin.cybermall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ProductCommentsVO;
import com.rybin.cybermall.beans.VO.ProductVO;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.Product;
import com.rybin.cybermall.beans.entity.ProductImg;
import com.rybin.cybermall.beans.entity.ProductParams;
import com.rybin.cybermall.beans.entity.ProductSku;
import com.rybin.cybermall.mapper.*;
import com.rybin.cybermall.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDAO productDAO;
    @Resource
    ProductImgDAO productImgDAO;
    @Resource
    ProductSkuDAO productSkuDAO;
    @Resource
    ProductParamsDAO productParamsDAO;
    @Resource
    ProductCommentsDAO productCommentsDAO;

    @Override
    public ResultVO listRecommendations() {
        List<ProductVO> productVOS = productDAO.listProductsOrderByDate(3);
        return new ResultVO(ResponseStatus.SUCCESS, "success", productVOS);
    }

    @Override
    public ResultVO getProductInfoById(String pid) {
        List<Product> products = productDAO.selectList(new QueryWrapper<Product>()
                .eq("product_id", pid)
                .eq("product_status", 1));

        if (products.isEmpty()) {
            return new ResultVO(ResponseStatus.FAIL, "商品不存在", null);
        } else {
            List<ProductImg> imgs = productImgDAO.selectList(new QueryWrapper<ProductImg>()
                    .eq("item_id", pid));
            List<ProductSku> productSkus = productSkuDAO.selectList(new QueryWrapper<ProductSku>()
                    .eq("product_id", pid)
                    .eq("status", 1));

            HashMap<String, Object> basicInfo = new HashMap();
            basicInfo.put("product", products.get(0));
            basicInfo.put("productImgs", imgs);
            basicInfo.put("productSkus", productSkus);

            return new ResultVO(ResponseStatus.SUCCESS, "success", basicInfo);
        }
    }

    @Override
    public ResultVO getProductParams(String pid) {
        List<ProductParams> productParams = productParamsDAO.selectList(new QueryWrapper<ProductParams>()
                .eq("product_id", pid));

        if (productParams.size() > 0) {
            return new ResultVO(ResponseStatus.SUCCESS, "success", productParams.get(0));
        } else {
            return new ResultVO(ResponseStatus.FAIL, "商品参数不存在", null);
        }
    }

    @Override
    public ResultVO getCommentsByProductId(String pid) {
        List<ProductCommentsVO> comments = productCommentsDAO.getCommentsByProductId(pid);
        return new ResultVO(ResponseStatus.SUCCESS, "success", comments);
    }
}
