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
	public MyPage mp;
	
	
	MainFrame(){
		mainTabb = new JTabbedPane();
		
		check_login = false;
		
		p7 = new Panel07(this);
		p1 = new Panel01(this,p7);
		p2 = new Panel02(this);
		p3 = new Panel03(this);
		p4 = new Panel04(this);
		p5 = new Panel05(this);
		p6 = new Panel06(this);
		
		

		
		mainTabb.addTab("����", p1);
		mainTabb.addTab("��������", p2);
		mainTabb.addTab("����", p3);
		mainTabb.addTab("������", p4);
		mainTabb.addTab("�Ұ��� ��ġ", p5);
		mainTabb.addTab("�����ϱ�", p6);
		mainTabb.addTab("����Ȯ��", p7);
		
		mainTabb.setEnabledAt(6, false);
		
		this.add(mainTabb);
		
		this.setTitle("ȣ�ڿ���ý��� ver1.0");
		this.setSize(850,700);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
