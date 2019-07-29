package cho_jeahyun;

public class Reservation_Info {
	private Integer order_id;
	private String cid;
	private String roomid;
	private Integer adult;
	private Integer child;
	private Integer total_price;
	private String reservation_date;
	private String check_in_d;
	private String check_out_d;
	
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public Integer getAdult() {
		return adult;
	}
	public void setAdult(Integer adult) {
		this.adult = adult;
	}
	public Integer getChild() {
		return child;
	}
	public void setChild(Integer child) {
		this.child = child;
	}
	public Integer getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public String getCheck_in_d() {
		return check_in_d;
	}
	public void setCheck_in_d(String check_in_d) {
		this.check_in_d = check_in_d;
	}
	public String getCheck_out_d() {
		return check_out_d;
	}
	public void setCheck_out_d(String check_out_d) {
		this.check_out_d = check_out_d;
	}
}
