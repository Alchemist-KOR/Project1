package cyc_real;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Nomember_Booking extends JFrame {
	private JPanel north, center, c_Center, c_South, south;
	private JPanel p1, p2, p3;
	private Image rogo1, rogo2;
	private JLabel rogo;
	private JLabel lbl;
	private JLabel name, email, tel, third;
	private JButton booking;
	private JTextField txt_name, txt_email, txt_tel;
	private Checkbox ck;
	public Nomember_Booking(){
		this.setVisible(true);
		this.setSize(850, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		north = new JPanel();
		north.setLayout(new BorderLayout());
		north.setBackground(new Color(0xFFFFFF));
		this.add("North", north);
		center = new JPanel();
		center.setLayout(new BorderLayout());
		c_Center = new JPanel();
		c_Center.setLayout(new GridLayout(11,2));
		c_South = new JPanel();
		south = new JPanel();
		south.setLayout(new BorderLayout());

		
		ImageIcon icon_rogo = new ImageIcon("img//rogo.jpg");
		rogo1 = icon_rogo.getImage();
		rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		rogo = new JLabel(icon_rogo2);
		north.add("Center",rogo);
		
		lbl = new JLabel("예약하기 | 비회원");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		north.add("South",lbl);
		
		p1 = new JPanel();p2 = new JPanel();p3 = new JPanel();
		
		name = new JLabel("이름");
		name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		name.setHorizontalAlignment(JLabel.CENTER);
		email = new JLabel("이메일");
		email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		email.setHorizontalAlignment(JLabel.CENTER);
		tel = new JLabel("전화번호");
		tel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		tel.setHorizontalAlignment(JLabel.CENTER);
		txt_name = new JTextField(20);
		txt_name.setHorizontalAlignment(JTextField.CENTER);
		txt_email = new JTextField(20);
		txt_tel = new JTextField("예시)01012345678",20);
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		c_Center.add(name);
		p1.add(txt_name);c_Center.add(p1);
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		c_Center.add(email);
		p2.add(txt_email);c_Center.add(p2);
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		c_Center.add(tel); 
		p3.add(txt_tel);c_Center.add(p3);
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		c_Center.add(new JLabel());c_Center.add(new JLabel());
		center.add("Center",c_Center);
		
		third = new JLabel("제 3자 정보 제공 동의");
		ck = new Checkbox();
		c_South.add(third); c_South.add(ck);
		center.add("South", c_South);
		
		booking = new JButton(new ImageIcon("img//그림1.png"));
		booking.setBorderPainted(false); booking.setContentAreaFilled(false);
		booking.setFocusPainted(false);
		south.add("Center", booking);
		south.add("East", new JLabel());south.add("West", new JLabel());
		this.add("South", south);
		
		this.add("Center", center);
	}
	
	
	
	
	public static void main(String[] args) {
		new Nomember_Booking();
	}

}
