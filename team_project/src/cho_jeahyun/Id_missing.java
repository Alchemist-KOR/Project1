package cho_jeahyun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Id_missing extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (name_txt.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
		} else if (email_txt.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸����� �Է��ϼ���.");
		} else {
			Login_info lf = new Login_info();
			CrudProcess crud = new CrudProcess();

			lf.setEmail(email_txt.getText());
			lf.setName(name_txt.getText());
			
			String res;
			res = crud.selectId(lf);
			
			if(res != null && res.length() != 0) {
				JOptionPane.showMessageDialog(this, "ID�� ��ȸ�Ǿ����ϴ�.");
				id_show_label.setText(name_txt.getText()+"���� ID "+res);
				
			}else {
				JOptionPane.showMessageDialog(this, "�ش� ������ �������� �ʽ��ϴ�.");
				email_txt.setText("");
				name_txt.setText("");
				id_show_label.setText("");
			}
		}
	}

	JLabel name_label, email_label, id_show_label;
	JTextField name_txt, email_txt;
	JButton ok_btn;
	JPanel name_pan, email_pan, id_show_pan, center, south;
	Login_info login_info;

	public Id_missing() {
		name_label = new JLabel("�̸�");
		email_label = new JLabel("�̸���");
		id_show_label = new JLabel("");

		// login_info.getName()+"���� ���̵�� "+login_info.getCid()+" �Դϴ�."

		name_txt = new JTextField(10);
		email_txt = new JTextField(15);

		ok_btn = new JButton("Ȯ��");
		ok_btn.addActionListener(this);

		name_pan = new JPanel();
		email_pan = new JPanel();
		id_show_pan = new JPanel();
		name_pan.add(name_label);
		name_pan.add(name_txt);
		email_pan.add(email_label);
		email_pan.add(email_txt);
		id_show_pan.add(id_show_label);

		center = new JPanel();
		south = new JPanel();
		center.add(name_pan);
		center.add(email_pan);
		center.add(id_show_pan);
		south.add(ok_btn);

		this.add("Center", center);
		this.add("South", south);
		this.setTitle("���̵� ã��");
		this.setVisible(true);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		;
	}

//	public static void main(String[] args) {
//		new Id_missing();
//
//	}

}
