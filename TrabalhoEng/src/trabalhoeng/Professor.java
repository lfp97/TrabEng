package trabalhoeng;

public class Professor extends Usuario
{
    private int notificacoes;
    public Professor(String nome, int codigo) {
        super(nome, codigo);
        this.notificacoes= 0;
    }
// isso eh um teste
    public int getNotificacoes() {
        return notificacoes;
    }

    public void addNotificacao() {
        this.notificacoes+= 1;
    }
    
}