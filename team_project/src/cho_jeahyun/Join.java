package cho_jeahyun;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Join extends JFrame implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton obj=(JButton) arg0.getSource();
		if(obj==join_btn) {
			Login_info login_info=new Login_info();
			
			String id=id_txt.getText();
			login_info.setCid(id);
			
			String pwd=pwd_txt.getText();
			login_info.setPw(pwd);
			
			String name=name_txt.getText();
			login_info.setName(name);
			
			String birth= birth_txt.getText();
			login_info.setBirthday(birth);
			
			String gender="";
			if(man.isSelected()) {//남자를 선택
				gender="남자";
			}else if(woman.isSelected()) {//여자를 선택
				gender="여자";
			}
			login_info.setGender(gender);
			
			String email=email_txt.getText();
			login_info.setEmail(email);
			
			String addr=addr_txt.getText();
			login_info.setAddress(addr);
			
			String phone=phoneNum_txt.getText();
			login_info.setPhone(phone);
			
			CrudProcess crud=new CrudProcess();
			int r = crud.insertLogin(login_info);
			
			if(r > 0) {
				JOptionPane.showMessageDialog(this, "정상적으로 등록되었습니다.");
				dispose();
			}else {
				JOptionPane.showMessageDialog(this, "등록 중 문제가 발생했습니다.");
			}
		}else if(obj == calendar_btn) {
			new CalendarBySwing(this);
		}
	}
	JLabel name_label,id_label,pwd_label,
			birth_label,gender_label,
			email_label,addr_label,
			phoneNum_label,information_label,temp;
	JTextField name_txt,id_txt,birth_txt,
				email_txt,addr_txt,phoneNum_txt;
	JPasswordField pwd_txt;
	JRadioButton man,woman;
	ButtonGroup group;
	JCheckBox info_check;
	JPanel gender_panel,center,south, calendar_panel;
	JButton join_btn ,calendar_btn;
	
	public Join(){
		name_label=new JLabel("이름");
		id_label=new JLabel("아이디");
		pwd_label=new JLabel("비밀전호");
		birth_label=new JLabel("생년월일");
		gender_label=new JLabel("성별");
		email_label=new JLabel("이메일");
		addr_label=new JLabel("주소");
		phoneNum_label=new JLabel("전화번호");
		information_label=new JLabel("제 3자 정보 제공 동의");
		temp = new JLabel("");
		
		name_txt=new JTextField(15);
		id_txt=new JTextField(15);
		pwd_txt=new JPasswordField(15);
		birth_txt=new JTextField("예시)2000/01/01",11);
		calendar_btn = new JButton("달력");
		email_txt=new JTextField(15);
		addr_txt=new JTextField(15);
		phoneNum_txt=new JTextField("예시)01012345678",15);
		
		calendar_btn.addActionListener(this);
		
		man=new JRadioButton("남자");
		woman=new JRadioButton("여자");
		group=new ButtonGroup();
		group.add(man);group.add(woman);
		
		info_check=new JCheckBox();
		
		join_btn=new JButton("가입하기");
		join_btn.addActionListener(this);
		
		gender_panel=new JPanel();
		gender_panel.add(man);gender_panel.add(woman);
		
		center=new JPanel(new GridLayout(10,2));
		calendar_panel = new JPanel(new FlowLayout());
		
		center.add(name_label);center.add(name_txt);
		center.add(id_label);center.add(id_txt);
		center.add(pwd_label);center.add(pwd_txt);
		calendar_panel.add(birth_txt);calendar_panel.add(calendar_btn);
		center.add(birth_label);center.add(calendar_panel);
//		center.add(temp); center.add(temp);
		center.add(gender_label);center.add(gender_panel);
		center.add(email_label);center.add(email_txt);
		center.add(addr_label);center.add(addr_txt);
		center.add(phoneNum_label);center.add(phoneNum_txt);
		center.add(information_label);center.add(info_check);
		setLabel();
		
		south=new JPanel();
		south.add(join_btn);
		
		this.add("Center",center);
		this.add("South",south);
		
		this.setTitle("회원가입");
		this.setSize(450,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	void setLabel() {
		name_label.setHorizontalAlignment(JLabel.CENTER);
		id_label.setHorizontalAlignment(JLabel.CENTER);
		pwd_label.setHorizontalAlignment(JLabel.CENTER);
		birth_label.setHorizontalAlignment(JLabel.CENTER);
		gender_label.setHorizontalAlignment(JLabel.CENTER);
		email_label.setHorizontalAlignment(JLabel.CENTER);
		addr_label.setHorizontalAlignment(JLabel.CENTER);
		phoneNum_label.setHorizontalAlignment(JLabel.CENTER);
		information_label.setHorizontalAlignment(JLabel.CENTER);
	}
//	public static void main(String[] args) {
//		new Join();
//	}
	
}
