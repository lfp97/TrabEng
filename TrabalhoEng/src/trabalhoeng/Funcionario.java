package trabalhoeng;

import java.util.ArrayList;

public class Funcionario extends Usuario //emprestimo de 2 dias
{

    public Funcionario(String nome, int codigo, ArrayList<Emprestimo> listaEmprestimos, ArrayList<trabalhoeng.Reserva> listaReservas) {
        super(nome, codigo, listaEmprestimos, listaReservas);
    }

}