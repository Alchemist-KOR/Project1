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
	private String[] day={"일","월","화","수","목","금","토"};
	private JButton[] days = new JButton[42];//7일이 6주이므로 42개의 버튼필요
	private JPanel selectPanel = new JPanel();
	private GridLayout grid = new GridLayout(7,7,5,5);//행,열,수평갭,수직갭
	private Calendar ca = Calendar.getInstance();
	private Dimension dimen, dimen1;
	private Calendar calander2 = Calendar.getInstance();
	private int xpos, ypos;
	private Join join;
	private Update_Account ua;
	private Panel06 p6;
	public CalendarBySwing(Join join) {
		this.join = join;
		setTitle("달력 - 오늘:"+ca.get(Calendar.YEAR)+"/"+(ca.get(Calendar.MONTH)+1)+"/"+ca.get(Calendar.DATE));
		setSize(550,500);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int)(dimen.getWidth()/2 - dimen1.getWidth()/2);
		ypos = (int)(dimen.getHeight()/2 - dimen1.getHeight()/2);
		setLocation(xpos, ypos);//화면의 가운데에 출력
		setResizable(false);
		setVisible(true);
		chyear = new Choice(); chmonth = new Choice();
		yLabel = new JLabel("년"); mLabel = new JLabel("월");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		init();
	}
	public CalendarBySwing(Update_Account ua) {
		this.ua = ua;
		setTitle("달력 - 오늘:"+ca.get(Calendar.YEAR)+"/"+(ca.get(Calendar.MONTH)+1)+"/"+ca.get(Calendar.DATE));
		setSize(550,500);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int)(dimen.getWidth()/2 - dimen1.getWidth()/2);
		ypos = (int)(dimen.getHeight()/2 - dimen1.getHeight()/2);
		setLocation(xpos, ypos);//화면의 가운데에 출력
		setResizable(false);
		setVisible(true);
		chyear = new Choice(); chmonth = new Choice();
		yLabel = new JLabel("년"); mLabel = new JLabel("월");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		init();
	}
	public CalendarBySwing(Panel06 p6) {
		this.p6 = p6;
		setTitle("달력 - 오늘:"+ca.get(Calendar.YEAR)+"/"+(ca.get(Calendar.MONTH)+1)+"/"+ca.get(Calendar.DATE));
		setSize(550,500);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int)(dimen.getWidth()/2 - dimen1.getWidth()/2);
		ypos = (int)(dimen.getHeight()/2 - dimen1.getHeight()/2);
		setLocation(xpos, ypos);//화면의 가운데에 출력
		setResizable(false);
		setVisible(true);
		chyear = new Choice(); chmonth = new Choice();
		yLabel = new JLabel("년"); mLabel = new JLabel("월");

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
				JOptionPane.showMessageDialog(this, "선택할 수 없습니다.");
				p6.textfield[4].setText("");
				System.out.println("date < date1");
			}else {
				JOptionPane.showMessageDialog(this, "선택할 수 없습니다.");
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
				JOptionPane.showMessageDialog(this, "선택할 수 없습니다.");
				p6.textfield[5].setText("");
			}else if(compare < 0) {
				System.out.println("day1 < day2");
				p6.resDay = resDay;
				p6.insert.setEnabled(true);
				
				DecimalFormat f = new DecimalFormat("#,##0");
				
				p6.price.setText("결제금액: "+f.format(p6.price_sum));
				dispose();
			}else {
				JOptionPane.showMessageDialog(this, "선택할 수 없습니다.");
				p6.textfield[5].setText("");
			}
		}
	}
		

	public void init(){
		select();
		calendar();
	}

	public void select(){
		JPanel panel = new JPanel(grid);//7행 7열의 그리드레이아웃
		for(int i=2019; i>=1920;i--){
			chyear.add(String.valueOf(i));
		}
		for(int i=1; i <=12; i++){
			chmonth.add(String.valueOf(i));
		}
		for(int i = 0; i < day.length;i++){//요일 이름을 레이블에 출력
			dayLabel[i] = new JLabel(day[i],JLabel.CENTER);
			panel.add(dayLabel[i]);
			dayLabel[i].setBackground(Color.GRAY);//사실상 의미가 없슴. 바뀌지 않음.
		}
		dayLabel[6].setForeground(Color.BLUE);//토요일 색상
		dayLabel[0].setForeground(Color.RED);//일요일 색상
		for(int i = 0; i < 42;i++){//모두 42개의 버튼을 생성
			days[i] = new JButton("");//제목이 없는 버튼 생성
			if(i % 7 == 0)
				days[i].setForeground(Color.RED);//일요일 버튼의 색
			else if(i % 7 == 6)
				days[i].setForeground(Color.BLUE);//토요일 버튼의 색
			else
				days[i].setForeground(Color.BLACK);
			days[i].addActionListener(this);
			panel.add(days[i]);
		}
		selectPanel.add(chyear);
		selectPanel.add(yLabel);
		selectPanel.add(chmonth);
		selectPanel.add(mLabel);
		this.add(selectPanel,"North");//연도와 월을 선택할 수 있는 화면읠 상단에 출력
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
		int max = gc.getActualMaximum(gc.DAY_OF_MONTH);//해당 달의 최대 일 수 획득
		int week = gc.get(gc.DAY_OF_WEEK);//해당 달의 시작 요일
//		System.out.println("DAY_OF_WEEK:"+week);
		String today = Integer.toString(ca.get(Calendar.DATE));//오늘 날짜 획득
		String today_month = Integer.toString(ca.get(Calendar.MONTH)+1);//오늘의 달 획득
//		System.out.println("today:"+today);
		for(int i = 0; i < days.length; i++){
			days[i].setEnabled(true);
		}
		for(int i = 0; i < week-1; i++){//시작일 이전의 버튼을 비활성화
			days[i].setEnabled(false);
		}
		for(int i = week; i< max+week; i++){
			days[i-1].setText((String.valueOf(i-week+1)));
			days[i-1].setBackground(Color.WHITE);
			if(today_month.equals(String.valueOf(month))){//오늘이 속한 달과 같은 달인 경우
				if(today.equals(days[i-1].getText())){//버튼의 날짜와 오늘날짜가 일치하는 경우
					days[i-1].setBackground(Color.CYAN);//버튼의 배경색 지정
				}
			}
		}
		for(int i = (max+week-1); i < days.length; i++){//날짜가 없는 버튼을 비활성화
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
			for(int i = 0; i < 42; i++){//년이나 월이 선택되면 기존의 달력을 지우고 새로 그린다.
				if( !days[i].getText().equals("")){
					days[i].setText("");//기존의 날짜를 지움
					days[i].setBackground(color);//달력의 배경색과 동일한 색으로 버튼의 배경색을 설정함.
				}
			}
			calendar();
		}
	}

	public static void main(String[] args) {
//		new CalendarBySwing();
	}
}









