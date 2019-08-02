package cho_jeahyun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pwd_missing extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id=id_txt.getText();
		String email=email_txt.getText();
		
		if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���.");
		} else if (email.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸����� �Է��ϼ���.");
		}else {
			CrudProcess crud = new CrudProcess();
			Login_info lf = new Login_info();
			
			
			lf.setEmail(email);
			lf.setCid(id);
			
			String pw;
			pw = crud.selectPw(lf);
			
			if(pw != null && pw.length() != 0) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ȸ�Ǿ����ϴ�.");
				pwd_show_label.setText(id+"���� ��й�ȣ��"+pw);
				
			}else {
				JOptionPane.showMessageDialog(this, "�ش� ������ �������� �ʽ��ϴ�.");
				email_txt.setText("");
				id_txt.setText("");
				pwd_show_label.setText("");
			}
		}
		
		
	}

	JLabel id_label, email_label,pwd_show_label;
	JTextField id_txt, email_txt;
	JButton ok_btn;
	JPanel pwd_show_pan, id_pan, email_pan, center, south;

	public Pwd_missing() {
		id_label = new JLabel("���̵�");
		email_label = new JLabel("�̸���");
		pwd_show_label=new JLabel();

		id_txt = new JTextField(10);
		email_txt = new JTextField(15);

		ok_btn = new JButton("Ȯ��");
		ok_btn.addActionListener(this);

		id_pan = new JPanel();		email_pan = new JPanel();
		id_pan.add(id_label);id_pan.add(id_txt);
		email_pan.add(email_label);email_pan.add(email_txt);

		pwd_show_pan=new JPanel();pwd_show_pan.add(pwd_show_label);
		
		center = new JPanel();south = new JPanel();
		
		center.add(id_pan);center.add(email_pan);center.add(pwd_show_pan);
		south.add(ok_btn);

		this.add("Center", center);
		this.add("South", south);
		this.setTitle("��й�ȣ ã��");
		this.setVisible(true);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

//	public static void main(String[] args) {
//		new Pwd_missing();
//
//	}

}
