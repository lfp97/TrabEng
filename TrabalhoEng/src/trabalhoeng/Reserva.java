package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {

    private Usuario user;
    private Livro livro;
    private Date dataReserva;
    private String tituloLivro;
    private String codExemplar;

    public Reserva(Usuario user, Livro livro, Date dataReserva, String tituloLivro, String codExemplar) {
        this.user = user;
        this.livro = livro;
        this.dataReserva = dataReserva;
        this.tituloLivro = tituloLivro;
        this.codExemplar = codExemplar;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Usuario getUser() {
        return user;
    }

    public String getNomeUsuario() {
        return user.getNome();
    }

    public int getCodUsuario() {
        return user.getCodigo();
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getCodExemplar() {
        return codExemplar;
    }

    public void setCodExemplar(String codExemplar) {
        this.codExemplar = codExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
