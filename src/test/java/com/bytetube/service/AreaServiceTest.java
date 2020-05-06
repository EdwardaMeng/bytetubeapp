package com.bytetube.service;

import com.bytetube.BaseTest;
import com.bytetube.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;


    @Test
public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("concordia",areaList.get(0).getAreaName());
    }
}
