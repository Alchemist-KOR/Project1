package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
class BarchartPanel extends JPanel{
	private Integer[] data; //25단위
	public List salessumList, saleavgList;
	Sales_management_M sm;
	Mng_Barchart bar;
	private int flag_avg_sum;
	BarchartPanel(){
		data = new Integer[12];

		for(int i=0; i<data.length;i++) {
			data[i] = 0;
		}
		
	}

	void setData(Sales_management_M smm, int flag_avg_sum) {
		this.sm = smm;
		data = new Integer[12];

		this.flag_avg_sum = flag_avg_sum;
		CrudProcess crud = new CrudProcess();
		salessumList = crud.selectSalesSum(sm);
		saleavgList = crud.selectSalesAvg(sm);
		
		if(flag_avg_sum == 1) {
			for(int i=0; i<data.length;i++) {
				data[i] = 0;
			}
			for(int i=0; i<salessumList.size(); i++) {
				data[i] = (Integer) salessumList.get(i);
			}
		}else if(flag_avg_sum == 2) {
			for(int i=0; i<data.length;i++) {
				data[i] = 0;
			}
			for(int i=0; i<saleavgList.size(); i++) {
				data[i] = (Integer) saleavgList.get(i);
			}
		}
		
		
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(100, 545, 1100, 545);
		for(int cnt = 1;cnt<11;cnt++) {
			g.drawString(cnt*100+"", 50, 600-50*cnt);
			g.drawLine(95, 595-50*cnt, 1105, 595-50*cnt);
		}
		for(int cnt = 1;cnt<11;cnt++) {
			g.drawString(cnt*100+"", 1130, 600-50*cnt);
		}
//		g.drawString("억원", 145, 70);
		g.drawLine(100,75,100,545);g.drawLine(1100,75,1100,545);
		g.drawString("1월", 150, 570);//막대그래프 1의 제목
		g.drawString("2월", 230, 570);
		g.drawString("3월", 310, 570);
		g.drawString("4월", 390, 570);
		g.drawString("5월", 470, 570);
		g.drawString("6월", 550, 570);
		g.drawString("7월", 630, 570);//막대그래프 1의 제목
		g.drawString("8월", 710, 570);
		g.drawString("9월", 790, 570);
		g.drawString("10월", 870, 570);
		g.drawString("11월", 950, 570);
		g.drawString("12월", 1030, 570);
		g.setColor(Color.RED);

		if(data[0]>0) {
			g.fillRect(145, 545-data[0]/100000, 30, data[0]/100000);
		}
		if(data[1]>0) {
			g.fillRect(225, 545-data[1]/100000, 30, data[1]/100000);
		}
		if(data[2]>0) {
			g.fillRect(305, 545-data[2]/100000, 30, data[2]/100000);
		}
		if(data[3]>0) {
			g.fillRect(385, 545-data[3]/100000, 30, data[3]/100000);
		}
		if(data[4]>0) {
			g.fillRect(465, 545-data[4]/100000, 30, data[4]/100000);
		}
		if(data[5]>0) {
			g.fillRect(545, 545-data[5]/100000, 30, data[5]/100000);
		}
		if(data[6]>0) {
			g.fillRect(625, 545-data[6]/100000, 30, data[6]/100000);
		}
		if(data[7]>0) {
			g.fillRect(705, 545-data[7]/100000, 30, data[7]/100000);
		}
		if(data[8]>0) {
			g.fillRect(785, 545-data[8]/100000, 30, data[8]/100000);
		}
		if(data[9]>0) {
			g.fillRect(865, 545-data[9]/100000, 30, data[9]/100000);
		}
		if(data[10]>0) {
			g.fillRect(945, 545-data[10]/100000, 30, data[10]/100000);
		}
		if(data[11]>0) {
			g.fillRect(1025, 545-data[11]/100000, 30, data[11]/100000);
		}

		this.repaint();//데이터 입력 후 그리기 버튼 누르면 갱신되는 메소드
	}
	
	
}

public class Mng_Barchart extends JPanel implements ItemListener, ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int flag_avg_sum = 0;
		if(e.getSource() == select_sum) {
			CrudProcess crud = new CrudProcess();
			flag_avg_sum = 1;
			
			
			String y = year.getSelectedItem().toString();
			if(year.getSelectedIndex() != 0) {
				
				smm.setStart_d(y+"/01/01");
				smm.setLast_d(y+"/12/31");

				center.setData(smm, flag_avg_sum);
				System.out.println(Integer.parseInt(y)+"/01/01");
			}
		}else if(e.getSource() == select_avg) {
			CrudProcess crud = new CrudProcess();
			flag_avg_sum = 2;
			
			
			String y = year.getSelectedItem().toString();
			if(year.getSelectedIndex() != 0) {
				
				smm.setStart_d(y+"/01/01");
				smm.setLast_d(y+"/12/31");

				center.setData(smm, flag_avg_sum);
				System.out.println(Integer.parseInt(y)+"/01/01");
			}
		}
		
	}
	Sales_management_M smm = new Sales_management_M();
	List list;
	public JComboBox year;
	private JButton select_sum, select_avg;
	private JPanel north;
	public BarchartPanel center;
	private JLabel swungdash;
	private String start, end;
	public Mng_Barchart() {
		this.setLayout(new BorderLayout());
		north = new JPanel();
		center = new BarchartPanel();
		select_sum = new JButton("총합 조회");
		select_sum.addActionListener(this);
		select_avg = new JButton("평균 조회");
		select_avg.addActionListener(this);
		setComboBox();
		north.add(select_sum);
		north.add(select_avg);
		this.add("North", north);this.add("Center", center);
		
	}
	void setComboBox() {
	 
		year = new JComboBox();
		year.addItem("연도를 선택하세요.");
		for(int i=2019;i>1919;i--) {
			year.addItem(i+"");
		}
		north.add(year);
		
	}
@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox jb = (JComboBox) e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if(jb == year) {
				String y = year.getSelectedItem().toString();
				System.out.println(y);
			}	
		}
	}
}
