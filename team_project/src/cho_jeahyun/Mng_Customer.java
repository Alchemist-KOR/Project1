package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class CustomerModel extends AbstractTableModel{
	private Object[][] data;
	private int cols, rows;//열의 갯수, 행의 갯수용 변수
	private String[] colName = {"CID","비밀번호","이름","생년월일","성별","E-mail","전화번호","주소","포인트"};
	private List<Login_info> custList;//DB조회 결과용 변수
	CustomerModel(){
		CrudProcess crud = new CrudProcess();
		custList = crud.selectAllCustomer();
		setData();
	}
	CustomerModel(List<Login_info> info){
		custList = info;
		setData();
	}
	void setData() {//목적 : empList에 있는 조회결과를 data에 저장
		rows = custList.size();//조회건수로 행의 갯수를 지정
		cols = colName.length;//제목 수로 열의 갯수를 지정
		data = new Object[rows][cols];
		Iterator it = custList.iterator();
		int r = 0;//행을 위한 변수
		while(it.hasNext()) {
			Login_info cust = (Login_info)it.next();
			data[r][0] = cust.getCid();
			data[r][1] = cust.getPw();
			data[r][2] = cust.getName();
			data[r][3] = cust.getBirthday().substring(0, 10);
			data[r][4] = cust.getGender();
			data[r][5] = cust.getEmail();
			data[r][6] = cust.getPhone();
			data[r][7] = cust.getAddress();
			data[r][8] = cust.getPoint();
			r++;
		}
	}
	@Override
	public int getColumnCount() {
		return cols;
	}

	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return data[arg0][arg1];
	}
	public String getColumnName(int column) {//테이블 열제목 불러오기
		return colName[column];
	}
}
public class Mng_Customer extends JPanel implements ActionListener, MouseListener{
	private String cid;
	private JLabel[] lbl;
	private JTextField[] txt;
	private JButton select, selectAll;
	private JTable table; private JScrollPane scroll;
	private JPanel north;
	private String[] columnName = {"CID","비밀번호","이름","생년월일","성별","E-mail","전화번호","주소","포인트"};
	public Mng_Customer() {
		this.setLayout(new BorderLayout());
		north = new JPanel();
		
		lbl = new JLabel[2];
		lbl[0]= new JLabel("Cid");
		lbl[1]= new JLabel("고객명");
		txt = new JTextField[2];
		txt[0]= new JTextField(15);
		txt[1]= new JTextField(15);
		select = new JButton("검색");
		select.addActionListener(this);
		selectAll = new JButton("전체조회");
		selectAll.addActionListener(this);
		north.add(lbl[0]);north.add(txt[0]);
		north.add(lbl[1]);north.add(txt[1]);
		north.add(select);north.add(selectAll);
		this.add("North", north);

		
		
		 table = new JTable();
		 table.setModel(new CustomerModel());
		 scroll = new JScrollPane(table);
		 this.add("Center", scroll);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = table.getSelectedRow();
		int max_col = table.getColumnCount();
		for(int i=0;i<max_col;i++) {
//			left.texts[i].setText(table.getValueAt(row, i)+"");;
					
		}

	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton obj = (JButton)arg0.getSource();
		if(obj == select) {
			table.setModel(new CustomerModel());
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (!txt[0].getText().equals("")) {// 번호
				map.put("cid", txt[0].getText());// "code"는 키
			}
			if (!txt[1].getText().equals("")) {// 이름
				map.put("name", txt[1].getText());
			}
			CrudProcess crud = new CrudProcess();
			List<Login_info> li = crud.selectCustomer(map);
			CustomerModel cust = new CustomerModel(li);// 데이터를 iteminfomodel에 넘겨줌
			this.table.setModel(cust);
		}else if(obj == selectAll) {
			table.setModel(new CustomerModel());
		}
	}
}
