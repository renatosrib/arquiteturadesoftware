package asw.xadrez.versao3.aposdojo1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Main{
	public JLabel tempo;
	static int time = 0;
	static final Color COR_CASA_SELECIONADA = Color.CYAN;
	static final Color COR_CASA_NAO_SELECIONADA = new Color(120, 120, 120);

	private static final int LARGURA_EM_PIXELS = 256;
	private static final int ALTURA_EM_PIXELS = 256;
	
	static final String CASA_VAZIA = "_";
	
	public void trocarCronometro(){
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		Tabuleiro tabuleiro = new Tabuleiro();
		Main m = new Main();
		final int secs = 60;
		JFrame janela = new JFrame();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Timer timer = new Timer(0, new ActionListener() {
			int temp = secs;
			@Override
			public void actionPerformed(ActionEvent e) {
				Date updatedTime = null;				
				
				try {
					updatedTime = (Date) dateFormat.parse(String.valueOf(temp/3600+":"+temp/60+":"+temp%60));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				m.tempo.setText(dateFormat.format(updatedTime));	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				temp ++;
			}
		}); 
		timer.setInitialDelay(2000);
		timer.start();
		janela.setSize(300, 300);
		janela.setVisible(true);
		
		m.tempo = new JLabel(String.valueOf(timer.getDelay()));
		m.tempo.setLayout(null);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JLabel tempo2 = new JLabel(String.valueOf(15));
/*		janela.add(tempo2);
	 
*/
		criarJanela();
		MouseAdapter tratadorCliques = new TratadorCliques();
		
		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);
		
		exibirJanela(janela);
	while(true){
			 timer.setDelay(time++);
			 janela.add(m.tempo);
			 janela.repaint();
			 Thread.sleep(500);
			 janela.remove(m.tempo);
 		}
		


		
		

	}

		private static JFrame criarJanela() {
		JFrame janela = new JFrame("Xadrez");
		janela.setLayout(new GridLayout(Constantes.NUMERO_LINHAS_TABULEIRO, Constantes.NUMERO_COLUNAS_TABULEIRO));
		janela.setSize(LARGURA_EM_PIXELS, ALTURA_EM_PIXELS);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return janela;
	}

	private static void preencherJanelaComCasas(Tabuleiro tabuleiro, JFrame janela,
			MouseAdapter tratadorCliques) {
		
		
		for (int i = 0; i < Constantes.NUMERO_LINHAS_TABULEIRO; ++i) {
			for (int j = 0; j < Constantes.NUMERO_COLUNAS_TABULEIRO; ++j) {
				Peca peca = tabuleiro.getPeca(i, j);
				JLabel label = new JLabel(peca.toString());
				label.setForeground(peca.getCor() == Cor.INDEFINIDO ? Color.CYAN:peca.getCor() == Cor.PRETO ? Color.BLACK : Color.WHITE);
				label.setBackground(COR_CASA_NAO_SELECIONADA);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setOpaque(true);
				label.addMouseListener(tratadorCliques);
				janela.add(label);
			}
		}
	}

	private static void exibirJanela(JFrame janela) {
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String string  = "teset";
		string.length();
	}
}