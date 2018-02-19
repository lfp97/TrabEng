package trabalhoeng;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Professor implements Usuario
{

    private String nome;
    private int diasEmprestimo = 7;
    private int codigo;
    private int notificacoes;
    private ArrayList<Emprestimo> listaEmprestimos;
    private ArrayList<Reserva> listaReservas;
    //private int notificacoes;

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

    public void addNotificacao() {
        this.notificacoes += 1;
    }
    
    public int getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(int notificacoes) {
        this.notificacoes = notificacoes;
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
    
    public Iterator getIteratorEmp ()
    {
        return listaEmprestimos.iterator();
    }
    
    @Override
    public boolean Emprestimo(Livro liv, Calendar dataEmp, Exemplar exe)
    {
        boolean flag = false;
        if (listaEmprestimos != null)
        {
            Iterator<Emprestimo> ite = getIteratorEmp(); //rodar a lista de emprestimos do usuario procurando se existe algum emprestimo em aberto desse livro
            while (ite.hasNext())
            {
                Emprestimo em = ite.next();
                Exemplar exem= em.getExemplar();
                if (exem.getCodLivro().equals(liv.getCodigo()))//se teve algum emprestimo de exemplar do livro
                    if (exem.getStatus().equals("emprestado"))//se ainda esta emprestado
                        flag = true;
            }
        }
        if (!flag)
            return true;
        System.out.println("Emprestimo não Realizado, usuario ja esta com exemplar emprestado");
        return false;
    }

    @Override
    public void Devolucao()
    {}

    @Override
    public void Reserva() {}

    @Override
    public void adicionarEmprestimoNaLista(Emprestimo e)
    {
        if (listaEmprestimos != null)
            listaEmprestimos.add(e);
        else
        {
            listaEmprestimos= new ArrayList <Emprestimo>();
            listaEmprestimos.add(e);
        }
    }


    @Override
    public Iterator getIteratorRes() {
        return this.listaReservas.iterator();
    }

}
