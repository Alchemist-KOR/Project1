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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (combo.getSelectedIndex() == 1) {
			c_Center.removeAll();

			lbl111 = new JLabel("�߿� ������ | Pool");
			lbl111.setFont(new Font("���� ���", Font.BOLD, 20));
			lbl111.setForeground(new Color(0x8B4513));
			c_Center.setLayout(null);
			lbl111.setLocation(10, 10);
			lbl111.setBounds(10, 50, 500, 25);
			c_Center.add(lbl111);

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
			img[0].setBounds(10, 100, 300, 200);
			c_Center.add(img[0]);
			img[2].setLocation(50, 50);
			img[2].setBounds(330, 100, 300, 200);
			c_Center.add(img[2]);
			c_Center.setBackground(new Color(0xFFFFFF));

			lbl222 = new JLabel("<html><body>���� OOOȣ���� �߿� ������, ��� ���Ϸ���� '���� �� �޽��� ��' ������ �߿� ������ �Դϴ�.<br>"
					+ "���� Ư��ȣ�� ���� �¼���, ������, ����ž, ī�ٳ� �� ������ �ٸ� �ƿ����� ��������Ÿ���� ���� �� �ֽ��ϴ�.<br>"
					+ "��� ���Ϸ���� �������� ���ٸ� �׸��� �湮�Ͻ� ������ ���ο� ������ �����մϴ�.</body></html>");
			lbl222.setFont(new Font("���� ���", Font.PLAIN, 12));
			lbl222.setLocation(10, 10);
			lbl222.setBounds(10, 350, 500, 100);
			c_Center.add(lbl222);

			c_Center.revalidate();
			c_Center.repaint();
		} else if (combo.getSelectedIndex() == 2) {
			c_Center.removeAll();
			lbl33 = new JLabel("���� | Spa");
			lbl33.setFont(new Font("���� ���", Font.BOLD, 20));
			lbl33.setForeground(new Color(0x8B4513));
			this.setLayout(null);
			lbl33.setLocation(50, 50);
			lbl33.setBounds(10, 50, 500, 25);
			c_Center.add(lbl33);

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
			img[3].setBounds(10, 100, 300, 200);
			c_Center.add(img[3]);
			img[4].setLocation(50, 50);
			img[4].setBounds(330, 100, 300, 200);
			c_Center.add(img[4]);
			this.setBackground(new Color(0xFFFFFF));
			lbl44 = new JLabel("<html><body>���� OOOȣ���� ���Ĵ� �����̹��ÿ� ������ ����� �������� �����ο� ������ �ǳ� ��쳪�Դϴ�.<br>"
					+ "��޽����� �ü��� ���񽺷� �����ο� �޽��� ���� �� �ֽ��ϴ�.<br>" + "���� ���� �ν� �� ���Ž� �� �����̹��ð� �� �ü��� ���߰� ������,<br>"
					+ "���⿡ ���� ������ �� �ִ� �پ��� �µ��� ũ���� ��쳪 �� ���� �����ϰ� �ֽ��ϴ�.</body></html>");
			lbl44.setFont(new Font("���� ���", Font.PLAIN, 12));
			lbl44.setLocation(10, 10);
			lbl44.setBounds(10, 330, 500, 100);
			c_Center.add(lbl44);

			c_Center.revalidate();
			c_Center.repaint();
		} else if (combo.getSelectedIndex() == 3) {
			c_Center.removeAll();
			lbl55 = new JLabel("��Ʈ�Ͻ� | Fitness");
			lbl55.setFont(new Font("���� ���", Font.BOLD, 20));
			lbl55.setForeground(new Color(0x8B4513));
			c_Center.setLayout(null);
			lbl55.setLocation(50, 50);
			lbl55.setBounds(10, 50, 500, 25);
			c_Center.add(lbl55);

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
			img[6].setBounds(10, 100, 300, 200);
			c_Center.add(img[6]);
			img[7].setLocation(50, 50);
			img[7].setBounds(330, 100, 300, 200);
			c_Center.add(img[7]);
			c_Center.setBackground(new Color(0xFFFFFF));
			lbl66 = new JLabel(
					"<html><body>ü������ ü�°����� ���� ��ɺ� ������ �ֻ��� �޽��� ���� �������� �����Ǿ� ��� �޽��� ��ȭ�Ӱ� ���� �� �ִ� �ǳ� ü������<br>"
							+ "�������� ����Ͽ� ����� ����, ������ ������ ���� �������� �̾����� ��å�ڽ��� ���õǾ� �ֽ��ϴ�.</body></html>");
			lbl66.setFont(new Font("���� ���", Font.PLAIN, 12));
			lbl66.setLocation(10, 10);
			lbl66.setBounds(10, 350, 500, 100);
			c_Center.add(lbl66);
			c_Center.revalidate();
			c_Center.repaint();
		}

	}

	private JLabel lbl, info, rogo, main;
	private JPanel north, n_East, center, c_East, c_Center;
	private JComboBox combo;
	private String[] str = { "����", "�߿� ������", "����", "��Ʈ�Ͻ�" };
	private Image rogo1, rogo2;
	private Image main1, main2;

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

		lbl = new JLabel("����");
		lbl.setFont(new Font("���� ���", Font.BOLD, 20));
		lbl.setForeground(new Color(0x8B4513));
		lbl.setLocation(50, 50);
		lbl.setBounds(10, 10, 500, 25);
		c_Center.add(lbl);
		info = new JLabel("ǰ���� �ٸ� ��������� ����� �޽��� å�����ϴ�.");
		info.setFont(new Font("����", Font.ITALIC, 13));
		info.setLocation(50, 50);
		info.setBounds(10, 40, 500, 25);
		ImageIcon icon_main = new ImageIcon("img//main.jpg");
		main1 = icon_main.getImage();
		main2 = main1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon icon_main2 = new ImageIcon(main2);
		main = new JLabel(icon_main2);
		main.setLocation(50, 50);
		main.setBounds(10, 70, 500, 500);

		c_Center.add(info);
		c_Center.add(main);
		c_Center.setBackground(new Color(0xFFFFFF));

		this.add("Center", center);

	}
}