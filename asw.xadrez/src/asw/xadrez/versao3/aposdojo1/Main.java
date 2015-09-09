package asw.xadrez.versao3.aposdojo1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	static final Color COR_CASA_SELECIONADA = Color.CYAN;
	static final Color COR_CASA_NAO_SELECIONADA = new Color(120, 120, 120);

	private static final int LARGURA_EM_PIXELS = 256;
	private static final int ALTURA_EM_PIXELS = 256;
	
	static final String CASA_VAZIA = "_";

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		
		JFrame janela = criarJanela();	
		
		

		MouseAdapter tratadorCliques = new TratadorCliques();

		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);
		JPanel controle = new JPanel();
		controle.setSize(new Dimension(256, 40));
		janela.add(controle);

		exibirJanela(janela);
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
}