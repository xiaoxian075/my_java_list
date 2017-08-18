package admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.AreaDao;
import admin.entity.Area;
import admin.entity.AreaShort;
import admin.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService{
	
	private AreaDao areaDao;

	@Autowired
	public AreaServiceImpl(AreaDao areaDao) {
		super();
		this.areaDao = areaDao;
	}

	public List<Area> getSon(String pId) {
		return areaDao.getSon(pId);
	}

	@Override
	public List<Area> getParent(String area_id) {
		return areaDao.getParent(area_id);
	}

	@Override
	public List<Area> autoLimitParent(String area_id) {
		return areaDao.autoLimitParent(area_id);
	}

	@Override
	public List<Area> getAllArea() {
		return areaDao.getAllArea();
	}

	@Override
	public List<AreaShort> getParentArea(String parent_area_id) {
		return areaDao.getParentArea(parent_area_id);
	}

	@Override
	public List<Area> getCityArea() {
		return areaDao.getCityArea();
	}


}




