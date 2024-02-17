package exercicio18;

public class Guincho extends Automovel{
    private Boolean transportando = false;
    private Automovel automovel;
    public Guincho(int numRodas, int velMax, String cor) {
        super(numRodas, velMax, cor);
    }

    public void rebocarAutomovel(Moto moto){
        this.automovel = moto;
        this.setTransportando(true);
    }
    public void rebocarAutomovel(Carro carro){
        this.automovel = carro;
        this.setTransportando(true);
    }
    
    public void soltarAutomovel(){
        this.automovel = null;
        this.setTransportando(false);
    }

    public Boolean isTransportando() {
        return this.transportando;
    }

    public void setTransportando(Boolean transportando) {
        this.transportando = transportando;
    }

    public Automovel getAutomovel() {
        return this.automovel;
    }
    
}
