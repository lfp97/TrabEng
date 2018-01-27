package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Exemplar extends Livro {

    private String codLivro;
    private String codExemplar;
    private String status;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String nomeUsuarioEmprestado;

    public Exemplar(String codLivro, String codExemplar, String status, Date dataEmprestimo, Date dataDevolucao, String nomeUsuarioEmprestado, String codigo, String titulo, String editora, String autores, String edicao, String anoPublic, ArrayList<Exemplar> listaExemplares, ArrayList<Reserva> listaReservas) {
        super(codigo, titulo, editora, autores, edicao, anoPublic, listaExemplares, listaReservas);
        this.codLivro = codLivro;
        this.codExemplar = codExemplar;
        this.status = status;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.nomeUsuarioEmprestado = nomeUsuarioEmprestado;
    }

    public String getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(String codLivro) {
        this.codLivro = codLivro;
    }

    public String getCodExemplar() {
        return codExemplar;
    }

    public void setCodExemplar(String codExemplar) {
        this.codExemplar = codExemplar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getNomeUsuarioEmprestado() {
        return nomeUsuarioEmprestado;
    }

    public void setNomeUsuarioEmprestado(String nomeUsuarioEmprestado) {
        this.nomeUsuarioEmprestado = nomeUsuarioEmprestado;
    }

}
