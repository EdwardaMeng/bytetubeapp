package com.bytetube.service.impl;


import com.bytetube.dao.ShopDao;
import com.bytetube.dto.ShopExecution;
import com.bytetube.entity.Shop;

import com.bytetube.entity.ShopCategory;
import com.bytetube.enums.ShopStateEnum;
import com.bytetube.exceptions.ShopOperationException;
import com.bytetube.service.ShopService;
import com.bytetube.util.FileUtil;
import com.bytetube.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;


	@Override
	@Transactional
	/**
	 * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	 */
	public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg){
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
		}
		try {
			//初始化店铺信息
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());

			//添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				try {
					if (shopImg != null) {
						//存储图片
						addShopImg(shop, shopImg);
						effectedNum = shopDao.updateShop(shop);
						if (effectedNum <= 0) {
							throw new ShopOperationException("创建图片地址失败");
						}
					}
				} catch (Exception e) {
					throw new ShopOperationException("addShopImg error: "
							+ e.getMessage());
				}

			}
		} catch (Exception e) {
			throw new ShopOperationException("insertShop error: " + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK,shop);
	}

	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex,
			int pageSize) {

		return null;
	}

	@Override
	public ShopExecution getByEmployeeId(long employeeId)
			throws ShopOperationException {
		return null;
	}

	@Override
	public Shop getByShopId(long shopId) {
		return null;
	}



	@Override
	@Transactional
	public ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg)
			throws ShopOperationException {
		return null;
	}

	private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
		String dest = FileUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

}
