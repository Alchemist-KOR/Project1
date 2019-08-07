package cyc_real;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
	private String[] colName = { "예약번호", "CID", "이름", "전화번호", "방호수", "성인(명)", "아이(명)", "총액", "예약 날짜", "체크인", "체크아웃", "체크인확인","체크아웃확인" };
	private List<Reservation_Info> bookingList;// DB조회 결과용 변수

	ReservationModel() {
		CrudProcess crud = new CrudProcess();
		bookingList = crud.selectAllReservation();
		setData();
	}

	ReservationModel(List<Reservation_Info> info) {
		bookingList = info;
		setData();
	}

	void setData() {// 목적 : empList에 있는 조회결과를 data에 저장
		rows = bookingList.size();// 조회건수로 행의 갯수를 지정
		cols = colName.length;// 제목 수로 열의 갯수를 지정
		data = new Object[rows][cols];
		Iterator it = bookingList.iterator();
		int r = 0;// 행을 위한 변수
		while (it.hasNext()) {
			Reservation_Info rinfo = (Reservation_Info) it.next();
			data[r][0] = rinfo.getOrder_id();
			data[r][1] = rinfo.getCid();
			data[r][2] = rinfo.getName();
			data[r][3] = rinfo.getPhone();
			data[r][4] = rinfo.getRoomid();
			data[r][5] = rinfo.getAdult();
			data[r][6] = rinfo.getChild();
			data[r][7] = rinfo.getTotal_price();
			data[r][8] = rinfo.getReservation_date().substring(0, 10);
			data[r][9] = rinfo.getCheck_in_d().substring(0, 10);
			data[r][10] = rinfo.getCheck_out_d().substring(0, 10);
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

	public String getColumnName(int column) {// 테이블 열제목 불러오기
		return colName[column];
	}

}
class ReservationModel2 extends AbstractTableModel {
	Object[][] data;
	private int cols, rows;// 열의 갯수, 행의 갯수용 변수
	private String[] colName = { "예약번호", "CID", "이름", "전화번호", "방호수", "성인(명)", "아이(명)", "총액", "예약 날짜", "체크인", "체크아웃", "체크인확인","체크아웃확인" };
	private List<Reservation_Info> bookingList;// DB조회 결과용 변수

	ReservationModel2() {
		CrudProcess crud = new CrudProcess();
		bookingList = crud.selectAllReservation();
		setData();
	}

	ReservationModel2(List<Reservation_Info> info) {
		bookingList = info;
		setData();
	}

	void setData() {// 목적 : empList에 있는 조회결과를 data에 저장
		rows = bookingList.size();// 조회건수로 행의 갯수를 지정
		cols = colName.length;// 제목 수로 열의 갯수를 지정
		data = new Object[rows][cols];
		Iterator it = bookingList.iterator();
		int r = 0;// 행을 위한 변수
		while (it.hasNext()) {
			Reservation_Info rinfo = (Reservation_Info) it.next();
			data[r][0] = rinfo.getOrder_id();
			data[r][1] = rinfo.getCid();
			data[r][2] = rinfo.getName();
			data[r][3] = rinfo.getPhone();
			data[r][4] = rinfo.getRoomid();
			data[r][5] = rinfo.getAdult();
			data[r][6] = rinfo.getChild();
			data[r][7] = rinfo.getTotal_price();
			data[r][8] = rinfo.getReservation_date().substring(0, 10);
			data[r][9] = rinfo.getCheck_in_d().substring(0, 10);
			data[r][10] = rinfo.getCheck_out_d().substring(0, 10);
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

	public String getColumnName(int column) {// 테이블 열제목 불러오기
		return colName[column];
	}

}

public class Mng_Reservation extends JPanel implements ActionListener, MouseListener {
	ReservationModel rm;
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
		lbl[0] = new JLabel("Cid");
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
		rm = new ReservationModel();
		table.setModel(rm);
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(800,510));
		center.add(scroll);
//		table2 = new JTable();
//		ck = new CheckInOutModel();
//		table2.setModel(ck);
//		scroll2 = new JScrollPane(table2);
//		scroll2.setPreferredSize(new Dimension(100,510));
//		center.add(scroll2);
		this.add("Center", center);

		south.add(check_in);
		south.add(check_out);
		this.add("South", south);

		cid = new JLabel("");
		reservation_date = new JLabel("");
	}

	private Integer orderID;
	private String indate;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getColumnCount();
//		rinfo.setOrder_id(Integer.parseInt(table.getValueAt(selectedRow, 0) + ""));
		
//		setOrder_id(Integer.parseInt(table.getValueAt(selectedRow, 0) + ""));
		orderID = Integer.parseInt(table.getValueAt(selectedRow, 0) + "");
		indate = table.getValueAt(selectedRow, 9)+"";
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
			table.setModel(new CustomerModel());
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (!txt[0].getText().equals("")) {// 번호
				map.put("cid", txt[0].getText());// "code"는 키
			}
			if (!txt[1].getText().equals("")) {// 이름
				map.put("name", txt[1].getText());
			}
			CrudProcess crud = new CrudProcess();
			List<Reservation_Info> rinfo = crud.selectReservation(map);
			ReservationModel booking = new ReservationModel(rinfo);
			this.table.setModel(booking);
		} else if (obj == check_in) {
			int result = JOptionPane.showConfirmDialog(this, "체크인 하시겠습니까?", "작업 확인", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {

					Calendar today = new GregorianCalendar();
					int year = today.get(Calendar.YEAR);
					int mon = today.get(Calendar.MONTH) + 1;// 0부터 출력되기 때문에 1을 더해줘야함
					int date = today.get(Calendar.DATE);
					String order_date = year + "/" + mon + "/" + date;

					Check_inout inout = new Check_inout();
					System.out.println(orderID +"   "+order_date);
					inout.setOrder_id(orderID);
					inout.setCheck_in_d(order_date);
					CrudProcess crud = new CrudProcess();
					int r = crud.check_in_true(inout);// DB update
					if (r > 0) {
						JOptionPane.showMessageDialog(this, "체크인 되었습니다.");
						table.setModel(rm);
					} else {
						
						JOptionPane.showMessageDialog(this, "작업 중 문제가 발생했습니다.");
					}
				
			}
		} else if (obj == check_out) {
			Calendar today = new GregorianCalendar();
			int year = today.get(Calendar.YEAR);
			int mon = today.get(Calendar.MONTH) + 1;// 0부터 출력되기 때문에 1을 더해줘야함
			int date = today.get(Calendar.DATE);
			String order_date = year + "/" + mon + "/" + date;

			Check_inout inout = new Check_inout();
			inout.setOrder_id(orderID);
			inout.setCheck_out_d(order_date);	
			CrudProcess crud = new CrudProcess();
			int r = crud.check_out_true(inout);// DB update
			if (r > 0) {
				JOptionPane.showMessageDialog(this, "체크아웃 되었습니다.");
				table.setModel(rm);
			} else {
				
				JOptionPane.showMessageDialog(this, "작업 중 문제가 발생했습니다.");
			}
		}
	}

}

