package JinSeop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel01 extends JFrame{
	JPanel north,east,center2,south3;
	JLabel south,center,south2;
	JButton btn_login;
	ImageIcon img;
	

	Panel01(){
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		east = new JPanel(new FlowLayout());
		south = new JLabel("00ȣ�ڸ��� Ư���� �����,���� �����Ͻð� ȸ������ Ư���� ������ ��������");
		center = new JLabel();
		center2 = new JPanel();
		south2 = new JLabel();
		south3 = new JPanel();
		
		
		setBtn();
		
		
		center.setIcon(new ImageIcon("img//ȣ��01.png"));
		center2.add(center);
		
		south2.setIcon(new ImageIcon("img//�����ؽ�Ʈ.png"));
		south3.add(south2);
		
		east.add(btn_login);
		north.add("East",east);
		
		
		this.add("Center",center2);
		this.add("North",north);
		this.add("South",south3);
		
		this.setTitle("ȣ�ڿ���ý��� ver1.0");
		this.setSize(600,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	void setBtn() {
		btn_login = new JButton("�α���");
	}
	public static void main(String [] ar) {
		new Panel01();
	}
}
