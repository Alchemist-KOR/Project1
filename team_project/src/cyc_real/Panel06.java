package cyc_real;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel06 extends JPanel implements ActionListener{
	private JPanel north, n_East, center, c_west, c_East;
	private JLabel rogo, gall;
	private JLabel gallery;
	private Image rogo1, rogo2;
	private JButton login, logout, left, right;
	public Panel06() {
		
		this.setLayout(new BorderLayout());
		north = new JPanel();
		north.setLayout(new BorderLayout());
		north.setBackground(new Color(0xFFFFFF));
		n_East = new JPanel();
		n_East.setBackground(new Color(0xFFFFFF));
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(new Color(0xFFFFFF));
		
		login = new JButton("�α���");
		n_East.add(login);
//		logout = new JButton("�α׾ƿ�");
//		n_East.add(logout);
		north.add("East", n_East);
		
		gallery = new JLabel("    ������");
		gallery.setFont(new Font("���� ����", Font.BOLD, 20 ));
		gallery.setForeground(new Color(0x8B4513));
		center.add("North",gallery);

		
		ImageIcon icon_rogo = new ImageIcon("src//cyc//rogo.jpg");
		rogo1 = icon_rogo.getImage();
		rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		rogo = new JLabel(icon_rogo2);
		north.add("Center",rogo);
		
		
		
		//���ʿ����ʹ�ư����
		left = new JButton(new ImageIcon("src//cyc//left.png"));
		left.addActionListener(this);
		left.setBorderPainted(false); left.setContentAreaFilled(false);
//		left.setFocusPainted(false);
		right = new JButton(new ImageIcon("src//cyc//right.png"));
		right.addActionListener(this);
		right.setBorderPainted(false); right.setContentAreaFilled(false);
		c_west = new JPanel();
		c_west.setLayout(new BorderLayout());
		c_west.setBackground(new Color(0xFFFFFF));
		c_west.add("Center",left);
		c_East = new JPanel();
		c_East.setLayout(new BorderLayout());
		c_East.setBackground(new Color(0xFFFFFF));
		c_East.add("Center", right);
		center.add("West", c_west);center.add("East", c_East);
		
		gall = new JLabel();
		center.add("Center",gall);
		
		ImageIcon img = new ImageIcon("src//cyc//����1.jpg");
		img1 = img.getImage();
		img2 = img1.getScaledInstance(550, 450, Image.SCALE_SMOOTH);
		ImageIcon imge = new ImageIcon(img2);
		gall.setIcon(imge);
		
		
		
		this.add("North", north);
		this.add("Center", center);
		
		
	}
	int count=1;
	private Image img1, img2;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == right) {
			if(count <6) count++;
			if(count == 6) count=1;
			ImageIcon img = new ImageIcon("src//cyc//����"+count+".jpg");
			img1 = img.getImage();
			img2 = img1.getScaledInstance(550, 450, Image.SCALE_SMOOTH);
			ImageIcon imge = new ImageIcon(img2);
			gall.setIcon(imge);
			gall.repaint();
			
			
		}else if(obj == left) {
			if(count > 0 )count--;
			if(count == 0) count = 5;
			ImageIcon img = new ImageIcon("src//cyc//����"+count+".jpg");
			img1 = img.getImage();
			img2 = img1.getScaledInstance(550, 450, Image.SCALE_SMOOTH);
			ImageIcon imge = new ImageIcon(img2);
			gall.setIcon(imge);
			gall.repaint();
			
			
		}
		
	}
}
