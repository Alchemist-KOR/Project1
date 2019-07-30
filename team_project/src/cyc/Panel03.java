package cyc;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


//컴포넌트전환으로 수정했어요


class PoolPanel extends JPanel{
	private JLabel lbl;
	private JLabel[] img;
	private Image poo1_1, poo1_2; private Image poo2_1, poo2_2;
	PoolPanel(){
		lbl = new JLabel("야외 수영장 | Pool");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20 ));
		lbl.setForeground(new Color(0x8B4513));
		this.setLayout(null);
		lbl.setLocation(50, 50);
		lbl.setBounds(10, 10, 500, 25);
		this.add(lbl);
		
		img = new JLabel[10];
		ImageIcon img1 = new ImageIcon("img//pool01.jpg");
		poo1_1 = img1.getImage();
		poo1_2 = poo1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		ImageIcon img1_1 = new ImageIcon(poo1_2);
		img[0] = new JLabel(img1_1);
		ImageIcon img3 = new ImageIcon("img//pool2.jpg");
		poo2_1 = img3.getImage();
		poo2_2 = poo2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		ImageIcon img3_1 = new ImageIcon(poo2_2);
		img[2] = new JLabel(img3_1);
		img[1] = new JLabel(img3_1);
		img[0].setLocation(50, 50);
		img[0].setBounds(10, 110, 300, 200);
		this.add(img[0]);
		img[2].setLocation(50, 50);
		img[2].setBounds(330, 110, 300, 200);
		this.add(img[2]);
		this.setBackground(new Color(0xFFFFFF));
	}
}
class SpaPanel extends JPanel{
	private JLabel lbl;
	private JLabel[] img;
	private Image spa1_1, spa1_2; private Image spa2_1, spa2_2;
	public String s;
	SpaPanel(){

		lbl = new JLabel("스파 | Spa");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20 ));
		lbl.setForeground(new Color(0x8B4513));
		this.setLayout(null);
		lbl.setLocation(50, 50);
		lbl.setBounds(10, 10, 500, 25);
		this.add(lbl);
		
		img = new JLabel[10];
		ImageIcon spa1 = new ImageIcon("img//spa01.jpg");
		spa1_1 = spa1.getImage();
		spa1_2 = spa1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		ImageIcon spa_1 = new ImageIcon(spa1_2);
		img[3] = new JLabel(spa_1);
		ImageIcon spa2 = new ImageIcon("img//spa02.jpg");
		spa2_1 = spa2.getImage();
		spa2_2 = spa2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		ImageIcon spa_2 = new ImageIcon(spa2_2);
		img[4] = new JLabel(spa_2);
		img[3].setLocation(50, 50);
		img[3].setBounds(10, 330, 300, 200);
		this.add(img[3]);
		img[4].setLocation(50, 50);
		img[4].setBounds(330, 330, 300, 200);
		this.add(img[4]);
		this.setBackground(new Color(0xFFFFFF));
	}
}
class FitnessPanel extends JPanel{
	private JLabel lbl;
	private JLabel[] img;
	private Image fit1_1, fit1_2; private Image fit2_1, fit2_2;
	FitnessPanel(){

		lbl = new JLabel("피트니스 | Fitness");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20 ));
		lbl.setForeground(new Color(0x8B4513));
		this.setLayout(null);
		lbl.setLocation(50, 50);
		lbl.setBounds(10, 10, 500, 25);
		this.add(lbl);
		
		img = new JLabel[10];
		ImageIcon fit1 = new ImageIcon("img//fit01.jpg");
		fit1_1 = fit1.getImage();
		fit1_2 = fit1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		ImageIcon fit_1 = new ImageIcon(fit1_2);
		img[6] = new JLabel(fit_1);
		ImageIcon fit2 = new ImageIcon("img//fit02.jpg");
		fit2_1 = fit2.getImage();
		fit2_2 = fit2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		ImageIcon fit_2 = new ImageIcon(fit2_2);
		img[7] = new JLabel(fit_2);
		img[6].setLocation(50, 50);
		img[6].setBounds(10, 680, 300, 200);
		this.add(img[6]);
		img[7].setLocation(50, 50);
		img[7].setBounds(330, 680, 300, 200);
		this.add(img[7]);
		this.setBackground(new Color(0xFFFFFF));
	}
}
public class Panel03 extends JPanel implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == swimmingpool) {
			center.removeAll();
			poolPanel = new PoolPanel();
			this.add("Center", poolPanel);
			swimmingpool.revalidate();
			swimmingpool.repaint();
		}else if(obj == sauna) {
			center.removeAll();
			spaPanel = new SpaPanel();
			this.add("Center", spaPanel);
			spaPanel.revalidate();
			spaPanel.repaint();
		}else if(obj == fitnesscenter) {
			center.removeAll();
			fitPanel = new FitnessPanel();
			this.add("Center", fitPanel);
			fitnesscenter.revalidate();
			fitnesscenter.repaint();
		}
		
	}
	public PoolPanel poolPanel;
	public SpaPanel spaPanel;
	public FitnessPanel fitPanel;
	private JLabel lbl, rogo, info, main;
