package cho_jeahyun;

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
	private int cols, rows;// ���� ����, ���� ������ ����
	private String[] colName = { "�����ȣ", "CID", "�̸�", "��ȭ��ȣ", "��ȣ��", "����(��)", "����(��)", "�Ѿ�", "���� ��¥", "üũ��", "üũ�ƿ�", "üũ��Ȯ��","üũ�ƿ�Ȯ��" };
	private List<Reservation_Info> bookingList;// DB��ȸ ����� ����

	ReservationModel() {
		CrudProcess crud = new CrudProcess();
		bookingList = crud.selectAllReservation();
		setData();
	}

	ReservationModel(List<Reservation_Info> info) {
		bookingList = info;
		setData();
	}

	void setData() {// ���� : empList�� �ִ� ��ȸ����� data�� ����
		rows = bookingList.size();// ��ȸ�Ǽ��� ���� ������ ����
		cols = colName.length;// ���� ���� ���� ������ ����
		data = new Object[rows][cols];
		Iterator it = bookingList.iterator();
		int r = 0;// ���� ���� ����
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

	public String getColumnName(int column) {// ���̺� ������ �ҷ�����
		return colName[column];
	}

}
class ReservationModel2 extends AbstractTableModel {
	Object[][] data;
	private int cols, rows;// ���� ����, ���� ������ ����
	private String[] colName = { "�����ȣ", "CID", "�̸�", "��ȭ��ȣ", "��ȣ��", "����(��)", "����(��)", "�Ѿ�", "���� ��¥", "üũ��", "üũ�ƿ�", "üũ��Ȯ��","üũ�ƿ�Ȯ��" };
	private List<Reservation_Info> bookingList;// DB��ȸ ����� ����

	ReservationModel2() {
		CrudProcess crud = new CrudProcess();
		bookingList = crud.selectAllReservation();
		setData();
	}

	ReservationModel2(List<Reservation_Info> info) {
		bookingList = info;
		setData();
	}

	void setData() {
		rows = bookingList.size();
		cols = colName.length;
		data = new Object[rows][cols];
		Iterator it = bookingList.iterator();
		int r = 0;
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

	public String getColumnName(int column) {// ���̺� ������ �ҷ�����
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
		lbl[1] = new JLabel("����");
		lbl[2] = new JLabel("��ȭ��ȣ");
		txt = new JTextField[3];
		txt[0] = new JTextField(15);
		txt[1] = new JTextField(15);
		txt[2] = new JTextField(15);
		select = new JButton("�˻�");
		select.addActionListener(this);
		check_in = new JButton("üũ��");
		check_in.addActionListener(this);
		check_out = new JButton("üũ�ƿ�");
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
		this.add("Center", center);

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
			if (!txt[0].getText().equals("")) {// ��ȣ
				map.put("cid", txt[0].getText());// "code"�� Ű
			}
			if (!txt[1].getText().equals("")) {// �̸�
				map.put("name", txt[1].getText());
			}
			CrudProcess crud = new CrudProcess();
			List<Reservation_Info> rinfo = crud.selectReservation(map);
			ReservationModel booking = new ReservationModel(rinfo);
			this.table.setModel(booking);
		} else if (obj == check_in) {
			int result = JOptionPane.showConfirmDialog(this, "üũ�� �Ͻðڽ��ϱ�?", "�۾� Ȯ��", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {

					Calendar today = new GregorianCalendar();
					int year = today.get(Calendar.YEAR);
					int mon = today.get(Calendar.MONTH) + 1;// 0���� ��µǱ� ������ 1�� ���������
					int date = today.get(Calendar.DATE);
					String order_date = year + "/" + mon + "/" + date;

					Check_inout inout = new Check_inout();
					System.out.println(orderID +"   "+order_date);
					inout.setOrder_id(orderID);
					inout.setCheck_in_d(order_date);
					CrudProcess crud = new CrudProcess();
					int r = crud.check_in_true(inout);// DB update
					if (r > 0) {
						JOptionPane.showMessageDialog(this, "üũ�� �Ǿ����ϴ�.");
						table.setModel(rm);
					} else {
						
						JOptionPane.showMessageDialog(this, "�۾� �� ������ �߻��߽��ϴ�.");
					}
				
			}
		} else if (obj == check_out) {

		}
	}
}