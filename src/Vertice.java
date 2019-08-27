
import java.util.ArrayList;
import java.util.List;


public class Vertice {
    
    private Tabuleiro tabuleiroEstado;
    
    private List<Vertice> verticesAdjascente = new ArrayList<Vertice>();
    
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
    
    
    
}
