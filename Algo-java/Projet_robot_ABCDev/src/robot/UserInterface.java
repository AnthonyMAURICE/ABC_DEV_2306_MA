package robot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import robot.Robot.Mouvement;

public class UserInterface extends JFrame implements ActionListener{
	private Robot bot;
	private int i = 0;
	private JButton power, avant, arriere, gauche, droite, scan, prendre, lacher, agir, detruire;
	private JLabel label2, label3, label4, label5, label6, label7, label8;
	public UserInterface(Robot _robot) {
		super();
		this.bot = _robot;
		build();
		
	}
	
	// création de la frame
	private void build() {
		setTitle(this.bot.getName());
		setSize(480, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel label = new JLabel("Vos instructions :");
		label.setBounds(180, 9, 121, 14);
		panel.add(label);
		//création des boutons
		power = new JButton("Power");
		power.setBounds(349, 5, 100, 23);
		avant = new JButton("Avant");
		avant.setBounds(73, 58, 100, 23);
		arriere = new JButton("Arrière");
		arriere.setBounds(68, 126, 100, 23);
		gauche = new JButton("Gauche");
		gauche.setBounds(10, 92, 100, 23);
		droite = new JButton("Droite");
		droite.setBounds(117, 92, 100, 23);
		scan = new JButton("Scanner");
		if (this.bot.getType().equals("KitchenBot")) {
			scan.setBounds(100, 92, 100, 23);
		}else {
			scan.setBounds(300, 60, 100, 23);
		}
		prendre = new JButton("Saisir");
		prendre.setBounds(300, 125, 100, 23);
		lacher = new JButton("Lâcher");
		lacher.setBounds(353, 92, 100, 23);
		agir = new JButton("Agir");
		agir.setBounds(243, 92, 100, 23);
		detruire = new JButton("Détruire");
		detruire.setBounds(10, 5, 111, 23);
		
		// Actions listeners et ajouts à la frame
		power.addActionListener(this);
		panel.add(power);
		
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
		// création des labels et ajout de ceux-cis à la frame
		label2 = new JLabel("Position : " + this.bot.getPosX() + " / " + this.bot.getPosY());
		label2.setBounds(190, 130, 121, 23);
		label3 = new JLabel("Direction : " + this.bot.getDirection());
		label3.setBounds(190, 160, 158, 23);
		label4 = new JLabel("<html><font color=\"red\">Scan non effectué</font></html>");
		label4.setBounds(349, 190, 163, 23);
		label5 = new JLabel("<html><font color=\"red\">Pas d'objet saisi</font></html>");
		label5.setBounds(10, 190, 163, 23);
		label6 = new JLabel("");
		label6.setBounds(12, 35, 462, 23);
		label7 = new JLabel("");
		label7.setBounds(10, 35, 464, 23);
		label8 = new JLabel(this.bot.getPower()? "Robot activé" : "<html><font color=\"red\">Robot désactivé</font></html>");
		label8.setBounds(190, 190, 100, 23);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		if(!this.bot.getType().equals("KitchenBot")) {
			panel.add(label5);
		}
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		return panel;
	}
	


	public void actionPerformed(ActionEvent e) {	
		label6.setText("");
		label7.setText("");
		Object source = e.getSource();
		if(source == power) {
			this.bot.setPower();	
			i = 0;
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
			if(i == 0) {
				this.bot.setMouvement(Mouvement.DETRUIRE);
				label6.setText("<html><font color=\"red\">" + this.bot.destroyAllMankind() + "</font></html>");
				if(this.bot.getPower()) {
					i++;
				}
			}else {
				Timer timer = new Timer();
				label6.setText("<html><font color=\"red\">Les missiles sont lançés... La Terre appartiendra... aux robots !</font></html>");				
				timer.schedule(new TimerTask(){
					public void run() {
						System.exit(0);
					}
				},1000*3);				
			}	
		}
				
		label2.setText("Position : " + this.bot.getPosX() + " / " + this.bot.getPosY());
		label3.setText("Direction : " + this.bot.getDirection());
		label4.setText(this.bot.getScanned()? "Scan effectué" : "<html><font color=\"red\">Scan non effectué</font></html>");
		label5.setText(this.bot.getHold()? "<html><font color=\"black\">Objet saisi</font></html>" : "<html><font color=\"red\">Pas d'objet saisi</font></html>");
		label8.setText(this.bot.getPower()? "Robot activé" : "<html><font color=\"red\">Robot désactivé</font></html>");
	}

	
	
	
	

	
}