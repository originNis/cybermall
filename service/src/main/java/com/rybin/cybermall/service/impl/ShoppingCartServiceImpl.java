package com.rybin.cybermall.service.impl;

import com.rybin.cybermall.beans.VO.ShoppingCartVO;
import com.rybin.cybermall.beans.entity.ShoppingCart;
import com.rybin.cybermall.mapper.ShoppingCartDAO;
import com.rybin.cybermall.service.ShoppingCartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartDAO shoppingCartDAO;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int addToShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.setCartTime(sdf.format(new Date()));
        return shoppingCartDAO.insert(shoppingCart);
    }

    @Override
    public List<ShoppingCartVO> listShoppingCartByUserId(Integer userId) {
        return shoppingCartDAO.selectShoppingCartByUserId(userId);
    }

    @Override
    public Integer updateCartNum(Integer cartId, Integer num) {
        return shoppingCartDAO.updateCartNum(cartId, num);
    }

    @Override
    public List<ShoppingCartVO> selectShoppingCartByListCartId(String cids) {
        String[] split = cids.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        return shoppingCartDAO.selectShoppingCartByListCartId(list);
    }
}
