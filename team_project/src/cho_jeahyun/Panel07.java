package cho_jeahyun;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//     ����Ȯ��
class Reservation_Info_Model extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;
	private JPanel temp;
	private JButton button = new JButton("���");
	private String[] columnName = { "�����ȣ", "���೯¥", "������ ��", "�� ��ȣ", "üũ��/üũ�ƿ�", "����"};
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
			JOptionPane.showMessageDialog(null, "��ȸ������ �����ϴ�.");
		} else {
			JOptionPane.showMessageDialog(null, "��ȸ �Ǿ����ϴ�.");
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
	
	private String[] columnName = { "�����ȣ", "���೯¥", "������ ��", "�� ��ȣ", "üũ��/üũ�ƿ�", "����"};

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
		}
	}

	private JPanel tabPanel, north_right, south;
	private JButton select, cancel;
	private JTable table;
	private JScrollPane tablescroll;
	private JButton cancel1, cancel2;
	private String[] columnName = { "�����ȣ", "���೯¥", "������ ��", "�� ��ȣ", "üũ��/üũ�ƿ�", "����", " " };
	MainFrame mf;
	String cid;

	Panel07(MainFrame mf) {
		this.mf = mf;
		this.setLayout(new BorderLayout());
		north_right = new JPanel(new BorderLayout());
		south = new JPanel(new FlowLayout());

		select = new JButton("��ȸ");
		select.addActionListener(this);
		cancel = new JButton("���");
		cancel.addActionListener(this);
		
		north_right.add("East", select);

		table = new JTable();
		table.setModel(new Column_Model());
		tablescroll = new JScrollPane(table);

		cancel = new JButton("���");
		cancel.addActionListener(this);

		south.add(cancel);

		this.add("North", north_right);
		this.add("Center", tablescroll);
		this.add("South", south);

		this.setVisible(true);
	}
}
