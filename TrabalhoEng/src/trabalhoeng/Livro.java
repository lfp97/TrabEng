package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Livro {

    private String codigo;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private String anoPublic;
    private ArrayList<Exemplar> listaExemplares;
    private ArrayList<Reserva> listaReservas;

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublic, ArrayList<Exemplar> listaExemplares, ArrayList<Reserva> listaReservas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublic = anoPublic;
        this.listaExemplares = listaExemplares;
        this.listaReservas = listaReservas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAnoPublic() {
        return anoPublic;
    }

    public void setAnoPublic(String anoPublic) {
        this.anoPublic = anoPublic;
    }

    public ArrayList<Exemplar> getListaExemplares() {
        return listaExemplares;
    }

    public void setListaExemplares(ArrayList<Exemplar> listaExemplares) {
        this.listaExemplares = listaExemplares;
    }

    public Iterator getIteratorListaExemplares() {
        return listaExemplares.iterator();
    }

    public int getNumeroReservas() {
        Iterator<Exemplar> iterator = listaExemplares.iterator();
        int qtd = 0;
        while (iterator.hasNext()) {
            Exemplar aux = iterator.next();
            if (!(aux.getStatus().equalsIgnoreCase("Disponível"))) //testando se o exemplar esta >indisponivel<
            {
                qtd++;
            }
        }
        return qtd;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Iterator getIteratorReservas ()
    {
        return listaReservas.iterator();
    }
}
