package admin.service;

import java.util.List;

import admin.entity.Area;
import admin.entity.AreaShort;

public interface AreaService{
	List<Area> getSon(String pId);
    List<Area> getParent(String area_id);
	List<Area> autoLimitParent(String area_id);
    List<Area> getAllArea();
    List<AreaShort> getParentArea(String parent_area_id);
    List<Area> getCityArea();	//搜索省市级的所有城市(level:1/2) 
}


