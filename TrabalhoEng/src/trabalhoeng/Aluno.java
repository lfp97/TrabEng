package trabalhoeng;

import java.util.ArrayList;

public class Aluno extends Usuario //emprestimo de 5 dias
{

    public Aluno(String nome, int codigo, ArrayList<Exemplar> listaEmprestimos, ArrayList<trabalhoeng.Reserva> listaReservas) {
        super(nome, codigo, listaEmprestimos, listaReservas);
    }

    @Override
    public void Emprestimo() {

    }

}
