package robot;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import robot.Robot.Mouvement;

public class UserInterface extends JFrame implements ActionListener{
	private Robot bot;
	//private Manette manette;
	private JButton power, avant, arriere, gauche, droite, scan, prendre, lacher, agir, detruire;
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	public UserInterface(Robot _robot) {
		super();
		this.bot = _robot;
		//this.manette = _manette;
		build();
	}
	
	private void build() {
		setTitle(this.bot.getName());
		setSize(480, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Vos instructions :");
		panel.add(label);
		
		power = new JButton("Power");
		avant = new JButton("Avant");
		arriere = new JButton("Arrière");
		gauche = new JButton("Gauche");
		droite = new JButton("Droite");
		scan = new JButton("Scanner");
		prendre = new JButton("Saisir");
		lacher = new JButton("Lâcher");
		agir = new JButton("Agir");
		detruire = new JButton("Détruire");
		
		power.addActionListener(this);
		panel.add(power);
		
		
		System.out.println(this.bot.getPower());
		if(!this.bot.getType().equals("KitchenBot")) {
			avant.addActionListener(this);
			panel.add(avant);
			arriere.addActionListener(this);
			panel.add(arriere);
			gauche.addActionListener(this);
			panel.add(gauche);
			droite.addActionListener(this);
			panel.add(droite);
			prendre.addActionListener(this);
			panel.add(prendre);
			lacher.addActionListener(this);
			panel.add(lacher);
		}
		scan.addActionListener(this);
		panel.add(scan);
		agir.addActionListener(this);
		panel.add(agir);
			
		if(this.bot.getType().equals("WarBot")) {
			detruire.addActionListener(this);
			panel.add(detruire);
		}
		
		label1 = new JLabel("Power : " + this.bot.getPower() +  " | ");
		label2 = new JLabel("Position : " + this.bot.getPosX() + " / " + this.bot.getPosY() + " | ");
		label3 = new JLabel("Direction : " + direction() + " | ");
		label4 = new JLabel("Scanner : " + this.bot.getScanned() + " | ");
		label5 = new JLabel("Objet tenu : " + this.bot.getHold() + " | ");
		label6 = new JLabel("");
		label7 = new JLabel("");
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);

		if(!this.bot.getType().equals("KitchenBot")) {
			panel.add(label5);
		}
		
		panel.add(label6);
		panel.add(label7);
		return panel;
	}
	
	public String direction() {
		if (this.bot.getDirection() == 0) {
			return "haut";
		}else if (this.bot.getDirection() == 90) {
			return "droite";
		}else if(this.bot.getDirection() == 180) {
			return "bas";
		}else {
			return "gauche";
		}
	}
	
	public void actionPerformed(ActionEvent e) {	
		label6.setText("");
		label7.setText("");
		Object source = e.getSource();
		if(source == power) {
			this.bot.setPower();	
		}else if(source == avant) {
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
			label6.setText(this.bot.agir());
			this.bot.setMouvement(Mouvement.AGIR);
		}else if (source == detruire) {
			this.bot.setMouvement(Mouvement.DETRUIRE);
			label7.setText(this.bot.destroyAllMankind());
		}else {
			System.out.println("Saisie invalide");
		}

		label1.setText("Power : " + this.bot.getPower() +  " | ");
		label2.setText("Position : " + this.bot.getPosX() + " / " + this.bot.getPosY() + " | ");
		label3.setText("Direction : " + direction() + " | ");
		label4.setText("Scanner : " + this.bot.getScanned() + " | ");
		label5.setText("Objet tenu : " + this.bot.getHold() + " | ");
		
	}

}
