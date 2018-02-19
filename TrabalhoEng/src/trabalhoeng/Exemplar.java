package trabalhoeng;

public class Exemplar {

    private String codLivro;
    private String codExemplar;
    private String status;

    public Exemplar(String codLivro, String codExemplar, String status) {
        this.codLivro = codLivro;
        this.codExemplar = codExemplar;
        this.status = status;
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
