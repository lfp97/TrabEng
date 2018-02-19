package trabalhoeng;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {

    private Usuario user;
    private Exemplar exemplar;
    private Calendar dataEmprestimo;
    private Calendar dataDevolucao;
    private String tituloExemplar;
    private String codExemplar;
    private String status; //emprestado ou devolvido

    public Emprestimo(Usuario user, Exemplar exemplar, Calendar dataEmprestimo, Calendar dataDevolucao, String tituloLivroExemplar, String statu) {
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

    public Calendar getDataEmprestimo() {
        System.out.println("Ano: " + dataEmprestimo.get(dataEmprestimo.YEAR));
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Calendar dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
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
