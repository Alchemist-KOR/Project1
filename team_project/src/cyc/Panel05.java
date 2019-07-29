package cyc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel05 extends JPanel{
	private Image introduce1, introduce2, rogo1, rogo2;
	private JLabel lbl1, lbl2; private JLabel img, rogo, line;
	private JButton login;
	private JPanel north, n_East, center;
	
	Panel05(){
		this.setVisible(true);
		this.setLayout(new BorderLayout());

		login = new JButton("로그인");
		north = new JPanel();
		north.setLayout(new BorderLayout());
		north.setBackground(new Color(0xFFFFFF));
		n_East = new JPanel();
		n_East.setBackground(new Color(0xFFFFFF));
		n_East.setLayout(new FlowLayout());
		n_East.add(login);
		north.add("East",n_East);
		this.add("North", north);
		center = new JPanel();
		center.setLayout(null);
		center.setBackground(new Color(0xFFFFFF));
		

		ImageIcon icon_rogo = new ImageIcon("img//rogo.jpg");
		rogo1 = icon_rogo.getImage();
		rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		rogo = new JLabel(icon_rogo2);
		north.add("Center",rogo);
		
		lbl1 =new JLabel("호텔 OOO | 소개 및 위치");
		lbl1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lbl1.setForeground(new Color(0x8B4513));
		lbl1.setLocation(10, 10);
		lbl1.setBounds(10, 10, 500, 35);
		center.add(lbl1);
		
		ImageIcon img4 = new ImageIcon("img//선.png");
		line = new JLabel(img4);
		line.setLocation(50, 50);
		line.setBounds(10, 55, 900, 10);
		center.add(line);
		
		ImageIcon icon_introduce = new ImageIcon("img//introduce.jpg");
		introduce1 = icon_introduce.getImage();
		introduce2 = introduce1.getScaledInstance(550, 400, Image.SCALE_SMOOTH);
		ImageIcon icon_introduce2 = new ImageIcon(introduce2);
		img = new JLabel(icon_introduce2);
		img.setLocation(50, 50);
		img.setBounds(10, 80, 600, 500);
		center.add(img);
		
		
		
		this.add("Center",center);
	}
}
