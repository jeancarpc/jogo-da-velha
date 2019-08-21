public class Tabuleiro {
    
    private String tabuleiro[][] = new String[3][3];
    
    public void adicionarJogada(int x, int y, String valor){
        this.tabuleiro[x][y] = valor;
    }
    
    public void limparTabuleiro(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                tabuleiro[i][j] = " ";
            }
        }
    }
    
}
