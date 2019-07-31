package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel01 extends JPanel implements ActionListener{
	

	JPanel north,east,center2,south3;
	JLabel south,center,south2;
	JButton btn_login,btn_mypage,btn_logout;
	ImageIcon img;
	MainFrame mf;
	Panel02 p2;
	Panel03 p3;
	Panel04 p4;
	Panel05 p5;
	Panel06 p6;
	Panel07 p7;
	

	Panel01(MainFrame mf,Panel07 p7){
		this.mf = mf;
		this.p7 = p7;
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		east = new JPanel(new FlowLayout());
		south = new JLabel("00호텔만의 특별한 멤버십,지금 가입하시고 회원만의 특별한 혜택을 받으세요");
		center = new JLabel();
		center2 = new JPanel();
		south2 = new JLabel();
		south3 = new JPanel();

		setBtn();

		center.setIcon(new ImageIcon("img//호텔01.png"));
		center2.add(center);
		
		south2.setIcon(new ImageIcon("img//객실텍스트.png"));
		south3.add(south2);
		
		east.add(btn_login);
		east.add(btn_logout);
		east.add(btn_mypage);
		btn_mypage.setVisible(false);
		btn_logout.setVisible(false);
		if(mf.check_login == true) {
			btn_mypage.setVisible(true);
		}
		north.add("East",east);

		this.add("Center",center2);
		this.add("North",north);
		this.add("South",south3);
		
		this.setVisible(true);

	}
	
	void setBtn() {
		btn_login = new JButton("로그인");
		btn_login.addActionListener(this);
		btn_mypage = new JButton("마이페이지");
		btn_mypage.addActionListener(this);
		btn_logout = new JButton("로그아웃");
		btn_logout.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton)e.getSource();
		
		if(bt == btn_login) {
			new Login(mf, this, p7);

		}else if(bt == btn_logout) {
			JOptionPane.showMessageDialog(this, "로그아웃 되었습니다.");
			btn_login.setVisible(true);
			btn_mypage.setVisible(false);
			btn_logout.setVisible(false);
			p7.cid = null;
			mf.mainTabb.setEnabledAt(6, false);
		}
	}

}
