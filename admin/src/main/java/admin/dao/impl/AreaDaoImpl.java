package admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.AreaDao;
import admin.entity.Area;
import admin.entity.AreaShort;
import admin.mapper.AreaMapper;

@Service("areaDao")
public class AreaDaoImpl implements AreaDao{
	
	@Autowired
	private AreaMapper mapper;

	
	@Override
	public List<Area> getAllArea() {
		return mapper.getAllArea();
	}

	@Override
	public List<Area> getSon(String pId) {
		return mapper.getSon(pId);
	}

	@Override
	public List<Area> getParent(String area_id) {
		return mapper.getParent(area_id);
	}

	@Override
	public List<Area> autoLimitParent(String area_id) {
		return mapper.autoLimitParent(area_id);
	}

	@Override
	public List<AreaShort> getParentArea(String parent_area_id) {
		return mapper.getParentArea(parent_area_id);
	}

	@Override
	public List<Area> getCityArea() {
		return mapper.getCityArea();
	}

}
