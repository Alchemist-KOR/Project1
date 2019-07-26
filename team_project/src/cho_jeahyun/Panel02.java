package cho_jeahyun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Panel02 extends JPanel{
	private JButton login;
	private JPanel north,north_east, center,center_content;
	private ImageIcon img; 
	
	
	
	Panel02(){
		img = new ImageIcon();
		this.setLayout(new BorderLayout());
		north = new JPanel(new BorderLayout());
		north_east = new JPanel(new FlowLayout());
		
		center = new JPanel(new BorderLayout());
		center_content = new JPanel(new GridLayout(12,1));
		
		login = new JButton("·Î±×ÀÎ");
		
		north_east.add(login);
		
		north.add("East",north_east);
		
		
		
		this.add("North", north);
		
		this.setVisible(true);
		
	}

}
