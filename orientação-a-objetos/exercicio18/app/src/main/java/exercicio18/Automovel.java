package exercicio18;

public class Automovel {
    private int numRodas;
    private int velMax;
    private String cor;
    private Boolean ligado = false;
    private Boolean freiando = false;
    private Boolean acelerando = false;

    public Automovel(int numRodas, int velMax, String cor) {
        this.numRodas = numRodas;
        this.velMax = velMax;
    }


    public void ligar(){
        this.ligado = true;
    }
    
    public void freiar(){
        this.freiando = true;
    }

    public void acelerar(){
        this.acelerando = true;
    }


    public int getNumRodas() {
        return this.numRodas;
    }

    public int getVelMax() {
        return this.velMax;
    }

    public void setNumRodas(int numRodas) {
        this.numRodas = numRodas;
    }
    public void setVelMax(int velMax) {
        this.velMax = velMax;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean isLigado() {
        return this.ligado;
    }

    public Boolean isFreiando() {
        return this.freiando;
    }

    public Boolean isAcelerando() {
        return this.acelerando;
    }
    

}
