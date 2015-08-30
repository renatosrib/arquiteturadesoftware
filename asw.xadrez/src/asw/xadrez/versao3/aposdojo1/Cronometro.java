package asw.xadrez.versao3.aposdojo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Cronometro {
	private Cor corDaPeca;
	
	private final int timeInSeconds;
	private final static int DEFAULT_TIME_IN_SECONDS = 300; 
	
	
	
	
	public Cronometro(int timeInSeconds){
		this.timeInSeconds = timeInSeconds;
		Timer timer = new Timer(0, new ActionListener() {
			int temp = timeInSeconds;
			@Override
			public void actionPerformed(ActionEvent e) {
				Date updatedTime = null;				
				
				try {
					updatedTime = (Date) dateFormat.parse(String.valueOf(temp/3600+":"+temp/60+":"+temp%60));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				tempo.setText(dateFormat.format(updatedTime));	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				temp ++;
			}
		}); 
	}
	
	

}
