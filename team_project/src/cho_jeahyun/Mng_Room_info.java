package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


class RoomModel extends AbstractTableModel{
	private Object[][] data;
	private int cols, rows;//���� ����, ���� ������ ����
	private String[] colName = {"���ȣ","�ֹ���ȣ","�ο���","���","üũ��","üũ�ƿ�", "���ó��"};
	private List<Room_info> roomList;//DB��ȸ ����� ����
	RoomModel(){
		CrudProcess crud = new CrudProcess();
		roomList = crud.selectAllRoom_info();
		setData();
	}
	RoomModel(List<Room_info> info){
		roomList = info;
		setData();
	}
	void setData() {//���� : empList�� �ִ� ��ȸ����� data�� ����
		rows = roomList.size();//��ȸ�Ǽ��� ���� ������ ����
		cols = colName.length;//���� ���� ���� ������ ����
		data = new Object[rows][cols];
		Iterator it = roomList.iterator();
		int r = 0;//���� ���� ����
		while(it.hasNext()) {
			Room_info room = (Room_info)it.next();
			data[r][0] = room.getRoomid();
			data[r][1] = room.getOrder_id();
			data[r][2] = room.getNum_peo();
			data[r][3] = room.getRating();
			if(room.getCheck_in_d() != null && room.getCheck_out_d() != null) {
				data[r][4] = room.getCheck_in_d().substring(0, 10);
				data[r][5] = room.getCheck_out_d().subSequence(0, 10);
			}
			data[r][4] = room.getCheck_in_d();
			data[r][5] = room.getCheck_out_d();
	
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
	public String getColumnName(int column) {//���̺� ������ �ҷ�����
		return colName[column];
	}
}
public class Mng_Room_info extends JPanel implements ActionListener{
	private String cid;
	private JLabel[] lbl;
	private JTextField[] txt;
	private JButton select;
	private JTable table; private JScrollPane scroll;
	private JPanel north;
	private String[] columnName = {"���ȣ","�ֹ���ȣ","�ο���","���","üũ��","üũ�ƿ�"};
	public Mng_Room_info() {
		this.setLayout(new BorderLayout());
		north = new JPanel();
		
		lbl = new JLabel[2];

		txt = new JTextField[2];

		select = new JButton("�˻�");
		select.addActionListener(this);

		north.add(select);
		this.add("North", north);

		 table = new JTable();
		 DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		 tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 TableColumnModel tcmSchedule = table.getColumnModel();
		 table.setModel(new RoomModel());
		 scroll = new JScrollPane(table);
		 this.add("Center", scroll);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton obj = (JButton)arg0.getSource();
		if(obj == select) {
			CrudProcess crud = new CrudProcess();
			List<Room_info> roomList = crud.selectAllRoom_info();
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcmSchedule = table.getColumnModel();
			this.table.setModel(new RoomModel(roomList));
		}
	}
}
