package cho_jeahyun;

public class Room_info {
	private Integer order_id;
	private String roomid;
	private Integer num_peo;
	private String rating;
	private String check_in_d;
	private String check_out_d;
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
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public Integer getNum_peo() {
		return num_peo;
	}
	public void setNum_peo(Integer num_peo) {
		this.num_peo = num_peo;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
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