//class CheckInOutModel extends AbstractTableModel {
//	Object[][] data;
//	private int cols, rows;// 열의 갯수, 행의 갯수용 변수
//	private String[] colName = { "체크인확인","체크아웃확인" };
//	private List<Check_inout> inoutList;// DB조회 결과용 변수
//
//	CheckInOutModel() {
//		CrudProcess crud = new CrudProcess();
//		inoutList = crud.selectAllCheckInout();
//		setData();
//	}
//
//
//	void setData() {// 목적 : empList에 있는 조회결과를 data에 저장
//		rows = inoutList.size();// 조회건수로 행의 갯수를 지정
//		cols = colName.length;// 제목 수로 열의 갯수를 지정
//		data = new Object[rows][cols];
//		Iterator it = inoutList.iterator();
//		int r = 0;// 행을 위한 변수
//		while (it.hasNext()) {
//			Check_inout inout = (Check_inout) it.next();
//			data[r][0] = inout.getCheck_in_d();
//			data[r][1] = inout.getCheck_out_d();
//			r++;
//		}
//	}
//
//	@Override
//	public int getColumnCount() {
//		return cols;
//	}
//
//	@Override
//	public int getRowCount() {
//		return rows;
//	}
//
//	@Override
//	public Object getValueAt(int arg0, int arg1) {
//		// TODO Auto-generated method stub
//		return data[arg0][arg1];
//	}
//
//	public String getColumnName(int column) {// 테이블 열제목 불러오기
//		return colName[column];
//	}
//
//}
	

