package cho_jeahyun;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame{
	
	JTabbedPane mainTabb;
	public Panel01 p1;
	public Panel02 p2;
	public Panel03 p3;
	public Panel04 p4;
	public Panel05 p5;
	public Panel06 p6;
	public Panel07 p7;
	public Panel08 p8;
	public boolean check_login;
	public MyPage mp;
	
	public String name, cid, phone;
	
	
	MainFrame(){
		mainTabb = new JTabbedPane();
		
		check_login = false;
		
		p7 = new Panel07(this);
		
		p2 = new Panel02(this);
		p3 = new Panel03();
		p4 = new Panel04();
		p5 = new Panel05(this);
		p6 = new Panel06(this);
		p8 = new Panel08();
		p1 = new Panel01(this,p7, p6, p8);
		
		
		
		
		mainTabb.addTab("메인", p1);
		mainTabb.addTab("객실정보", p2);
		mainTabb.addTab("서비스", p3);
		mainTabb.addTab("갤러리", p4);
		mainTabb.addTab("소개및 위치", p5);
		mainTabb.addTab("예약하기", p6);
		mainTabb.addTab("예약확인", p7);
		mainTabb.addTab("비회원 예약확인", p8);
		
		mainTabb.setEnabledAt(6, false);
		
		this.add(mainTabb);
		
		this.setTitle("호텔예약시스템 ver1.0");
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
