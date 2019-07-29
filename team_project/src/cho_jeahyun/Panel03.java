package cho_jeahyun;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Image_Service {

	private boolean flag = false;// flag가 true면 종료
	ImageIcon[] image;

	Image_Service() {

		image = new ImageIcon[10];
		image[0] = new ImageIcon("src\\cyc\\fool01.png");
	}

	public class Panel03 extends JPanel {
		private JLabel[] lbl;
		private JLabel[] images;
		private JButton login;
		private JPanel north, n_East, center;
		private Image poo1_1, poo1_2;
		private Image poo2_1, poo2_2;
		private Image spa1_1, spa1_2;
		private Image spa2_1, spa2_2;
		private Image fit1_1, fit1_2;
		private Image fit2_1, fit2_2;

		public Panel03() {
			this.setVisible(true);
			this.setLayout(new BorderLayout());

			login = new JButton("로그인");
			north = new JPanel();
			north.setLayout(new BorderLayout());
			n_East = new JPanel();
			n_East.setLayout(new FlowLayout());
			n_East.add(login);
			north.add("East", n_East);
			this.add("North", north);
			center = new JPanel();
			center.setLayout(null);
			center.setBackground(new Color(0xFFFFFF));

			setLabel();
			setImage();
			center.add(lbl[0]);
			lbl[0].setLocation(50, 50);
			lbl[0].setBounds(10, 10, 500, 25);
			center.add(lbl[1]);
			lbl[1].setLocation(50, 50);
			lbl[1].setBounds(10, 70, 500, 25);
			images[0].setLocation(50, 50);
			images[0].setBounds(10, 110, 300, 200);
			center.add(images[0]);
			images[2].setLocation(50, 50);
			images[2].setBounds(330, 110, 300, 200);
			center.add(images[2]);

			center.add(lbl[2]);
			lbl[2].setLocation(50, 50);
			lbl[2].setBounds(10, 500, 500, 25);

			images[1].setLocation(50, 50);
			images[1].setBounds(10, 480, 900, 10);
			center.add(images[1]);

			images[3].setLocation(50, 50);
			images[3].setBounds(10, 530, 300, 200);
			center.add(images[3]);
			images[4].setLocation(50, 50);
			images[4].setBounds(330, 530, 300, 200);
			center.add(images[4]);

			images[1].setLocation(50, 50);
			images[1].setBounds(10, 800, 900, 10);
			center.add(images[1]);

			lbl[3].setLocation(50, 50);
			lbl[3].setBounds(10, 850, 500, 25);

			this.add("Center", center);
		}

		void setLabel() {
			lbl = new JLabel[10];
			lbl[0] = new JLabel("품격이 다른 편안함으로 당신의 휴식을 책임집니다.");
			lbl[0].setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lbl[0].setForeground(new Color(0x8B4513));
			lbl[1] = new JLabel("야외 수영장 | Pool");
			lbl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			lbl[2] = new JLabel("스파 | Spa");
			lbl[2].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			lbl[3] = new JLabel("피트니스 | Fitness");
			lbl[3].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		}

		void setImage() {
			images = new JLabel[10];
			ImageIcon img1 = new ImageIcon("img//pool01.jpg");
			poo1_1 = img1.getImage();
			poo1_2 = poo1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
			ImageIcon img1_1 = new ImageIcon(poo1_2);
			images[0] = new JLabel(img1_1);

			ImageIcon img2 = new ImageIcon("img//선.png");
			images[1] = new JLabel(img2);

			ImageIcon img3 = new ImageIcon("img//pool2.jpg");
			poo2_1 = img3.getImage();
			poo2_2 = poo2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
			ImageIcon img3_1 = new ImageIcon(poo2_2);
			images[2] = new JLabel(img3_1);

			ImageIcon spa1 = new ImageIcon("img//spa01.jpg");
			spa1_1 = spa1.getImage();
			spa1_2 = spa1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
			ImageIcon spa_1 = new ImageIcon(spa1_2);
			images[3] = new JLabel(spa_1);

			ImageIcon spa2 = new ImageIcon("img//spa02.jpg");
			spa2_1 = spa2.getImage();
			spa2_2 = spa2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
			ImageIcon spa_2 = new ImageIcon(spa2_2);
			images[4] = new JLabel(spa_2);

			ImageIcon img4 = new ImageIcon("img//선.png");
			images[5] = new JLabel(img4);

			ImageIcon fit1 = new ImageIcon("img//fit01.jpg");
			fit1_1 = fit1.getImage();
			fit1_2 = fit1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
			ImageIcon fit_1 = new ImageIcon(fit1_2);
			images[6] = new JLabel(fit_1);

			ImageIcon fit2 = new ImageIcon("img//fit02.jpg");
			fit2_1 = fit2.getImage();
			fit2_2 = spa2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
			ImageIcon fit_2 = new ImageIcon(fit2_2);
			images[7] = new JLabel(fit_2);
		}
	}
}

public class Panel03 extends JPanel {
	private JLabel[] lbl;
	private JLabel[] images;
	private Image_Service imgService;
	private JButton login;
	private JPanel north, n_East;
	public Panel03() {
		imgService = new Image_Service();
		this.setLayout(new BorderLayout());
		login = new JButton("로그인");
		
		north = new JPanel();
		n_East = new JPanel();
		n_East.add(login);
		north.add("East",n_East);
		this.add("North", north);
	}

	void setLabel() {
		lbl = new JLabel[10];

	}

	void setImage() {
		images = new JLabel[10];
		images[0].setIcon(imgService.image[0]);
		images[0].setSize(50, 50);
		images[0].setLocation(5, 20);
		this.add(images[0]);
	}

}
