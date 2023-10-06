package objectSW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ChoiceUI extends JFrame implements ActionListener{
	private ArrayList<Personnage> liste;
	private String[] names;
	private Personnage machine, player;
	private JComboBox c1;
	private JComboBox c2;
	JButton start;
	public ChoiceUI(ArrayList<Personnage> _liste) {
			//this.liste = _liste.toArray(new Personnage[_liste.size()]);
			this.liste = _liste;
			this.names = new String[this.liste.size()];
			for(int i = 0; i < this.liste.size(); i++) {
				this.names[i] = this.liste.get(i).getNom();
			}
		build();
	}
	
	private void build() {
		setTitle("Choix");
		setSize(350, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setLayout(null);
		
		
		start = new JButton("Démarrer");
		start.setBounds(120, 105, 89, 23);
		start.addActionListener(this);
		panel.add(start);
		
		c1 = new JComboBox(this.names);
		c1.setSize(130, 20);
		c1.setLocation(10, 50);
		c2 = new JComboBox(this.names);
		c2.setSize(130, 20);
		c2.setLocation(194, 50);
		panel.add(c1);
		panel.add(c2);
		
		

		return panel;
	}
	
	public Personnage selection(String object) {
		int i = 0;
		if(object.equals("Yoda")) {
			i = 0;
		}else if(object.equals("Mace Windu")) {
			i = 1;
		}else if(object.equals("Obi-Wan Kenobi")) {
			i = 2;
		}else if(object.equals("Darth Vader")) {
			i = 3;
		}else if(object.equals("Mandalore")) {
			i = 4;
		}
		return this.liste.get(i);
	}
	
		
	public void choice(Personnage player, Personnage machine, ArrayList<Personnage> _liste) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UI userInterface = new UI(player, machine, _liste);
				userInterface.setVisible(true);
			}

		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == start) {
			this.player = selection(c1.getSelectedItem().toString());
    		this.machine = selection(c2.getSelectedItem().toString());		
			this.choice(this.player, this.machine, liste);
			this.setVisible(false);
		}
	}
	
}
	
