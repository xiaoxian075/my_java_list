package admin.dao.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.util.RedisUtil;

import admin.dao.LogitempDao;
import admin.entity.Areaset;
import admin.entity.ReachArea;
import admin.entity.ShipTemplate;
import admin.mapper.LogitempMapper;


@Service("logitempDao")
public class LogitempDaoImpl implements LogitempDao{
	
	//@Autowired 
	//private Redis<BigInteger,ShipTemplate> redis;

	@Autowired
	private LogitempMapper mapper;
	
	@Override
	public int selectcountShipTemplateByShipname(HashMap<String, Object> paraMap) {
		return mapper.selectcountShipTemplateByShipname(paraMap);
	}

	@Override
	public List<ShipTemplate> selectlistShipTemplateByComId(BigInteger comId) {
		return mapper.selectlistShipTemplateByComId(comId);
	}

	@Override
	public List<ShipTemplate> selectlistShipTemplateByShipname(HashMap<String, Object> paraMap) {
//		List<ShipTemplate> listShipTemplate = redis.getCacheList("shiptemplateList2");
//		if (listShipTemplate.size()==0) {
//			listShipTemplate = mapper.selectlistShipTemplateByShipname(paraMap);
//			redis.setCacheList("shiptemplateList2",listShipTemplate);
//		}
//		return listShipTemplate;
		
		StringBuffer key = new StringBuffer("shiptemplateList");
		for(Entry<String,Object> entry : paraMap.entrySet()) {
			Object value = entry.getValue();
			if (value!=null) {
				key.append("#");
				key.append(entry.getValue());
			}
		}
		
		List<ShipTemplate> listShipTemplate = null;
		if (RedisUtil.exists(key.toString())) {
			listShipTemplate = RedisUtil.getList(key.toString());
		} else {
			listShipTemplate = mapper.selectlistShipTemplateByShipname(paraMap);
			RedisUtil.setList(key.toString(), listShipTemplate,30);
		}
		 
		for (ShipTemplate node : listShipTemplate) {
			System.out.println(node);
		}
		 return listShipTemplate;
	}

	@Override
	public List<Areaset> selectlistAreasetByShipId(BigInteger ship_id) {
		return mapper.selectlistAreasetByShipId(ship_id);
	}

	@Override
	public List<ReachArea> selectlistReachAreaByAsId(BigInteger as_id) {
		return mapper.selectlistReachAreaByAsId(as_id);
	}

	@Override
	public List<ShipTemplate> selectByComId(String com_id) {
		return mapper.selectByComId(com_id);
	}

	@Override
	public ShipTemplate selectShipTemplate(BigInteger ship_id) {
		return mapper.selectShipTemplate(ship_id);
	}

	@Override
	public ReachArea selectReachArea(BigInteger rea_id) {
		return mapper.selectReachArea(rea_id);
	}

	@Override
	public Areaset selectAreaset(BigInteger as_id) {
		return mapper.selectAreaset(as_id);
	}

	@Override
	public int insertShipTemplate(ShipTemplate shipTemplate) {
		return mapper.insertShipTemplate(shipTemplate);
	}

	@Override
	public int insertReachArea(ReachArea reachnode) {
		return mapper.insertReachArea(reachnode);
	}

	@Override
	public int insertAreaset(Areaset areaset) {
		return mapper.insertAreaset(areaset);
	}

	@Override
	public int updateShipTemplate(ShipTemplate shipTemplate) {
		return mapper.updateShipTemplate(shipTemplate);
	}

	@Override
	public int updateReachArea(ReachArea reachnode) {
		return mapper.updateReachArea(reachnode);
	}

	@Override
	public int updateAreaset(Areaset areaset) {
		return mapper.updateAreaset(areaset);
	}

	@Override
	public int updateShipTemplateState(Map<String, Object> param) {
		return mapper.updateShipTemplateState(param);
	}

	@Override
	public void deleteShipTemplateStatus(BigInteger ship_id) {
		mapper.deleteShipTemplateStatus(ship_id);
	}

}
