import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tela extends JFrame implements ActionListener{
    
    JButton[][] botoes = new JButton[3][3];
    Tabuleiro tabuleiro = new Tabuleiro();
    int jogador = 1;
    //Inclusão do Argente inteligente
    int coordenadaXproximaJogadaIA;
    int cordenadaYProximaJogadaIA;
    
    public Tela(){
        super("Jogo da velha - Tec. Desenv. de jogos Digitais JEAN CARLOS DE ALMEIDA");
        this.setSize(800,800);
        this.setVisible(true);
        this.setLayout(new GridLayout(3, 3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        tabuleiro.limparTabuleiro();
        
        for (int i=0; i< 3; i++){
            for (int j = 0; j < 3; j++){
                botoes[i][j] = new JButton();
                botoes[i][j].addActionListener(this);
                this.add(botoes[i][j]);
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(e.getSource() == botoes[i][j]){
                    botoes[i][j].setText("Teste");
                    jogar(i, j, jogador);
                }
            }
        }
    }
    
    public void jogar(int x, int y, int jogador){
        
        String text = "O";
        tabuleiro.adicionarJogada(x, y, text);        
        /**APAGAR AQUI EMBAIXO
         * if(jogador == 1){    
            texto = "X";
            this.jogador = 2;
        } else{
            texto = "O";
            this.jogador = 1;
        }**/
        
        botoes[x][y].setText(text);
        botoes[x][y].setFont(new Font("Dialog", 0, 75));
        botoes[x][y].setEnabled(false);

        if(tabuleiro.verificarVencedor(text)){
            JOptionPane.showMessageDialog(null, "Venceu o Jogador: " + text);
            dispose();
        }
        jogarIA(text);
    }
    
     public void jogarIA(String jogadaHumano){
            String text = "X";
            
            if(tabuleiro.verificarVencedor(text)){
                JOptionPane.showMessageDialog(null, "Vencedor é o Jogador: "+ text);
                dispose();
            }
        // Fazer um método para selecionar a jogada do agente usando o método da busca em profundidade
        Vertice verticeEstadoAtual = new Vertice();
        verticeEstadoAtual.setJogadaText(jogadaHumano);
        verticeEstadoAtual.setTabuleiroEstado(tabuleiro);
        BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade();
        try{
            
            Vertice verticeObjetivo = buscaEmProfundidade.encontrarVerticeSolucao(verticeEstadoAtual);
            Vertice proximaJogadaVertice = selecionarProximaJogadaAPrtirDoVerticeObjetivo(verticeObjetivo);
            setXYIA(proximaJogadaVertice.getTabuleiroEstado(), verticeEstadoAtual.getTabuleiroEstado());
            
            tabuleiro.adicionarJogada(this.coordenadaXproximaJogadaIA, this.cordenadaYProximaJogadaIA, text);
            botoes[coordenadaXproximaJogadaIA][cordenadaYProximaJogadaIA].setText(text);
            botoes[coordenadaXproximaJogadaIA][cordenadaYProximaJogadaIA].setFont(new Font("Dialog",0,60));
            botoes[coordenadaXproximaJogadaIA][cordenadaYProximaJogadaIA].setEnabled(false);
            
            if(tabuleiro.verificarVencedor(text)){
                JOptionPane.showMessageDialog(null, "Vencedor é o Jogador" + text);
                dispose();
            }
            //Falta pegar a proxima jogada do tabuleiro;
        }catch(CloneNotSupportedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
    
    public Vertice selecionarProximaJogadaAPrtirDoVerticeObjetivo(Vertice verticeObjetivo){
        
        Vertice verticeAux =verticeObjetivo;
        Vertice verticeAnterior = null;
        while(verticeAux.getVerticePai() != null){
            verticeAnterior = verticeAux;
            verticeAux = verticeAux.getVerticePai();
        }
        return verticeAnterior;
    }
    public void setXYIA(Tabuleiro proximoEstado, Tabuleiro estadoAtual){
        String[][] tabuleiroProximoEstado = proximoEstado.getTabuleiro();
        String[][] tabuleiroEstadoAtual =estadoAtual.getTabuleiro();
        for(int i=0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!tabuleiroEstadoAtual[i][j].equals(tabuleiroProximoEstado[i][j])){
                    this.coordenadaXproximaJogadaIA = i;
                    this.coordenadaXproximaJogadaIA = j;
                }
            }
        }
    }
}
