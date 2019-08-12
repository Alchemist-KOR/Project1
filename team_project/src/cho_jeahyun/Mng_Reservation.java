package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

class ReservationModel extends AbstractTableModel {
	Object[][] data;
	private int cols, rows;// ���� ����, ���� ������ ����
	private String[] colName = { "�����ȣ", "CID", "�̸�", "��ȭ��ȣ", "��ȣ��", "���", "����(��)", "����(��)", "�Ѿ�", "���� ��¥", "üũ��", "üũ�ƿ�",
			"üũ��Ȯ��", "üũ�ƿ�Ȯ��" };
	private List<Reservation_Info> bookingList;// DB��ȸ ����� ����
	private List<Check_inout> check_inout;

	ReservationModel() {
		CrudProcess crud = new CrudProcess();
		bookingList = crud.selectAllReservation();
		check_inout = crud.selectAllCheckInout();
		setData();
	}

	ReservationModel(List<Reservation_Info> info, List<Check_inout> info2) {
		bookingList = info;
		check_inout = info2;
	
		setData();
	}

	void setData() {// ���� : empList�� �ִ� ��ȸ����� data�� ����
		rows = bookingList.size();// ��ȸ�Ǽ��� ���� ������ ����
		cols = colName.length;// ���� ���� ���� ������ ����
		data = new Object[rows][cols];
		Iterator it = bookingList.iterator();
		Iterator it2 = check_inout.iterator();
		int r1 = 0;// ���� ���� ����
		int r2 = 0;
		while (it.hasNext()) {
			Reservation_Info rinfo = (Reservation_Info) it.next();
			
			data[r1][0] = rinfo.getOrder_id();
			data[r1][1] = rinfo.getCid();
			data[r1][2] = rinfo.getName();
			data[r1][3] = rinfo.getPhone();
			data[r1][4] = rinfo.getRoomid();
			data[r1][5] = rinfo.getRating();
			data[r1][6] = rinfo.getAdult();
			data[r1][7] = rinfo.getChild();
			data[r1][8] = rinfo.getTotal_price();
			data[r1][9] = rinfo.getReservation_date().substring(0, 10);
			data[r1][10] = rinfo.getCheck_in_d().substring(0, 10);
			data[r1][11] = rinfo.getCheck_out_d().substring(0, 10);
			
			r1++;
		}
		int temp = 2000;
		while(it2.hasNext()) {
			Check_inout cinfo = (Check_inout) it2.next();
			
			if(!(cinfo.getCheck_in_d() == null)) {
				if(temp < Integer.parseInt(cinfo.getCheck_in_d().substring(0,4))) {
					data[r2][12] = cinfo.getCheck_in_d().substring(0,10);
				}else {
					data[r2][12] = cinfo.getCheck_in_d().substring(4,5);
				}
			}
			if(!(cinfo.getCheck_out_d() == null)) {
				if(temp < Integer.parseInt(cinfo.getCheck_out_d().substring(0,4))) {
					data[r2][13] = cinfo.getCheck_out_d().substring(0,10);
				}else {
					data[r2][13] = cinfo.getCheck_out_d().substring(4,5);
				}
				
			}
			r2++;
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
	private String[] colName = { "�����ȣ", "CID", "�̸�", "��ȭ��ȣ", "��ȣ��", "���", "����(��)", "����(��)", "�Ѿ�", "���� ��¥", "üũ��", "üũ�ƿ�",
			"üũ��Ȯ��", "üũ�ƿ�Ȯ��" };

	ReservationModel2() {

		setData();
	}


	void setData() {// ���� : empList�� �ִ� ��ȸ����� data�� ����
		rows = 0;// ��ȸ�Ǽ��� ���� ������ ����
		cols = colName.length;// ���� ���� ���� ������ ����
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

//	CheckInOutModel ck;
	JLabel cid, reservation_date;
	private JLabel[] lbl;
	private JLabel room;
	private JTextField[] txt;
	private JTextField room_txt;
	private JButton select, check_in, check_out, room_btn, delete_btn;
	private JTable table;
	private JScrollPane scroll;
	private JPanel north, south;

	public Mng_Reservation() {

		this.setLayout(new BorderLayout());
		north = new JPanel();
		south = new JPanel();
		
		room = new JLabel("�����");
		room_txt = new JTextField(10);
		room_btn = new JButton("����");
		room_btn.addActionListener(this);
		delete_btn = new JButton("�������");
		delete_btn.addActionListener(this);

		lbl = new JLabel[3];
		lbl[0] = new JLabel("�ֹ���ȣ");
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
		
		
		table = new JTable();
		table.setModel(new ReservationModel());
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
//		scroll.setPreferredSize(new Dimension(1100, 680));
//		center.add(scroll);
		this.add("Center", scroll);

		south.add(room);
		south.add(room_txt);
		south.add(room_btn);
		
		
		south.add(check_in);
		south.add(check_out);
		south.add(delete_btn);
		
		this.add("South", south);

		cid = new JLabel("");
		reservation_date = new JLabel("");
	}

	private Integer orderID;
	private String check_in_d;
	private String check_out_d;
	private String res_date;
	private Integer price;
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getColumnCount();
		orderID = Integer.parseInt(table.getValueAt(selectedRow, 0) + "");
		price = Integer.parseInt(table.getValueAt(selectedRow, 8) + "");
		res_date = (String) table.getValueAt(selectedRow, 9);
		check_in_d = (String) table.getValueAt(selectedRow, 10);
		check_out_d = (String) table.getValueAt(selectedRow, 11);
		
		System.out.println(orderID);

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
			if(!isNumeric(txt[0].getText()) && !(txt[0].getText().equals(""))) {
				JOptionPane.showMessageDialog(this, "�ֹ���ȣ�� �Է��Ͽ� �ֽʽÿ�.");
			}
			else if(txt[0].getText().equals("") && txt[1].getText().equals("") && txt[2].getText().equals("")) {
				CrudProcess crud = new CrudProcess();
				List<Reservation_Info> info = crud.selectAllReservation();
				
				if(info == null) {
					table.setModel(new ReservationModel2());
					JOptionPane.showMessageDialog(this, "��ȸ������ �����ϴ�.");
				}else {
					table.setModel(new ReservationModel());
					JOptionPane.showMessageDialog(this, "��ü�� ��ȸ �Ǿ����ϴ�.");
				}
			}
			else if(txt[0].getText().equals("") || !(txt[0].getText().equals(""))){

				HashMap<String, Object> map = new HashMap<String, Object>();
				Check_inout ck = new Check_inout();
				if (!txt[0].getText().equals("")) {// �ֹ���ȣ
					map.put("order_id", txt[0].getText());// "code"�� Ű
					ck.setOrder_id(Integer.parseInt(txt[0].getText()));
				}
				if (!txt[1].getText().equals("")) {// �̸�
					map.put("name", txt[1].getText());
				}
				if(!txt[2].getText().equals("")) {
					map.put("phone", txt[2].getText());
				}
				CrudProcess crud = new CrudProcess();
				List<Reservation_Info> rinfo = crud.selectReservation(map);
				List<Check_inout> rinfo2 = crud.selectCheck_inout(ck);
				
				if(rinfo.size() == 0 && rinfo2.size() == 0) {
					table.setModel(new ReservationModel2());
					DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
					tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
					TableColumnModel tcmSchedule = table.getColumnModel();
					for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
						tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
					}
					JOptionPane.showMessageDialog(this, "��ȸ ������ �����ϴ�.");
				}else {
					ReservationModel booking = new ReservationModel(rinfo, rinfo2);
					this.table.setModel(booking);
					DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
					tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
					TableColumnModel tcmSchedule = table.getColumnModel();
					for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
						tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
					}
					JOptionPane.showMessageDialog(this, "��ȸ�Ǿ����ϴ�.");
				}
			}
		} else if (obj == check_in) {
			int result = JOptionPane.showConfirmDialog(this, "üũ�� �Ͻðڽ��ϱ�?", "�۾� Ȯ��", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				Check_inout inout = new Check_inout();
				int r = 0;

				inout.setOrder_id(orderID);
				if(orderID != null) {
					CrudProcess crud = new CrudProcess();
					r = crud.check_in_true(inout);// DB update
				}
				if (r > 0) {
					JOptionPane.showMessageDialog(this, "üũ�� �Ǿ����ϴ�.");
					table.setModel(new ReservationModel());
					DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
					tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
					TableColumnModel tcmSchedule = table.getColumnModel();
					for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
						tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
					}
				}else if(r == 0) {
					JOptionPane.showMessageDialog(this, "������� �����Ͽ� �ֽʽÿ�.");
				}else {
					JOptionPane.showMessageDialog(this, "�۾� �� ������ �߻��߽��ϴ�.");
				}
			}
		} else if (obj == check_out) {
			int result = JOptionPane.showConfirmDialog(this, "üũ�ƿ� �Ͻðڽ��ϱ�?", "�۾� Ȯ��", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int r = 0;
				Check_inout inout = new Check_inout();
				inout.setOrder_id(orderID);
				if(orderID != null) {
					CrudProcess crud = new CrudProcess();
					r = crud.check_out_true(inout);// DB update
				}

				if (r > 0) {
					JOptionPane.showMessageDialog(this, "üũ�ƿ� �Ǿ����ϴ�.");
					table.setModel(new ReservationModel());
					DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
					tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
					TableColumnModel tcmSchedule = table.getColumnModel();
					for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
						tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
					}
				}else if(r == 0) {
					JOptionPane.showMessageDialog(this, "������� �����Ͽ� �ֽʽÿ�.");
				}else {
					JOptionPane.showMessageDialog(this, "�۾� �� ������ �߻��߽��ϴ�.");
				}
			}
		}else if(obj == room_btn) {
			int result = JOptionPane.showConfirmDialog(this, "������� �Ͻðڽ��ϱ�?", "�۾� Ȯ��", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int r = -1;
				int r2 = 0;
				String room = room_txt.getText();
				if(orderID != null) {
					CrudProcess crud = new CrudProcess();
					Room_info rd = new Room_info();
					Reservation_Info rinfo = new Reservation_Info();
					Sales_management sm = new Sales_management();
					
					
					rd.setOrder_id(orderID);
					rd.setCheck_in_d(check_in_d);
					rd.setCheck_out_d(check_out_d);
					rd.setRoomid(room);
					
					sm.setOrder_id(orderID);
					sm.setBenefit(price);
					sm.setReservation_date(res_date);
					
					r2 = crud.updateRoom_info(rd);
					if(r2 > 0) {
						rinfo.setOrder_id(orderID);
						rinfo.setRoomid(room);
						crud.insertSales_management(sm);
						r = crud.updateReservation_room(rinfo);
					}
				}
				if (r > 0) {
					JOptionPane.showMessageDialog(this, "���� ���� �Ǿ����ϴ�.");
					table.setModel(new ReservationModel());
					DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
					tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
					TableColumnModel tcmSchedule = table.getColumnModel();
					for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
						tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
					}
				}else if(r == 0) {
					JOptionPane.showMessageDialog(this, "���� �����Ͽ� �ֽʽÿ�.");
				}else {
					JOptionPane.showMessageDialog(this, "�۾� �� ������ �߻��߽��ϴ�.");
				}
			}
		}else if(obj == delete_btn) {
			int result = JOptionPane.showConfirmDialog(this, "������ ��� �Ͻðڽ��ϱ�?", "�۾� Ȯ��", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				CrudProcess crud = new CrudProcess();
				int r = crud.deleteReservation(orderID);
				crud.deleteCheck_inout(orderID);
				int r2 = 0;
				if(r > 0) {
					List<Sales_management> slist;
					slist = crud.selectSales(orderID);
					if(slist.size() > 0) {
						crud.deleteSales(orderID);
					}
					r2 = crud.updateRoom_info_null(orderID);
				}
				
				if (r > 0) {
					JOptionPane.showMessageDialog(this, "������ ��ҵǾ����ϴ�.");
					table.setModel(new ReservationModel());
					DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
					tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
					TableColumnModel tcmSchedule = table.getColumnModel();
					for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
						tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
					}
				}else if(r == 0) {
					JOptionPane.showMessageDialog(this, "������ �����Ͽ� �ֽʽÿ�.");
				}else {
					JOptionPane.showMessageDialog(this, "�۾� �� ������ �߻��߽��ϴ�.");
				}
			}
		
		}
	}
}