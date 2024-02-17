package exercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgendaTelefonica {
    private List<Contato> agendaTelefonica = new ArrayList<>();

    public void adicionarContato(Contato contato) {
        agendaTelefonica.add(contato);
    }

    public void removerContato(int id) {
        Optional<Contato> contato = agendaTelefonica.stream().filter(cont -> {
            return cont.getId() == id;
        }).findFirst();
        if (contato.isPresent()) {
            agendaTelefonica.remove(contato.get());
            return;
        }
        System.out.println("Contato não encontrado");
    }

    public void atualizarContato(int id, String nome, String telefone) {
        Optional<Contato> contato = agendaTelefonica.stream().filter(cont -> {
            return cont.getId() == id;
        }).findFirst();
        if (contato.isPresent()) {
            contato.get().setNome(nome);
            contato.get().setTelefoneCelular(telefone);
            return;
        }
        System.out.println("Contato não encontrado");

    }

    public List<Contato> getAgendaTelefonica() {
        return agendaTelefonica;
    }


    @Override
    public String toString() {
        return "{" +
            " agendaTelefonica='" + getAgendaTelefonica() + "'" +
            "}";
    }

}
