package cho_jeahyun;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Mng extends JFrame {

	private JPanel sales, reservation, reservation_cancel, room_info;
	public Mng_Customer customer = null;
	private Panel01 p1;
	public Mng(Panel01 p1){
		this.p1 = p1;
		
		customer = new Mng_Customer();
		sales = new Mng_Barchart();
		reservation = new Mng_Reservation();
		reservation_cancel = new Mng_Reservation_cancel();
		room_info = new Mng_Room_info();
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("������", customer);
		tab.addTab("�������", sales);
		tab.addTab("�������", reservation);
		tab.addTab("����ȸ", room_info);
		tab.addTab("������ҿ�û", reservation_cancel);
		this.add("Center",tab);
		
		this.setTitle("������������");
		this.setVisible(true);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
	public static void main(String[] args) {
//		Login login = new Login();
//		new Mng(login);
	}

}
