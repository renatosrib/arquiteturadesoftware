package asw.xadrez.versao3.aposdojo1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;


public class Cronometro {
	private Cor corDaPeca;
	
	private final int timeInSeconds;
	private int currentTime;
	private boolean myTurn;
	
	private JLabel tempo = new JLabel("Aguarde...");
	private Timer timer = new Timer();
	private TimerTask timerTask;
	
	
	public Cronometro(final int timeInSeconds, final Cor corDaPeca){
		this.timeInSeconds = timeInSeconds;
		myTurn = false;
		currentTime = timeInSeconds;
		this.corDaPeca = corDaPeca;	
		
		timerTask = new TimerTask() {			
			@Override
			public void run() {
				updtateTime();				
			}
		};

		timer.scheduleAtFixedRate(timerTask, this.timeInSeconds, 1000);
		 
	}
	
	public JLabel getTempoLabel(){
		return tempo;
	}
	
	public void start(){
		myTurn = true;
	}
	
	public void changeStatus(){
		myTurn = !myTurn;
	}
	
	public void updtateTime(){

		if(myTurn){
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");	
			Date updatedTime = null;								
			try {
				updatedTime = (Date) dateFormat.parse(String.valueOf(currentTime/3600+":"+currentTime/60+":"+currentTime%60));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			tempo.setText(dateFormat.format(updatedTime));
			if(currentTime==0){
				timer.cancel();
				Main.finalizarJogo(corDaPeca);
			}
			currentTime--;	
		}
		

	}
	
	public void stop(){
		myTurn = false;	
	}	
}
