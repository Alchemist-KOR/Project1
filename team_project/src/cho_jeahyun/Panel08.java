package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

class Reservation_Info_Model_norl extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;
	private JPanel temp;
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격" };
	private List list;
	private Reservation_Info info;

//	Reservation_Info_Model_norl(List<Reservation_Info> info) {
//		list = info;
//		setData();
//	}

	Reservation_Info_Model_norl(Reservation_Info info) {
		CrudProcess crud = new CrudProcess();
		this.info = info;

		list = crud.selectAllReservation_Info_non(info);

		if (list.size() > 0) {
			setData();
		} else {
			JOptionPane.showMessageDialog(null, "조회내역이 없습니다.");
		}
	}

	void setData() {

		Iterator it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
		int r = 0;
		temp = new JPanel();
		while (it.hasNext()) {
			Reservation_Info res = (Reservation_Info) it.next();
			tableData[r][0] = res.getOrder_id();
			tableData[r][1] = res.getReservation_date().substring(0, 10);
			tableData[r][2] = res.getName();
			tableData[r][3] = res.getRoomid();
			tableData[r][4] = res.getCheck_in_d().substring(0, 10) + " ~ " + res.getCheck_out_d().substring(0, 10);
			tableData[r][5] = res.getTotal_price();
			r++;
		}
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "조회내역이 없습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "조회 되었습니다.");
		}

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

class Column_Model extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;

	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격" };

	Column_Model() {
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

public class Panel08 extends JPanel implements ActionListener, MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getColumnCount();
		orderID = Integer.parseInt(table.getValueAt(selectedRow, 0) + "");
		reservation_date = (table.getValueAt(selectedRow, 1) + "");
		refund = Integer.parseInt((table.getValueAt(selectedRow, 5) + ""));

		System.out.println(orderID + "  " + reservation_date + "  " + refund);

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == select || t2 == obj || t3 == obj) {
			if (t2.getText().equals("") || t3.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "빈칸을 채워주십시오.");
			} else {
				info = new Reservation_Info();
				info.setName(t2.getText());
				info.setPhone(t3.getText());

				table.setModel(new Reservation_Info_Model_norl(info));
				DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
				tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tcmSchedule = table.getColumnModel();
				for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
					tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);

				}
			}

		} else if (obj == cancel) {
			Reservation_cancel_info rc = new Reservation_cancel_info();
			CrudProcess crud = new CrudProcess();
			
			List<Reservation_cancel_info> rlist = crud.selectReservation_cancel_info_spe(orderID);
			List<Reservation_cancel_info> rlist2 = crud.selectReservation_cancel_check(orderID);
			if(rlist.size() > 0) {
				JOptionPane.showMessageDialog(this, "이미 요청되었습니다.");
			}else if(rlist2.size() > 0) {
				JOptionPane.showMessageDialog(this, "취소처리가 완료 되었습니다.");
			}else {
				rc.setOrder_id(orderID);
				rc.setRefund(refund);
				rc.setReservation_date(reservation_date);
				rc.setCheck_info("false");

				int r = crud.insertReservation_cancel(rc);
				
				if (r > 0) {
					JOptionPane.showMessageDialog(this, "정상적으로 취소 처리되었습니다.");
				} else {
					JOptionPane.showMessageDialog(this, "취소등록 중 문제가 발생했습니다.");
				}
			}
		}else if(obj == refresh) {
			table.setModel(new Column_Model());
		}
	}

	public static boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private JPanel tabPanel, north, north_center, south;
	private JButton select, cancel,refresh;
	private JLabel l2, l3;
	public JTextField t2, t3;
	public JTable table;
	private JScrollPane tablescroll;
	private Reservation_Info info;
	MainFrame mf;
	String cid;
	String reservation_date;
	Integer refund;
	Integer orderID;

	Panel08() {
		this.setLayout(new BorderLayout());
		north_center = new JPanel(new FlowLayout());
		north = new JPanel(new BorderLayout());
		south = new JPanel(new FlowLayout());

		select = new JButton("조회");
		select.addActionListener(this);
		cancel = new JButton("취소");
		cancel.addActionListener(this);
		refresh = new JButton("검색결과 초기화");
		refresh.addActionListener(this);
		

		north.add("East", select);

		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new Column_Model());
		tablescroll = new JScrollPane(table);
		l2 = new JLabel("이름");
		l3 = new JLabel("전화번호");

		t2 = new JTextField(10);
		t2.addActionListener(this);
		t3 = new JTextField(10);
		t3.addActionListener(this);

		north_center.add(l2);
		north_center.add(t2);
		north_center.add(l3);
		north_center.add(t3);

		
		north.add("Center", north_center);

		south.add("East",refresh);
		south.add(cancel);

		this.add("North", north);
		this.add("Center", tablescroll);
		this.add("South", south);

		this.setVisible(true);
	}
}
