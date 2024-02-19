package exercicio20.pedido;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import exercicio20.estoque.Estoque;
import exercicio20.item.Item;
import exercicio20.produto.Produto;
import exercicio20.utils.Utils;

public class Pedido implements IPedido {

    private ArrayList<Item> listaDeItens = new ArrayList<>();
    private double valorTotalDoPedido = 0;

    public ArrayList<Item> getListaDeItens() {
        return this.listaDeItens;
    }

    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public double getValorTotalDoPedido() {
        this.calculaValorTotal();
        return this.valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    @Override
    public void calculaValorTotal() {
        double valorTotal = this.listaDeItens.stream().mapToDouble(Item::getValorDoItem).sum();
        this.valorTotalDoPedido = valorTotal;
    }

    @Override
    public Boolean adicionarItemNaLista(Produto produto, int quantidade) {
        Item item = new Item(produto, quantidade);

        return this.listaDeItens.add(item);
    }

    public void removerItemDaLista(Item item) {
        this.listaDeItens.remove(item);
    }

    public void atualizarItemDaLista(Item item, int quantidade) {
        if (item.getProduto().getQuantidadeEmEstoque() < quantidade) {
            throw new IllegalArgumentException("O estoque possui somente %d desse produto".formatted(item.getProduto().getQuantidadeEmEstoque()));
        }
        if(quantidade == 0){
            this.listaDeItens.remove(item);
        }
        item.setQuantidade(quantidade);
    }

    @Override
    public void imprimePedido() {
        if(!this.listaDeItens.isEmpty()) {
            listaDeItens.stream().forEach(item -> {
                System.out.println(item);
            });
            this.imprimeValorTotal();
            return;
        }
        System.out.println("=== Carrinho vazio ===");
    }

    @Override
    public void imprimeValorTotal() {
        System.out.println("Valor total do pedido: " + this.getValorTotalDoPedido());
    }

    @Override
    public void adicionaItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionaItem'");
    }

    @Override
    public String recebeNomeDoTeclado(Scanner scanner) {
        System.out.println("Insira o nome do produto desejado:");
        String nomeDoProduto = scanner.next();
        return nomeDoProduto;
    }

    @Override
    public int recebeQuantidadeDoTeclado(Scanner scanner) {
        System.out.println("Insira a quantidade do produto desejado:");
        int quantidadeDeProdutos = Utils.leituraDeDadoInteiro(scanner);
        return quantidadeDeProdutos;
    }

    public int recebeIdDoTeclado(Scanner scanner) {
        System.out.println("Insira o id do produto desejado:");
        int id = Utils.leituraDeDadoInteiro(scanner);
        return id;
    }

    public Optional<Item> pegarItemComProduto(Produto produto) {
        return this.listaDeItens.stream().filter(item -> item.getProduto() == produto).findFirst();
    }

    @Override
    public void limparCarrinho() {
        this.valorTotalDoPedido = 0;
        this.listaDeItens.clear();
    }

    public void finalizarPedido(Estoque estoque) {
        this.listaDeItens.stream().forEach(item -> {
            boolean sucesso = estoque.darBaixaEmEstoque(item.getProduto().getId(), item.getQuantidade());
            if(!sucesso){
                throw new RuntimeException("Estoque não possui a quantidade de %s solicitada".formatted(item.getProduto().getNome()));
            }
        });
        this.limparCarrinho();
    }

}
