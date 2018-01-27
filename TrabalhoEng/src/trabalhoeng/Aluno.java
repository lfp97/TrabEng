package trabalhoeng;

import java.util.ArrayList;

public class Aluno extends Usuario {

    public Aluno(String nome, int codigo, ArrayList<Exemplar> listaEmprestimos, ArrayList<trabalhoeng.Reserva> listaReservas) {
        super(nome, codigo, listaEmprestimos, listaReservas);
    }

    @Override
    public void Emprestimo() {

    }

}
