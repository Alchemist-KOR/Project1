package JinSeop;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel05 extends JFrame{
	JLabel north,center,south;
	JPanel north1,center1,south1;
	
	Panel05(){
		
		this.setLayout(new BorderLayout());
		north = new JLabel();
		north1 = new JPanel();
		center = new JLabel();
		center1 = new JPanel();
		south = new JLabel();
		south1 = new JPanel();
		
		north.setIcon(new ImageIcon("img//호텔소개및위치1.png"));
		north1.add(north);
		center.setIcon(new ImageIcon("img//신라호텔지도.png"));
		center1.add(center);
		south.setIcon(new ImageIcon("img//위치및소개.png"));
		south1.add(south);
		
		
		
		this.add("North",north1);
		this.add("Center",center1);
		this.add("South",south1);
		
		this.setTitle("호텔예약시스템 ver1.0");
		this.setSize(600,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String [] ar) {
		new Panel05();
	}
}
