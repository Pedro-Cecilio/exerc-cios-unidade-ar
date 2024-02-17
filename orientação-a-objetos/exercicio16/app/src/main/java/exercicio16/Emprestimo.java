package exercicio16;

import java.util.HashMap;
import java.util.Map;

public class Emprestimo {
    private Livro livro;
    private Pessoa pessoa;
    private Boolean ativo = true;

    public Emprestimo(Livro livro, Pessoa pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean isAtivo() {
        return this.ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
