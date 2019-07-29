package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//     예약확인
class Reservation_Info_Model extends AbstractTableModel {
	private Object[][] tableData;
	int cols, rows;
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
		}
	}

	private JPanel tabPanel, north_right;
	private JButton select;
	private JTable table;
	private JScrollPane tablescroll;
	
	
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
}
