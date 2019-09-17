import java.util.HashSet;
import java.util.Set;

public class Vertice {
    
    private Tabuleiro tabuleiroEstado;
    
    private Set<Vertice> verticeAdjascente = new HashSet<Vertice>();
    
        Vertice verticePai;
        
        private String textJogada;
        
        //private String jogadaText; // saber se a jogada é X ou O
        public Tabuleiro getTabuleiroEstado() {
        	return tabuleiroEstado;
        }
        
        public void adicionarVertice(Vertice vertice) {
        	verticeAdjascente.add(vertice);
        }
        
        public Vertice getVerticePai() {
        	return verticePai;
        }
        
        public void setVerticePai(Vertice verticePai) {
        	this.verticePai = verticePai;
        }
        
        public void setTabuleiroEstado(Tabuleiro tabuleiroEstado) {
        	this.tabuleiroEstado = tabuleiroEstado;
        }
        
        public String getTextJogada(){
                return textJogada;
        }
        
        public void setTextJogada(String textJogada) {
        	this.textJogada = textJogada;
        }
        

}
            
     /**   public void getTextJogada(String jogadaText){
            this.textJogada = textJogada;
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
    **/