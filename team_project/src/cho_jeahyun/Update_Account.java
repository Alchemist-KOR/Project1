package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Update_Account extends JPanel implements ActionListener{
	
	private JPanel center, south, north, RBpanel,cal_panel, email_Panel;
	public JLabel[] j1, temp;
	public JLabel email_other;
	private JButton update,cal_btn;
	private JRadioButton man,woman;
	private ButtonGroup group;
	public JTextField[] t1;
	private JComboBox email_default;
	String[] email_address = {"�����Է�","naver.com","daum.net","hanmail.net","nate.com","gmail.com",
			"lycos.co.kr","yahoo.co.kr","empal.com","dream wiz.com","paran.com",
			"korea.com","choi.com","hanmir.com","hanafos.com","hotmail.com"};
	String cid;
	

	Update_Account(String cid){
		this.cid = cid;
		this.setLayout(new BorderLayout());
		
		north = new JPanel(new FlowLayout());
		center = new JPanel(new GridLayout(12,2));
		south = new JPanel(new FlowLayout());
		cal_panel = new JPanel(new FlowLayout());
		email_Panel = new JPanel(new FlowLayout());
		RBpanel = new JPanel(new FlowLayout());
		
		
		j1 = new JLabel[7];
		t1 = new JTextField[6];
		temp = new JLabel[8];
		
		update = new JButton("����");
		update.addActionListener(this);
		cal_btn = new JButton("�޷�");
		cal_btn.addActionListener(this);
		email_default = new JComboBox<String>(email_address);
		email_other = new JLabel("@");
		
		
		man=new JRadioButton("����");
		woman=new JRadioButton("����");
		group=new ButtonGroup();
		group.add(man);group.add(woman);
		
		
		RBpanel.add(man);	RBpanel.add(woman);
		
		
		for(int i = 0 ; i < 6 ; i++) {
			temp[i] = new JLabel(" ");
		}
		t1[0] = new JTextField(20);
		t1[1] = new JTextField(20);
		t1[2] = new JTextField(10);
		t1[3] = new JTextField(10);
		t1[4] = new JTextField(20);
		t1[5] = new JTextField(20);
		
		
		j1[0] = new JLabel("�̸�");
		j1[1] = new JLabel("��й�ȣ");
		j1[2] = new JLabel("�������");
		j1[3] = new JLabel("����");
		j1[4] = new JLabel("�̸���");
		j1[5] = new JLabel("�ּ�");
		j1[6] = new JLabel("��ȭ��ȣ");
		
		cal_panel.add(t1[2]);
		cal_panel.add(cal_btn);
		
		email_Panel.add(t1[3]);
		email_Panel.add(email_other);
		email_Panel.add(email_default);
		
		north.add(update);
		for(int i = 0; i < 4 ; i++) {
			center.add(temp[i]);
		}
		center.add(j1[0]); center.add(t1[0]);
		center.add(j1[1]); center.add(t1[1]);
		center.add(j1[2]); center.add(cal_panel);
		center.add(j1[3]); center.add(RBpanel);
		center.add(j1[4]); center.add(email_Panel);
		center.add(j1[5]); center.add(t1[4]);
		center.add(j1[6]); center.add(t1[5]);


		for(int i = 0 ; i < 7 ; i++) {
			j1[i].setHorizontalAlignment(JLabel.CENTER);
		}
		
		this.add("North", north);
		this.add("Center", center);
		this.add("South", south);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton jb = (JButton)arg0.getSource();
		if(jb == update) {
			if(t1[0].equals("") ||
					t1[1].getText().equals("") ||
					t1[2].getText().equals("") ||
					t1[3].getText().equals("") ||
					t1[4].getText().equals("") ||
					t1[5].getText().equals("")) {
				JOptionPane.showMessageDialog(this, "��ĭ�� ä�� �ֽʽÿ�.");
			}else {
				CrudProcess crud = new CrudProcess();
				Login_info lf = new Login_info();
				
				lf.setName(t1[0].getText());
				lf.setPw(t1[1].getText());
				lf.setBirthday(t1[2].getText());
				
				if(man.isSelected()) {
					lf.setGender("��");
				}else if(woman.isSelected()) {
					lf.setGender("��");
				}
				lf.setEmail(t1[3].getText()+"@"+email_default.getSelectedItem());
				lf.setAddress(t1[4].getText());
				lf.setPhone(t1[5].getText());
				lf.setCid(cid);
				
				Integer r = crud.updateCustomer(lf);
				
				if(r == 1) {
					JOptionPane.showMessageDialog(this, "ȸ�������� �����Ǿ����ϴ�.");
				}else {
					JOptionPane.showMessageDialog(this, "���� ������ ������ �߻��Ͽ����ϴ�.");
				}
			}
			
		}else if(jb == cal_btn) {
			new CalendarBySwing(this);
		}
		
	}
}
