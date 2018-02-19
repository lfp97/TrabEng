package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {

    private Usuario user;
    private Livro livro;
    private Date dataReserva;
    private String tituloLivro;
    private String status; //ativa ou inativa

    public Reserva(Usuario user, Livro livro, Date dataReserva, String tituloLivro, String statu) {
        this.user = user;
        this.livro = livro;
        this.dataReserva = dataReserva;
        this.tituloLivro = tituloLivro;
        this.status= statu;
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

    public String getCodLivro ()
    {
        return this.livro.getCodigo();
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

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
