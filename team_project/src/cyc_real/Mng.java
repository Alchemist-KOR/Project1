package cyc_real;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Mng extends JFrame {
//	private CardLayout card;
	private JPanel sales, reservation;
	public Mng_Customer customer = null;
	public boolean check_in_d_b;
	public boolean check_out_d_b;
	public Mng(){
		
		
		customer = new Mng_Customer();
		sales = new Mng_Barchart();
		reservation = new Mng_Reservation();
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("绊按包府", customer);
		tab.addTab("概免包府", sales);
		tab.addTab("抗距包府", reservation);
		this.add("Center",tab);
		this.setVisible(true);
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		new Mng();
	}

}
