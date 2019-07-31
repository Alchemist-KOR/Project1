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
	
	private String room[] = {"선택하세요.","스텐다드", "프리미엄", "스위트"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object bt = e.getSource();
		if(room_select.getSelectedIndex() == 1) {
			center_content.removeAll();
			rating1.setText("스텐다드");
			img1 = new ImageIcon("img//호텔02(스텐다드).png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(550, 350, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			rating1.setBounds(65,7,55 , 15);
			text1.setBounds(65, 340, 420, 120);
			imglabel1.setBounds(65, 25, 550, 350);

			text1.setText("<html><body>기본타입 룸<br>스튜디오 타입의 파스텔 톤 객실에 휴식을 취할 수 있는"
				+ "테이블과 체어, <br>그리고 라탄 타입의 아늑한 체어를 완비한 OO의 가장 기본적인 룸입니다.</body></html>");
			center_content.add(rating1);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
		}else if(room_select.getSelectedIndex() == 2) {
			center_content.removeAll();
			rating1.setText("프리미엄");
			imglabel1 = new JLabel(res_img1);
			img1 = new ImageIcon("img//호텔03(프리미엄).png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(550, 350, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			rating1.setBounds(65,7,55 , 15);
			text1.setBounds(65, 350, 420, 120);
			imglabel1.setBounds(65, 25, 550, 350);
			text1.setText("<html><body>스튜디오 타입 디자인<br>스튜디오 타입 객실에 블루 패턴의 카페트와 화이트 패브릭 소파가 세련된 느낌을<br>"
					+ "자아내며, 휴식을 취할 수 있는 다이닝 테이블과 체어를 완비한 제주신라의 객실로<br>"
					+ "5~8층에 위치해 제주의 멋진 풍광을 감상 할 수 있는 색실입니다.");
			center_content.add(rating1);
			center_content.add(imglabel1);
			center_content.add(text1);
			center_content.add(room_select);
			center_content.repaint();
		}else if(room_select.getSelectedIndex() == 3){
			center_content.removeAll();
			rating1.setText("스위트");
			img1 = new ImageIcon("img//호텔04(스위트).png");
			resizeimage = img1.getImage();
			result = resizeimage.getScaledInstance(550, 350, Image.SCALE_SMOOTH);
			res_img1 = new ImageIcon(result);
			imglabel1 = new JLabel(res_img1);
			text1.setText("<html><body>편안함 느낌의 휴양 리조트 인테리어 코너 스위트는 본관 1층에서 6층까지 건물 윙의 가장 끝 부분에 위치하여 낮은 층에서는<br>"
					+ "탁 트인 정원 전망을, 높은 층에서는 제주의 푸른 바다의 한라산의 기품을 함께 즐길 수 "
					+ "있습니다.<br>"
					+ "침실과 거실, 욕실이 분리되어 있으며 침실과 거실 사이는 루버도어로 장식이 되어 있습<br>"
					+ "니다. 벽지, 커페트 등에 전체적으로 화이트, 제이드 그린, 블루 톤을 사용했으며, 캐노피<br>"
					+ "침대와 클래식한 화장대로 스위트의 우아한 느낌을 더욱 살렸습니다."
					+ "<br>침대옆에는 스툴이 있는 라탄 윙 체어를 놓아 리조트의 편안한 느낌을 연출 하였습니다.</body></html>");
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
