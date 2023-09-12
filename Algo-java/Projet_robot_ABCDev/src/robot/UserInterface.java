package robot;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robot.Robot.Mouvement;

public class UserInterface extends JFrame implements ActionListener{
	private Robot bot;
	private Manette manette;
	private JButton avant, arriere, gauche, droite, scan, prendre, lacher, agir, detruire;
	private JLabel label2;
	public UserInterface(Robot _robot, Manette _manette) {
		super();
		this.bot = _robot;
		this.manette = _manette;
		build();
	}
	
	private void build() {
		setTitle(this.bot.getName());
		setSize(320, 240);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Vos insctructions :");
		panel.add(label);
		
		avant = new JButton("Avant");
		arriere = new JButton("Arrière");
		gauche = new JButton("Gauche");
		droite = new JButton("Droite");
		scan = new JButton("Scanner");
		prendre = new JButton("Saisir");
		lacher = new JButton("Lâcher");
		agir = new JButton("Agir");
		detruire = new JButton("Détruire");
		
		
		avant.addActionListener(this);
		panel.add(avant);
		arriere.addActionListener(this);
		panel.add(arriere);
		gauche.addActionListener(this);
		panel.add(gauche);
		droite.addActionListener(this);
		panel.add(droite);
		scan.addActionListener(this);
		panel.add(scan);
		prendre.addActionListener(this);
		panel.add(prendre);
		lacher.addActionListener(this);
		panel.add(lacher);
		agir.addActionListener(this);
		panel.add(agir);
		detruire.addActionListener(this);
		panel.add(detruire);
		

		
		JLabel label2 = new JLabel("Position : " + this.bot.getPosX() + " / " + this.bot.getPosY());
		panel.add(label2);
		
		return panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		label2 = new JLabel("Position : " + this.bot.getPosX() + " / " + this.bot.getPosY());
		Object source = e.getSource();
		if(source == avant) {
			this.bot.setMouvement(Mouvement.AVANT);
		}else if (source == arriere) {
			this.bot.setMouvement(Mouvement.ARRIERE);
		}else if (source == gauche) {
			this.bot.setMouvement(Mouvement.GAUCHE);
		}else if (source == droite) {
			this.bot.setMouvement(Mouvement.DROITE);
		}else if (source == scan) {
			this.bot.setMouvement(Mouvement.SCANNER);
		}else if (source == prendre) {
			this.bot.setMouvement(Mouvement.SAISIR);
		}else if (source == lacher) {
			this.bot.setMouvement(Mouvement.LACHER);
		}else if (source == agir) {
			this.bot.setMouvement(Mouvement.AGIR);
		}else if (source == detruire) {
			this.bot.setMouvement(Mouvement.DETRUIRE);
		}else {
			System.out.println("Saisie invalide");
		}
	}
	
	
	
}
