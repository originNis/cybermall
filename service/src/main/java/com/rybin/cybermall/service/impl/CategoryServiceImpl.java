package com.rybin.cybermall.service.impl;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.CategoryVO;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.mapper.CategoryDAO;
import com.rybin.cybermall.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryDAO categoryDAO;

    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryDAO.listCategories(0);
        return new ResultVO(ResponseStatus.SUCCESS, "success", categoryVOS);
    }
}
