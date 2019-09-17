import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tela extends JFrame implements ActionListener {
	
	JButton[][] botoes = new JButton[3][3];
	Tabuleiro tabuleiro = new Tabuleiro();
	int jogador = 1;
	
	int coordenadaXProximaJogadaIA;
	int coordenadaYProximaJogadaIA;
	
	public Tela() {
		super("Jogo da Velha");
		this.setSize(800,800);
		this.setVisible(true);
		this.setLayout(new GridLayout(3,3));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		tabuleiro.limparTabuleiro();
		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botoes[i][j] = new JButton();
				botoes[i][j].addActionListener(this);
				this.add(botoes[i][j]);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < botoes.length; i++) {
			for (int j = 0; j < botoes.length; j++) {
				if(e.getSource() == botoes[i][j]) {
					jogar(i,j,jogador);
				}
			}
		}
	}
	
	 public void jogar(int x, int y, int jogador) {
		 String text = "O";
		 tabuleiro.adicionarJogada(x, y, text);
		 botoes[x][y].setText(text);
		 botoes[x][y].setFont(new Font("Dialog", 0, 60));
		 botoes[x][y].setEnabled(false);
		 if(tabuleiro.verificarVencedor(text)) {
			 JOptionPane.showMessageDialog(null, "Vencedor ? o Jogador: " + text);
			 dispose();
		 }
		 // fazer um m?todo para selecionar a jogada do agente usando o m?todo da busca em profundidade
		 jogarIA(text);
		 
	 }
	 
	 public Vertice selecionarProximaJogadaAPartirDoVerticeObjetivo(Vertice verticeObjetivo) {

		 Vertice verticeAux = verticeObjetivo;
		 Vertice verticeAnterior = null;
		 while(verticeAux.getVerticePai() != null) {
			 verticeAnterior = verticeAux;
			 verticeAux = verticeAux.getVerticePai();
		 }
		 return verticeAnterior;
	 }
	 
	 public void jogarIA(String jogadaHumano) {
		 String text = "X";
		
		 if(tabuleiro.verificarVencedor(text)) {
			 JOptionPane.showMessageDialog(null, "Vencedor ? o Jogador: " + text);
			 dispose();
		 }
		 // fazer um m?todo para selecionar a jogada do agente usando o m?todo da busca em profundidade
		 Vertice verticeEstadoAtual = new Vertice();
		 verticeEstadoAtual.setTextJogada(jogadaHumano);
		 verticeEstadoAtual.setTabuleiroEstado(tabuleiro);
		 BuscaEmProfundidade buscaEmProfunidade = new BuscaEmProfundidade();
		 try {
			 
			Vertice verticeObjetivo =  buscaEmProfunidade.encontrarVerticeSolucao(verticeEstadoAtual);
			Vertice proximaJogadaVertice = selecionarProximaJogadaAPartirDoVerticeObjetivo(verticeObjetivo);
			setXYIA(proximaJogadaVertice.getTabuleiroEstado(), verticeEstadoAtual.getTabuleiroEstado());
			
			 tabuleiro.adicionarJogada(this.coordenadaXProximaJogadaIA, this.coordenadaYProximaJogadaIA, text);
			 botoes[coordenadaXProximaJogadaIA][coordenadaYProximaJogadaIA].setText(text);
			 botoes[coordenadaXProximaJogadaIA][coordenadaYProximaJogadaIA].setFont(new Font("Dialog", 0, 60));
			 botoes[coordenadaXProximaJogadaIA][coordenadaYProximaJogadaIA].setEnabled(false);
			 if(tabuleiro.verificarVencedor(text)) {
				 JOptionPane.showMessageDialog(null, "Vencedor ? o Jogador: " + text);
				 dispose();
			 }
			//Falta pegar a pr?xima jogada do tabuleiro;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void setXYIA(Tabuleiro proximoEstado, Tabuleiro estadoAtual) {
		 String[][] tabuleiroProximoEstado = proximoEstado.getTabuleiro();
		 String[][] tabuleiroEstadoAtual = estadoAtual.getTabuleiro();
		 for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(!tabuleiroEstadoAtual[i][j].equals(tabuleiroProximoEstado[i][j])) {
					this.coordenadaXProximaJogadaIA = i;
					this.coordenadaYProximaJogadaIA = j;
				}
			}
		}
	 }
	

}
