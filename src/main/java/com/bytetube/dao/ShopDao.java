package com.bytetube.dao;

import com.bytetube.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺
     *
     * @param shop
     * @return effectedNum
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     *
     * @param shop
     * @return effectedNum
     */
    int updateShop(Shop shop);
}
