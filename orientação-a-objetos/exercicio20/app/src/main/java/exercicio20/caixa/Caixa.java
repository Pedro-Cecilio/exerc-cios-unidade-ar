package exercicio20.caixa;

import exercicio20.caixa.dto.QuantidadeNotasTrocoDto;

public class Caixa {
    public static double calcularTroco(double valorTotal, double valorPago){
        return valorPago - valorTotal ;
    }
    public static QuantidadeNotasTrocoDto calcularMenorQuantidadeDeNotas(double troco){
        int notasDe100 = 0;
        int notasDe50 = 0;
        int notasDe20 = 0;
        int notasDe10 = 0;
        int notasDe5 = 0;
        int notasDe2 = 0;
        for(;;){
            if(troco >= 100){
                troco -= 100;
                notasDe100++;
            }else if(troco >= 50){
                troco -= 50;
                notasDe50++;
            }else if(troco >= 20){
                troco -= 20;
                notasDe20++;
            }else if(troco >= 10){
                troco -= 10;
                notasDe10++;
            }else if(troco >= 5){
                troco -= 5;
                notasDe5++;
            }else if(troco >= 2){
                troco -= 2;
                notasDe2++;
            }else{
                break;
            }
        }
        return new QuantidadeNotasTrocoDto(notasDe100, notasDe50, notasDe20, notasDe10, notasDe5, notasDe2);
    }
}
