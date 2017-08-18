package admin.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import admin.dao.LogitempDao;
import admin.entity.Areaset;
import admin.entity.AreasetVo;
import admin.entity.ReachArea;
import admin.entity.ShipTemplate;
import admin.entity.ShipTemplateVo;
import admin.service.LogitempService;


@Service("logitempService")
public class LogitempServiceImpl implements LogitempService{
	private static final Logger logger = Logger.getLogger(LogitempServiceImpl.class);

	private LogitempDao dao;
	
	@Autowired
	public LogitempServiceImpl(LogitempDao dao) {
		super();
		this.dao=dao;
	}
	

	@Override
	public int selectcountShipTemplateByShipname(HashMap<String, Object> paraMap) {
		return dao.selectcountShipTemplateByShipname(paraMap);
	}
	
	@Override
	public List<ShipTemplate> getlist(HashMap<String, Object> paraMap) {
		return dao.selectlistShipTemplateByShipname(paraMap);
	}

	@Override
	public List<ShipTemplateVo> getlist2(BigInteger com_id) {
		List<ShipTemplateVo> shipTemplateVoList = new ArrayList<ShipTemplateVo>();
		
		List<ShipTemplate> shipTemplateList = dao.selectlistShipTemplateByComId(com_id);
		for (ShipTemplate shipTemplate : shipTemplateList) {
			List<AreasetVo> areasetVoList = new ArrayList<AreasetVo>();
			
			List<Areaset> areasetList = dao.selectlistAreasetByShipId(shipTemplate.getShip_id());
			for (Areaset areaset : areasetList) {
				List<ReachArea> reach_area = dao.selectlistReachAreaByAsId(areaset.getAs_id());
				areasetVoList.add(new AreasetVo(areaset,reach_area));
			}
			
			shipTemplateVoList.add(new ShipTemplateVo(shipTemplate,areasetVoList));
		}
		
		return shipTemplateVoList;
	}
	
	@Override
	@Transactional
	public boolean insertShipTemplateTest(int n){
//		try {
			ReachArea reachArea = new ReachArea(new BigInteger("12"),new BigInteger("11"),"23332");
			if(1!=dao.insertReachArea(reachArea)) {
				throw new RuntimeException();
			}
			
			if (n==0) {
				throw new RuntimeException();
			}
			
			Areaset areaset = new Areaset(new BigInteger("11"),2,3.2f,new BigDecimal("3.22"),3.23f,new BigDecimal("3.22"),"1",34);
			if(1!=dao.insertAreaset(areaset)) {
				throw new RuntimeException();
			}
//		} catch (Exception e) {
//			logger.error("insertShipTemplate",e);
//			return false;
//		}

		return true;
	}
	
//	@Override
////	@Transactional(noRollbackFor=Exception.class)
////	@Transactional("transactionManager")
////	@Transactional
//	public boolean insertShipTemplateTest() {
//		//try {
//			if(!insertShipTemplateLogic()) {
//				throw new RuntimeException("注释");
//			}
////		} catch (RuntimeException e) {
////			logger.error("insertShipTemplate",e);
////			return false;
////		}
//		
//		return true;
//	}
//	
//	private boolean insertShipTemplateLogic(){
//		boolean result = false;
//		try {
//			ReachArea reachArea = new ReachArea(new BigInteger("12"),new BigInteger("11"),"23332");
//			if(1!=dao.insertReachArea(reachArea)) {
//				return false;
//			}
//			
//			Areaset areaset = new Areaset(new BigInteger("11"),2,3.2f,new BigDecimal("3.22"),3.23f,new BigDecimal("3.22"),"1",34);
//			if(1!=dao.insertAreaset(areaset)) {
//				return false;
//			}
//			result = true;
//		} catch (RuntimeException e) {
//			logger.error("insertShipTemplate",e);
//			return false;
//		}
//		
//		return result;
//	}

