package exercicio18;

public class Carro extends Automovel{
    private int numPortas;

    public Carro(int numRodas, int velMax, String cor, int numPortas) {
        super(numRodas, velMax, cor);
        this.numPortas = numPortas;
    }
    
}
