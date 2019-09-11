
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

    public void setTabuleiroEstado(Tabuleiro tabuleiroEstado) {
        this.tabuleiroEstado = tabuleiroEstado;
    }

    public void setVerticePai(Vertice verticePai) {
        this.verticePai = verticePai;
    }
        
        // Adiciona vertices filho a vértice atual
        
     public void adiconarVertice(Vertice vertice){
         verticesAdjascente.add(vertice);
     }

    public Set<Vertice> getVerticesAdjascente() {
        return verticesAdjascente;
    }

    public void setVerticesAdjascente(Set<Vertice> verticesAdjascente) {
        this.verticesAdjascente = verticesAdjascente;
    }
    
    

    
}
