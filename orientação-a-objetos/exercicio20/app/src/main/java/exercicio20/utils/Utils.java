package exercicio20.utils;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Utils {
    public static String removeAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
   public static int leituraDeDadoInteiro(Scanner scanner){
        try {
            int dado = scanner.nextInt();
            return dado;
        } catch (Exception e) {
            throw new InputMismatchException("Esse campo precisa ser um valor inteiro");
        }
   }
   public static double leituraDeDadoDouble(Scanner scanner){
        try {
            double dado = scanner.nextDouble();
            return dado;
        } catch (Exception e) {
            throw new InputMismatchException("Esse campo precisa ser um valor inteiro ou decimal");
        }
   }
}
