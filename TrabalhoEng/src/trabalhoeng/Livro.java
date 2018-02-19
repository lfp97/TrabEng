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
    private int qtdExemplares;
    private ArrayList<Reserva> listaReservas;
    private int qtdObs;
    private ArrayList<Usuario> listaObservadores;

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublic, ArrayList<Exemplar> listaExemplares, int qtdExemplares, ArrayList<Reserva> listaReservas, int qtdObs) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublic = anoPublic;
        this.listaExemplares = listaExemplares;
        this.qtdExemplares = qtdExemplares;
        this.listaReservas = listaReservas;
        this.qtdObs = qtdObs;
        this.listaObservadores = null;
    }

    public ArrayList<Usuario> getListaObservadores() {
        return listaObservadores;
    }

    public void setListaObservadores(ArrayList<Usuario> listaObservadores) {
        this.listaObservadores = listaObservadores;
    }
    
    public void addObservadorNaLista (Usuario user)
    {
        if (listaObservadores != null)
            this.listaObservadores.add(user);
        else
        {
            listaObservadores= new ArrayList<Usuario>();
            this.listaObservadores.add(user);
        }
        
    }
    
    public Usuario getObservadorDaListaPorCod (int cod)
    {
        Usuario resp=null;
        Iterator <Usuario> it= listaObservadores.iterator();
        while (it.hasNext())
        {
            Usuario aux= it.next();
            if (aux.getCodigo() == cod)
                resp= aux;
        }
        return resp;
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

    public int getQtdReservas() {
        Iterator<Reserva> iterator = listaReservas.iterator();
        int qtd = 0;
        while (iterator.hasNext()) {
            Reserva res= iterator.next();
            if (res.getCodLivro().equalsIgnoreCase(getCodigo()) && res.getStatus().equalsIgnoreCase("ativa")) //testando se a reserva eh sobre o livro e se a reserva esta ativa
                qtd++;
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

    public int getQtdExemplares() {
        return qtdExemplares;
    }

    public void setQtdExemplares(int qtdExemplares) {
        this.qtdExemplares = qtdExemplares;
    }
    
    public void subtrairQtdExemplares ()
    {
        this.qtdExemplares--;
    }
    
    public void adicionarQtdExemplares ()
    {
        this.qtdExemplares++;
    }

    public int getQtdObservadores()
    {
        int result=0;
        Iterator <Reserva> it= listaReservas.iterator();
        while (it.hasNext())
        {
            Reserva re= it.next();
            if (re.getStatus().equals("ativa"))
                result++;
        }
        return result;
    }

    public void setQtdObs(int qtdObs) {
        this.qtdObs = qtdObs;
    }
    
    public void addObservador ()
    {
        this.qtdObs++;
    }
}
