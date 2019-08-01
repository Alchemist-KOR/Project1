package seun;

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





public class Login extends JFrame implements ActionListener	{
	JLabel log_label,pwd_label;
	JTextField id_txt;
	JPasswordField pwd_txt;
	JButton log_btn,join_btn,id_missing_btn,pwd_missing_btn;
	JPanel id_panel,pwd_panel,id_pwd_panel;
	JPanel center,south,east;
	
	public Login(){
		log_label=new JLabel("���̵�");
		pwd_label=new JLabel("��й�ȣ"); 
		
		id_txt=new JTextField(10);
		pwd_txt=new JPasswordField(10);
		
		log_btn=new JButton("�α���");
		join_btn=new JButton("ȸ������");
		id_missing_btn=new JButton("���̵� ã��");
		pwd_missing_btn=new JButton("��й�ȣ ã��");
		
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
		
		this.setTitle("�α���/ȸ������");
		this.setSize(350,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==log_btn) {//�α��ι�ư ��������
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
				
				System.out.println(temp.size());
		
				if(temp.size() == 0) {					//�α��� ����
					JOptionPane.showMessageDialog(this, "���̵� �� ��й�ȣ�� Ȯ���ϼ���.");
					id_txt.setText("");
					pwd_txt.setText("");
				}else {								//�α��� ����
					JOptionPane.showMessageDialog(this, "�α��� �Ǿ����ϴ�.");
					
					System.exit(0);
				}	
			}
		}else if(obj==join_btn) {//ȸ������ ��ư�� ��������
			new Join();
		}
	}
	Login login;
	public static void main(String[] args) {
		new Login();

	}

}