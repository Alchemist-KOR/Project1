package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

//     예약확인
class Reservation_Info_Model extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;
	private JPanel temp;
	private JButton button = new JButton("취소");
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격", " " };
	private List list;
	String cid;

	Reservation_Info_Model(List<Reservation_Info> info) {
		list = info;
		setData();
	}

	Reservation_Info_Model(String cid) {
		this.cid = cid;
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
			tableData[r][1] = res.getReservation_date();
			tableData[r][2] = res.getName();
			tableData[r][3] = res.getRoomid();
			tableData[r][4] = res.getCheck_in_d() + res.getCheck_out_d();
			tableData[r][5] = res.getTotal_price();
			r++;

			
			
		}
		System.out.println(list.size());
		if (list.size() == 0) {
			System.out.println("list가 널");
			JOptionPane.showMessageDialog(null, "조회내역이 없습니다.");
		} else {
			System.out.println("list가 널이 아님");
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
	
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격", " " };

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

public class Panel07 extends JPanel implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button == select) {
			table.setModel(new Reservation_Info_Model(cid));
			table.getColumnModel().getColumn(6).setCellRenderer(new TableCell());
			table.getColumnModel().getColumn(6).setCellEditor(new TableCell());
		}
//		if(button == cancel) {
//			System.out.println("sdasd");
//		}
	}

	private JPanel tabPanel, north_right, south;
	private JButton select;
	private JTable table;
	private JScrollPane tablescroll;
	private JButton cancel1, cancel2;
	private String[] columnName = { "예약번호", "예약날짜", "예약자 명", "방 번호", "체크인/체크아웃", "가격", " " };
	MainFrame mf;
	String cid;

	Panel07(MainFrame mf) {
		this.mf = mf;
		this.setLayout(new BorderLayout());
		north_right = new JPanel(new BorderLayout());
		south = new JPanel(new FlowLayout());

		select = new JButton("조회");
		select.addActionListener(this);

		north_right.add("East", select);

		table = new JTable();
		table.setModel(new Column_Model());
		tablescroll = new JScrollPane(table);

		cancel2 = new JButton("취소");
		cancel2.addActionListener(this);

		south.add(cancel2);

		this.add("North", north_right);
		this.add("Center", tablescroll);
		this.add("South", south);

		this.setVisible(true);
	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		public TableCell() {
			// TODO Auto-generated constructor stub
			cancel1 = new JButton("취소");
//			cancel.setOpaque(true);
//			cancel.addActionListener(e -> {
//				System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
//			});
//			cancel1.addActionListener(e ->{
//				test();
//			});

		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return cancel1;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return cancel1;
		}

	}
}
