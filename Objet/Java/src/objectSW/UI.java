package objectSW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class UI extends JFrame implements ActionListener{
	private Personnage pers1, pers2;
	private ArrayList<Personnage> liste = new ArrayList<Personnage>();
	private JProgressBar progressBar, progressBar_1, progressBar_2, progressBar_3;
	private JLabel first, opponent, firstPv, opponentPv, firstForce, opponentForce, label2, label3;
	private JButton attaquer, forceHeal, forcePush, forceLightning, forceChoke, jetpack;
	
	public UI(Personnage _pers1, Personnage _pers2, ArrayList<Personnage> _liste) {
		super();
		this.liste = _liste;
		this.pers1 = _pers1;
		this.pers2 = _pers2;
		build();
	}
	
	
	private void build() {
		setTitle("Title");
		setSize(480, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		first = new JLabel(this.pers1.getNom());
		first.setLocation(56, 11);
		first.setSize(100, 20);
		panel.add(first);
		opponent = new JLabel(this.pers2.getNom());
		opponent.setLocation(286, 11);
		opponent.setSize(100, 20);
		panel.add(opponent);
		
		
		
		progressBar = new JProgressBar();
		progressBar.setBounds(30, 42, 150, 20);
		progressBar.setValue(this.pers1.getHp());
		progressBar.setStringPainted(true);
		panel.add(progressBar);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(260, 42, 150, 20);
		progressBar_1.setValue(this.pers2.getHp());
		progressBar_1.setStringPainted(true);
		panel.add(progressBar_1);
		
		JLabel lblNewLabel = new JLabel("PV");
		lblNewLabel.setBounds(204, 43, 46, 14);
		panel.add(lblNewLabel);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(30, 73, 150, 20);
		progressBar_2.setValue(this.pers1.getForce());
		progressBar_2.setStringPainted(true);
		panel.add(progressBar_2);
		
		progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(260, 73, 150, 20);
		progressBar_3.setValue(this.pers2.getForce());
		progressBar_3.setStringPainted(true);
		panel.add(progressBar_3);
		
		JLabel lblNewLabel_1 = new JLabel("Spécial");
		lblNewLabel_1.setBounds(193, 74, 46, 14);
		panel.add(lblNewLabel_1);
		
		attaquer = new JButton("Attaquer");
		attaquer.addActionListener(this);
		attaquer.setBounds(30, 175, 89, 23);
		panel.add(attaquer);
		
		label2 = new JLabel("");
		label2.setBounds(30, 104, 380, 23);
		panel.add(label2);
		
		label3 = new JLabel("");
		label3.setBounds(30, 138, 380, 26);
		panel.add(label3);
			
		if(this.pers1 instanceof Sith) {
			forceLightning = new JButton("Force Lightning");
			forceLightning.setBounds(160, 175, 110, 23);
			panel.add(forceLightning);
			forceChoke = new JButton("Force Choke");
			forceChoke.setBounds(300, 175, 110, 23);
			panel.add(forceChoke);
		}else if(this.pers1 instanceof Jedi) {
			forceHeal = new JButton("Force Heal");
			forceHeal.setBounds(160, 175, 110, 23);
			panel.add(forceHeal);
			forcePush = new JButton("Force Push");
			forcePush.setBounds(300, 175, 110, 23);
			panel.add(forcePush);
		}else {
			jetpack = new JButton("Jetpack");
			jetpack.setBounds(300, 175, 110, 23);
			panel.add(jetpack);
		}
		return panel;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
			if(source == attaquer) {
				pers1.attack(pers1, pers2);
			}else if (source == forceLightning) {
				
			}else if (source == forceChoke) {
				
			}else if (source == forceHeal) {
				
				pers1.heal();
			}else if (source == forcePush) {
				
			}else if (source == jetpack) {
				
			}
			int other = ThreadLocalRandom.current().nextInt(1, 3);
			if (other == 1) {
				pers2.attack(pers2, pers1);
			}else if (other == 2) {
				
			}else if (other == 3) {
				
			}
		try {
			this.update(this.liste);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void update(ArrayList<Personnage> liste) throws InterruptedException {
		if(pers1.getHp()<=0 || pers2.getHp() <= 0) {
			label3.setText("");
			if(pers1.isAlive()) {
				label2.setText(pers1.getNom() + " a vaincu " + pers2.getNom());
			}else {
				label2.setText(pers2.getNom() + " a vaincu " + pers1.getNom());
			}
			TimeUnit.SECONDS.sleep(3);
			pers1.healMax();
			pers2.healMax();
			this.setVisible(false);
			run();	
		}else {
			label2.setText(pers1.attack(pers1, pers2));
			label3.setText(pers2.attack(pers2, pers1));
			progressBar.setValue(this.pers1.getHp());
			progressBar_1.setValue(this.pers2.getHp());
			progressBar_2.setValue(this.pers1.getForce());
			progressBar_3.setValue(this.pers2.getForce());
		}
		
	
	}
	public void run() {
		ChoiceUI userChoice = new ChoiceUI(this.liste);
		userChoice.setVisible(true);
	}
}
