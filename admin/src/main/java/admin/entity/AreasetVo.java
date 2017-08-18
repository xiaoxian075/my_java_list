package admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class AreasetVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4731299559380209882L;
	private BigInteger as_id;
	private int ship_id;
	private Float express_start;
	private BigDecimal express_price;
	private Float express_plus;
	private BigDecimal express_priceplus;
	private String express_id;
	private int default_ship;
	private List<ReachArea> reach_area;
	public AreasetVo() {
		super();
	}
	public AreasetVo(BigInteger as_id, int ship_id, Float express_start, BigDecimal express_price, Float express_plus,
			BigDecimal express_priceplus, String express_id, int default_ship,List<ReachArea> reach_area) {
		super();
		this.as_id = as_id;
		this.ship_id = ship_id;
		this.express_start = express_start;
		this.express_price = express_price;
		this.express_plus = express_plus;
		this.express_priceplus = express_priceplus;
		this.express_id = express_id;
		this.default_ship = default_ship;
		this.reach_area = reach_area;
	}
	public AreasetVo(Areaset info,List<ReachArea> reach_area) {
		this.as_id = info.getAs_id();
		this.ship_id = info.getShip_id();
		this.express_start = info.getExpress_start();
		this.express_price = info.getExpress_price();
		this.express_plus = info.getExpress_plus();
		this.express_priceplus = info.getExpress_priceplus();
		this.express_id = info.getExpress_id();
		this.default_ship = info.getDefault_ship();
		this.reach_area = reach_area;
	}
	public BigInteger getAs_id() {
		return as_id;
	}
	public void setAs_id(BigInteger as_id) {
		this.as_id = as_id;
	}
	public int getShip_id() {
		return ship_id;
	}
	public void setShip_id(int ship_id) {
		this.ship_id = ship_id;
	}
	public Float getExpress_start() {
		return express_start;
	}
	public void setExpress_start(Float express_start) {
		this.express_start = express_start;
	}
	public BigDecimal getExpress_price() {
		return express_price;
	}
	public void setExpress_price(BigDecimal express_price) {
		this.express_price = express_price;
	}
	public Float getExpress_plus() {
		return express_plus;
	}
	public void setExpress_plus(Float express_plus) {
		this.express_plus = express_plus;
	}
	public BigDecimal getExpress_priceplus() {
		return express_priceplus;
	}
	public void setExpress_priceplus(BigDecimal express_priceplus) {
		this.express_priceplus = express_priceplus;
	}
	public String getExpress_id() {
		return express_id;
	}
	public void setExpress_id(String express_id) {
		this.express_id = express_id;
	}
	public int getDefault_ship() {
		return default_ship;
	}
	public void setDefault_ship(int default_ship) {
		this.default_ship = default_ship;
	}
	public List<ReachArea> getReach_area() {
		return reach_area;
	}
	public void setReach_area(List<ReachArea> reach_area) {
		this.reach_area = reach_area;
	}
}
