package cho_jeahyun;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

class Reservation_cancelModel extends AbstractTableModel {
	Object[][] data;
	private int cols, rows;// 열의 갯수, 행의 갯수용 변수
	private String[] colName = {"예약번호", "환불금액", "예약날자", "취소날자", "취소작업"};
	private List<Reservation_cancel_info> cancelList;// DB조회 결과용 변수

	Reservation_cancelModel() {
		CrudProcess crud = new CrudProcess();
		cancelList = crud.selectReservation_cancel_info();

		setData();
	}

	Reservation_cancelModel(List<Reservation_cancel_info> info) {
		cancelList = info;
	
		setData();
	}

	void setData() {// 목적 : empList에 있는 조회결과를 data에 저장
		rows = cancelList.size();// 조회건수로 행의 갯수를 지정
		cols = colName.length;// 제목 수로 열의 갯수를 지정
		data = new Object[rows][cols];
		Iterator it = cancelList.iterator();
		int r = 0;// 행을 위한 변수
		while (it.hasNext()) {
			Reservation_cancel_info rinfo = (Reservation_cancel_info) it.next();
			
			data[r][0] = rinfo.getOrder_id();
			data[r][1] = rinfo.getRefund();
			data[r][2] = rinfo.getReservation_date().substring(0, 10);
			data[r][3] = rinfo.getCancel_date().substring(0, 10);
			if(rinfo.getCheck_info().equals("") || rinfo.getCheck_info() == null) {
				data[r][4] = "처리중";
			}else if(rinfo.getCheck_info().equals("true")){
				data[r][4] = "취소처리 완료";
			}
			
			
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
class Reservation_cancelModel2 extends AbstractTableModel {
	Object[][] data;
	private int cols, rows;// 열의 갯수, 행의 갯수용 변수
	private String[] colName = { "예약번호", "환불금액", "예약날자", "취소날자"};
	private List<Reservation_cancel_info> cancelList;// DB조회 결과용 변수

	Reservation_cancelModel2() {

		setData();
	}

	Reservation_cancelModel2(List<Reservation_cancel_info> info) {
		cancelList = info;
	
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


public class Mng_Reservation_cancel extends JPanel implements ActionListener, MouseListener {

	JLabel cid, reservation_date;
	private JLabel[] lbl;
	private JTextField[] txt;
	private JButton select, cancel;
	private JTable table, table2;
	private JScrollPane scroll, scroll2;
	private JPanel north, south, center;

	public Mng_Reservation_cancel() {

		this.setLayout(new BorderLayout());
		north = new JPanel();
		south = new JPanel();

		lbl = new JLabel[1];
		lbl[0] = new JLabel("주문번호");
		txt = new JTextField[3];
		txt[0] = new JTextField(15);
		select = new JButton("검색");
		select.addActionListener(this);
		cancel = new JButton("취소");
		cancel.addActionListener(this);

		north.add(lbl[0]);
		north.add(txt[0]);
		
		north.add(select);
		this.add("North", north);

		center = new JPanel();
		table = new JTable();
		table.setModel(new Reservation_cancelModel());
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		south.add(cancel);

		this.add("Center", scroll);

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
			if(txt[0].getText().equals("")) {
				table.setModel(new Reservation_cancelModel());
				JOptionPane.showMessageDialog(this, "전체가 조회 되었습니다.");
			}else if(!(isNumeric(txt[0].getText()))) {
				JOptionPane.showMessageDialog(this, "주문번호를 입력하여 주십시오.");
			}else{
				CrudProcess crud = new CrudProcess();
				Integer order_id = Integer.parseInt(txt[0].getText());
				List<Reservation_cancel_info> info = crud.selectReservation_cancel_info_spe(order_id);
				
				if(info == null) {
					table.setModel(new Reservation_cancelModel2());
					JOptionPane.showMessageDialog(this, "조회내역이 없습니다.");
				}else {
					table.setModel(new Reservation_cancelModel(info));
					JOptionPane.showMessageDialog(this, "조회 되었습니다.");
				}
			}
		}else if(obj == cancel) {
			Reservation_cancel_info rc = new Reservation_cancel_info();
			
			rc.setCheck_info("true");
			rc.setOrder_id(orderID);
			CrudProcess crud = new CrudProcess();
			
			int r = crud.deleteReservation(orderID);
			crud.deleteSales(orderID);
			crud.deleteCheck_inout(orderID);
			int r3 = crud.updateReservation_cancel(rc);
			crud.updateRoom_info_null(orderID);
			
			if(r > 0 ) {
				JOptionPane.showMessageDialog(this, "정상적으로 취소 처리되었습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "취소처리 중 문제가 발생했습니다.");
			}
		}
	}
}
