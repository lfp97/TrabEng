package trabalhoeng;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Facade
{
    private ArrayList <Aluno> listaAlunos;
    private ArrayList <Professor> listaProfessor;
    private ArrayList <Funcionario> listaFuncionarios;
    private Biblioteca bib;
    private ArrayList <Livro> listaLivros;
    private ArrayList <Exemplar> listaExemplar;
    private ArrayList <Reserva> listaReservas;
    private ArrayList <Emprestimo> listaEmprestimos;
    private ArrayList <Usuario> listaUsuarios;
    private Calendar dataSys;

    public Facade(ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessor, ArrayList<Funcionario> listaFuncionarios, Biblioteca bib, ArrayList<Livro> listaLivros, ArrayList<Exemplar> listaExemplar, ArrayList<Reserva> listaReservas, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Usuario> listaUsuarios, Calendar dataSys) {
        this.listaAlunos = listaAlunos;
        this.listaProfessor = listaProfessor;
        this.listaFuncionarios = listaFuncionarios;
        this.bib = bib;
        this.listaLivros = listaLivros;
        this.listaExemplar = listaExemplar;
        this.listaReservas = listaReservas;
        this.listaEmprestimos = listaEmprestimos;
        this.listaUsuarios = listaUsuarios;
        this.dataSys = dataSys;
    }
    
    public Usuario getUsuarioFromCodigo (int cod)
    {
        Iterator <Usuario> it= listaUsuarios.iterator();
        Usuario resp=null;
        while (it.hasNext())
        {
            Usuario user= it.next();
            if (user.getCodigo() == cod)
                resp= user;
        }
        return resp;
    }
    
    public Livro getLivroFromCodigo(String codigoLivro)
    {
        Iterator<Livro> l = listaLivros.iterator();
        while (l.hasNext()) {
            Livro liv = l.next();
            if (liv.getCodigo().equals(codigoLivro))
                return liv;
        }
        return null;
    }

    public void RealizarEmprestimo (int codUsuario, String codLivro)
    {
        Usuario user= getUsuarioFromCodigo(codUsuario);
        Livro liv= getLivroFromCodigo(codLivro);
        bib.realizarEmprestimo(user, liv);
    }
    
    public void RealizarDevolucao (int codUsuario, String codLivro)
    {
        Usuario user= getUsuarioFromCodigo(codUsuario);
        Livro liv= getLivroFromCodigo(codLivro);
        bib.RealizarDevolucao(user, liv);
    }
    
    public void realizarReserva (int codUsuario, String codLivro)
    {
        Usuario user= getUsuarioFromCodigo(codUsuario);
        Livro liv= getLivroFromCodigo(codLivro);
        bib.RealizarReserva(user, liv, dataSys);
    }
    
    public void criarObservador (int codUsuario, String codLivro)
    {
        Usuario user= getUsuarioFromCodigo(codUsuario);
        Livro liv= getLivroFromCodigo(codLivro);
        bib.CriarObservador(user, liv);
    }
    
    public void consultarLivro (String codigo)
    {
        bib.ConsultarLivro(codigo);
    }
    
    public void consultarUsuario (int codigo)
    {
        bib.ConsultarUsuario(codigo);
    }
    
    public void consultarNotificacoes (int codUsuario)
    {
        Usuario user= getUsuarioFromCodigo(codUsuario);
        bib.ConsultarNotificacoes(user);
    }
    
    
    public ArrayList <Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList <Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public ArrayList <Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(ArrayList <Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }

    public ArrayList <Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(ArrayList <Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public Biblioteca getBiblioteca() {
        return bib;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.bib = biblioteca;
    }

    public ArrayList <Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(ArrayList <Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public ArrayList <Exemplar> getListaExemplar() {
        return listaExemplar;
    }

    public void setListaExemplar(ArrayList <Exemplar> listaExemplar) {
        this.listaExemplar = listaExemplar;
    }

    public ArrayList <Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList <Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList <Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList <Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

    public Calendar getDataSys() {
        return dataSys;
    }

    public void setDataSys(Calendar dataSys) {
        this.dataSys = dataSys;
    }
}