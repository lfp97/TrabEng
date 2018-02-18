package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public interface Usuario
{
    String nome="";
    int cod=0;
    int diasEmprestimo=0;
    /*private String nome;
    private int codigo;
    private ArrayList <Emprestimo> listaEmprestimos;
    private ArrayList <Reserva> listaReservas;*/

    /*public Usuario(String nome, int codigo, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservas) {
        this.nome = nome;
        this.codigo = codigo;
        this.listaEmprestimos = listaEmprestimos;
        this.listaReservas = listaReservas;
    }*/
    
    public int getDiasEmprestimo ();
    
    public int getNotificacoes();

    public void addNotificacao();

    public String getNome();

    public void setNome(String nome);

    public int getCodigo();

    public void setCodigo(int codigo);
    
    public boolean Emprestimo(Date data);
    
    public void Devolucao();
    
    public void Reserva();

    public ArrayList <Emprestimo> getListaEmprestimos();

    public void setListaEmprestimos(ArrayList <Emprestimo> listaEmprestimos);
    
    public void adicionarEmprestimoNaLista (Emprestimo e);
    
    public Iterator getIteratorEmp ();

    public ArrayList <Reserva> getListaReservas();

    public void setListaReservas(ArrayList <Reserva> listaReservas);
    
    public Iterator getIteratorRes ();
    
}