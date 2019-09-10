
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Vertice {
    
    private Tabuleiro tabuleiroEstado;
    
    private Set<Vertice> verticesAdjascente = new HashSet<Vertice>();
    
        Vertice verticePai;
        

        
        private String jogadaText; // saber se a jogada é X ou O
        
            public String getJogadaText(){
                return jogadaText;
            }
            
        public void setJogadaText(String jogadaText){
            this.jogadaText = jogadaText;
        }
        
        public Vertice getVerticePai(){
            return verticePai;
            
        }
        
        public void setVerticePai(){
            this.verticePai = verticePai;
        }
        
        public Tabuleiro getTabuleiroEstado(){
            return tabuleiroEstado;
        }
        
        // Adiciona vertices filho a vértice atual
        
     public void adiconarVertice(Vertice vertice){
         verticesAdjascente.add(vertice);
     }

    String getTextJogada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setVerticePai(Vertice verticeAtual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setTextJogada(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setTabuleiroEstado(Tabuleiro tabuleiroFilho) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
