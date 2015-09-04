package asw.xadrez.versao3.aposdojo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Cronometro {
	private Cor corDaPeca;
	
	private final int timeInSeconds;
	private final static int DEFAULT_TIME_IN_SECONDS = 300; 
	
	private JLabel tempo = new JLabel("Aguarde...");
	private Timer timer;
	
	
	public Cronometro(int timeInSeconds){
		this.timeInSeconds = timeInSeconds;
		 timer = new Timer(0, new ActionListener() {
			int temp = timeInSeconds;
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");		
			@Override
			public void actionPerformed(ActionEvent e) {
				Date updatedTime = null;				
				
				try {
					updatedTime = (Date) dateFormat.parse(String.valueOf(temp/3600+":"+temp/60+":"+temp%60));
					tempo.setText(dateFormat.format(updatedTime));
					Thread.sleep(1000);
					Thread.sleep(1000);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				temp--;
			}
		}); 
	}
	
	public JLabel getTempoLabel(){
		return tempo;
	}
	
	public void start(){
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}
	

}
