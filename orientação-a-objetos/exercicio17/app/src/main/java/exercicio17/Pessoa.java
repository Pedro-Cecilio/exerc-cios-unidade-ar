package exercicio17;

public class Pessoa {
    private String nome;
    private String idade;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, String idade, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.idade = idade;
        this.pai = pai;
        this.mae = mae;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return this.idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Pessoa getPai() {
        return this.pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return this.mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    private void arvoreGenealogica(String prefixo) {
        System.out.println(prefixo + this.nome);
    
        if (this.mae != null) {
            System.out.println(prefixo + "  Filho(a) de: " + this.mae.getNome());
            this.mae.arvoreGenealogica(prefixo + "   ");
        }
    
        if (this.pai != null) {
            System.out.println(prefixo + "  Filho(a) de: " + this.pai.getNome());
            this.pai.arvoreGenealogica(prefixo + "   ");
        }
    }
    
    public void mostrarArvoreGenealogica() {
        arvoreGenealogica("");
    }
}
