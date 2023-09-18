package robot;
import java.awt.*;
import javax.swing.*;

public class RobotUI extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, 2, 2);
	}

	
}
