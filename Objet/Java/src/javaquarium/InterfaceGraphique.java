package javaquarium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class InterfaceGraphique extends JFrame implements ActionListener{
	private Poissons poisson;
	private Aquarium aquarium;
	private JTable table;
	private JTable table_1;
	
	public InterfaceGraphique(Aquarium _aquarium) {
		super();
		this.aquarium = _aquarium;

		build();
	}
	
	// création de la frame
		private void build() {
			setTitle("Javaquarium");
			setSize(480, 300);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setContentPane(buildContentPane());
		}
		
		private JPanel buildContentPane() {
			JPanel panel = new JPanel();
			panel.setLayout(null);
			
			table_1 = new JTable();
			table_1.setBounds(10, 11, 444, 239);
			panel.add(table_1);
			
			if(this.aquarium.getPoissons().size() > 0) {
				for (int i = 0; i < this.aquarium.getPoissons().size(); i++){
					JLabel label = new JLabel(this.aquarium.getPoissons().get(i).getName());
					panel.add(label);
				}
			}
			
			return panel;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
