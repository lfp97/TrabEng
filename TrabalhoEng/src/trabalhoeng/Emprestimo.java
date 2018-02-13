package trabalhoeng;

import java.util.Date;

public class Emprestimo {

    private Usuario user;
    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String tituloExemplar;
    private int codExemplar;

    public Emprestimo(Usuario user, Exemplar exemplar, Date dataEmprestimo, Date dataDevolucao, String tituloExemplar, int codExemplar) {
        this.user = user;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.tituloExemplar = tituloExemplar;
        this.codExemplar = codExemplar;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public String getNome ()
    {
        return this.user.getNome();
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

    public String getTituloExemplar() {
        return tituloExemplar;
    }

    public void setTituloExemplar(String tituloExemplar) {
        this.tituloExemplar = tituloExemplar;
    }

    public int getCodExemplar() {
        return codExemplar;
    }

    public void setCodExemplar(int codExemplar) {
        this.codExemplar = codExemplar;
    }

    public String getNomeUsuario() {
        return user.getNome();
    }

    public int getCodUsuario() {
        return user.getCodigo();
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
}
