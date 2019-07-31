package cho_jeahyun;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame{
	
	JTabbedPane mainTabb;
	public Panel01 p1;
	public Panel02 p2;
	public Panel03 p3;
	public Panel04 p4;
	public Panel05 p5;
	public Panel06 p6;
	public Panel07 p7;
	private JScrollPane pan2;
	private JScrollBar bar;
	public boolean check_login;
	
	
	MainFrame(){
		mainTabb = new JTabbedPane();
		
		check_login = false;
		
		p1 = new Panel01(this);
		p2 = new Panel02(this);
		p3 = new Panel03(this);
		p4 = new Panel04(this);
		p5 = new Panel05(this);
		p6 = new Panel06(this);
		p7 = new Panel07(this);
		
		pan2 = new JScrollPane(p2);
		//pan2.setHorizontalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		pan2.setPreferredSize(new Dimension(800,700));
		pan2.setMinimumSize(new Dimension(800,10));
//		pan2.setMaximumSize(new Dimension(850,1200));
		
		mainTabb.addTab("메인", p1);
		mainTabb.addTab("객실정보", pan2);
		mainTabb.addTab("서비스", p3);
		mainTabb.addTab("갤러리", p4);
		mainTabb.addTab("소개및 위치", p5);
		mainTabb.addTab("예약하기", p6);
		mainTabb.addTab("예약확인", p7);
		
		this.add(mainTabb);
		
		this.setTitle("호텔예약시스템 ver1.0");
		this.setSize(850,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
