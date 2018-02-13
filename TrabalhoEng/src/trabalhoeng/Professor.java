package trabalhoeng;

import java.util.ArrayList;

public class Professor extends Usuario //emprestimo de 7 dias
{

    private int notificacoes;

    public Professor(String nome, int codigo, ArrayList<Emprestimo> listaEmprestimos, ArrayList<trabalhoeng.Reserva> listaReservas) {
        super(nome, codigo, listaEmprestimos, listaReservas);
    }

    public int getNotificacoes() {
        return notificacoes;
    }

    public void addNotificacao() {
        this.notificacoes += 1;
    }

}
