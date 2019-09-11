
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuscaEmProfundidade {
    
    private Vertice estadoAtual;
    private List<Vertice>sucessores;
    private List<Vertice> verticesVisitados;
    
    
    private boolean isObjetivo(Vertice verticeAtual){
        Tabuleiro tabuleiro = verticeAtual.getTabuleiroEstado();
        
        if(tabuleiro.verificarVencedor("X")){
            return true;
        }
        return false;
    }
    private List<Vertice> gerarFilhos(Vertice verticeAtual) throws CloneNotSupportedException{
        String text = null;
        
        if(verticeAtual.getJogadaText()== "X"){
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
                    if (tabuleiroAtual.isVazio(i, j)){
                        Tabuleiro tabuleiroFilho = (Tabuleiro) tabuleiroAtual.clone();
                        tabuleiroFilho.adicionarJogada(i, j, text);
                        Vertice verticeFilho = new Vertice();
                        verticeFilho.setVerticePai(verticeAtual);
                        verticeFilho.setJogadaText(text);
                        verticeFilho.setTabuleiroEstado(tabuleiroFilho);
                        verticesFilhos.add(verticeFilho);
                        
                    }
                }
            }
             
        }
        return verticesFilhos;    
    } 
    public Vertice encontrarVerticeSolucao(Vertice verticeAtual) throws CloneNotSupportedException{
        
        Stack<Vertice> pilha = new Stack<Vertice>();
        
        pilha.push(verticeAtual);
        
        // Adicionar filhos a pilha e depois percorrer a pilha
        while (!pilha.isEmpty()){
            verticeAtual = pilha.pop();
            
            if (isObjetivo(verticeAtual)){
                return verticeAtual;
            }
            
            List<Vertice> filhosDoVerticeAtual = gerarFilhos(verticeAtual);
            
            for (Vertice filho : filhosDoVerticeAtual){
                pilha.push(filho);
            }
        }
        return null;
    }

}