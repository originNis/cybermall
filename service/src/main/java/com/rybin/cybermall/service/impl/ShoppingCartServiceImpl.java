package com.rybin.cybermall.service.impl;

import com.rybin.cybermall.beans.entity.ShoppingCart;
import com.rybin.cybermall.mapper.ShoppingCartDAO;
import com.rybin.cybermall.service.ShoppingCartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartDAO shoppingCartDAO;

    @Override
    public int addToShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDAO.insert(shoppingCart);
    }
}
