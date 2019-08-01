package cho_jeahyun;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel06 extends JPanel{
	MainFrame mf;
	private JPanel north;
	private JLabel rogo;
	private Image rogo1, rogo2;
	public Panel06(MainFrame mf){
		this.mf = mf;
		north = new JPanel();
		ImageIcon icon_rogo = new ImageIcon("src//cyc//rogo.jpg");
		rogo1 = icon_rogo.getImage();
		rogo2 = rogo1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon icon_rogo2 = new ImageIcon(rogo2);
		rogo = new JLabel(icon_rogo2);
		north.add("Center",rogo);

	}
}