	@Override
	public boolean insertShipTemplate(ShipTemplateVo vo) {
		try {
			List<AreasetVo> area_info = vo.getArea_info();
			if (area_info==null || area_info.size()<=0)
				return false;
			
			//验证是否有默认模板
			int countDefault = 0;
			for (AreasetVo node : area_info) {
				int defaultShip = node.getDefault_ship();
				if (defaultShip!=0 && defaultShip!=1)
					return false;
				if (defaultShip==1) {
					countDefault++;
					continue;
				}
			}
			if (countDefault!=1)
				return false;
		
		
			for (AreasetVo node : area_info) {
				if (node.getDefault_ship()==0) {
					List<ReachArea> reach_area = node.getReach_area();
					if (reach_area==null || reach_area.size()==0)
						return false;
					for (ReachArea reachnode : reach_area) {
						if(1!=dao.insertReachArea(reachnode)) {
							throw new RuntimeException();
						}
					}
				}
				
				if(1!=dao.insertAreaset(new Areaset(node))) {
					throw new RuntimeException();
				}
			}
			
			if(1!=dao.insertShipTemplate(new ShipTemplate(vo))) {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			logger.error("insertShipTemplate",e);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateShipTemplate(ShipTemplateVo vo) {
		try {
			List<AreasetVo> area_info = vo.getArea_info();
			if (area_info==null || area_info.size()<=0)
				return false;
			
			//验证是否有默认模板
			int countDefault = 0;
			for (AreasetVo node : area_info) {
				int defaultShip = node.getDefault_ship();
				if (defaultShip!=0 && defaultShip!=1)
					return false;
				if (defaultShip==1) {
					countDefault++;
					continue;
				}
				
			}
			if (countDefault!=1)
				return false;
			
			for (AreasetVo node : area_info) {
				if (node.getDefault_ship()==0) {
					List<ReachArea> reach_area = node.getReach_area();
					if (reach_area==null || reach_area.size()==0) {
						throw new RuntimeException();
					}
					for (ReachArea reachnode : reach_area) {
						ReachArea _reachnode = dao.selectReachArea(reachnode.getRea_id());
						if (_reachnode==null) {	
							if(1!=dao.insertReachArea(reachnode)) {
								throw new RuntimeException();
							}
						} else {
							if(1!=dao.updateReachArea(reachnode)) {
								throw new RuntimeException();
							}
						}
					}
				}
				
				Areaset _areaset = dao.selectAreaset(node.getAs_id());
				if (_areaset==null) {
					if(1!=dao.insertAreaset(new Areaset(node))) {
						throw new RuntimeException();
					}
				} else {
					if(1!=dao.updateAreaset(new Areaset(node))) {
						throw new RuntimeException();
					}
				}
			}
			
			if(1!=dao.updateShipTemplate(new ShipTemplate(vo))) {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			logger.error("updateShipTemplate",e);
			return false;
		}
		
		return true;
	}

	@Override
	public List<ShipTemplate> selectByComId(String com_id) {
		return dao.selectByComId(com_id);
	}


	@Override
	public boolean setShipTemplateStatus(BigInteger ship_id, int state) {
		ShipTemplate shipTemplate = dao.selectShipTemplate(ship_id);
		if (shipTemplate!=null) {
			if (shipTemplate.getState()!=state) {
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("ship_id", ship_id);
				param.put("state", state);
				if (1==dao.updateShipTemplateState(param))
					return true;
			} else {
				return true;
			}
		}
		return false;
	}


	@Override
	public void deleteShipTemplateStatus(BigInteger ship_id) {
		dao.deleteShipTemplateStatus(ship_id);
	}


	@Override
	public boolean batchShipTemplateDelete(List<BigInteger> arr_shipid) {
		try {
			for (BigInteger ship_id : arr_shipid) {
				dao.deleteShipTemplateStatus(ship_id);
			}
		} catch (Exception exception) {
			return false;
		}
		return true;
	}


	@Override
	public boolean batchShipTemplateUpdateState(List<BigInteger> arr_shipid, int state) {
		try {
			for (BigInteger ship_id : arr_shipid) {
				ShipTemplate shipTemplate = dao.selectShipTemplate(ship_id);
				if (shipTemplate!=null) {
					if (shipTemplate.getState()!=state) {
						Map<String,Object> param = new HashMap<String,Object>();
						param.put("ship_id", ship_id);
						param.put("state", state);
						if (1==dao.updateShipTemplateState(param))
							return true;
					} else {
						return true;
					}
				} else {
					throw new Exception();
				}
			}
		} catch (Exception exception) {
			return false;
		}
		return true;
	}



}
