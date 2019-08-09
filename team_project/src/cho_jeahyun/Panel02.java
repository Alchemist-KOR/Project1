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
	


	private JPanel north, center,center_content;
	private ImageIcon img1,img2;
	private ImageIcon res_img1, res_img2;
	private JLabel text1,imglabel1, imglabel2;
	private Image resizeimage, resizeimage2;
	private Image result;
	private JButton left, right;
	MainFrame mf;
	Panel07 p7;
	int count = 1;
	int change_image = 0;

	private JComboBox room_select;
	
	private String room[] = {"���ٴٵ�", "�����̾�", "����Ʈ"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object bt = e.getSource();
		if(room_select.getSelectedIndex() == 1) {
			change_image = 1;
		}else if(room_select.getSelectedIndex() == 2) {
			change_image = 2;
		}else if(room_select.getSelectedIndex() == 3) {
			change_image = 3;
		}
		if(room_select.getSelectedIndex() == 0) {
			center_content.removeAll();
			
			
			img2 = new ImageIcon("img//���ٴٵ�.PNG");
			resizeimage2 = img2.getImage();
			result = resizeimage2.getScaledInstance(450, 70, Image.SCALE_SMOOTH);
			res_img2 = new ImageIcon(result);
			imglabel2 = new JLabel(res_img2);
			
			img1 = new ImageIcon("img//hotel_class//ȣ��02(���ٴٵ�)1.png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			
			imglabel2.setBounds(60,15, 450 , 70);
			imglabel1.setBounds(200, 100, 750, 450);
			text1.setBounds(200, 520, 420, 120);
			

			text1.setText("<html><body>�⺻Ÿ�� ��<br>��Ʃ��� Ÿ���� �Ľ��� �� ���ǿ� �޽��� ���� �� �ִ�"
				+ "���̺�� ü��, <br>�׸��� ��ź Ÿ���� �ƴ��� ü� �Ϻ��� OO�� ���� �⺻���� ���Դϴ�.</body></html>");
			center_content.add(left);
			center_content.add(right);
			center_content.add(imglabel2);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
			
		}else if(room_select.getSelectedIndex() == 1) {
			center_content.removeAll();
			
			
			img2 = new ImageIcon("img//�����̾�.PNG");
			resizeimage2 = img2.getImage();
			result = resizeimage2.getScaledInstance(450, 55, Image.SCALE_SMOOTH);
			res_img2 = new ImageIcon(result);
			imglabel2 = new JLabel(res_img2);
			
			
			imglabel1 = new JLabel(res_img1);
			img1 = new ImageIcon("img//hotel_class//ȣ��03(�����̾�)1.png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			imglabel2.setBounds(60,30, 450 , 55);
			imglabel1.setBounds(200, 100, 750, 450);
			text1.setBounds(200, 530, 650, 120);
			text1.setText("<html><body>��Ʃ��� Ÿ�� ������<br>��Ʃ��� Ÿ�� ���ǿ� ��� ������ ī��Ʈ�� ȭ��Ʈ �к긯 ���İ� ���õ� ������<br>"
					+ "�ھƳ���, �޽��� ���� �� �ִ� ���̴� ���̺�� ü� �Ϻ��� ���ֽŶ��� ���Ƿ�<br>"
					+ "5~8���� ��ġ�� ������ ���� ǳ���� ���� �� �� �ִ� �����Դϴ�.");
			center_content.add(left);
			center_content.add(right);
			center_content.add(imglabel2);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
		}else if(room_select.getSelectedIndex() == 2){
			center_content.removeAll();
			
			
			img2 = new ImageIcon("img//����Ʈ.PNG");
			resizeimage2 = img2.getImage();
			result = resizeimage2.getScaledInstance(450, 60, Image.SCALE_SMOOTH);
			res_img2 = new ImageIcon(result);
			imglabel2 = new JLabel(res_img2);
			
			
			img1 = new ImageIcon("img//hotel_class//ȣ��04(����Ʈ)1.png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			text1.setText("<html><body>����� ������ �޾� ����Ʈ ���׸��� �ڳ� ����Ʈ�� ���� 1������ 6�������ǹ� ���� ���� �� �κп� ��ġ�Ͽ� ���� ��������<br>"
					+ "Ź Ʈ�� ���� ������, ���� �������� ������ Ǫ�� �ٴ��� �Ѷ���� ��ǰ�� �Բ� ��� �� "
					+ "�ֽ��ϴ�.<br>"
					+ "ħ�ǰ� �Ž�, ����� �и��Ǿ� ������ ħ�ǰ� �Ž� ���̴� �������� ����� �Ǿ� �ֽ�"
					+ "�ϴ�. ����, Ŀ��Ʈ � ��ü������ ȭ��Ʈ,<br> ���̵� �׸�, ��� ���� ���������, ĳ����"
					+ "ħ��� Ŭ������ ȭ���� ����Ʈ�� ����� ������ ���� ��Ƚ��ϴ�."
					+ "ħ�뿷���� ������ �ִ� ��ź �� ü� ���� ����Ʈ�� ����� ������ ���� �Ͽ����ϴ�.</body></html>");
			imglabel2.setBounds(60,30, 450 , 60);
			imglabel1.setBounds(200, 100, 750, 450);
			text1.setBounds(200, 530, 800, 150);
			center_content.add(left);
			center_content.add(right);
			center_content.add(imglabel2);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
		
		}
		if(change_image == 1) {
			
			if(bt == right) {
				center_content.removeAll();
				
				if(count <5) count++;
				if(count == 5) count=1;
				
				img1 = new ImageIcon("img//hotel_class//ȣ��02(���ٴٵ�)"+count+".png");
				resizeimage = img1.getImage();
				result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
				res_img1 = new ImageIcon(result);
				imglabel1 = new JLabel(res_img1);
				imglabel1.setBounds(200, 100, 750, 450);
				
				center_content.add(left);
				center_content.add(right);
				center_content.add(imglabel2);
				center_content.add(imglabel1);
				center_content.add(text1);
				center_content.add(room_select);
				center_content.repaint();
				
				
			}else if(bt == left) {
				center_content.removeAll();
				
				if(count > 0 )count--;
				if(count == 0) count = 4;
				
				img1 = new ImageIcon("img//hotel_class//ȣ��02(���ٴٵ�)"+count+".png");
				resizeimage = img1.getImage();
				result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
				res_img1 = new ImageIcon(result);
				imglabel1 = new JLabel(res_img1);
				
				imglabel1.setBounds(200, 100, 750, 450);
				
				center_content.add(left);
				center_content.add(right);
				center_content.add(imglabel2);
				center_content.add(imglabel1);
				center_content.add(text1);
				center_content.add(room_select);
				center_content.repaint();
			}
		}else if(change_image == 2) {
			if(bt == right) {
				center_content.removeAll();
				
				if(count <5) count++;
				if(count == 5) count=1;
				
				img1 = new ImageIcon("img//hotel_class//ȣ��03(�����̾�)"+count+".png");
				resizeimage = img1.getImage();
				result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
				res_img1 = new ImageIcon(result);
				imglabel1 = new JLabel(res_img1);
				imglabel1.setBounds(200, 100, 750, 450);
				
				center_content.add(left);
				center_content.add(right);
				center_content.add(imglabel2);
				center_content.add(imglabel1);
				center_content.add(text1);
				center_content.add(room_select);
				center_content.repaint();
				
				
			}else if(bt == left) {
				center_content.removeAll();
				
				if(count > 0 )count--;
				if(count == 0) count = 4;
				
				img1 = new ImageIcon("img//hotel_class//ȣ��03(�����̾�)"+count+".png");
				resizeimage = img1.getImage();
				result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
				res_img1 = new ImageIcon(result);
				imglabel1 = new JLabel(res_img1);
				
				imglabel1.setBounds(200, 100, 750, 450);
				
				center_content.add(left);
				center_content.add(right);
				center_content.add(imglabel2);
				center_content.add(imglabel1);
				center_content.add(text1);
				center_content.add(room_select);
				center_content.repaint();
			}
		}else if(change_image == 3) {
			if(bt == right) {
				center_content.removeAll();
				
				if(count <5) count++;
				if(count == 5) count=1;
				
				img1 = new ImageIcon("img//hotel_class//ȣ��04(����Ʈ)"+count+".png");
				resizeimage = img1.getImage();
				result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
				res_img1 = new ImageIcon(result);
				imglabel1 = new JLabel(res_img1);
				imglabel1.setBounds(200, 100, 750, 450);
				
				center_content.add(left);
				center_content.add(right);
				center_content.add(imglabel2);
				center_content.add(imglabel1);
				center_content.add(text1);
				center_content.add(room_select);
				center_content.repaint();
				
				
			}else if(bt == left) {
				center_content.removeAll();
				
				if(count > 0 )count--;
				if(count == 0) count = 4;
				
				img1 = new ImageIcon("img//hotel_class//ȣ��04(����Ʈ)"+count+".png");
				resizeimage = img1.getImage();
				result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
				res_img1 = new ImageIcon(result);
				imglabel1 = new JLabel(res_img1);
				
				imglabel1.setBounds(200, 100, 750, 450);
				
				center_content.add(left);
				center_content.add(right);
				center_content.add(imglabel2);
				center_content.add(imglabel1);
				center_content.add(text1);
				center_content.add(room_select);
				center_content.repaint();
			}
		}
		
	}
	Panel02(MainFrame mf){
		this.mf = mf;
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		
		room_select = new JComboBox<String>(room);
		room_select.addActionListener(this);
		
		left = new JButton(new ImageIcon("img//left.png"));
		left.addActionListener(this);
		left.setBorderPainted(false); left.setContentAreaFilled(false);
		left.setBounds(40, 210, 150, 200);
		

		right = new JButton(new ImageIcon("img//right.png"));
		right.addActionListener(this);
		right.setBorderPainted(false); right.setContentAreaFilled(false);
		right.setBounds(950, 210, 150, 200);

		
		center = new JPanel(new BorderLayout());
		center_content = new JPanel();
		center_content.setLayout(null);
		
		
//		img1 = new ImageIcon();
//		imglabel1 = new JLabel();
//		imglabel2 = new JLabel();
		text1 = new JLabel();

		ImageIcon icon_rogo = new ImageIcon("img//rogo.jpg");
		Image rogo1 = icon_rogo.getImage();
		Image rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		JLabel rogo = new JLabel(icon_rogo2);
		north.add("Center", rogo);
		
		north.setBackground(Color.white);

		room_select.setBounds(1000, 7, 150, 25);
		
		img2 = new ImageIcon("img//���ٴٵ�.PNG");
		resizeimage2 = img2.getImage();
		result = resizeimage2.getScaledInstance(450, 70, Image.SCALE_SMOOTH);
		res_img2 = new ImageIcon(result);
		imglabel2 = new JLabel(res_img2);
		
		img1 = new ImageIcon("img//hotel_class//ȣ��02(���ٴٵ�)1.png");
		resizeimage = img1.getImage();
		result = resizeimage.getScaledInstance(750, 450, Image.SCALE_SMOOTH);
		res_img1 = new ImageIcon(result);
		imglabel1 = new JLabel(res_img1);
		
		imglabel2.setBounds(60,15, 450 , 70);
		imglabel1.setBounds(200, 100, 750, 450);
		text1.setBounds(200, 520, 420, 120);
		

		text1.setText("<html><body>�⺻Ÿ�� ��<br>��Ʃ��� Ÿ���� �Ľ��� �� ���ǿ� �޽��� ���� �� �ִ�"
			+ "���̺�� ü��, <br>�׸��� ��ź Ÿ���� �ƴ��� ü� �Ϻ��� OO�� ���� �⺻���� ���Դϴ�.</body></html>");
		center_content.add(left);
		center_content.add(right);
		center_content.add(imglabel2);
		center_content.add(imglabel1);
		center_content.add(text1);
		center_content.add(room_select);
		
		
		center.add(center_content);
		center_content.setBackground(Color.white);
		this.add("Center",center);
		this.add("North", north);
		
		this.setVisible(true);
	}

}
