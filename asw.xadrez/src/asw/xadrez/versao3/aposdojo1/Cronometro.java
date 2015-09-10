package asw.xadrez.versao3.aposdojo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Cronometro {
	private Cor corDaPeca;
	
	private final int timeInSeconds;
	private int currentTime;
	private final static int DEFAULT_TIME_IN_SECONDS = 300; 
	boolean myTurn;
	
	private JLabel tempo = new JLabel("Aguarde...");
	private Timer timer = new Timer();
	TimerTask timerTask;
	
	
	public Cronometro(final int timeInSeconds){
		this.timeInSeconds = timeInSeconds;
		myTurn = true;
		currentTime = timeInSeconds;
		
		
//		 timer = new Timer(0, new ActionListener() {
//			int temp = timeInSeconds;
//			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Date updatedTime = null;				
//				
//				try {
//					updatedTime = (Date) dateFormat.parse(String.valueOf(temp/3600+":"+temp/60+":"+temp%60));
//					tempo.setText(dateFormat.format(updatedTime));
////					Thread.sleep(1000);					
//					Thread.sleep(1000);
//				} catch (ParseException e2) {
//					e2.printStackTrace();
//				}
//				catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//				temp--;
//			}
//		});
		 
	}
	
	public JLabel getTempoLabel(){
		return tempo;
	}
	
	public void runTimer(){
		timerTask = new TimerTask() {			
			@Override
			public void run() {
				updtateTime();				
			}
		};

		timer.scheduleAtFixedRate(timerTask, timeInSeconds, 1000);
	}
	public void start(){
		myTurn = true;
	}
	
	public void updtateTime(){

		if(myTurn){
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");	
			Date updatedTime = null;								
			try {
				updatedTime = (Date) dateFormat.parse(String.valueOf(currentTime/3600+":"+currentTime/60+":"+currentTime%60));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo.setText(dateFormat.format(updatedTime));
			if(currentTime==0){
				timer.cancel();
				//tempo.setText("Perdeu playboy...");
				JOptionPane.showInputDialog("Perdeu Playboy...");
			}
			currentTime--;	
		}
		

	}
	
	public void stop(){
		myTurn = false;	
	}	
}
