package exercicio18;

public class CarroAutomatico extends Carro{

    public CarroAutomatico(int numRodas, int velMax, String cor, int numPortas) {
        super(numRodas, velMax, cor, numPortas);
    }
    
    @Override
    public void ligar(){
        if(this.isFreiando()){
            super.ligar();
            return;
        }
        System.out.println("Para ligar, o freio precisa estar pressionado.");
    }
}
