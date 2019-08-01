package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Confirm_Account extends JPanel implements ActionListener{
	
	
	String cid = null;
	private JPanel north, center, south, south_content;
	private JButton confirm;
	public JButton delete;
	private JLabel[] account;
	private Font font1, font2;
	MyPage mp;
	

	Confirm_Account(MyPage mp ,String cid){
		this.cid = cid;
		this.mp = mp;
		this.setLayout(new BorderLayout());
		
		account = new JLabel[20];
		center = new JPanel(new GridLayout(10,2));
		south_content = new JPanel(new FlowLayout());
		north = new JPanel(new FlowLayout());
		
		confirm = new JButton("조회");
		confirm.addActionListener(this);
		delete = new JButton("회원 탈퇴");
		delete.addActionListener(this);
		
		account[0] =  new JLabel("이름");
		account[1] = new JLabel(" ");
		account[2] = new JLabel("아이디");
		account[3] = new JLabel(" ");
		account[4] = new JLabel("생년월일");
		account[5] = new JLabel(" ");
		account[6] = new JLabel("성별");
		account[7] = new JLabel(" ");
		account[8] = new JLabel("이메일");
		account[9] = new JLabel(" ");
		account[10] = new JLabel("주소");
		account[11] = new JLabel(" ");
		account[12] = new JLabel("전화번호");
		account[13] = new JLabel(" ");
		account[14] = new JLabel("내 포인트");
		account[15] = new JLabel(" ");
		account[16] = new JLabel(); account[17] = new JLabel();
		account[18] = new JLabel(); account[19] = new JLabel();
		
		
		delete.setHorizontalAlignment(JLabel.RIGHT);
		north.add(delete);
		
		
		center.add(account[18]);
		center.add(account[19]);
		for(int i = 0 ; i< 18 ; i++) {
			center.add(account[i]);
		}
		for(int i = 0 ; i < 8 ; i++) {
			account[2*i].setHorizontalAlignment(JLabel.CENTER);

		}
		
		south_content.add(confirm);

		this.add("North", north);
		this.add("Center", center);
		this.add("South", south_content);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == confirm) {
			CrudProcess crud = new CrudProcess();
			
			List<Login_info> lf = crud.selectAccount(cid);
			Iterator it = lf.iterator();
			while(it.hasNext()) {
				Login_info data = (Login_info)it.next();
			
				account[1].setText(data.getName());
				account[3].setText(data.getCid());
				account[5].setText(data.getBirthday());
				account[7].setText(data.getGender());
				account[9].setText(data.getEmail());
				account[11].setText(data.getAddress());
				account[13].setText(data.getPhone());
				account[15].setText(Integer.toString(data.getPoint()));
				
			}
		}else if(e.getSource() == delete) {
			int result = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?", "작업 확인", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				HashMap<String, Object> map = new HashMap<String, Object>();
	
					map.put("cid", account[3].getText());
					map.put("name", account[1].getText());
					map.put("email", account[9].getText());
				CrudProcess crud = new CrudProcess();
				int r = crud.deleteCustomer(map);
				if (r > 0) {
					JOptionPane.showMessageDialog(this, "회원탈퇴 되셨습니다.");
					mp.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "회원탈퇴 도중 오류가 발생하였습니다.");
				}
			}
		}
	}
}
