package robot;

import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.JLabel;

import robot.Robot.Mouvement;
import robot.RobotUI;

class MoveAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	enum Action {
        MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT, MOVE_SCAN, MOVE_ACT, MOVE_TAKE, MOVE_DROP, MOVE_POWER, MOVE_DESTROY;
    }


    Robot bot;
    UserInterface window;
    Action action;
	private JLabel label6;
	private int i;
    public MoveAction(UserInterface window, Action action, Robot bot, JLabel _label6) {
        this.window = window;
        this.action = action;
        this.bot = bot;
        this.label6 = _label6;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	label6.setText("");
        switch (action) {
        case MOVE_UP:
        	this.bot.setMouvement(Mouvement.AVANT);
            break;
        case MOVE_DOWN:
        	this.bot.setMouvement(Mouvement.ARRIERE);
            break;
        case MOVE_LEFT:
        	this.bot.setMouvement(Mouvement.GAUCHE);
            break;
        case MOVE_RIGHT:
        	this.bot.setMouvement(Mouvement.DROITE);
            break;
        case MOVE_SCAN:
        	this.bot.setMouvement(Mouvement.SCANNER);
            break;
        case MOVE_ACT:
        	this.label6.setText(this.bot.agir());
        	this.bot.setMouvement(Mouvement.AGIR);
            break;
        case MOVE_TAKE:
        	
        	this.bot.setMouvement(Mouvement.SAISIR);
            break;
        case MOVE_DROP:
        	this.bot.setMouvement(Mouvement.LACHER);
            break;
        case MOVE_POWER:
        	this.bot.setPower();
        	i = 0;
        	break;
        case MOVE_DESTROY:
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
        	break;
        }
        
        window.update();
    }
}