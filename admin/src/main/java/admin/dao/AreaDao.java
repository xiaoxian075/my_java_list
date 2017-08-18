package admin.dao;

import java.util.List;

import admin.entity.Area;
import admin.entity.AreaShort;

public interface AreaDao{

    List<Area> getAllArea();

    List<Area> getSon(String pId);

    List<Area> getParent(String area_id);

    List<Area> autoLimitParent(String area_id);

    List<AreaShort> getParentArea(String parent_area_id);

	List<Area> getCityArea();
}



