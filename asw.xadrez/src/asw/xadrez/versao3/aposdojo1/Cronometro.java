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
	
	private Timer timer;
	private int seconds;
		
	
	
	
	public Cronometro(int timeInSeconds){
		this.timeInSeconds = timeInSeconds;
		timer = new Timer(0, new ActionListener() {
			int remainSeconds = timeInSeconds;
			@Override
			public void actionPerformed(ActionEvent e) {
				Date updatedTime = null;	
				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				
				try {
					updatedTime = (Date) dateFormat.parse(String.valueOf(remainSeconds/3600+":"+remainSeconds/60+":"+remainSeconds%60));
					Thread.sleep(1000);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//tempo.setText(dateFormat.format(updatedTime));	
				remainSeconds ++;
				seconds = remainSeconds;
			}
		}); 
	}
	
	public void start(){
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}
	
	public int remainSeconds(){
		return seconds;
	}
	
	

}
