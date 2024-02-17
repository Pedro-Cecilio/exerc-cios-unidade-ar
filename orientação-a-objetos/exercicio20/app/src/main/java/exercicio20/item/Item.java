package exercicio20.item;

import exercicio20.produto.Produto;

public class Item implements IITem{
    private Produto produto;
    private int quantidade;
    private double valorDoItem;
    
    public Item(Produto produto, int quantidade){
        this.produto = produto;
        this.setQuantidade(quantidade);
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        System.out.println("Entrou pra setar quantidade");
        int quantidadeNoEstoque = this.produto.getQuantidadeEmEstoque();
        if(quantidade <= quantidadeNoEstoque){
            this.quantidade = quantidade;
            return;
        }
        throw new IllegalArgumentException("O estoque não possui a quantidade do produto solicitada");
    }

    public double getValorDoItem() {
        this.defineValorTotal();
        return this.valorDoItem;
    }

    public void setValorDoItem(double valorDoItem) {
        this.valorDoItem = valorDoItem;
    }


    @Override
    public void defineValorTotal() {
       this.valorDoItem = this.produto.getPreco() * this.quantidade;
    }

    @Override
    public String toString() {
        return """
            Item:{
                Produto: {
                    Id: %d
                    Nome: %s
                    Preço: %.2f
                }
                Quantidade: %d
                Valor: %.2f
            }
                """.formatted(this.produto.getId(), this.produto.getNome(), this.produto.getPreco(), this.quantidade, this.getValorDoItem());
            
    }


}
