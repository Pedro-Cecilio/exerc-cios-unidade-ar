package exercicio20.menu;

import exercicio20.estoque.Estoque;
import exercicio20.pedido.Pedido;
import java.util.Scanner;


public interface IMenu {
    public void controlaMenu(Estoque estoque, Pedido pedido, Scanner scanner);
    public void mostraEstoque(Estoque estoque);
    public void switchCase(Estoque estoque, Pedido pedido, Scanner scanner);
}
