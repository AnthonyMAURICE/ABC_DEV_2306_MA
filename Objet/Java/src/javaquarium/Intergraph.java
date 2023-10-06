package javaquarium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class Intergraph extends JFrame implements ActionListener{
	private ArrayList<Algue> algues;
	private ArrayList<Poissons> fish;
	private JLabel name, pv, age, species;
	//private Jbutton advance;
	
	public Intergraph(ArrayList<Algue> _algues, ArrayList<Poissons> _fish) {
		super();
		this.fish = _fish;
		this.algues = _algues;
		build();
	}

	private void build() {
		setTitle("Javaquarium");
		setSize(480, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		name = new JLabel("Nom");
		name.setForeground(new Color(0, 0, 0));
		name.setSize(75, 20);
		name.setLocation(10, 10);
		pv = new JLabel("Points de vie");
		pv.setLocation(111, 10);
		pv.setSize(75, 20);
		age = new JLabel("Age");
		age.setLocation(265, 10);
		age.setSize(75, 20);
		species = new JLabel("espèce");
		species.setLocation(379, 10);
		species.setSize(75, 20);
		panel.add(name);
		panel.add(pv);
		panel.add(age);
		panel.add(species);
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
