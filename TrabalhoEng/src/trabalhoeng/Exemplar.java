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

}
