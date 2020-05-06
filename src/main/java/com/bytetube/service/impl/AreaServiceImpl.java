package com.bytetube.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.bytetube.dao.AreaDao;

import com.bytetube.entity.Area;

import com.bytetube.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;



	@Override
	public List<Area> getAreaList() {

			return areaDao.queryArea();

	}


}
