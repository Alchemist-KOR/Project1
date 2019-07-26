package cho_jeahyun;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
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
	private JScrollPane pan2;
	
	
	MainFrame(){
		mainTabb = new JTabbedPane();
		
		
		p1 = new Panel01();
		p2 = new Panel02();
		p3 = new Panel03();
		p4 = new Panel04();
		p5 = new Panel05();
		p6 = new Panel06();
		p7 = new Panel07();
		
		pan2 = new JScrollPane(p2);
		
		
		mainTabb.addTab("메인", p1);
		mainTabb.addTab("객실정보", pan2);
		mainTabb.addTab("서비스", p3);
		mainTabb.addTab("갤러리", p4);
		mainTabb.addTab("소개및 위치", p5);
		mainTabb.addTab("예약하기", p6);
		mainTabb.addTab("예약확인", p7);
		
		this.add(mainTabb);
		
		this.setTitle("호텔예약시스템 ver1.0");
		this.setSize(600,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
