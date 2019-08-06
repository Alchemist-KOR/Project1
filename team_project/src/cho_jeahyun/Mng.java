package cho_jeahyun;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Mng extends JFrame {

	private JPanel sales, reservation;
	public Mng_Customer customer = null;
	private Panel01 p1;
	public Mng(Panel01 p1){
		this.p1 = p1;
		
		customer = new Mng_Customer();
		sales = new JPanel();
		reservation = new Mng_Reservation();
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("绊按包府", customer);
		tab.addTab("概免包府", sales);
		tab.addTab("抗距包府", reservation);
		this.add("Center",tab);
		
		this.setTitle("包府磊其捞瘤");
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
