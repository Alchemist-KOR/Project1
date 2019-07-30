package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

//     예약확인
class Reservation_Info_Model extends AbstractTableModel{
	

	private Object[][] tableData;
	int cols, rows;
	private JButton button = new JButton("취소");
	private String[] columnName = {"예약번호","예약날짜","예약자 명","방 번호","체크인/체크아웃","가격"," "};
	private List list;
	
	Reservation_Info_Model(List<Reservation_Info> info) {
		list = info;
		setData();
	}
	Reservation_Info_Model() {
		CrudProcess crud = new CrudProcess();
		list = crud.selectAllReservation_Info();
		setData();
	}

	void setData() {
		
		Iterator it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
		int r = 0;
		while (it.hasNext()) {
			Reservation_Info res = (Reservation_Info) it.next();
			tableData[r][0] = res.getOrder_id();
			tableData[r][1] = res.getReservation_date();
			tableData[r][2] = res.getName();
			tableData[r][3] = res.getRoomid();
			tableData[r][4] = res.getCheck_in_d()+res.getCheck_out_d();
			tableData[r][5] = res.getTotal_price();
//			tableData[r][6] = button;
			r++;
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
public class Panel07 extends JPanel implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		if(button == select) {
			table.setModel(new Reservation_Info_Model());
			table.getColumnModel().getColumn(6).setCellRenderer(new TableCell());
			table.getColumnModel().getColumn(6).setCellEditor(new TableCell());
		}
//		if(button == cancel) {
//			System.out.println("sdasd");
//		}
	}

	private JPanel tabPanel, north_right;
	private JButton select;
	private JTable table;
	private JScrollPane tablescroll;
	private JButton cancel;
	
	
	Panel07(){
		
		this.setLayout(new BorderLayout());
		north_right = new JPanel(new BorderLayout());
		
		select = new JButton("조회");
		select.addActionListener(this);
		
		north_right.add("East", select);
		
		
		table = new JTable();
		
		tablescroll = new JScrollPane(table);

		
		this.add("North", north_right);
		this.add("Center",tablescroll);
		
		this.setVisible(true);
	}
	public void test(){
		System.out.println("sadasdawq");
	}
	
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

		

		public TableCell() {
			// TODO Auto-generated constructor stub
			cancel = new JButton("취소");
//			cancel.setOpaque(true);
//			cancel.addActionListener(e -> {
//				System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
//			});
			cancel.addActionListener(e ->{
				test();
			});
		
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
			return cancel;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return cancel;
		}
		
	}
}
