
import java.util.ArrayList;
import java.util.List;

public class BuscaEmProfundidade {
    
    private Vertice estadoAtual;
    private List<Vertice>sucessores;
    private List<Vertice> verticesVisitados;
    
    
    private boolean isObjetivo(Vertice verticeAtual){
        Tabuleiro tabuleiro = verticeAtual.getTabuleiroEstado();
        
        if(tabuleiro.verificarVencedor("X")){
            
        }
        return false;
    }
    private List<Vertice> gerarFilhos(Vertice verticeAtual) throws CloneNotSupportedException{
        String text = null;
        
        if(verticeAtual.getTextJogada() == "X"){
            text = "O";
        }
        else{
            text = "X";
        }
    List<Vertice> verticesFilhos = new ArrayList<Vertice>();
        if(!isObjetivo(verticeAtual) && !verticeAtual.getTabuleiroEstado().isFimDeJogo()){
            Tabuleiro tabuleiroAtual = verticeAtual.getTabuleiroEstado();
            for (int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if (tabuleiroAtual.isVazio(j, j)){
                        Tabuleiro tabuleiroFilho = (Tabuleiro) tabuleiroAtual.clone();
                        tabuleiroFilho.adicionarJogada(i, j, text);
                        Vertice verticeFilho = new Vertice();
                        verticeFilho.setVerticePai(verticeAtual);
                        verticeFilho.setTextJogada(text);
                        verticeFilho.setTabuleiroEstado(tabuleiroFilho);
                        verticesFilhos.add(verticeFilho);
                        
                    }
                }
            }
             
        }
        return verticesFilhos;    
    } 

}