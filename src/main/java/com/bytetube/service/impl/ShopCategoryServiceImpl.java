package com.bytetube.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.bytetube.dao.ShopCategoryDao;

import com.bytetube.entity.ShopCategory;

import com.bytetube.service.ShopCategoryService;
import com.bytetube.util.FileUtil;
import com.bytetube.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;




	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition)
			throws IOException {
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}


}
