package admin.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class ShipTemplate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6323892406751440288L;
	private BigInteger ship_id;
	private BigInteger com_id;
	private BigInteger goods_id;
	private String ship_name;
	private String start_area;
	private String send_time_id;
	private String send_time;
	private int valuation_mode;
	private String express_id_str;
	private int free_ship;
	private int state;
	private Timestamp tem_modify_time;
	public ShipTemplate() {
		super();
	}
	public ShipTemplate(BigInteger ship_id, BigInteger com_id, BigInteger goods_id, String ship_name, String start_area,
			String send_time_id, String send_time, int valuation_mode, String express_id_str, int free_ship,
			int state, Timestamp tem_modify_time) {
		super();
		this.ship_id = ship_id;
		this.com_id = com_id;
		this.goods_id = goods_id;
		this.ship_name = ship_name;
		this.start_area = start_area;
		this.send_time_id = send_time_id;
		this.send_time = send_time;
		this.valuation_mode = valuation_mode;
		this.express_id_str = express_id_str;
		this.free_ship = free_ship;
		this.state = state;
		this.tem_modify_time = tem_modify_time;
	}
	public ShipTemplate(ShipTemplateVo info) {
		this.ship_id = info.getShip_id();
		this.com_id = info.getCom_id();
		this.goods_id = info.getGoods_id();
		this.ship_name = info.getShip_name();
		this.start_area = info.getStart_area();
		this.send_time_id = info.getSend_time_id();
		this.send_time = info.getSend_time();
		this.valuation_mode = info.getValuation_mode();
		this.express_id_str = info.getExpress_id_str();
		this.free_ship = info.getFree_ship();
		this.state = info.getState();
		this.tem_modify_time = info.getTem_modify_time();
	}
	public BigInteger getShip_id() {
		return ship_id;
	}
	public void setShip_id(BigInteger ship_id) {
		this.ship_id = ship_id;
	}
	public BigInteger getCom_id() {
		return com_id;
	}
	public void setCom_id(BigInteger com_id) {
		this.com_id = com_id;
	}
	public BigInteger getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(BigInteger goods_id) {
		this.goods_id = goods_id;
	}
	public String getShip_name() {
		return ship_name;
	}
	public void setShip_name(String ship_name) {
		this.ship_name = ship_name;
	}
	public String getStart_area() {
		return start_area;
	}
	public void setStart_area(String start_area) {
		this.start_area = start_area;
	}
	public String getSend_time_id() {
		return send_time_id;
	}
	public void setSend_time_id(String send_time_id) {
		this.send_time_id = send_time_id;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public int getValuation_mode() {
		return valuation_mode;
	}
	public void setValuation_mode(int valuation_mode) {
		this.valuation_mode = valuation_mode;
	}
	public String getExpress_id_str() {
		return express_id_str;
	}
	public void setExpress_id_str(String express_id_str) {
		this.express_id_str = express_id_str;
	}
	public int getFree_ship() {
		return free_ship;
	}
	public void setFree_ship(int free_ship) {
		this.free_ship = free_ship;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getTem_modify_time() {
		return tem_modify_time;
	}
	public void setTem_modify_time(Timestamp tem_modify_time) {
		this.tem_modify_time = tem_modify_time;
	}
	@Override
	public String toString() {
		return "ShipTemplate [ship_id=" + ship_id + ", com_id=" + com_id + ", goods_id=" + goods_id + ", ship_name="
				+ ship_name + ", start_area=" + start_area + ", send_time_id=" + send_time_id + ", send_time="
				+ send_time + ", valuation_mode=" + valuation_mode + ", express_id_str=" + express_id_str
				+ ", free_ship=" + free_ship + ", state=" + state + ", tem_modify_time=" + tem_modify_time + "]";
	}
}
