package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Funcionario implements Usuario
{
    private String nome;
    private int diasEmprestimo=2;
    private int codigo;
    private ArrayList<Emprestimo> listaEmprestimos;
    private ArrayList<Reserva> listaReservas;

    public Funcionario(String nome, int codigo, ArrayList<trabalhoeng.Emprestimo> listaEmprestimos, ArrayList<trabalhoeng.Reserva> listaReservas) {
        this.nome = nome;
        this.codigo = codigo;
        this.listaEmprestimos = listaEmprestimos;
        this.listaReservas = listaReservas;
    }
    
    @Override
    public int getDiasEmprestimo() {
        return this.diasEmprestimo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public ArrayList<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    @Override
    public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

    @Override
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    @Override
    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public boolean Emprestimo(Date data)
    {
        boolean result= true;
        boolean flag= true;
        int qtdEmpres=0;
        Iterator <Emprestimo> it= listaEmprestimos.iterator();
        while (it.hasNext())
        {
            Emprestimo e= it.next();
            if (e.getDataDevolucao().before(data)) // testa se o emprestimo e antigo
                if(e.getStatus().equals("emprestado"))//testa se o emprestimo foi devolvido ou nao
                {
                    result= false;
                    flag= false;    
                }
            if (e.getStatus().equals("emprestado"))
                qtdEmpres++;
        }
        if (qtdEmpres < 3) //2 emprestimos ainda permite 1
            result= true;
        return (flag && result);
    }

    @Override
    public void Devolucao()
    {
        
    }

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

    @Override
    public int getNotificacoes() {return 0;}

    @Override
    public void addNotificacao()
    {}

}