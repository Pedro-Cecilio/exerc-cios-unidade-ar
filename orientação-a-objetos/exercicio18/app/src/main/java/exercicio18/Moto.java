package exercicio18;

public class Moto extends Automovel{
    private int cilindradas;
    public Moto(int numRodas, int velMax, String cor, int cilindradas) {
        super(numRodas, velMax, cor);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return this.cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    
}
