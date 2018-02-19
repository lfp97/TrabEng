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
    public boolean Emprestimo(Livro liv, Date dataEmp, Exemplar exe)
    {
        boolean result= false;
        boolean flag= true;
        int qtdEmpres=0;
        Iterator <Emprestimo> it= listaEmprestimos.iterator();
        while (it.hasNext())
        {
            Emprestimo e= it.next();
            if (e.getDataDevolucao().before(dataEmp)) // testa se o emprestimo e antigo, dataEmp tem a data de hoje por isso eh usada como referencia
                if(e.getStatus().equals("emprestado"))//testa se o emprestimo foi devolvido ou nao
                    flag= false;
            if (e.getStatus().equals("emprestado"))
                qtdEmpres++;
        }
        if (qtdEmpres < 3) //usuario tem ate 2 emprestimos ainda permite 1
            result= true;
        if (flag && result)
            return true;
        if (flag == false)
            System.out.println("Emprestimo não Realizado, usuario e devedor de livro");
        if (result == false)
            System.out.println("Emprestimo não Realizado, usuario ja esta com o maximo permitido de exemplares emprestados");
        return false;
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
    public int getNotificacoes() {
        return 0;
    }

    @Override
    public void addNotificacao() {
        
    }

}