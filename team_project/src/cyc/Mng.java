package cyc;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Mng extends JFrame {
//	private CardLayout card;
	private JPanel sales, reservation;
	public Mng_Customer customer = null;
	public Mng(){
		this.setVisible(true);
		this.setSize(950, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		customer = new Mng_Customer();
		sales = new JPanel();
		reservation = new JPanel();
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("������", customer);
		tab.addTab("�������", sales);
		tab.addTab("�������", reservation);
		this.add("Center",tab);

	}
	public static void main(String[] args) {
		
		new Mng();
	}

}
