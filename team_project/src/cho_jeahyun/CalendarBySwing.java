package cho_jeahyun;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarBySwing extends JFrame implements WindowListener, ActionListener, ItemListener{
	private Choice chyear, chmonth;
	private JLabel yLabel, mLabel;
	GregorianCalendar gc;
	private int year, month;
	private JLabel[] dayLabel = new JLabel[7];
	private String[] day={"��","��","ȭ","��","��","��","��"};
	private JButton[] days = new JButton[42];//7���� 6���̹Ƿ� 42���� ��ư�ʿ�
	private JPanel selectPanel = new JPanel();
	private GridLayout grid = new GridLayout(7,7,5,5);//��,��,����,������
	private Calendar ca = Calendar.getInstance();
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	private Join join;
	public CalendarBySwing(Join join) {
		this.join = join;
		setTitle("�޷� - ����:"+ca.get(Calendar.YEAR)+"/"+(ca.get(Calendar.MONTH)+1)+"/"+ca.get(Calendar.DATE));
		setSize(550,500);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int)(dimen.getWidth()/2 - dimen1.getWidth()/2);
		ypos = (int)(dimen.getHeight()/2 - dimen1.getHeight()/2);
		setLocation(xpos, ypos);//ȭ���� ����� ���
		setResizable(false);
		setVisible(true);
		chyear = new Choice(); chmonth = new Choice();
		yLabel = new JLabel("��"); mLabel = new JLabel("��");
//		addWindowListener(this);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void actionPerformed(ActionEvent arg0) {
		
		String year = chyear.getSelectedItem();
		String month = chmonth.getSelectedItem();
		JButton btn = (JButton)arg0.getSource();
		String day = btn.getText();
		if(join != null) {
			join.birth_txt.setText(year+"-"+month+"-"+day);
		}
		System.out.println(year+","+month+","+day);
//		if(index != 0) {
//			
//			if(index != 0) {
//				es.choices[3].removeAllItems();
//				es.choices[3].addItem("��");
//				switch(index) {
//				case 4:
//				case 6:
//				case 9:
//				case 11:	for(int i=1;i<=30;i++) {
//								es.choices[3].addItem(i+"");											
//							}
//							break;
//				case 2:		for(int i=1;i<=28;i++) {
//								es.choices[3].addItem(i+"");
//							}
//							break;
//				default :	for(int i=1;i<=31;i++) {
//								es.choices[3].addItem(i+"");
//							}
//				}//end of switch
//			}//end of if
//			//���� ���� ���� ä���. ��
//			es.choices[3].setSelectedItem(day);
//		}
//		}
		
		//���� ���� ���� ä���. ����
	}
		

	public void init(){
		select();
		calendar();
	}

	public void select(){
		JPanel panel = new JPanel(grid);//7�� 7���� �׸��巹�̾ƿ�
		for(int i=2019; i>=1920;i--){
			chyear.add(String.valueOf(i));
		}
		for(int i=1; i <=12; i++){
			chmonth.add(String.valueOf(i));
		}
		for(int i = 0; i < day.length;i++){//���� �̸��� ���̺� ���
			dayLabel[i] = new JLabel(day[i],JLabel.CENTER);
			panel.add(dayLabel[i]);
			dayLabel[i].setBackground(Color.GRAY);//��ǻ� �ǹ̰� ����. �ٲ��� ����.
		}
		dayLabel[6].setForeground(Color.BLUE);//����� ����
		dayLabel[0].setForeground(Color.RED);//�Ͽ��� ����
		for(int i = 0; i < 42;i++){//��� 42���� ��ư�� ����
			days[i] = new JButton("");//������ ���� ��ư ����
			if(i % 7 == 0)
				days[i].setForeground(Color.RED);//�Ͽ��� ��ư�� ��
			else if(i % 7 == 6)
				days[i].setForeground(Color.BLUE);//����� ��ư�� ��
			else
				days[i].setForeground(Color.BLACK);
			days[i].addActionListener(this);
			panel.add(days[i]);
		}
		selectPanel.add(chyear);
		selectPanel.add(yLabel);
		selectPanel.add(chmonth);
		selectPanel.add(mLabel);
		this.add(selectPanel,"North");//������ ���� ������ �� �ִ� ȭ���� ��ܿ� ���
		this.add(panel, "Center");
		String m = (ca.get(Calendar.MONTH)+1)+"";
		String y = ca.get(Calendar.YEAR)+"";
		chyear.select(y);
		chmonth.select(m);
		chyear.addItemListener(this);
		chmonth.addItemListener(this);
	}

	public void calendar(){
		year = Integer.parseInt(chyear.getSelectedItem());
		month=Integer.parseInt(chmonth.getSelectedItem());
		gc = new GregorianCalendar(year, month-1, 1);
		int max = gc.getActualMaximum(gc.DAY_OF_MONTH);//�ش� ���� �ִ� �� �� ȹ��
		int week = gc.get(gc.DAY_OF_WEEK);//�ش� ���� ���� ����
//		System.out.println("DAY_OF_WEEK:"+week);
		String today = Integer.toString(ca.get(Calendar.DATE));//���� ��¥ ȹ��
		String today_month = Integer.toString(ca.get(Calendar.MONTH)+1);//������ �� ȹ��
//		System.out.println("today:"+today);
		for(int i = 0; i < days.length; i++){
			days[i].setEnabled(true);
		}
		for(int i = 0; i < week-1; i++){//������ ������ ��ư�� ��Ȱ��ȭ
			days[i].setEnabled(false);
		}
		for(int i = week; i< max+week; i++){
			days[i-1].setText((String.valueOf(i-week+1)));
			days[i-1].setBackground(Color.WHITE);
			if(today_month.equals(String.valueOf(month))){//������ ���� �ް� ���� ���� ���
				if(today.equals(days[i-1].getText())){//��ư�� ��¥�� ���ó�¥�� ��ġ�ϴ� ���
					days[i-1].setBackground(Color.CYAN);//��ư�� ���� ����
				}
			}
		}
		for(int i = (max+week-1); i < days.length; i++){//��¥�� ���� ��ư�� ��Ȱ��ȭ
			days[i].setEnabled(false);
		}
//		System.out.println("max+week:"+(max+week)+",week:"+week);
	}
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
		arg0.getWindow().dispose();
//		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}

	public void itemStateChanged(ItemEvent arg0) {
		Color color = this.getBackground();
		if(arg0.getStateChange()==ItemEvent.SELECTED){
			for(int i = 0; i < 42; i++){//���̳� ���� ���õǸ� ������ �޷��� ����� ���� �׸���.
				if( !days[i].getText().equals("")){
					days[i].setText("");//������ ��¥�� ����
					days[i].setBackground(color);//�޷��� ������ ������ ������ ��ư�� ������ ������.
				}
			}
			calendar();
		}
	}

	public static void main(String[] args) {
//		new CalendarBySwing();
	}
}









