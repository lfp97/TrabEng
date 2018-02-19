package trabalhoeng;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public interface Usuario
{
    String nome="";
    int cod=0;
    int diasEmprestimo=0;
    int notificacoes=0;
    
    public int getDiasEmprestimo ();
    
    public int getNotificacoes();

    public void addNotificacao();

    public String getNome();

    public void setNome(String nome);

    public int getCodigo();

    public void setCodigo(int codigo);
    
    
    public boolean Emprestimo(Livro l, Calendar data, Exemplar exe);
    
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