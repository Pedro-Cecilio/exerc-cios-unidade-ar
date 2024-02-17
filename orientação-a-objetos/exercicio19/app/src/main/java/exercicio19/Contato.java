package exercicio19;
import java.util.Objects;

public class Contato {
    private int id;
    private String nome;
    private String telefoneCelular;

    private String regexCelular = "\\d{2}9\\d{8}";


    public Contato(int id, String nome, String telefoneCelular) {
        this.id = id;
        this.nome = nome;
        setTelefoneCelular(telefoneCelular);
    }

    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneCelular() {
        return this.telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        if (telefoneCelular.matches(regexCelular)){
            this.telefoneCelular = telefoneCelular;
            return;
        }
        throw new IllegalArgumentException("Telefone celular com formato inválido");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contato)) {
            return false;
        }
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && telefoneCelular.equals(contato.telefoneCelular) && id == contato.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefoneCelular);
    }
    
    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefoneCelular='" + telefoneCelular + '\'' +
                '}';
    }
}
