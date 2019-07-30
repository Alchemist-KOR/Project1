package cho_jeahyun;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener	{
	JLabel log_label,pwd_label;
	JTextField id_txt;
	JPasswordField pwd_txt;
	JButton log_btn,join_btn,id_missing_btn,pwd_missing_btn;
	JPanel id_panel,pwd_panel,id_pwd_panel;
	JPanel center,south,east;
	
	public Login(){
		log_label=new JLabel("아이디");
		pwd_label=new JLabel("비밀번호");
		
		id_txt=new JTextField(10);
		pwd_txt=new JPasswordField(10);
		
		log_btn=new JButton("로그인");
		join_btn=new JButton("회원가입");
		id_missing_btn=new JButton("아이디 찾기");
		pwd_missing_btn=new JButton("비밀번호 찾기");
		
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
		join_btn.addActionListener(this);
		center.add(id_pwd_panel);
		south.add(join_btn);south.add(id_missing_btn);south.add(pwd_missing_btn);
		east.add(log_btn);
		
		this.add("Center",center);
		this.add("South",south);
		this.add("East",east);
		
		this.setTitle("로그인/회원가입");
		this.setSize(350,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==log_btn) {//로그인버튼 눌렀을때
			String id=id_txt.getText();
			String pwd=pwd_txt.getText();
			Login_info login_info=new Login_info();
			
			int r;
			if(id.equals("")) {//id가 빈칸일 경우
				JOptionPane.showMessageDialog(this, "아이디 를 입력하세요");
				return;
			}else if(pwd.equals("")) {//pwd 가 빈칸일 경우
				JOptionPane.showMessageDialog(this, "비밀번호 를 입력하세요");
				return;
			}else {
				login_info.setCustomer_id(id);
				login_info.setCustomer_pwd(pwd);
				
				System.out.println(login_info.getCustomer_id()+"   "+ login_info.getCustomer_pwd());
				
				CrudProcess crud = new CrudProcess();
				r = crud.selectLogin(login_info);
				
				System.out.println(r);
				
				
				if(r <= 0) {					//로그인 실패
					JOptionPane.showMessageDialog(this, "아이디 와 비밀번호를 확인하세요.");
				}else {								//로그인 성공
					JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
					//윈도위의 title 를 바꾼다 -> 환영합니다 누구누구 님
					login.setTitle("호텔예약시스템 ver1.0 - 환영합니다 "+id+" 님");
					System.exit(0);
				}	
			}
		}else if(obj==join_btn) {//회원가입 버튼을 눌렀을때
			new Join();
		}
	}
	Login login;
	public static void main(String[] args) {
		new Login();

	}

}
