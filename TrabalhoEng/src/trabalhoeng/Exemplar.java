package trabalhoeng;

public class Exemplar extends Livro {

    private String codLivro;
    private String codExemplar;
    private String status;

    public Exemplar(String codigo, String titulo, String editora, String autores, String edicao, String anoPublic,
     String codlivr, String codexemplar, String statu)
    {
        super(codigo, titulo, editora, autores, edicao, anoPublic);
        this.codLivro= codlivr;
        this.codExemplar= codexemplar;
        this.status= statu;
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

}
