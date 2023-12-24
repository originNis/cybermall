package com.rybin.cybermall.service.impl;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.IndexImg;
import com.rybin.cybermall.mapper.IndexImgDAO;
import com.rybin.cybermall.service.IndexService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    IndexImgDAO indexImgDAO;

    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = indexImgDAO.listIndexImgs();

        if (indexImgs.size() <= 0) {
            return new ResultVO(ResponseStatus.FAIL, "fail", null);
        } else {
            return new ResultVO(ResponseStatus.SUCCESS, "success", indexImgs);
        }
    }
}
