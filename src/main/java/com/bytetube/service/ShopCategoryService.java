package com.bytetube.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.bytetube.entity.ShopCategory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;

public interface ShopCategoryService {

	/**
	 * 
	 *
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) throws IOException;



}
