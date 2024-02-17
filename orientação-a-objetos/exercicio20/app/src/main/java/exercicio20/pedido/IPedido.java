package exercicio20.pedido;

import java.util.Scanner;

import exercicio20.produto.Produto;

public interface IPedido {
    public void calculaValorTotal();
    public Boolean adicionarItemNaLista(Produto produto, int quantidade);
    public void imprimePedido();
    public void imprimeValorTotal();
    public void adicionaItem();
    public String recebeNomeDoTeclado(Scanner scanner);
    public int recebeQuantidadeDoTeclado(Scanner scanner);
    public void limparCarrinho();
}
