package cho_jeahyun;

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
			if(man.isSelected()) {//���ڸ� ����
				gender="����";
			}else if(woman.isSelected()) {//���ڸ� ����
				gender="����";
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
				JOptionPane.showMessageDialog(this, "���������� ��ϵǾ����ϴ�.");
				dispose();
			}else {
				JOptionPane.showMessageDialog(this, "��� �� ������ �߻��߽��ϴ�.");
			}
		}
	}
	JLabel name_label,id_label,pwd_label,
			birth_label,gender_label,
			email_label,addr_label,
			phoneNum_label,information_label;
	JTextField name_txt,id_txt,birth_txt,
				email_txt,addr_txt,phoneNum_txt;
	JPasswordField pwd_txt;
	JRadioButton man,woman;
	ButtonGroup group;
	JCheckBox info_check;
	JPanel gender_panel,center,south;
	JButton join_btn;
	
	public Join(){
		name_label=new JLabel("�̸�");
		id_label=new JLabel("���̵�");
		pwd_label=new JLabel("�����ȣ");
		birth_label=new JLabel("�������");
		gender_label=new JLabel("����");
		email_label=new JLabel("�̸���");
		addr_label=new JLabel("�ּ�");
		phoneNum_label=new JLabel("��ȭ��ȣ");
		information_label=new JLabel("�� 3�� ���� ���� ����");
		
		name_txt=new JTextField(15);
		id_txt=new JTextField(15);
		pwd_txt=new JPasswordField(15);
		birth_txt=new JTextField("����)2000/01/01",15);
		email_txt=new JTextField(15);
		addr_txt=new JTextField(15);
		phoneNum_txt=new JTextField("����)01012345678",15);
		
		man=new JRadioButton("����");
		woman=new JRadioButton("����");
		group=new ButtonGroup();
		group.add(man);group.add(woman);
		
		info_check=new JCheckBox();
		
		join_btn=new JButton("�����ϱ�");
		join_btn.addActionListener(this);
		
		gender_panel=new JPanel();
		gender_panel.add(man);gender_panel.add(woman);
		
		center=new JPanel(new GridLayout(9,2));
		
		center.add(name_label);center.add(name_txt);
		center.add(id_label);center.add(id_txt);
		center.add(pwd_label);center.add(pwd_txt);
		center.add(birth_label);center.add(birth_txt);
		center.add(gender_label);center.add(gender_panel);
		center.add(email_label);center.add(email_txt);
		center.add(addr_label);center.add(addr_txt);
		center.add(phoneNum_label);center.add(phoneNum_txt);
		center.add(information_label);center.add(info_check);
		
		south=new JPanel();
		south.add(join_btn);
		
		this.add("Center",center);
		this.add("South",south);
		
		this.setTitle("ȸ������");
		this.setSize(400,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
//	public static void main(String[] args) {
//		new Join();
//	}
	
}
