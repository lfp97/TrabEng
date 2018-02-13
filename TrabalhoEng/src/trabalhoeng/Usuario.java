package trabalhoeng;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario
{
    private String nome;
    private int codigo;
    private ArrayList <Emprestimo> listaEmprestimos;
    private ArrayList <Reserva> listaReservas;

    public Usuario(String nome, int codigo, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Reserva> listaReservas) {
        this.nome = nome;
        this.codigo = codigo;
        this.listaEmprestimos = listaEmprestimos;
        this.listaReservas = listaReservas;
    }

    public Usuario(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
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
    
    public void Emprestimo()
    {
        
    }
    
    public void Devolucao()
    {
        
    }
    
    public void Reserva()
    {
        
    }

    public ArrayList <Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList <Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }
    
    public Iterator getIteratorEmp ()
    {
        return this.listaEmprestimos.iterator();
    }

    public ArrayList <Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList <Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    public Iterator getIteratorRes ()
    {
        return this.listaReservas.iterator();
    }
    
}