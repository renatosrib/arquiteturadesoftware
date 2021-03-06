package asw.xadrez.versao3.aposdojo1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Main {

	static final Color COR_CASA_SELECIONADA = Color.CYAN;
	static final Color COR_CASA_NAO_SELECIONADA = new Color(120, 120, 120);
	private static final int LARGURA_EM_PIXELS = 480;
	private static final int ALTURA_EM_PIXELS = 480;
	private static JFrame janela;
	static final String CASA_VAZIA = "_";

	public static void main(String[] args) {
		
		int time  = Integer.parseInt(JOptionPane.showInputDialog("Digite os minutos de duração da partida :"));
		Cronometro cronometroBranca = new Cronometro(time*60, Cor.BRANCO);
		Cronometro cronometroPreto = new Cronometro(time*60, Cor.PRETO);
		cronometroBranca.getTempoLabel();
		Tabuleiro tabuleiro = new Tabuleiro();
		
		janela = criarJanela();	
		
		
		MouseAdapter tratadorCliques = new TratadorCliques(cronometroBranca,cronometroPreto);
		cronometroBranca.start();
		JLabel labelRelogio = cronometroBranca.getTempoLabel();
		labelRelogio.setVerticalTextPosition(SwingConstants.CENTER);
		janela.add(labelRelogio);
		
		JLabel labelBrancas = new JLabel("Brancas");
		labelBrancas.setVerticalTextPosition(SwingConstants.CENTER);
		labelBrancas.setHorizontalAlignment(SwingConstants.RIGHT);
		
		janela.add(labelBrancas);
		janela.add(new JLabel());
		janela.add(new JLabel());
		janela.add(new JLabel());
		janela.add(new JLabel());
		janela.add(new JLabel("Pretas"));
		
		JLabel labelPretas = cronometroPreto.getTempoLabel();
		labelPretas.setVerticalTextPosition(SwingConstants.CENTER);
		janela.add(labelPretas);
		
		janela.setResizable(false);
		
		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);

		exibirJanela(janela);
	}

		private static JFrame criarJanela() {
			
		JFrame janela = new JFrame("Xadrez");
				
		janela.setLayout(new GridLayout(Constantes.NUMERO_LINHAS_TABULEIRO+1, Constantes.NUMERO_COLUNAS_TABULEIRO));
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
				label.setSize(32, 32);
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
	public static void finalizarJogo(Cor corPerdedora){
		String cor = corPerdedora.equals(Cor.BRANCO) ? "Brancas" : "Pretas";
		JOptionPane.showMessageDialog(null, cor+" Perderam!");
		System.exit(0);
	}
}