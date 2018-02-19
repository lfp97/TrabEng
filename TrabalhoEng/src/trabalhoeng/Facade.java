package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;

public class Facade
{
    private ArrayList <Aluno> listaAlunos= new ArrayList<Aluno> ();
    private ArrayList <Professor> listaProfessor= new ArrayList<Professor> ();
    private ArrayList <Funcionario> listaFuncionarios= new ArrayList<Funcionario> ();
    private Biblioteca bib;
    private ArrayList <Livro> listaLivros= new ArrayList<Livro> ();
    private ArrayList <Exemplar> listaExemplar= new ArrayList<Exemplar> ();
    private ArrayList <Reserva> listaReservas= new ArrayList<Reserva> ();
    private ArrayList <Emprestimo> listaEmprestimos= new ArrayList<Emprestimo> ();
    private Date dataSys;

    public Facade(ArrayList<Aluno> listaAlunos, ArrayList<Professor> listaProfessor, ArrayList<Funcionario> listaFuncionarios, Biblioteca biblioteca, ArrayList<Livro> listaLivros, ArrayList<Exemplar> listaExemplar, ArrayList<Reserva> listaReservas, ArrayList<Emprestimo> listaEmprestimos, Date dataSys) {
        this.listaAlunos = listaAlunos;
        this.listaProfessor = listaProfessor;
        this.listaFuncionarios = listaFuncionarios;
        this.bib = biblioteca;
        this.listaLivros = listaLivros;
        this.listaExemplar = listaExemplar;
        this.listaReservas = listaReservas;
        this.listaEmprestimos = listaEmprestimos;
        this.dataSys = dataSys;
    }
    
    public Usuario getUsuarioFromCodigo (int cod)
    {
        return bib.getUsuarioFromCodigo(cod);
    }
    
    public Livro getLivroFromCodigo (String codLivro)
    {
        return bib.getLivroFromCodigo(codLivro);
    }

    public void RealizarEmprestimo (int codUsuario, String codLivro)
    {
        bib.realizarEmprestimo(bib.getUsuarioFromCodigo(codUsuario), bib.getLivroFromCodigo(codLivro));
    }
    
    public void RealizarDevolucao (int codUsuario, String codLivro)
    {
        bib.RealizarDevolucao(bib.getUsuarioFromCodigo(codUsuario), bib.getLivroFromCodigo(codLivro));
    }
    
    public void realizarReserva (int codUsuario, String codLivro)
    {
        bib.RealizarReserva(bib.getUsuarioFromCodigo(codUsuario), bib.getLivroFromCodigo(codLivro), dataSys);
    }
    
    public void criarObservador (int codUsuario, String codLivro)
    {
        bib.CriarObservador(bib.getUsuarioFromCodigo(codUsuario), bib.getLivroFromCodigo(codLivro));
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
        bib.ConsultarNotificacoes(bib.getUsuarioFromCodigo(codUsuario));
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

    public Date getDataSys() {
        return dataSys;
    }

    public void setDataSys(Date dataSys) {
        this.dataSys = dataSys;
    }
}