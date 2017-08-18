package admin.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.entity.Areaset;
import admin.entity.ReachArea;
import admin.entity.ShipTemplate;


public interface LogitempDao {
	int selectcountShipTemplateByShipname(HashMap<String, Object> paraMap);
	
	List<ShipTemplate> selectlistShipTemplateByComId(BigInteger comId);
	List<ShipTemplate> selectlistShipTemplateByShipname(HashMap<String, Object> paraMap);
	List<Areaset> selectlistAreasetByShipId(BigInteger ship_id);
	List<ReachArea> selectlistReachAreaByAsId(BigInteger as_id);
	List<ShipTemplate> selectByComId(String com_id);
	
	ShipTemplate selectShipTemplate(BigInteger ship_id);
	ReachArea selectReachArea(BigInteger rea_id);
	Areaset selectAreaset(BigInteger as_id);

	int insertShipTemplate(ShipTemplate shipTemplate);
	int insertReachArea(ReachArea reachnode);
	int insertAreaset(Areaset areaset);
	
	int updateShipTemplate(ShipTemplate shipTemplate);
	int updateReachArea(ReachArea reachnode);
	int updateAreaset(Areaset areaset);

	int updateShipTemplateState(Map<String,Object> param);
	void deleteShipTemplateStatus(BigInteger ship_id);
}
