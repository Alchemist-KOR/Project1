package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel02 extends JPanel{
	private JButton login;
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

	
	
	
	
	Panel02(){
		
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		north_east = new JPanel(new FlowLayout());
		
		login = new JButton("�α���");
		
		north_east.add(login);
		north.add("East",north_east);
		
		center = new JPanel(new BorderLayout());
		center_content = new JPanel();
		center_content.setLayout(null);
		
		rating1 = new JLabel("���ٴٵ�");
		img1 = new ImageIcon("img//ȣ��02(���ٴٵ�).png");
		resizeimage = img1.getImage();
		result = resizeimage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		res_img1 = new ImageIcon(result);
		imglabel1 = new JLabel(res_img1);
		text1 = new JLabel("<html><body>�⺻Ÿ�� ��<br>��Ʃ��� Ÿ���� �Ľ��� �� ���ǿ� �޽��� ���� �� �ִ�"
				+ "���̺�� ü��, <br>�׸��� ��ź Ÿ���� �ƴ��� ü� �Ϻ��� OO�� ���� �⺻���� ���Դϴ�.</body></html>");
		
		rating2 = new JLabel("�����̾�");
		img2 = new ImageIcon("img//ȣ��03(�����̾�).png");
		resizeimage = img2.getImage();
		result = resizeimage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		res_img2 = new ImageIcon(result);
		imglabel2 = new JLabel(res_img2);
		text2 = new JLabel("<html><body>��Ʃ��� Ÿ�� ������<br>��Ʃ��� Ÿ�� ���ǿ� ��� ������ ī��Ʈ�� ȭ��Ʈ �к긯 ���İ� ���õ� ������<br>"
				+ "�ھƳ���, �޽��� ���� �� �ִ� ���̴� ���̺�� ü� �Ϻ��� ���ֽŶ��� ���Ƿ�<br>"
				+ "5~8���� ��ġ�� ������ ���� ǳ���� ���� �� �� �ִ� �����Դϴ�.");
		
		rating3 = new JLabel("����Ʈ");
		img3 = new ImageIcon("img//ȣ��04(����Ʈ).png");
		resizeimage = img3.getImage();
		result = resizeimage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		res_img3 = new ImageIcon(result);
		imglabel3 = new JLabel(res_img3);
		text3 = new JLabel("<html><body>����� ������ �޾� ����Ʈ ���׸���<br>�ڳ� ����Ʈ�� ���� 1������ 6������ �ǹ� ���� ���� �� �κп� ��ġ�Ͽ� ���� ��������<br>"
				+ "Ź Ʈ�� ���� ������, ���� �������� ������ Ǫ�� �ٴ��� �Ѷ���� ��ǰ�� �Բ� ��� ��<br>"
				+ "�ֽ��ϴ�.<br>"
				+ "ħ�ǰ� �Ž�, ����� �и��Ǿ� ������ ħ�ǰ� �Ž� ���̴� �������� ����� �Ǿ� �ֽ�<br>"
				+ "�ϴ�. ����, Ŀ��Ʈ � ��ü������ ȭ��Ʈ, ���̵� �׸�, ��� ���� ���������, ĳ����<br>"
				+ "ħ��� Ŭ������ ȭ���� ����Ʈ�� ����� ������ ���� ��Ƚ��ϴ�."
				+ "<br>ħ�뿷���� ������ �ִ� ��ź �� ü� ���� ����Ʈ�� ����� ������ ���� �Ͽ����ϴ�.</body></html>");
		
		
		
		rating1.setBounds(65,7,55 , 15);
		imglabel1.setBounds(65, 25, 400, 200);
		text1.setBounds(65, 190, 420, 120);
		
		rating2.setBounds(65,320,55, 15);
		imglabel2.setBounds(65, 340, 400, 200);
		text2.setBounds(65, 530, 420, 150);
		
		rating3.setBounds(65,690,55 , 15);
		imglabel3.setBounds(65, 710, 400, 200);
		text3.setBounds(65, 860, 420, 350);
		
		center_content.add(rating1);
		center_content.add(imglabel1);
		center.setAlignmentX(imglabel1.LEFT_ALIGNMENT);
		center_content.add(text1);
		
		//center_content.add(content_1);
		
		center_content.add(rating2);
		center_content.add(imglabel2);
		center.setAlignmentX(imglabel2.LEFT_ALIGNMENT);
		center_content.add(text2);
		
		center_content.add(rating3);
		center_content.add(imglabel3);
		center.setAlignmentX(imglabel3.LEFT_ALIGNMENT);
		center_content.add(text3);
		
		
		center.add(center_content);

		
		
		this.add("Center",center);
		this.add("North", north);
		
		this.setVisible(true);
		
	}

}
