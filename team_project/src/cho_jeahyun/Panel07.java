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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

//     예약확인
class Reservation_Info_Model extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;
	private JPanel temp;
	private JButton button = new JButton("취소");
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격"};
	private List list;
	String cid;

	Reservation_Info_Model(List<Reservation_Info> info) {
		list = info;
		setData();
	}

	Reservation_Info_Model(String cid) {
		this.cid = cid;
		System.out.println(cid);
		CrudProcess crud = new CrudProcess();
		list = crud.selectAllReservation_Info(cid);
		setData();
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
			tableData[r][4] = res.getCheck_in_d().substring(0, 10) +"~"+
					res.getCheck_out_d().substring(0, 10);
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
	
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격"};

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

public class Panel07 extends JPanel implements ActionListener, MouseListener {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getColumnCount();
		orderID = Integer.parseInt(table.getValueAt(selectedRow, 0) + "");
		reservation_date = (table.getValueAt(selectedRow, 1) + "");
		refund = Integer.parseInt((table.getValueAt(selectedRow, 5) + ""));
		
		System.out.println(orderID +"  "+reservation_date+"  "+refund);
		
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
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button == select) {
			System.out.println(cid);
			table.setModel(new Reservation_Info_Model(cid));
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcmSchedule = table.getColumnModel();
			for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
				tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
			}
		}else if(button == cancel) {
			Reservation_cancel_info rc = new Reservation_cancel_info();
			CrudProcess crud = new CrudProcess();
			
			rc.setOrder_id(orderID);
			rc.setRefund(refund);
			rc.setReservation_date(reservation_date);
			rc.setCheck_info("false");
			
			
			int r = crud.insertReservation_cancel(rc);
			
			if(r > 0) {
				JOptionPane.showMessageDialog(this, "정상적으로 취소 처리되었습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "취소등록 중 문제가 발생했습니다.");
			}
		}
	}

	private JPanel tabPanel, north_right, south;
	private JButton select, cancel;
	public JTable table;
	private JScrollPane tablescroll;
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격"};
	MainFrame mf;
	String cid;
	Integer orderID;
	Integer refund;
	String reservation_date;

	Panel07(MainFrame mf) {
		this.mf = mf;
		this.setLayout(new BorderLayout());
		north_right = new JPanel(new BorderLayout());
		south = new JPanel(new FlowLayout());

		select = new JButton("조회");
		select.addActionListener(this);
		cancel = new JButton("취소");
		cancel.addActionListener(this);
		
		north_right.add("East", select);

		table = new JTable();
		table.setModel(new Column_Model());
		table.addMouseListener(this);
		
		tablescroll = new JScrollPane(table);

		cancel = new JButton("취소");
		cancel.addActionListener(this);

		south.add(cancel);

		this.add("North", north_right);
		this.add("Center", tablescroll);
		this.add("South", south);

		this.setVisible(true);
	}
}
