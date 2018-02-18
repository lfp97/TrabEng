package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Professor implements Usuario
{
    private String nome;
    private int diasEmprestimo=7;
    private int codigo;
    private ArrayList<Emprestimo> listaEmprestimos;
    private ArrayList<Reserva> listaReservas;
    private int notificacoes;

    public Professor(String nome, int codigo, ArrayList<trabalhoeng.Emprestimo> listaEmprestimos, ArrayList<trabalhoeng.Reserva> listaReservas, int notificacoes) {
        this.nome = nome;
        this.codigo = codigo;
        this.listaEmprestimos = listaEmprestimos;
        this.listaReservas = listaReservas;
        this.notificacoes = notificacoes;
    }

    @Override
    public int getDiasEmprestimo() {
        return this.diasEmprestimo;
    }
    
    @Override
    public void addNotificacao() {
        this.notificacoes += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public int getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(int notificacoes) {
        this.notificacoes = notificacoes;
    }

    @Override
    public boolean Emprestimo(Date data) {return false;}

    @Override
    public void Devolucao() {}
    @Override
    public void Reserva() {}

    @Override
    public void adicionarEmprestimoNaLista(Emprestimo e) {
        this.listaEmprestimos.add(e);
    }

    @Override
    public Iterator getIteratorEmp()
    {
        return this.listaEmprestimos.iterator();
    }

    @Override
    public Iterator getIteratorRes()
    {
        return this.listaReservas.iterator();
    }

}
