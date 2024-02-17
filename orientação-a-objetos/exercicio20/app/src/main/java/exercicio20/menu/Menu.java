package exercicio20.menu;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import exercicio20.caixa.Caixa;
import exercicio20.caixa.dto.QuantidadeNotasTrocoDto;
import exercicio20.estoque.Estoque;
import exercicio20.item.Item;
import exercicio20.pedido.Pedido;
import exercicio20.produto.Produto;
import exercicio20.utils.Utils;

public class Menu implements IMenu {

    @Override
    public void controlaMenu(Estoque estoque, Pedido pedido, Scanner scanner) {
        this.apresentarMenu();
        this.switchCase(estoque, pedido, scanner);
    }

    @Override
    public void mostraEstoque(Estoque estoque) {
        System.out.println(
                "\n---------------------------------------- Estoque ----------------------------------------\n");
        estoque.imprimeCatalogoDoEstoque();
    }

    @Override
    public void switchCase(Estoque estoque, Pedido pedido, Scanner scanner) {

        int opcao = Utils.leituraDeDadoInteiro(scanner); 
        switch (opcao) {
            case 1:
                this.mostraEstoque(estoque);
                break;
            case 2:
                this.adicionarItensNoPedido(estoque, pedido, scanner);
                break;
            case 3:
                this.removerItemDoPedido(estoque, pedido, scanner);
                break;
            case 4:
                pedido.limparCarrinho();
                break;
            case 5:
                this.atualizarItemDoPedido(estoque, pedido, scanner);
                break;
            case 6:
                pedido.imprimePedido();
                break;
            case 7:
                this.finalizarPedido(estoque, pedido, scanner);
                break;
            case 8:
                this.inserirProdutoNoEstoque(estoque, scanner);
                break;
            case 9:
                this.finalizarPedido(estoque, pedido, scanner);
                break;
            case 10:
                this.finalizarPedido(estoque, pedido, scanner);
                break;
            case 0:
                System.out.println("Você escolheu sair. Até mais!");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }
    private void inserirProdutoNoEstoque(Estoque estoque, Scanner scanner) {
        System.out.println("Insira o nome do novo produto:");
        String nome = scanner.nextLine();
        System.out.println("Insira o preço do produto:");
        double preco = Utils.leituraDeDadoDouble(scanner);
        if(preco < 0){
            System.out.println("O preço deve ser maior que zero!");
            return;
        }
        System.out.println("Insira a quantidade em estoque do produto:");
        int quantidade = Utils.leituraDeDadoInteiro(scanner);
        estoque.inserirProdutoNoEstoque(nome, preco, quantidade);

    }
    private void apresentarMenu() {
        System.out.println("\n===============================");
        System.out.println("   Sistema do Super Mercado");
        System.out.println("===============================");
        System.out.println("Opções disponíveis:");
        System.out.println("1 - Ver estoque");
        System.out.println("2 - Adicionar Itens no pedido");
        System.out.println("3 - Remover item do pedido");
        System.out.println("4 - Remover todos itens do pedido");
        System.out.println("5 - Atualizar quantidade de produtos de um item");
        System.out.println("6 - Ver itens do pedido");
        System.out.println("7 - Finalizar pedido");
        System.out.println("8 - Inserir produto no estoque");
        System.out.println("9 - Remover produto do estoque");
        System.out.println("10 - Atualizar quantidade do produto em estoque");
        System.out.println("0 - Sair");
        System.out.println("===============================");

    }

    private void adicionarItensNoPedido(Estoque estoque, Pedido pedido, Scanner scanner) {
        int opcao = this.capturarOpcaoParaInformarProduto(scanner, "Adicionar");
        switch (opcao) {
            case 1:
                String nome = pedido.recebeNomeDoTeclado(scanner);
                Produto produto = estoque.encontraProduto(nome);
                int quantidade = pedido.recebeQuantidadeDoTeclado(scanner);
                System.out.println(quantidade);
                Optional<Item> item = pedido.pegarItemComProduto(produto);

                if (item.isPresent()) {
                    item.get().setQuantidade(item.get().getQuantidade() + quantidade);
                    break;
                }
                pedido.adicionarItemNaLista(produto, quantidade);
                break;
            case 2:
                int id = pedido.recebeIdDoTeclado(scanner);
                produto = estoque.encontraProduto(id);
                quantidade = pedido.recebeQuantidadeDoTeclado(scanner);
                item = pedido.pegarItemComProduto(produto);
                if (item.isPresent()) {
                    item.get().setQuantidade(item.get().getQuantidade() + quantidade);
                    break;
                }
                pedido.adicionarItemNaLista(produto, quantidade);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }

    private void removerItemDoPedido(Estoque estoque, Pedido pedido, Scanner scanner) {
        int opcao = this.capturarOpcaoParaInformarProduto(scanner, "Remover");
        switch (opcao) {
            case 1:
                String nome = pedido.recebeNomeDoTeclado(scanner);
                Produto produto = estoque.encontraProduto(nome);
                Optional<Item> item = pedido.pegarItemComProduto(produto);

                if (item.isEmpty()) {
                    throw new NoSuchElementException("Item não encontrado.");
                }

                pedido.removerItemDaLista(item.get());
                break;
            case 2:
                int id = pedido.recebeIdDoTeclado(scanner);
                produto = estoque.encontraProduto(id);
                item = pedido.pegarItemComProduto(produto);

                if (item.isEmpty()) {
                    throw new NoSuchElementException("Item não encontrado.");
                }

                pedido.removerItemDaLista(item.get());
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }

    private void atualizarItemDoPedido(Estoque estoque, Pedido pedido, Scanner scanner) {
        int opcao = this.capturarOpcaoParaInformarProduto(scanner, "Atualizar");
        switch (opcao) {
            case 1:
                String nome = pedido.recebeNomeDoTeclado(scanner);
                Produto produto = estoque.encontraProduto(nome);
                int quantidade = pedido.recebeQuantidadeDoTeclado(scanner);
                Optional<Item> item = pedido.pegarItemComProduto(produto);

                if (item.isEmpty()) {
                    throw new NoSuchElementException("Item não encontrado.");
                }

                pedido.atualizarItemDaLista(item.get(), quantidade);
                break;
            case 2:
                int id = pedido.recebeIdDoTeclado(scanner);
                produto = estoque.encontraProduto(id);
                quantidade = pedido.recebeQuantidadeDoTeclado(scanner);
                item = pedido.pegarItemComProduto(produto);

                if (item.isEmpty()) {
                    throw new NoSuchElementException("Item não encontrado.");
                }

                pedido.atualizarItemDaLista(item.get(), quantidade);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }

    public int capturarOpcaoParaInformarProduto(Scanner scanner, String operacao) {
        System.out.println("Opções disponíveis para %s item:".formatted(operacao.toLowerCase()));
        System.out.println("1 - %s pelo nome do produto".formatted(operacao));
        System.out.println("2 - %s pelo id do produto".formatted(operacao));
        int opcao = Utils.leituraDeDadoInteiro(scanner);
        if (opcao != 1 && opcao != 2) {
            System.out.println("Vou mandar um illegal");
            throw new IllegalArgumentException("Opção inválida");
        }
        return opcao;

    }

    public double capturarDadoDePagamento(Scanner scanner) {
        System.out.println("Informe o valor de pagamento:");
        return Utils.leituraDeDadoDouble(scanner);
    }

    public void finalizarPedido(Estoque estoque, Pedido pedido, Scanner scanner) {
        if (pedido.getListaDeItens().isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }
        pedido.imprimeValorTotal();
        double valorPago = capturarDadoDePagamento(scanner);
        if (valorPago < pedido.getValorTotalDoPedido()) {
            throw new IllegalArgumentException("Valor de pagamento insuficiente");
        }
        double troco = Caixa.calcularTroco(pedido.getValorTotalDoPedido(), valorPago);
        QuantidadeNotasTrocoDto notasTroco = Caixa.calcularMenorQuantidadeDeNotas(troco);
        String mensagem = """
                Notas de 100: %d
                Notas de 50: %d
                Notas de 20: %d
                Notas de 10: %d
                Notas de 5: %d
                Notas de 2: %d
                """.formatted(notasTroco.notasDe100(), notasTroco.notasDe50(), notasTroco.notasDe20(),
                notasTroco.notasDe10(), notasTroco.notasDe5(), notasTroco.notasDe2());
        System.out.println("Valor do troco: " + troco);
        System.out.println("Menor quantidade de notas para o troco: ");
        System.out.println(mensagem);
        pedido.finalizarPedido(estoque);
    }

}
