package com.bytetube.dao;

import com.bytetube.BaseTest;
import com.bytetube.entity.ShopCategory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;


	@Test
	public void testBQueryShopCategory() throws Exception {
		ShopCategory sc = new ShopCategory();
		List<ShopCategory> shopCategoryList = shopCategoryDao
				.queryShopCategory(sc);
		assertEquals(2, shopCategoryList.size());
	ShopCategory testC = new ShopCategory();
	ShopCategory pc = new ShopCategory();
	pc.setShopCategoryId(1L);
	testC.setParent(pc);
	shopCategoryList = shopCategoryDao.queryShopCategory(testC);
		assertEquals(1, shopCategoryList.size());
		System.out.println(shopCategoryList.get(0).getShopCategoryName());
	}



}
