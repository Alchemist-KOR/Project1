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
		
		login = new JButton("로그인");
		
		north_east.add(login);
		north.add("East",north_east);
		
		center = new JPanel(new BorderLayout());
		center_content = new JPanel();
		center_content.setLayout(null);
		
		rating1 = new JLabel("스텐다드");
		img1 = new ImageIcon("img//호텔02(스텐다드).png");
		resizeimage = img1.getImage();
		result = resizeimage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		res_img1 = new ImageIcon(result);
		imglabel1 = new JLabel(res_img1);
		text1 = new JLabel("<html><body>기본타입 룸<br>스튜디오 타입의 파스텔 톤 객실에 휴식을 취할 수 있는"
				+ "테이블과 체어, <br>그리고 라탄 타입의 아늑한 체어를 완비한 OO의 가장 기본적인 룸입니다.</body></html>");
		
		rating2 = new JLabel("프리미엄");
		img2 = new ImageIcon("img//호텔03(프리미엄).png");
		resizeimage = img2.getImage();
		result = resizeimage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		res_img2 = new ImageIcon(result);
		imglabel2 = new JLabel(res_img2);
		text2 = new JLabel("<html><body>스튜디오 타입 디자인<br>스튜디오 타입 객실에 블루 패턴의 카페트와 화이트 패브릭 소파가 세련된 느낌을<br>"
				+ "자아내며, 휴식을 취할 수 있는 다이닝 테이블과 체어를 완비한 제주신라의 객실로<br>"
				+ "5~8층에 위치해 제주의 멋진 풍광을 감상 할 수 있는 색실입니다.");
		
		rating3 = new JLabel("스위트");
		img3 = new ImageIcon("img//호텔04(스위트).png");
		resizeimage = img3.getImage();
		result = resizeimage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		res_img3 = new ImageIcon(result);
		imglabel3 = new JLabel(res_img3);
		text3 = new JLabel("<html><body>편안함 느낌의 휴양 리조트 인테리어<br>코너 스위트는 본관 1층에서 6층까지 건물 윙의 가장 끝 부분에 위치하여 낮은 층에서는<br>"
				+ "탁 트인 정원 전망을, 높은 층에서는 제주의 푸른 바다의 한라산의 기품을 함께 즐길 수<br>"
				+ "있습니다.<br>"
				+ "침실과 거실, 욕실이 분리되어 있으며 침실과 거실 사이는 루버도어로 장식이 되어 있습<br>"
				+ "니다. 벽지, 커페트 등에 전체적으로 화이트, 제이드 그린, 블루 톤을 사용했으며, 캐노피<br>"
				+ "침대와 클래식한 화장대로 스위트의 우아한 느낌을 더욱 살렸습니다."
				+ "<br>침대옆에는 스툴이 있는 라탄 윙 체어를 놓아 리조트의 편안한 느낌을 연추 하였습니다.</body></html>");
		
		
		
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
