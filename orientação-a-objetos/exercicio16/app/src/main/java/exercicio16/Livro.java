package exercicio16;

public class Livro {
    private int id;
    private String nome;
    private String autor;
    private int paginas;   
    

    public Livro(int id, String nome, String autor, int paginas) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.paginas = paginas;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }   
}
