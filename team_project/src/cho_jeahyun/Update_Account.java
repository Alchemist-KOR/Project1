package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Update_Account extends JPanel implements ActionListener{
	
	private JPanel center, south, north, RBpanel;
	private JLabel[] j1, temp;
	private JButton update;
	private JRadioButton man,woman;
	private ButtonGroup group;
	private JTextField[] t1;
	String cid;
	

	Update_Account(String cid){
		this.cid = cid;
		this.setLayout(new BorderLayout());
		
		north = new JPanel(new FlowLayout());
		center = new JPanel(new GridLayout(12,2));
		south = new JPanel(new FlowLayout());
		
		j1 = new JLabel[7];
		t1 = new JTextField[6];
		temp = new JLabel[8];
		
		update = new JButton("����");
		update.addActionListener(this);
		
		man=new JRadioButton("����");
		woman=new JRadioButton("����");
		group=new ButtonGroup();
		group.add(man);group.add(woman);
		RBpanel = new JPanel(new FlowLayout());
		
		RBpanel.add(man);	RBpanel.add(woman);
		
		
		for(int i = 0 ; i < 6 ; i++) {
			t1[i] = new JTextField(20);
			temp[i] = new JLabel(" ");
		}
		
		j1[0] = new JLabel("�̸�");
		j1[1] = new JLabel("��й�ȣ");
		j1[2] = new JLabel("�������");
		j1[3] = new JLabel("����");
		j1[4] = new JLabel("�̸���");
		j1[5] = new JLabel("�ּ�");
		j1[6] = new JLabel("��ȭ��ȣ");
		
		north.add(update);
		for(int i = 0; i < 4 ; i++) {
			center.add(temp[i]);
		}
		for(int i = 0 ; i < 7 ; i++) {
			center.add(j1[i]);
			j1[i].setHorizontalAlignment(JLabel.CENTER);
			if(i == 3) {
				center.add(RBpanel);
			}else {
				if(i < 6) {
					center.add(t1[i]);
				}
			}
		}
		center.add(t1[3]);
		
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
				lf.setEmail(t1[4].getText());
				lf.setAddress(t1[5].getText());
				lf.setPhone(t1[3].getText());
				lf.setCid(cid);
				
				Integer r = crud.updateCustomer(lf);
				
				if(r == 1) {
					JOptionPane.showMessageDialog(this, "ȸ�������� �����Ǿ����ϴ�.");
				}else {
					JOptionPane.showMessageDialog(this, "���� ������ ������ �߻��Ͽ����ϴ�.");
				}
			}
			
		}
		
	}
}
