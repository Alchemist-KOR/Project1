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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private Calendar calander2 = Calendar.getInstance();
	private int xpos, ypos;
	private Join join;
	private Update_Account ua;
	private Panel06 p6;
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

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		init();
	}
	public CalendarBySwing(Update_Account ua) {
		this.ua = ua;
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

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		init();
	}
	public CalendarBySwing(Panel06 p6) {
		this.p6 = p6;
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

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		init();
	}

	public void actionPerformed(ActionEvent arg0) {
		
		String year = chyear.getSelectedItem();
		
		Integer m = Integer.parseInt(chmonth.getSelectedItem());

		String month;
		String day;
		if(m < 10) {
			month = "0" + m;
		}else {
			month = chmonth.getSelectedItem();
		}
		
		JButton btn = (JButton)arg0.getSource();

		int d = Integer.parseInt(btn.getText());
		
		if(d < 10) {
			day = "0" + d;
		}else {
			day = btn.getText();
		}

		if(join != null) {
			join.birth_txt.setText(year+"-"+month+"-"+day);
			dispose();
		}
		if(ua != null) {
			ua.t1[2].setText(year+"-"+month+"-"+day);
			dispose();
		}
		if(p6 != null && p6.flage.equals("true")) {

			Calendar date1 = Calendar.getInstance();
			Calendar date = Calendar.getInstance();
			
			date1.set(Calendar.YEAR, date1.get(Calendar.YEAR));
			date1.set(Calendar.MONTH, date1.get(Calendar.MONTH)+1);
			date1.set(Calendar.DAY_OF_MONTH, date1.get(Calendar.DAY_OF_MONTH));
			
			date.set(Calendar.YEAR, Integer.parseInt(year));
			date.set(Calendar.MONTH, Integer.parseInt(month));
			date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			System.out.println(date);
			System.out.println(date1);
			
			int compare = date.compareTo(date1);
			
			if(compare > 0) {
				p6.textfield[4].setText(year+"-"+month+"-"+day);
				System.out.println("date > date1");
				dispose();
			}else if(compare < 0){
				JOptionPane.showMessageDialog(this, "������ �� �����ϴ�.");
				p6.textfield[4].setText("");
				System.out.println("date < date1");
			}else {
				JOptionPane.showMessageDialog(this, "������ �� �����ϴ�.");
				p6.textfield[5].setText("");
			}
			
		}else if(p6 != null && p6.flage.equals("false")) {
			p6.textfield[5].setText(year+"-"+month+"-"+day);
			calander2 = Calendar.getInstance();
			calander2.set(Calendar.YEAR, Integer.parseInt(year));
			calander2.set(Calendar.MONTH, Integer.parseInt(month));
			calander2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			
			System.out.println(p6.calander1);
			System.out.println(calander2);
			long resSec = (calander2.getTimeInMillis() - p6.calander1.getTimeInMillis())/1000;
			
			long resDay = resSec/(24*60*60);
			System.out.println(resDay);
			int compare = p6.calander1.compareTo(calander2);
			
			if(compare > 0) {
				JOptionPane.showMessageDialog(this, "������ �� �����ϴ�.");
				p6.textfield[5].setText("");
			}else if(compare < 0) {
				System.out.println("day1 < day2");
				p6.resDay = resDay;
				p6.insert.setEnabled(true);
				
				DecimalFormat f = new DecimalFormat("#,##0");
				
				p6.price.setText("�����ݾ�: "+f.format(p6.price_sum));
				dispose();
			}else {
				JOptionPane.showMessageDialog(this, "������ �� �����ϴ�.");
				p6.textfield[5].setText("");
			}
		}
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









