package cho_jeahyun;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
	

	JLabel log_label,pwd_label;
	JTextField id_txt;
	JPasswordField pwd_txt;
	JButton log_btn,join_btn,id_missing_btn,pwd_missing_btn, manager_login_btn;
	JPanel id_panel,pwd_panel,id_pwd_panel;
	JPanel center,south,east;
	public String cid;
	public boolean login_check = false;
	MainFrame mf;
	Panel01 p1;
	Panel02 p2;
	Panel03 p3;
	Panel04 p4;
	Panel05 p5;
	Panel06 p6;
	Panel07 p7;
	MyPage mp;
	public Login(MainFrame mf, Panel01 p1, Panel07 p7, Panel06 p6) {
		this.mf = mf;
		this.p1 = p1;
		this.p7 = p7;
		this.p6 = p6;
		this.mp = mp;
		log_label=new JLabel("���̵�");
		pwd_label=new JLabel("��й�ȣ");
		
		id_txt=new JTextField(10);
		pwd_txt=new JPasswordField(10);
		
		log_btn=new JButton("�α���");
		join_btn=new JButton("ȸ������");
		id_missing_btn=new JButton("���̵� ã��");
		pwd_missing_btn=new JButton("��й�ȣ ã��");
		manager_login_btn = new JButton("������");
		
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
		id_missing_btn.addActionListener(this);
		pwd_missing_btn.addActionListener(this);
		manager_login_btn.addActionListener(this);
		
		
		id_txt.addActionListener(this);
		pwd_txt.addActionListener(this);
		
		
		center.add(id_pwd_panel);
		south.add(join_btn);south.add(id_missing_btn);south.add(pwd_missing_btn);
		south.add(manager_login_btn);
		east.add(log_btn);
		
		this.add("Center",center);
		this.add("South",south);
		this.add("East",east);
		
		this.setTitle("�α���/ȸ������");
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
			Login_info login_info=new Login_info();
			List<Login_info> temp;
			
			int r;
			if(id.equals("")) {//id�� ��ĭ�� ���
				JOptionPane.showMessageDialog(this, "���̵� �� �Է��ϼ���");
				return;
			}else if(pwd.equals("")) {//pwd �� ��ĭ�� ���
				JOptionPane.showMessageDialog(this, "��й�ȣ �� �Է��ϼ���");
				return;
			}else {
				login_info.setCid(id);
				login_info.setPw(pwd);

				CrudProcess crud = new CrudProcess();
				temp = crud.selectLogin(login_info);
				
				
				if(temp.size() == 0) {					//�α��� ����
					JOptionPane.showMessageDialog(this, "���̵� �� ��й�ȣ�� Ȯ���ϼ���.");
					id_txt.setText("");
					pwd_txt.setText("");
				}else {								//�α��� ����
					JOptionPane.showMessageDialog(this, "�α��� �Ǿ����ϴ�.");
					//�������� title �� �ٲ۴� -> ȯ���մϴ� �������� ��
					String cid = login_info.getCid();
					System.out.println(cid);
					login_check = true;
					mf.check_login = login_check;
					p1.btn_login.setVisible(false);
					p1.btn_mypage.setVisible(true);
					p1.btn_logout.setVisible(true);
					mf.mainTabb.setEnabledAt(6, true);
					mf.cid = cid;
					List<Login_info> lf = crud.selectAccount(cid);
					Iterator it = lf.iterator();
					Login_info rinfo = (Login_info) it.next();
					mf.name = rinfo.getName();
					mf.phone = rinfo.getPhone();
					p7.cid = cid;
					p6.label[0].setVisible(false);
					p6.label[3].setVisible(false);
					p6.textfield[0].setVisible(false);
					p6.textfield[3].setVisible(false);
					
					p1.cid = cid;
					dispose();
				}
			}
		}else if(obj == join_btn) {//ȸ������ ��ư�� ��������
			new Join();
		}if(obj == id_missing_btn) {// ID ã���ư�� ��������
			new Id_missing();
		}else if(obj == pwd_missing_btn) {// ��й�ȣ ã���ư�� ��������
			new Pwd_missing();
		}else if(obj == manager_login_btn) {
			new Login_Manager(p1);
			dispose();
		}
	}
	public static void main(String[] args) {

	}

}
