package exercicio20.estoque;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import exercicio20.produto.Produto;
import exercicio20.utils.Utils;

public class Estoque implements IEstoque {

    private int id = 1;
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    @Override
    public void inicializaEstoque() {
        Produto produto1 = new Produto(1, "Arroz", 15.99, 50);
        Produto produto2 = new Produto(2, "Feijão", 8.99, 30);
        Produto produto3 = new Produto(3, "Sabonete", 2.49, 50);
        Produto produto4 = new Produto(4, "Shampoo", 12.99, 40);
        Produto produto5 = new Produto(5, "Biscoito", 3.99, 100);

        this.cadastraProduto(produto1);
        this.cadastraProduto(produto2);
        this.cadastraProduto(produto3);
        this.cadastraProduto(produto4);
        this.cadastraProduto(produto5);
    }

    @Override
    public Produto encontraProduto(String nome) {
        Optional<Produto> produto = this.listaDeProdutos.stream().filter(prod -> {
            String nomeProdutoEstoque = Utils.removeAcentos(prod.getNome());
            String nomeProducoProcurado = Utils.removeAcentos(nome);
            return nomeProdutoEstoque.equalsIgnoreCase(nomeProducoProcurado);
        }).findFirst();

        if (produto.isEmpty()) {
            throw new NoSuchElementException("Produto não encontrado.");
        }
        return produto.get();
    }

    @Override
    public Produto encontraProduto(int id) {
        Optional<Produto> produto = this.listaDeProdutos.stream().filter(prod -> prod.getId() == id).findFirst();
        if (produto.isEmpty()) {
            throw new NoSuchElementException("Produto não encontrado.");
        }
        return produto.get();
    }

    public Produto encontraProduto(Produto produto) {
        Optional<Produto> produtoBuscado = this.listaDeProdutos.stream().filter(prod -> prod == produto).findFirst();
        if (produtoBuscado.isEmpty()) {
            throw new NoSuchElementException("Produto não encontrado.");
        }
        return produtoBuscado.get();
    }

    @Override
    public Boolean cadastraProduto(Produto produto) {
        Boolean adicionado = this.listaDeProdutos.add(produto);
        this.id += 1;
        return adicionado;
    }

    @Override
    public void imprimeCatalogoDoEstoque() {
        listaDeProdutos.forEach(produto -> {
            String mensagem = """
                    PRODUTO [ ID: %-5d | Nome: %-20s | Preço: R$ %-7.2f | Quantidade em Estoque: %d ]
                    """.formatted(produto.getId(), produto.getNome(), produto.getPreco(),
                    produto.getQuantidadeEmEstoque());
            System.out.println(mensagem);

        });

    }

    @Override
    public Boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa) {
        Produto produto = this.encontraProduto(nome);
        if (produto.getQuantidadeEmEstoque() < quantidadeParaDarBaixa) {
            return false;
        }
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
        return true;
    }

    @Override
    public Boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa) {
        Produto produto = this.encontraProduto(id);
        if (produto.getQuantidadeEmEstoque() < quantidadeParaDarBaixa) {
            return false;
        }
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
        return true;
    }

    @Override
    public int getQuantidadeAtualEmEstoque(Produto produto) {
        return this.encontraProduto(produto).getQuantidadeEmEstoque();
    }

    @Override
    public int getPosicaoDoProdutoNaLista(Produto produto) {
        int indexDoProduto = this.listaDeProdutos.indexOf(produto);
        if (indexDoProduto == -1) {
            throw new NoSuchElementException("Produto não encontrado.");
        }
        return indexDoProduto;

    }

    @Override
    public Boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa) {
        Produto produtoBuscado = this.encontraProduto(id);
        return produtoBuscado.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa;
    }

    public void inserirProdutoNoEstoque(String nome, double preco, int quantidade) {
        Produto produto = new Produto(id, nome, preco, quantidade);
        this.cadastraProduto(produto);
    }

    public void removerProdutoEmEstoque(int id) {
        Produto produto = this.encontraProduto(id);
        this.listaDeProdutos.remove(produto);
    }

    public void atualizarQuantidadeProdutoEmEstoque(int id, int novaQuantidade) {
        Produto produto = this.encontraProduto(id);
        System.out.println(novaQuantidade);
        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa");
        }
        System.out.println(produto.getNome());
        System.out.println(novaQuantidade);
        produto.setQuantidadeEmEstoque(novaQuantidade);
        System.out.println(produto.getQuantidadeEmEstoque());
    }
}
