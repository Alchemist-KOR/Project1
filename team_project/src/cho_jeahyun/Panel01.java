package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class Panel01 extends JPanel implements ActionListener{
	

	JPanel north,east,center2,south3;
	JLabel south,center,south2;
	JButton btn_login,btn_mypage,btn_logout, manager_page_bth,btn_mlogout;
	private Image resizeimage;
	private Image result;
	private ImageIcon img1;
	private ImageIcon res_img1;
	private JLabel imglabel1;
	MainFrame mf;
	String cid;
	Panel02 p2;
	Panel03 p3;
	Panel04 p4;
	Panel05 p5;
	Panel06 p6;
	Panel07 p7;
	Panel08 p8;
	Mng mng;
	

	Panel01(MainFrame mf,Panel07 p7, Panel06 p6, Panel08 p8){
		this.mf = mf;
		this.p7 = p7;
		this.p6 = p6;
		this.p8 = p8;
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		east = new JPanel(new FlowLayout());
		south = new JLabel("00호텔만의 특별한 멤버십,지금 가입하시고 회원만의 특별한 혜택을 받으세요");
		center = new JLabel();
		center2 = new JPanel();
		south2 = new JLabel();
		south3 = new JPanel();

		setBtn();

//		center.setIcon(new ImageIcon("img//호텔01.png"));
		
		ImageIcon img1;
		
		
		img1 = new ImageIcon("img//호텔01.png");
		resizeimage = img1.getImage();
		result = resizeimage.getScaledInstance(1050, 400, Image.SCALE_SMOOTH);
		res_img1 = new ImageIcon(result);
		imglabel1 = new JLabel(res_img1);
		
		center.setIcon(res_img1);
		
		
		center2.add(center);
		
		south2.setIcon(new ImageIcon("img//객실텍스트.png"));
		south3.add(south2);
		
		east.add(btn_login);
		east.add(btn_logout);
		east.add(btn_mypage);
		east.add(btn_mlogout);
		east.add(manager_page_bth);
		btn_mypage.setVisible(false);
		btn_logout.setVisible(false);
		manager_page_bth.setVisible(false);
		if(mf.check_login == true) {
			btn_mypage.setVisible(true);
		}
		btn_mlogout.setVisible(false);
		north.add("East",east);
		
		north.setBackground(Color.white);
		center2.setBackground(Color.white);
		south3.setBackground(Color.white);
		btn_login.setBackground(Color.white);
		
		this.add("Center",center2);
		this.add("North",north);
		this.add("South",south3);
		
		
		this.setVisible(true);

	}
	
	void setBtn() {
		btn_login = new JButton("로그인");
		btn_login.addActionListener(this);
		btn_mypage = new JButton("마이페이지");
		btn_mypage.addActionListener(this);
		btn_logout = new JButton("로그아웃");
		btn_logout.addActionListener(this);
		manager_page_bth = new JButton("관리자 페이지");
		manager_page_bth.addActionListener(this);
		btn_mlogout = new JButton("로그아웃");
		btn_mlogout.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton)e.getSource();
		
		if(bt == btn_login) {
			new Login(mf, this, p7, p6);

			
		}else if(bt == btn_logout) {
			JOptionPane.showMessageDialog(this, "로그아웃 되었습니다.");
			btn_login.setVisible(true);
			btn_mypage.setVisible(false);
			btn_logout.setVisible(false);
			p6.label[0].setVisible(true);
			p6.textfield[0].setVisible(true);
			p6.label[3].setVisible(true);
			p6.textfield[3].setVisible(true);
			p7.table.setModel(new Column_Model1());
			p8.table.setModel(new Column_Model2());
			p8.t2.setText("");
			p8.t3.setText("");
			p7.cid = null;
			mf.mainTabb.setEnabledAt(6, false);
		}else if(bt == btn_mypage) {
			new MyPage(this);
		}
		if(bt == manager_page_bth) {
			mng = new Mng(this);
		}else if(bt == btn_mlogout) {
			JOptionPane.showMessageDialog(this, "로그아웃 되었습니다.");
			btn_login.setVisible(true);
			manager_page_bth.setVisible(false);
			btn_mlogout.setVisible(false);
			
			p7.table.setModel(new Column_Model1());
			p8.table.setModel(new Column_Model2());
			p8.t2.setText("");
			p8.t3.setText("");
			
			mf.cid = "";
			mf.name = "";
			mf.phone = "";
			if(mng != null) {
				mng.dispose();
			}
		}
	}
}
class Column_Model1 extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;
	
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격"};

	Column_Model1() {
		rows = 0;
		cols = columnName.length;
	}

	@Override
	public String getColumnName(int arg0) {
		return columnName[arg0];
	}

	public int getColumnCount() {
		return cols;
	}

	public int getRowCount() {
		return rows;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableData[rowIndex][columnIndex];
	}

}
class Column_Model2 extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;

	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격" };

	Column_Model2() {
		rows = 0;
		cols = columnName.length;
	}

	@Override
	public String getColumnName(int arg0) {
		return columnName[arg0];
	}

	public int getColumnCount() {
		return cols;
	}

	public int getRowCount() {
		return rows;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableData[rowIndex][columnIndex];
	}

}
