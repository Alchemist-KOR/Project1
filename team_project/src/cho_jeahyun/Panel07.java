package cho_jeahyun;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//     예약확인
class ItemInfoModel extends AbstractTableModel {
	private Object[][] tableData;
	int cols, rows;
	private String[] columnName = { "상품번호", "상품이름", "상품가격", "상품정보", "원산지", "이미지 이름" };
	private List list;
	
//	ItemInfoModel(List<ItemInfo> info) {
//		list = info;
//		setData();
//	}
	ItemInfoModel() {
		CrudProcess crud = new CrudProcess();
		//list = crud.selectAllIteminfo();
		setData();
	}

	void setData() {
		Iterator it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
		int r = 0;
		while (it.hasNext()) {
			ItemInfo item = (ItemInfo) it.next();
			tableData[r][0] = item.getCode();
			tableData[r][1] = item.getName();
			tableData[r][2] = item.getPrice();
			tableData[r][3] = item.getInfo();
			tableData[r][4] = item.getOrgin();
			tableData[r][5] = item.getImage();
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
public class Panel07 extends JPanel{
	private JPanel tabPanel, north_right;
	private JButton select;
	private JTable table;
	private JScrollPane tablescroll;
	
	
	
	
	Panel07(){
		String[] header = {"예약번호","예약날짜","예약자 명","방 번호","체크인/체크아웃","가격"," "};
		this.setLayout(new BorderLayout());
		north_right = new JPanel(new BorderLayout());
		
		select = new JButton("조회");
		
		north_right.add("East", select);
		
		
		table = new JTable();
		tablescroll = new JScrollPane(table);
		
		
		this.add("North", north_right);
		this.add("Center",tablescroll);
		
		this.setVisible(true);
	}
}
