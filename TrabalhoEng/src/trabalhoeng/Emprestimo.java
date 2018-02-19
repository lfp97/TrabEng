package trabalhoeng;

import java.util.Date;

public class Emprestimo {

    private Usuario user;
    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String tituloExemplar;
    private String codExemplar;
    private String status; //emprestado ou devolvido

    public Emprestimo(Usuario user, Exemplar exemplar, Date dataEmprestimo, Date dataDevolucao, String tituloLivroExemplar, String statu) {
        this.user = user;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.tituloExemplar = tituloLivroExemplar;
        this.codExemplar = exemplar.getCodExemplar();
        this.status= statu;
    }

    public String getCodLivroDoExemplar ()
    {
        return this.exemplar.getCodLivro();
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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

    public String getCodExemplar() {
        return codExemplar;
    }

    public void setCodExemplar(String codExemplar) {
        this.codExemplar = codExemplar;
    }

    public String getNomeUsuario() {
        return this.user.getNome();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
