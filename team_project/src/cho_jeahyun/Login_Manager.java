package cho_jeahyun;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class Login_Manager extends JFrame implements ActionListener{
	JLabel log_label,pwd_label;
	JTextField id_txt;
	JPasswordField pwd_txt;
	JButton log_btn;
	JPanel id_panel,pwd_panel,id_pwd_panel;
	JPanel center,south,east;
	public String cid;
	public boolean login_check = false;
	Panel01 p1;

	public Login_Manager(Panel01 p1) {

		this.p1 = p1;

		log_label=new JLabel("아이디");
		pwd_label=new JLabel("비밀번호");
		
		id_txt=new JTextField(10);
		pwd_txt=new JPasswordField(10);
		
		log_btn=new JButton("로그인");
		
		id_panel=new JPanel();
		pwd_panel=new JPanel();
		id_pwd_panel=new JPanel(new GridLayout(2,1));
		
		center=new JPanel();
		south=new JPanel();
		east=new JPanel();
		
		id_panel.add(log_label);id_panel.add(id_txt);
		pwd_panel.add(pwd_label);pwd_panel.add(pwd_txt);
		
		id_pwd_panel.add(id_panel);id_pwd_panel.add(pwd_panel);
		
		log_btn.addActionListener(this);
		
		
		id_txt.addActionListener(this);
		pwd_txt.addActionListener(this);
		
		
		center.add(id_pwd_panel);

		east.add(log_btn);
		
		this.add("Center",center);
		this.add("South",south);
		this.add("East",east);
		
		this.setTitle("관리자 로그인");
		this.setSize(450,200);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public boolean Logout() {
		login_check = false;
		return login_check;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==log_btn || pwd_txt == obj || id_txt == obj) {
			String id=id_txt.getText();
			String pwd=pwd_txt.getText();
			Manager_info mlogin_info = new Manager_info();
			List<Manager_info> temp;
			
			int r;
			if(id.equals("")) {//id가 빈칸일 경우
				JOptionPane.showMessageDialog(this, "아이디 를 입력하세요");
				return;
			}else if(pwd.equals("")) {//pwd 가 빈칸일 경우
				JOptionPane.showMessageDialog(this, "비밀번호 를 입력하세요");
				return;
			}else {
				mlogin_info.setMid(id);
				mlogin_info.setPw(pwd);

				CrudProcess crud = new CrudProcess();
				temp = crud.select_managerLogin(mlogin_info);
				
				
				if(temp.size() == 0) {					//로그인 실패
					JOptionPane.showMessageDialog(this, "아이디 와 비밀번호를 확인하세요.");
					id_txt.setText("");
					pwd_txt.setText("");
				}else {								//로그인 성공
					JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
					//윈도위의 title 를 바꾼다 -> 환영합니다 누구누구 님
					login_check = true;
					p1.btn_login.setVisible(false);
					p1.manager_page_bth.setVisible(true);
					p1.btn_mlogout.setVisible(true);
//					p1.cid = mlogin_info.getMid();
					dispose();
				}
			}
		}
	}
	public static void main(String[] args) {

	}

}
