package cho_jeahyun;

public class Reservation_cancel_info {
	
	private Integer order_id;
	private Integer refund;
	private String reservation_date;
	private String cancel_date;
	private String check_info;
	
	public String getCheck_info() {
		return check_info;
	}
	public void setCheck_info(String check_info) {
		this.check_info = check_info;
	}
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getRefund() {
		return refund;
	}
	public void setRefund(Integer refund) {
		this.refund = refund;
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public String getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(String cancel_date) {
		this.cancel_date = cancel_date;
	}
}
