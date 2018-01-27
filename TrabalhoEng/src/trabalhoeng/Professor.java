package trabalhoeng;

import java.util.ArrayList;

public class Professor extends Usuario {

    private int notificacoes;

    public Professor(String nome, int codigo, ArrayList<Exemplar> listaEmprestimos, ArrayList<trabalhoeng.Reserva> listaReservas) {
        super(nome, codigo, listaEmprestimos, listaReservas);
    }

    public int getNotificacoes() {
        return notificacoes;
    }

    public void addNotificacao() {
        this.notificacoes += 1;
    }

}
