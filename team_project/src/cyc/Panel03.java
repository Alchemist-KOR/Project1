package cyc;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Image_Service {

	private boolean flag = false;// flag가 true면 종료
	ImageIcon[] image;
	Image_Service() {

		image = new ImageIcon[10];
		image[0] = new ImageIcon("src\\cyc\\fool01.png");

	}
}

public class Panel03 extends JPanel {
	private JLabel[] lbl;
	private JLabel[] images;
	private Image_Service imgService;
	private JButton login;
	private JPanel north, n_East;
	public Panel03() {
		imgService = new Image_Service();
		this.setLayout(new BorderLayout());
		login = new JButton("로그인");
		
		north = new JPanel();
		n_East = new JPanel();
		n_East.add(login);
		north.add("East",n_East);
		this.add("North", north);
	}

	void setLabel() {
		lbl = new JLabel[10];

	}

	void setImage() {
		images = new JLabel[10];
		images[0].setIcon(imgService.image[0]);
		images[0].setSize(50, 50);
		images[0].setLocation(5, 20);
		this.add(images[0]);
	}

	public static void main(String[] args) {
		
	}

}
