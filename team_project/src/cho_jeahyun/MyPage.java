package cho_jeahyun;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MyPage extends JFrame{

	JTabbedPane submainTabb;
	public Confirm_Account mp1;
	public Update_Account mp2;
	private Panel01 p1;
	
	MyPage(Panel01 p1){
		this.p1 = p1;
		submainTabb = new JTabbedPane();
		
		
		mp1 = new Confirm_Account(this, p1.cid);
		mp2 = new Update_Account(p1.cid);
		
		
		submainTabb.addTab("ȸ������ Ȯ��", mp1);
		submainTabb.addTab("ȸ������ ����", mp2);
		
		this.add(submainTabb);
		
		this.setTitle("���� ������");
		this.setSize(600,550);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}