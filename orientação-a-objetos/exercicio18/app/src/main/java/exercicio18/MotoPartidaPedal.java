package exercicio18;

public class MotoPartidaPedal extends Moto{
    public MotoPartidaPedal(int numRodas, int velMax, String cor, int cilindradas) {
        super(numRodas, velMax, cor, cilindradas);
    }
    
    @Override
    public void ligar(){
        if(this.isAcelerando()){
            super.ligar();
            return;
        }
        System.out.println("Para ligar, o acelerador precisa estar puxado.");
    }
}
