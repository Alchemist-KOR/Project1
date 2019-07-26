package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



class Image_Service {

	private boolean flag = false;// flag가 true면 종료
	ImageIcon[] image;
	Image_Service() {
		image = new ImageIcon[10];
		image[0] = new ImageIcon("img\\fool01.jpg");

	}
}

public class Panel03 extends JPanel {
	private JLabel[] lbl;
	private JLabel[] images;
	private Image_Service imgService;
	private JButton login;
	private JPanel north, n_East, center;
	public Panel03() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		imgService = new Image_Service();
		
		
		login = new JButton("로그인");
		north = new JPanel();
		north.setLayout(new BorderLayout());
		n_East = new JPanel();
		n_East.setLayout(new FlowLayout());
		n_East.add(login);
		north.add("East",n_East);
		this.add("North", north);
		center = new JPanel();
		center.setLayout(new GridLayout(7,1));
		setLabel();
		
		
	}

	void setLabel() {
		lbl = new JLabel[10];
		lbl[0] =new JLabel("품격이 다른 편안함으로 당신의 휴식을 책임집니다.");
		lbl[0].setFont(new Font("함초롱바탕 확장 보통", Font.BOLD, 15 ));
		center.add(lbl[0]);
	}

	void setImage() {
		images = new JLabel[10];
		images[0].setIcon(imgService.image[0]);
		images[0].setSize(50, 50);
		images[0].setLocation(5, 20);
		center.add(images[0]);
	}

	public static void main(String[] args) {
		
	}

}