//	private JLabel[] images;
	private JButton login, swimmingpool, sauna, fitnesscenter;
	private JPanel north, n_East, center, south;
//	private Image poo1_1, poo1_2; private Image poo2_1, poo2_2;
//	private Image spa1_1, spa1_2; private Image spa2_1, spa2_2;
//	private Image fit1_1, fit1_2; private Image fit2_1, fit2_2;
	private Image rogo1, rogo2;private Image main1, main2;
	public Panel03() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		swimmingpool = new JButton("야외 수영장");
		sauna = new JButton("스파");
		fitnesscenter = new JButton("피트니스");
		swimmingpool.addActionListener(this);
		sauna.addActionListener(this);
		fitnesscenter.addActionListener(this);
		south = new JPanel();
		south.add(swimmingpool);
		south.add(sauna);
		south.add(fitnesscenter);
		this.add("South", south);
		login = new JButton("로그인");
		north = new JPanel();
		north.setLayout(new BorderLayout());
		n_East = new JPanel();
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
		
		lbl = new JLabel("서비스");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20 ));
		lbl.setForeground(new Color(0x8B4513));
		lbl.setLocation(50, 50);
		lbl.setBounds(10, 10, 500, 25);
		center.add(lbl);
		info =new JLabel("품격이 다른 편안함으로 당신의 휴식을 책임집니다.");
		info.setFont(new Font("바탕", Font.ITALIC, 13 ));
		info.setLocation(50, 50);
		info.setBounds(10, 40, 500, 25);
		center.add(info);
		
		ImageIcon icon_main = new ImageIcon("img//rogo.jpg");
		main1 = icon_main.getImage();
		main2 = main1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon icon_main2 = new ImageIcon(main2);
		main = new JLabel(icon_main2);
		main.setLocation(50, 50);
		main.setBounds(10, 70, 500, 500);
		center.add("Center",main);
		
		
