package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel01 extends JPanel implements ActionListener{
	

	JPanel north,east,center2,south3;
	JLabel south,center,south2;
	JButton btn_login;
	ImageIcon img;
	

	Panel01(){
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		east = new JPanel(new FlowLayout());
		south = new JLabel("00ȣ�ڸ��� Ư���� �����,���� �����Ͻð� ȸ������ Ư���� ������ ��������");
		center = new JLabel();
		center2 = new JPanel();
		south2 = new JLabel();
		south3 = new JPanel();
		
		
		setBtn();
		
		
		center.setIcon(new ImageIcon("img//ȣ��01.png"));
		center2.add(center);
		
		south2.setIcon(new ImageIcon("img//�����ؽ�Ʈ.png"));
		south3.add(south2);
		
		east.add(btn_login);
		north.add("East",east);
		
		
		this.add("Center",center2);
		this.add("North",north);
		this.add("South",south3);
		
		this.setVisible(true);

	}
	
	void setBtn() {
		btn_login = new JButton("�α���");
		btn_login.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton)e.getSource();
		
		if(bt == btn_login) {
			new Login();
		}
	}

}
