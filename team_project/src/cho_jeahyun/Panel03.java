package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel03 extends JPanel implements ActionListener {
	private JLabel lbl111, lbl222, lbl33, lbl44, lbl55, lbl66;
	private JLabel[] img;
	private Image poo1_1, poo1_2;
	private Image poo2_1, poo2_2;
	private Image spa1_1, spa1_2;
	private Image spa2_1, spa2_2;
	private Image fit1_1, fit1_2;
	private Image fit2_1, fit2_2;

	private Image img_pool1, img_pool2;
	private Image img_pool3, img_pool4;
	private Image img_spa1, img_spa2, img_spa3, img_spa4;
	private Image img_fit1, img_fit2, img_fit3, img_fit4;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (combo.getSelectedIndex() == 1) {
			c_Center.removeAll();
			c_Center.setLayout(null);
			
			ImageIcon pool_icon3 = new ImageIcon("img//pool_info2.png");
			img_pool3 = pool_icon3.getImage();
			img_pool4 = img_pool3.getScaledInstance(1100, 100, Image.SCALE_SMOOTH);
			ImageIcon pool_icon4 = new ImageIcon(img_pool4);
			lbl111 = new JLabel(pool_icon4);
			lbl111.setLocation(10, 10);
			lbl111.setBounds(10, 50, 1100, 100);
			c_Center.add(lbl111);

			ImageIcon img1 = new ImageIcon("img//pool01.jpg");
			poo1_1 = img1.getImage();
			poo1_2 = poo1_1.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
			ImageIcon img1_1 = new ImageIcon(poo1_2);
			img[0] = new JLabel(img1_1);
			ImageIcon img3 = new ImageIcon("img//pool2.jpg");
			poo2_1 = img3.getImage();
			poo2_2 = poo2_1.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
			ImageIcon img3_1 = new ImageIcon(poo2_2);
			img[2] = new JLabel(img3_1);
			img[1] = new JLabel(img3_1);
			img[0].setLocation(50, 50);
			img[0].setBounds(30, 100, 500, 400);
			c_Center.add(img[0]);
			img[2].setLocation(50, 50);
			img[2].setBounds(570, 100, 500, 400);
			c_Center.add(img[2]);
			c_Center.setBackground(new Color(0xFFFFFF));

			
			ImageIcon pool_icon = new ImageIcon("img//pool_info.png");
			img_pool1 = pool_icon.getImage();
			img_pool2 = img_pool1.getScaledInstance(1000, 110, Image.SCALE_SMOOTH);
			ImageIcon pool_icon2 = new ImageIcon(img_pool2);
			lbl222 = new JLabel(pool_icon2);
			lbl222.setLocation(10, 10);
			lbl222.setBounds(0, 520, 1000, 110);
			c_Center.add(lbl222);

			c_Center.revalidate();
			c_Center.repaint();
		} else if (combo.getSelectedIndex() == 2) {
			c_Center.removeAll();
			
			ImageIcon spa_icon1 = new ImageIcon("img//spa_info.png");
			img_spa1 = spa_icon1.getImage();
			img_spa2 = img_spa1.getScaledInstance(1100, 100, Image.SCALE_SMOOTH);
			ImageIcon spa_icon2 = new ImageIcon(img_spa2);
			lbl33 = new JLabel(spa_icon2);
			this.setLayout(null);
			lbl33.setLocation(50, 50);
			lbl33.setBounds(10, 50, 1100, 100);
			c_Center.add(lbl33);

			ImageIcon spa1 = new ImageIcon("img//spa01.jpg");
			spa1_1 = spa1.getImage();
			spa1_2 = spa1_1.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
			ImageIcon spa_1 = new ImageIcon(spa1_2);
			img[3] = new JLabel(spa_1);
			ImageIcon spa2 = new ImageIcon("img//spa02.jpg");
			spa2_1 = spa2.getImage();
			spa2_2 = spa2_1.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
			ImageIcon spa_2 = new ImageIcon(spa2_2);
			img[4] = new JLabel(spa_2);
			img[3].setLocation(50, 50);
			img[3].setBounds(30, 100, 500, 400);
			c_Center.add(img[3]);
			img[4].setLocation(50, 50);
			img[4].setBounds(570, 100, 500, 400);
			c_Center.add(img[4]);
			this.setBackground(new Color(0xFFFFFF));
			
			ImageIcon spa_icon3 = new ImageIcon("img//spa_info2.png");
			img_spa3 = spa_icon3.getImage();
			img_spa4 = img_spa3.getScaledInstance(1000, 110, Image.SCALE_SMOOTH);
			ImageIcon spa_icon4 = new ImageIcon(img_spa4);
			lbl44 = new JLabel(spa_icon4);
			lbl44.setLocation(10, 10);
			lbl44.setBounds(0, 520, 1000, 110);
			c_Center.add(lbl44);

			c_Center.revalidate();
			c_Center.repaint();
		} else if (combo.getSelectedIndex() == 3) {//피트니스 
			c_Center.removeAll();
			c_Center.setLayout(null);
			
			ImageIcon fit_icon1 = new ImageIcon("img//fit_info.png");
			img_fit1 = fit_icon1.getImage();
			img_fit2 = img_fit1.getScaledInstance(1100, 100, Image.SCALE_SMOOTH);
			ImageIcon fit_icon2 = new ImageIcon(img_fit2);
			lbl55 = new JLabel(fit_icon2);
			lbl55.setLocation(50, 50);
			lbl55.setBounds(10, 50, 1100, 100);
			c_Center.add(lbl55);

			ImageIcon fit1 = new ImageIcon("img//fit01.jpg");
			fit1_1 = fit1.getImage();
			fit1_2 = fit1_1.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
			ImageIcon fit_1 = new ImageIcon(fit1_2);
			img[6] = new JLabel(fit_1);
			ImageIcon fit2 = new ImageIcon("img//fit02.jpg");
			fit2_1 = fit2.getImage();
			fit2_2 = fit2_1.getScaledInstance(500, 400, Image.SCALE_SMOOTH);
			ImageIcon fit_2 = new ImageIcon(fit2_2);
			img[7] = new JLabel(fit_2);
			img[6].setLocation(50, 50);
			img[6].setBounds(30, 100, 500, 400);
			c_Center.add(img[6]);
			img[7].setLocation(50, 50);
			img[7].setBounds(570, 100, 500, 400);
			c_Center.add(img[7]);
			c_Center.setBackground(new Color(0xFFFFFF));
			
			
			ImageIcon fit_icon3 = new ImageIcon("img//fit_info2.png");
			img_fit3 = fit_icon3.getImage();
			img_fit4 = img_fit3.getScaledInstance(1000, 110, Image.SCALE_SMOOTH);
			ImageIcon fit_icon4 = new ImageIcon(img_fit4);
			lbl66 = new JLabel(fit_icon4);
			lbl66.setLocation(10, 10);
			lbl66.setBounds(0, 520, 1000, 110);
			c_Center.add(lbl66);
			c_Center.revalidate();
			c_Center.repaint();
		}
		else if(combo.getSelectedIndex() == 0) {
			c_Center.removeAll();
			ImageIcon icon_rogo = new ImageIcon("img//rogo.jpg");
			rogo1 = icon_rogo.getImage();
			rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			ImageIcon icon_rogo2 = new ImageIcon(rogo2);
			rogo = new JLabel(icon_rogo2);
			north.add("Center", rogo);


			
			ImageIcon icon_info = new ImageIcon("img//info1.png");//품격이 다른 편안함으로 OO호텔은 당신의 휴식을 책임집니다
			info1 = icon_info.getImage();
			info2 = info1.getScaledInstance(1200, 130, Image.SCALE_SMOOTH);
			ImageIcon icon_info2 = new ImageIcon(info2);
			info = new JLabel(icon_info2);
			info.setLocation(10, 40);
			info.setBounds(10, 40, 1200, 100);
			
			
			ImageIcon icon_main = new ImageIcon("img//main.jpg");
			main1 = icon_main.getImage();
			main2 = main1.getScaledInstance(800, 530, Image.SCALE_SMOOTH);
			ImageIcon icon_main2 = new ImageIcon(main2);
			main = new JLabel(icon_main2);
			main.setLocation(50, 50);
			main.setBounds(200, 120, 800, 530);

			c_Center.add(info);
			c_Center.add(main);
			c_Center.setBackground(new Color(0xFFFFFF));
			c_Center.repaint();
		}

	}

	private JLabel lbl, info, rogo, main;
	private JPanel north, n_East, center, c_East, c_Center;
	private JComboBox combo;
	private String[] str = { "서비스", "야외 수영장", "스파", "피트니스" };
	private Image rogo1, rogo2;
	private Image main1, main2;
	private Image info1, info2;
	
	public Panel03() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		img = new JLabel[10];
		c_East = new JPanel();
		c_East.setBackground(new Color(0xFFFFFF));
		c_Center = new JPanel();
		c_Center.setLayout(null);
		combo = new JComboBox(str);
		combo.addActionListener(this);
		c_East.add(combo);
		north = new JPanel();
		north.setLayout(new BorderLayout());
		north.setBackground(new Color(0xFFFFFF));
		n_East = new JPanel();
		n_East.setLayout(new FlowLayout());
		n_East.setBackground(new Color(0xFFFFFF));
		north.add("East", n_East);
		this.add("North", north);
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(new Color(0xFFFFFF));
		center.add("Center", c_Center);
		center.add("East", c_East);

		ImageIcon icon_rogo = new ImageIcon("img//rogo.jpg");
		rogo1 = icon_rogo.getImage();
		rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		rogo = new JLabel(icon_rogo2);
		north.add("Center", rogo);


		
		ImageIcon icon_info = new ImageIcon("img//info1.png");//품격이 다른 편안함으로 OO호텔은 당신의 휴식을 책임집니다
		info1 = icon_info.getImage();
		info2 = info1.getScaledInstance(1200, 130, Image.SCALE_SMOOTH);
		ImageIcon icon_info2 = new ImageIcon(info2);
		info = new JLabel(icon_info2);
		info.setLocation(10, 40);
		info.setBounds(10, 40, 1200, 100);
		
		
		ImageIcon icon_main = new ImageIcon("img//main.jpg");
		main1 = icon_main.getImage();
		main2 = main1.getScaledInstance(800, 530, Image.SCALE_SMOOTH);
		ImageIcon icon_main2 = new ImageIcon(main2);
		main = new JLabel(icon_main2);
		main.setLocation(50, 50);
		main.setBounds(200, 120, 800, 530);

		c_Center.add(info);
		c_Center.add(main);
		c_Center.setBackground(new Color(0xFFFFFF));

		this.add("Center", center);

	}
}