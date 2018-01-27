package trabalhoeng;

import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {

    ArrayList <Livro> listaLivros;
    ArrayList <Usuario> listaUsuarios;
    
    public void RealizarEmprestimo() {
 
    }

    public void RealizarDevolucao() {

    }

    public void RealizarReserva() {

    }

    public void CriarObservador() {

    }

    public void AvisarObservador() {

    }

    public void ConsultarLivro(String titulo)
    {
        Iterator<Livro> it = listaLivros.iterator();
        while (it.hasNext())
        {
            Livro l = it.next();
            if (l.getTitulo().equalsIgnoreCase(titulo))
            {
                System.out.println("Título: " + l.getTitulo());
                System.out.println("Quantidade de Reservas: " + l.getNumeroReservas());
                if (l.getNumeroReservas() != 0)
                {
                    int aux=0;
                    aux= l.getNumeroReservas();
                    for (int i=0; i<aux; i++)
                    {
                        System.out.println("!"); //nome dos usuarios q fizeram reserva    <<<IMPLEMENTAR 
                    }
                }
                Iterator<Exemplar> ite= l.getIteratorLista();
                while (ite.hasNext())
                {
                    Exemplar e= ite.next();
                    System.out.println("Exemplar de Código: " + e.getCodigo());
                    System.out.println("Status: " + e.getStatus());
                    if (!(e.getStatus().equalsIgnoreCase("Disponível"))) // se >indisponivel<
                    {
                        System.out.println("!");//nome do usuario q fez o emprestimo    <<<IMPLEMENTAR 
                        System.out.println("!");//data do emprestimo            <<<IMPLEMENTAR 
                        System.out.println("!");//data prevista de entrega      <<<IMPLEMENTAR 
                    }
                }
            }
        }
    }

    public void ConsultarUsuario() {

    }

    public void ConsultarNotificacoes() {

    }

    public void Sair() {

    }

}