//		setLabel();
//		setImage();
//		center.add(lbl[0]);
//		lbl[0].setLocation(50, 50);
//		lbl[0].setBounds(10, 10, 500, 25);
//		center.add(lbl[1]);//야외수영장
//		lbl[1].setLocation(50, 50);
//		lbl[1].setBounds(10, 70, 500, 25);
//		images[0].setLocation(50, 50);
//		images[0].setBounds(10, 110, 300, 200);
//		center.add(images[0]);
//		images[2].setLocation(50, 50);
//		images[2].setBounds(330, 110, 300, 200);
//		center.add(images[2]);
//		
////		images[1].setLocation(50, 50);
////		images[1].setBounds(10, 330, 900, 10);
////		center.add(images[1]);//선
//		
//		lbl[2].setLocation(50, 50);
//		lbl[2].setBounds(10, 300, 500, 25);
//		center.add(lbl[2]);//
//		
//		images[3].setLocation(50, 50);
//		images[3].setBounds(10, 330, 300, 200);
//		center.add(images[3]);
//		images[4].setLocation(50, 50);
//		images[4].setBounds(330, 330, 300, 200);
//		center.add(images[4]);
//		
////		images[5].setLocation(50, 50);
////		images[5].setBounds(10, 650, 900, 10);
////		center.add(images[5]);
//		
//		lbl[3].setLocation(50, 50);
//		lbl[3].setBounds(10, 650, 500, 25);
//		
//		images[6].setLocation(50, 50);
//		images[6].setBounds(10, 680, 300, 200);
//		center.add(images[6]);
//		images[7].setLocation(50, 50);
//		images[7].setBounds(330, 680, 300, 200);
//		center.add(images[7]);
//		
//		
		this.add("Center",center);
	}

//	void setLabel() {
//		lbl = new JLabel[10];
//		lbl[0] =new JLabel("품격이 다른 편안함으로 당신의 휴식을 책임집니다.");
//		lbl[0].setFont(new Font("맑은 고딕", Font.BOLD, 20 ));
//		lbl[0].setForeground(new Color(0x8B4513));
//		lbl[1] =new JLabel("야외 수영장 | Pool");
//		lbl[1].setFont(new Font("맑은 고딕", Font.PLAIN, 15 ));
//		lbl[2] =new JLabel("스파 | Spa");
//		lbl[2].setFont(new Font("맑은 고딕", Font.PLAIN, 15 ));
//		lbl[3] =new JLabel("피트니스 | Fitness");
//		lbl[3].setFont(new Font("맑은 고딕", Font.PLAIN, 15 ));
//	}
//
//	void setImage() {
//		images = new JLabel[10];
//		ImageIcon img1 = new ImageIcon("img//pool01.jpg");
//		poo1_1 = img1.getImage();
//		poo1_2 = poo1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//		ImageIcon img1_1 = new ImageIcon(poo1_2);
//		images[0] = new JLabel(img1_1);
//		
////		ImageIcon img2 = new ImageIcon("img//선.png");
////		images[1] = new JLabel(img2);
//		
//		ImageIcon img3 = new ImageIcon("img//pool2.jpg");
//		poo2_1 = img3.getImage();
//		poo2_2 = poo2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//		ImageIcon img3_1 = new ImageIcon(poo2_2);
//		images[2] = new JLabel(img3_1);
//
//		ImageIcon spa1 = new ImageIcon("img//spa01.jpg");
//		spa1_1 = spa1.getImage();
//		spa1_2 = spa1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//		ImageIcon spa_1 = new ImageIcon(spa1_2);
//		images[3] = new JLabel(spa_1);
//		
//		ImageIcon spa2 = new ImageIcon("img//spa02.jpg");
//		spa2_1 = spa2.getImage();
//		spa2_2 = spa2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//		ImageIcon spa_2 = new ImageIcon(spa2_2);
//		images[4] = new JLabel(spa_2);
//		
////		ImageIcon img4 = new ImageIcon("img//선.png");
////		images[5] = new JLabel(img4);
//		
//		ImageIcon fit1 = new ImageIcon("img//fit01.jpg");
//		fit1_1 = fit1.getImage();
//		fit1_2 = fit1_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//		ImageIcon fit_1 = new ImageIcon(fit1_2);
//		images[6] = new JLabel(fit_1);
//		
//		ImageIcon fit2 = new ImageIcon("img//fit02.jpg");
//		fit2_1 = fit2.getImage();
//		fit2_2 = spa2_1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//		ImageIcon fit_2 = new ImageIcon(fit2_2);
//		images[7] = new JLabel(fit_2);
//	}

	public static void main(String[] args) {
		
	}

}