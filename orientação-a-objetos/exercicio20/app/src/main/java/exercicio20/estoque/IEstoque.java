package exercicio20.estoque;

import exercicio20.produto.Produto;

public interface IEstoque {
    public void inicializaEstoque();
    public Produto encontraProduto(String nome);
    public Produto encontraProduto(int id);
    public Boolean cadastraProduto(Produto produto);
    public void imprimeCatalogoDoEstoque();
    public Boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa);
    public Boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa);
    public int getQuantidadeAtualEmEstoque(Produto produto);
    public int getPosicaoDoProdutoNaLista(Produto produto);
    public Boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa);
}
