package admin.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import admin.entity.ShipTemplate;
import admin.entity.ShipTemplateVo;


public interface LogitempService {
	boolean insertShipTemplateTest(int n);
	int selectcountShipTemplateByShipname(HashMap<String, Object> paraMap);
	List<ShipTemplate> getlist(HashMap<String, Object> paraMap);
	List<ShipTemplateVo> getlist2(BigInteger com_id);
	boolean insertShipTemplate(ShipTemplateVo vo);
	boolean updateShipTemplate(ShipTemplateVo vo);
	List<ShipTemplate> selectByComId(String com_id);
	boolean setShipTemplateStatus(BigInteger ship_id, int state);
	void deleteShipTemplateStatus(BigInteger ship_id);
	boolean batchShipTemplateDelete(List<BigInteger> arr_shipid);
	boolean batchShipTemplateUpdateState(List<BigInteger> arr_shipid, int state);
	
}
