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
	
	
	MainFrame(){
		mainTabb = new JTabbedPane();
		
		p1 = new Panel01();
		p2 = new Panel02();
		p3 = new Panel03();
		p4 = new Panel04();
		p5 = new Panel05();
		
		
		mainTabb.addTab("����", p1);
		mainTabb.addTab("��������", p2);
		mainTabb.addTab("����", p3);
		mainTabb.addTab("�Ұ��� ��ġ", p4);
		mainTabb.addTab("����", p5);
		this.add(mainTabb);
		
		this.setTitle("ȣ�ڿ���ý��� ver1.0");
		this.setSize(600,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
