package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel02 extends JPanel implements ActionListener{
	


	private JPanel north,north_east, center,center_content;
	private JPanel content_1,content_2,content_3;
	private ImageIcon img1,img2,img3;
	private ImageIcon res_img1, res_img2,res_img3;
	private JLabel rating1,text1,imglabel1;
	private JLabel rating2,text2,imglabel2;
	private JLabel rating3,text3,imglabel3;
	private Font font;
	private Image resizeimage;
	private Image result;
	MainFrame mf;
	Panel07 p7;

	private JComboBox room_select;
	
	private String room[] = {"�����ϼ���.","���ٴٵ�", "�����̾�", "����Ʈ"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object bt = e.getSource();
		if(room_select.getSelectedIndex() == 1) {
			center_content.removeAll();
			rating1.setText("���ٴٵ�");
			img1 = new ImageIcon("img//ȣ��02(���ٴٵ�).png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(550, 350, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			rating1.setBounds(65,7,55 , 15);
			text1.setBounds(65, 340, 420, 120);
			imglabel1.setBounds(65, 25, 550, 350);

			text1.setText("<html><body>�⺻Ÿ�� ��<br>��Ʃ��� Ÿ���� �Ľ��� �� ���ǿ� �޽��� ���� �� �ִ�"
				+ "���̺�� ü��, <br>�׸��� ��ź Ÿ���� �ƴ��� ü� �Ϻ��� OO�� ���� �⺻���� ���Դϴ�.</body></html>");
			center_content.add(rating1);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
		}else if(room_select.getSelectedIndex() == 2) {
			center_content.removeAll();
			rating1.setText("�����̾�");
			imglabel1 = new JLabel(res_img1);
			img1 = new ImageIcon("img//ȣ��03(�����̾�).png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(550, 350, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			rating1.setBounds(65,7,55 , 15);
			text1.setBounds(65, 350, 420, 120);
			imglabel1.setBounds(65, 25, 550, 350);
			text1.setText("<html><body>��Ʃ��� Ÿ�� ������<br>��Ʃ��� Ÿ�� ���ǿ� ��� ������ ī��Ʈ�� ȭ��Ʈ �к긯 ���İ� ���õ� ������<br>"
					+ "�ھƳ���, �޽��� ���� �� �ִ� ���̴� ���̺�� ü� �Ϻ��� ���ֽŶ��� ���Ƿ�<br>"
					+ "5~8���� ��ġ�� ������ ���� ǳ���� ���� �� �� �ִ� �����Դϴ�.");
			center_content.add(rating1);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
		}else if(room_select.getSelectedIndex() == 3){
			center_content.removeAll();
			rating1.setText("����Ʈ");
			img1 = new ImageIcon("img//ȣ��04(����Ʈ).png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(550, 350, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			text1.setText("<html><body>����� ������ �޾� ����Ʈ ���׸��� �ڳ� ����Ʈ�� ���� 1������ 6������ �ǹ� ���� ���� �� �κп� ��ġ�Ͽ� ���� ��������<br>"
					+ "Ź Ʈ�� ���� ������, ���� �������� ������ Ǫ�� �ٴ��� �Ѷ���� ��ǰ�� �Բ� ��� �� "
					+ "�ֽ��ϴ�.<br>"
					+ "ħ�ǰ� �Ž�, ����� �и��Ǿ� ������ ħ�ǰ� �Ž� ���̴� �������� ����� �Ǿ� �ֽ�<br>"
					+ "�ϴ�. ����, Ŀ��Ʈ � ��ü������ ȭ��Ʈ, ���̵� �׸�, ��� ���� ���������, ĳ����<br>"
					+ "ħ��� Ŭ������ ȭ���� ����Ʈ�� ����� ������ ���� ��Ƚ��ϴ�."
					+ "<br>ħ�뿷���� ������ �ִ� ��ź �� ü� ���� ����Ʈ�� ����� ������ ���� �Ͽ����ϴ�.</body></html>");
			rating1.setBounds(65,7,55 , 15);
			text1.setBounds(65, 380, 420, 200);
			imglabel1.setBounds(65, 25, 550, 350);
			center_content.add(rating1);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
		
		}
	}
	Panel02(MainFrame mf){
		this.mf = mf;
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		north_east = new JPanel(new FlowLayout());
		
		room_select = new JComboBox<String>(room);
		room_select.addActionListener(this);

		north.add("East",north_east);
		
		center = new JPanel(new BorderLayout());
		center_content = new JPanel();
		center_content.setLayout(null);
		
		rating1 = new JLabel();
		img1 = new ImageIcon();
		imglabel1 = new JLabel();
		text1 = new JLabel();


		room_select.setBounds(650, 7, 150, 25);
		
		
		center_content.add(room_select);
		
		center.add(center_content);
		center_content.setBackground(new Color(0xb6e7f0));
		this.add("Center",center);
		this.add("North", north);
		
		this.setVisible(true);
		
	}

}
