package robot;

import javax.swing.JFrame;

public class UserInterface extends JFrame{
	public UserInterface() {
		super();
		
		build();
	}
	
	private void build() {
		setTitle("Mon Robot");
		setSize(320, 240);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
