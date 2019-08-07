package cho_jeahyun;

import javax.swing.JPanel;

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

public class Panel04 extends JPanel implements ActionListener{
	private JPanel north, n_East, center, c_west, c_East;
	private JLabel rogo, gall;
	private JLabel gallery;
	private Image rogo1, rogo2;
	private JButton logout, left, right;
	public Panel04() {
		
		this.setLayout(new BorderLayout());
		north = new JPanel();
		north.setLayout(new BorderLayout());
		north.setBackground(Color.white);
		n_East = new JPanel();
		n_East.setBackground(Color.white);
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(Color.white);
		
		north.add("East", n_East);
		
		gallery = new JLabel("    갤러리");
		gallery.setFont(new Font("맑은 고딕", Font.BOLD, 20 ));
		gallery.setForeground(new Color(0x8B4513));
		center.add("North",gallery);

		
		ImageIcon icon_rogo = new ImageIcon("img//rogo.jpg");
		rogo1 = icon_rogo.getImage();
		rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		rogo = new JLabel(icon_rogo2);
		north.add("Center",rogo);
		
		
		
		//왼쪽오른쪽버튼설계
		left = new JButton(new ImageIcon("img//left.png"));
		left.addActionListener(this);
		left.setBorderPainted(false); left.setContentAreaFilled(false);

		right = new JButton(new ImageIcon("img//right.png"));
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
		
		ImageIcon img = new ImageIcon("img//사진1.jpg");
		img1 = img.getImage();
		img2 = img1.getScaledInstance(1000, 550, Image.SCALE_SMOOTH);
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
			ImageIcon img = new ImageIcon("img//사진"+count+".jpg");
			img1 = img.getImage();
			img2 = img1.getScaledInstance(1000, 550, Image.SCALE_SMOOTH);
			ImageIcon imge = new ImageIcon(img2);
			gall.setIcon(imge);
			gall.repaint();
			
			
		}else if(obj == left) {
			if(count > 0 )count--;
			if(count == 0) count = 5;
			ImageIcon img = new ImageIcon("img//사진"+count+".jpg");
			img1 = img.getImage();
			img2 = img1.getScaledInstance(1000, 550, Image.SCALE_SMOOTH);
			ImageIcon imge = new ImageIcon(img2);
			gall.setIcon(imge);
			gall.repaint();
			
			
		}
		
	}
}
