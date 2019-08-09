package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel06 extends JPanel implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton bt = (JButton) arg0.getSource();
		String tf1, tf2;
		tf1 = textfield[1].getText();
		tf2 = textfield[2].getText();
		Integer adult = 0;
		Integer child = 0;
		if (bt == check_in) {
			flage = "true";
			new CalendarBySwing(this);
		} else if (bt == check_out) {
			if (tf1 == null || tf1.equals("") || tf2 == null || tf2.equals("")) {
				JOptionPane.showMessageDialog(this, "명수를 입력하여주십시오.");
			} else {
				if(textfield[4].getText().equals("") || textfield[4].getText() == null) {
					JOptionPane.showMessageDialog(this, "체크인 날자를 선택하여주십시오.");
					
				}else if(rateing.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(this, "등급을 선택하여주십시오.");
				}else {
					flage = "false";
					adult = Integer.parseInt(textfield[1].getText());
					child = Integer.parseInt(textfield[2].getText());
					calander1 = Calendar.getInstance();
					calander1.set(Calendar.YEAR, Integer.parseInt(textfield[4].getText().substring(0, 4)));
					calander1.set(Calendar.MONTH, Integer.parseInt(textfield[4].getText().substring(5, 7)));
					calander1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(textfield[4].getText().substring(8, 10)));
					new CalendarBySwing(this);
					if (rateing.getSelectedIndex() == 1) {
						if (resDay == 0) {
							price_sum = (int) ((adult * ADULT + child * CHILD) + STANDARD);
						} else {
							price_sum = (int) (((adult * ADULT + child * CHILD) + STANDARD) * resDay);
						}

					} else if (rateing.getSelectedIndex() == 2) {
						if (resDay == 0) {
							price_sum = (int) ((adult * ADULT + child * CHILD) + PREMIUM);
						} else {
							price_sum = (int) (((adult * ADULT + child * CHILD) + PREMIUM) * resDay);
						}

					} else if (rateing.getSelectedIndex() == 3) {
						if (resDay == 0) {
							price_sum = (int) ((adult * ADULT + child * CHILD) + SWEET);
						} else {
							price_sum = (int) (((adult * ADULT + child * CHILD) + SWEET) * resDay);
						}

					}
				}
			}

		}
		if (mf.cid == null) {
			if (insert == bt) {
				if(tf1 == null || tf1.equals("") || tf2 == null || tf2.equals("")
						|| textfield[0].getText() == null || textfield[0].getText().equals("")
						|| textfield[3].getText() == null || textfield[3].getText().equals("")) {
					JOptionPane.showMessageDialog(this, "빈칸을 입력하여주십시오.");
				}else if(rateing.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(this, "등급을 선택하여주십시오.");
				}else {
					int result = JOptionPane.showConfirmDialog(this, "예약을 하시겠습니까?", "작업 확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						Reservation_Info rinfo = new Reservation_Info();
						CrudProcess crud = new CrudProcess();

						if (crud.selectReservation_Max() == null) {
							max_num = 8;
						} else {
							max_num = crud.selectReservation_Max();
						}
						max_num++;

						adult = Integer.parseInt(textfield[1].getText());
						child = Integer.parseInt(textfield[2].getText());
						System.out.println(textfield[0].getText());
						rinfo.setOrder_id(max_num);
						rinfo.setName(textfield[0].getText());
						rinfo.setAdult(adult);
						rinfo.setChild(child);
						rinfo.setPhone(textfield[3].getText());
						if (rateing.getSelectedIndex() == 1) {
							rinfo.setRating("STANDARD");
							if (resDay == 0) {
								price_sum = (int) ((adult * ADULT + child * CHILD) + STANDARD);
							} else {
								price_sum = (int) (((adult * ADULT + child * CHILD) + STANDARD) * resDay);
							}

						} else if (rateing.getSelectedIndex() == 2) {
							rinfo.setRating("PREMIUM");
							if (resDay == 0) {
								price_sum = (int) ((adult * ADULT + child * CHILD) + PREMIUM);
							} else {
								price_sum = (int) (((adult * ADULT + child * CHILD) + PREMIUM) * resDay);
							}

						} else if (rateing.getSelectedIndex() == 3) {
							rinfo.setRating("SWEET");
							if (resDay == 0) {
								price_sum = (int) ((adult * ADULT + child * CHILD) + SWEET);
							} else {
								price_sum = (int) (((adult * ADULT + child * CHILD) + SWEET) * resDay);
							}

						}
						rinfo.setTotal_price(price_sum);

						rinfo.setCheck_in_d(textfield[4].getText());
						rinfo.setCheck_out_d(textfield[5].getText());

						int r = crud.insertReservation_Info_nomember(rinfo);
						if (r > 0) {
							for (int i = 0; i < textfield.length; i++) {
								textfield[i].setText("");
							}
							rateing.setSelectedIndex(0);
							JOptionPane.showMessageDialog(this, "예약처리가 정상적으로 완료 되었습니다.");
						} else {
							JOptionPane.showMessageDialog(this, "예약처리 중 문제가 발생하였습니다.");
						}
					}
				}
				
			}
		} else if (mf.cid != null) {
			if (insert == bt) {
				if(tf1 == null || tf1.equals("") || tf2 == null || tf2.equals("")) {
					JOptionPane.showMessageDialog(this, "빈칸을 입력하여주십시오.");
				}else if(rateing.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(this, "등급을 선택하여주십시오.");
				}else {
					int result = JOptionPane.showConfirmDialog(this, "예약을 하시겠습니까?", "작업 확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						Reservation_Info rinfo = new Reservation_Info();
						CrudProcess crud = new CrudProcess();

						if (crud.selectReservation_Max() == null) {
							max_num = 8;
						} else {
							max_num = crud.selectReservation_Max();
						}
						max_num++;

						adult = Integer.parseInt(textfield[1].getText());
						child = Integer.parseInt(textfield[2].getText());
						Integer price_sum = 0;
						System.out.println(mf.cid + "   " + mf.name + "    " + mf.phone);

						rinfo.setOrder_id(max_num);
						rinfo.setCid(mf.cid);
						rinfo.setName(mf.name);
						rinfo.setAdult(adult);
						rinfo.setChild(child);
						rinfo.setPhone(mf.phone);
						if (rateing.getSelectedIndex() == 1) {
							rinfo.setRating("STANDARD");
							if (resDay == 0) {
								price_sum = (int) ((adult * ADULT + child * CHILD) + STANDARD);
							} else {
								price_sum = (int) (((adult * ADULT + child * CHILD) + STANDARD) * resDay);
							}

						} else if (rateing.getSelectedIndex() == 2) {
							rinfo.setRating("PREMIUM");
							if (resDay == 0) {
								price_sum = (int) ((adult * ADULT + child * CHILD) + PREMIUM);
							} else {
								price_sum = (int) (((adult * ADULT + child * CHILD) + PREMIUM) * resDay);
							}

						} else if (rateing.getSelectedIndex() == 3) {
							rinfo.setRating("SWEET");
							if (resDay == 0) {
								price_sum = (int) ((adult * ADULT + child * CHILD) + SWEET);
							} else {
								price_sum = (int) (((adult * ADULT + child * CHILD) + SWEET) * resDay);
							}

						}
						rinfo.setTotal_price(price_sum);

						rinfo.setCheck_in_d(textfield[4].getText());
						rinfo.setCheck_out_d(textfield[5].getText());

						int r = crud.insertReservation_Info_member(rinfo);
						if (r > 0) {
							JOptionPane.showMessageDialog(this, "예약처리가 정상적으로 완료 되었습니다.");
							for (int i = 0; i < textfield.length; i++) {
								textfield[i].setText("");
							}

							rateing.setSelectedIndex(0);
						} else {
							JOptionPane.showMessageDialog(this, "예약처리 중 문제가 발생하였습니다.");
						}
					}
				}
			}
		}
	}

	MainFrame mf;
	private JPanel north, center;
	private JLabel rogo;
	public JLabel[] label;
	public JLabel cal, price;
	public JTextField[] textfield;
	private JButton check_in, check_out;
	public JButton insert;
	private Image rogo1, rogo2, img;
	private JComboBox rateing;
	public String flage;
	private ImageIcon imageIcon;
	private Image resizeimage;
	private Image result;
	private ImageIcon res_img;
	private JLabel imglabel1, imglabel2, imglabel3;
	public final int STANDARD = 250000;
	public final int PREMIUM = 340000;
	public final int SWEET = 450000;
	public final int ADULT = 50000;
	public final int CHILD = 25000;

	public Calendar calander1;
	public long resDay;
	Integer price_sum = 0;
	int max_num = 0;

	String[] rating_content = { "선택하십시오", "스텐다드", "프리미엄", "스위트" };

	public Panel06(MainFrame mf) {
		this.mf = mf;

		this.setLayout(new BorderLayout());
		north = new JPanel();
		north.setBackground(Color.white);
		center = new JPanel(null);
		center.setBackground(Color.white);

		ImageIcon icon_rogo = new ImageIcon("img//rogo.jpg");
		rogo1 = icon_rogo.getImage();
		rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		rogo = new JLabel(icon_rogo2);
		north.add("Center", rogo);

		rateing = new JComboBox<String>(rating_content);

		ImageIcon temp = new ImageIcon("img//calendarIcon.png");
		img = temp.getImage();
		img = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		temp = new ImageIcon(img);
		
		imageIcon = new ImageIcon("img//panel06//이용료.png");
		resizeimage = imageIcon.getImage();
		result = resizeimage.getScaledInstance(770, 50, Image.SCALE_SMOOTH);
		res_img = new ImageIcon(result);
		imglabel1 = new JLabel(res_img);
		
		imageIcon = new ImageIcon("img//panel06//패널6 설명.png");
		resizeimage = imageIcon.getImage();
		result = resizeimage.getScaledInstance(950, 500, Image.SCALE_SMOOTH);
		res_img = new ImageIcon(result);
		imglabel2 = new JLabel(res_img);

		check_in = new JButton(temp);
		check_in.setContentAreaFilled(false);
		check_in.addActionListener(this);

		check_out = new JButton(temp);
		check_out.setContentAreaFilled(false);
		check_out.addActionListener(this);

		insert = new JButton("예약하기");
		insert.addActionListener(this);

		label = new JLabel[7];
		
		textfield = new JTextField[6];

		label[0] = new JLabel("이름");
		label[1] = new JLabel("성인");
		label[2] = new JLabel("미성년");
		label[3] = new JLabel("전화번호");
		label[4] = new JLabel("체크인");
		label[5] = new JLabel("체크아웃");
		label[6] = new JLabel("객실");
		cal = new JLabel("~");
		price = new JLabel("결제금액: " + price_sum);

		textfield[0] = new JTextField(5);
		textfield[1] = new JTextField(3);
		textfield[2] = new JTextField(3);
		textfield[3] = new JTextField(10);
		textfield[4] = new JTextField(10);
		textfield[5] = new JTextField(10);
		
		
		
		imglabel1.setBounds(110, 80, 770, 50);
		imglabel2.setBounds(110, 160, 950, 500);
		
		label[0].setBounds(110, 20, 40, 20);
		textfield[0].setBounds(140, 20, 70, 20);
		label[1].setBounds(220, 20, 40, 20);
		textfield[1].setBounds(248, 20, 40, 20);
		label[2].setBounds(290, 20, 40, 20);
		textfield[2].setBounds(330, 20, 40, 20);

		label[3].setBounds(375, 20, 60, 20);
		textfield[3].setBounds(430, 20, 95, 20);
		label[4].setBounds(535, 20, 60, 20);
		textfield[4].setBounds(580, 20, 95, 20);
		check_in.setBounds(675, 20, 20, 20);

		cal.setBounds(700, 20, 20, 20);

		label[5].setBounds(720, 20, 60, 20);
		textfield[5].setBounds(775, 20, 95, 20);
		check_out.setBounds(870, 20, 20, 20);

		label[6].setBounds(235, 50, 50, 20);
		rateing.setBounds(270, 50, 100, 20);

		insert.setBounds(950, 15, 100, 30);
		insert.setEnabled(false);
		price.setBounds(880, 40, 300, 70);

		price.setFont(new Font("맑음고딕", Font.ITALIC | Font.BOLD, 30));
		for (int i = 0; i < 6; i++) {
			center.add(label[i]);
			center.add(textfield[i]);
		}
		center.add(imglabel1);
		center.add(imglabel2);

		center.add(label[6]);
		center.add(cal);
		center.add(price);
		center.add(check_in);
		center.add(check_out);

		center.add(rateing);

		center.add(insert);

		this.add("North", north);
		this.add("Center", center);

	}
}
