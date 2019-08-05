package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class ReservationModel extends AbstractTableModel {
	Object[][] data;
	private int cols, rows;// 열의 갯수, 행의 갯수용 변수
	private String[] colName = { "예약번호", "CID", "이름", "전화번호", "방호수", "성인(명)", "아이(명)", "총액", "예약 날짜", "체크인", "체크아웃",
			"체크인확인", "체크아웃확인" };
	private List<Reservation_Info> bookingList;// DB조회 결과용 변수
	private List<Check_inout> check_inout;

	ReservationModel() {
		CrudProcess crud = new CrudProcess();
		bookingList = crud.selectAllReservation();
		check_inout = crud.selectAllCheckInout();
		setData();
	}

	ReservationModel(List<Reservation_Info> info, List<Check_inout> info2) {
		bookingList = info;
		check_inout = info2;
	
		setData();
	}

	void setData() {// 목적 : empList에 있는 조회결과를 data에 저장
		rows = bookingList.size();// 조회건수로 행의 갯수를 지정
		cols = colName.length;// 제목 수로 열의 갯수를 지정
		data = new Object[rows][cols];
		Iterator it = bookingList.iterator();
		Iterator it2 = check_inout.iterator();
		int r1 = 0;// 행을 위한 변수
		int r2 = 0;
		while (it.hasNext()) {
			Reservation_Info rinfo = (Reservation_Info) it.next();
			
			data[r1][0] = rinfo.getOrder_id();
			data[r1][1] = rinfo.getCid();
			data[r1][2] = rinfo.getName();
			data[r1][3] = rinfo.getPhone();
			data[r1][4] = rinfo.getRoomid();
			data[r1][5] = rinfo.getAdult();
			data[r1][6] = rinfo.getChild();
			data[r1][7] = rinfo.getTotal_price();
			data[r1][8] = rinfo.getReservation_date().substring(0, 10);
			data[r1][9] = rinfo.getCheck_in_d().substring(0, 10);
			data[r1][10] = rinfo.getCheck_out_d().substring(0, 10);
			
			r1++;
		}
		while(it2.hasNext()) {
			Check_inout cinfo = (Check_inout) it2.next();
			if(!(cinfo.getCheck_in_d() == null)) {
				data[r2][11] = cinfo.getCheck_in_d().substring(0, 10);
			}
			if(!(cinfo.getCheck_out_d() == null)) {
				data[r2][12] = cinfo.getCheck_out_d().substring(0, 10);
			}
			r2++;
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

	public String getColumnName(int column) {// 테이블 열제목 불러오기
		return colName[column];
	}

}
class ReservationModel2 extends AbstractTableModel {
	Object[][] data;
	private int cols, rows;// 열의 갯수, 행의 갯수용 변수
	private String[] colName = { "예약번호", "CID", "이름", "전화번호", "방호수", "성인(명)", "아이(명)", "총액", "예약 날짜", "체크인", "체크아웃",
			"체크인확인", "체크아웃확인" };
	private List<Reservation_Info> bookingList;// DB조회 결과용 변수
	private List<Check_inout> check_inout;

	ReservationModel2() {

		setData();
	}

	ReservationModel2(List<Reservation_Info> info, List<Check_inout> info2) {
		bookingList = info;
		check_inout = info2;
	
		setData();
	}

	void setData() {// 목적 : empList에 있는 조회결과를 data에 저장
		rows = 0;// 조회건수로 행의 갯수를 지정
		cols = colName.length;// 제목 수로 열의 갯수를 지정
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

	public String getColumnName(int column) {// 테이블 열제목 불러오기
		return colName[column];
	}

}


public class Mng_Reservation extends JPanel implements ActionListener, MouseListener {

//	CheckInOutModel ck;
	JLabel cid, reservation_date;
	private JLabel[] lbl;
	private JTextField[] txt;
	private JButton select, check_in, check_out;
	private JTable table, table2;
	private JScrollPane scroll, scroll2;
	private JPanel north, south, center;

	public Mng_Reservation() {

		this.setLayout(new BorderLayout());
		north = new JPanel();
		south = new JPanel();

		lbl = new JLabel[3];
		lbl[0] = new JLabel("주문번호");
		lbl[1] = new JLabel("고객명");
		lbl[2] = new JLabel("전화번호");
		txt = new JTextField[3];
		txt[0] = new JTextField(15);
		txt[1] = new JTextField(15);
		txt[2] = new JTextField(15);
		select = new JButton("검색");
		select.addActionListener(this);
		check_in = new JButton("체크인");
		check_in.addActionListener(this);
		check_out = new JButton("체크아웃");
		check_out.addActionListener(this);
		north.add(lbl[0]);
		north.add(txt[0]);
		north.add(lbl[1]);
		north.add(txt[1]);
		north.add(lbl[2]);
		north.add(txt[2]);
		north.add(select);
		this.add("North", north);

		center = new JPanel();
		table = new JTable();
		table.setModel(new ReservationModel());
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
//		scroll.setPreferredSize(new Dimension(1100, 680));
//		center.add(scroll);
		this.add("Center", scroll);

		south.add(check_in);
		south.add(check_out);
		this.add("South", south);

		cid = new JLabel("");
		reservation_date = new JLabel("");
	}

	private Integer orderID;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getColumnCount();
		orderID = Integer.parseInt(table.getValueAt(selectedRow, 0) + "");

	}
	public static boolean isNumeric(String s) {
		  try {
		      Double.parseDouble(s);
		      return true;
		  } catch(NumberFormatException e) {
		      return false;
		  }
		}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton obj = (JButton) e.getSource();
		if (obj == select) {
			if(!isNumeric(txt[0].getText()) && !(txt[0].getText().equals(""))) {
				JOptionPane.showMessageDialog(this, "주문번호를 입력하여 주십시오.");
			}else if(txt[0].getText().equals("") && txt[1].getText().equals("") && txt[2].getText().equals("")) {
				CrudProcess crud = new CrudProcess();
				List<Reservation_Info> info = crud.selectAllReservation();
				
				if(info == null) {
					table.setModel(new ReservationModel2());
					JOptionPane.showMessageDialog(this, "조회내역이 없습니다.");
				}else {
					table.setModel(new ReservationModel());
					JOptionPane.showMessageDialog(this, "전체가 조회 되었습니다.");
				}
			}else if(txt[0].getText().equals("") || !(txt[0].getText().equals(""))){
//				table.setModel(new CustomerModel());
				HashMap<String, Object> map = new HashMap<String, Object>();
				Check_inout ck = new Check_inout();
				if (!txt[0].getText().equals("")) {// 주문번호
					map.put("order_id", txt[0].getText());// "code"는 키
					ck.setOrder_id(Integer.parseInt(txt[0].getText()));
				}
				if (!txt[1].getText().equals("")) {// 이름
					map.put("name", txt[1].getText());
				}
				if(!txt[2].getText().equals("")) {
					map.put("phone", txt[2].getText());
				}
				CrudProcess crud = new CrudProcess();
				List<Reservation_Info> rinfo = crud.selectReservation(map);
				List<Check_inout> rinfo2 = crud.selectCheck_inout(ck);

				if(rinfo.size() == 0 || rinfo2.size() == 0) {
					table.setModel(new ReservationModel2());
					JOptionPane.showMessageDialog(this, "조회 내역이 없습니다.");
				}else {
					ReservationModel booking = new ReservationModel(rinfo, rinfo2);
					this.table.setModel(booking);
					JOptionPane.showMessageDialog(this, "조회되었습니다.");
				}
			}
		} else if (obj == check_in) {
			int result = JOptionPane.showConfirmDialog(this, "체크인 하시겠습니까?", "작업 확인", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				Check_inout inout = new Check_inout();
				int r = 0;

				inout.setOrder_id(orderID);
				if(orderID != null) {
					CrudProcess crud = new CrudProcess();
					r = crud.check_in_true(inout);// DB update
				}
				if (r > 0) {
					JOptionPane.showMessageDialog(this, "체크인 되었습니다.");
					table.setModel(new ReservationModel());
				}else if(r == 0) {
					JOptionPane.showMessageDialog(this, "예약건을 선택하여 주십시오.");
				}else {
					JOptionPane.showMessageDialog(this, "작업 중 문제가 발생했습니다.");
				}
			}
		} else if (obj == check_out) {
			int result = JOptionPane.showConfirmDialog(this, "체크아웃 하시겠습니까?", "작업 확인", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int r = 0;
				Check_inout inout = new Check_inout();
				inout.setOrder_id(orderID);
				if(orderID != null) {
					CrudProcess crud = new CrudProcess();
					r = crud.check_out_true(inout);// DB update
				}

				if (r > 0) {
					JOptionPane.showMessageDialog(this, "체크아웃 되었습니다.");
					table.setModel(new ReservationModel());
				}else if(r == 0) {
					JOptionPane.showMessageDialog(this, "예약건을 선택하여 주십시오.");
				}else {
					JOptionPane.showMessageDialog(this, "작업 중 문제가 발생했습니다.");
				}
			}
		}
	}
}