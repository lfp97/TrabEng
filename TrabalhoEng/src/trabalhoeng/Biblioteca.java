package trabalhoeng;

import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {

    ArrayList <Livro> listaLivros;
    ArrayList <Usuario> listaUsuarios;
    ArrayList <Reserva> listaReservas;
    ArrayList <Emprestimo> listaEmprestimos;
    
    public void RealizarEmprestimo(Emprestimo e)
    {
        listaEmprestimos.add(e);
        int aux= listaLivros.indexOf(e);
        listaLivros.get(aux);
    }

    public void RealizarDevolucao() {

    }

    public void RealizarReserva() {

    }

    public void CriarObservador() {

    }

    public void AvisarObservador() {

    }

    public void ConsultarLivro(String titulo) //se puder enviar obj ao inves de titulo
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
                    Iterator<Reserva> itRes= l.getIteratorReservas();
                    while (itRes.hasNext())
                    {
                        Reserva auxre= itRes.next();
                        System.out.println("Reservado por: " + auxre.getNomeUsuario());
                    }
                }
                Iterator<Exemplar> ite= l.getIteratorListaExemplares();
                while (ite.hasNext())
                {
                    Exemplar e= ite.next();
                    System.out.println("Exemplar de Código: " + e.getCodigo());
                    System.out.println("Status: " + e.getStatus());
                    if (!(e.getStatus().equalsIgnoreCase("Disponível"))) // se >indisponivel<
                    {
                        
                        System.out.println("Emprestado a: " + e.getNomeUsuarioEmprestado());
                        System.out.println("Emprestado em: " + e.getDataEmprestimo());//data do emprestimo
                        System.out.println("Devolucao deste exemplar prevista para: " + e.getDataDevolucao());
                    }
                }
            }
        }
    }

    public void ConsultarUsuario(int c) //se puder, enviar o obj 
    {
        Iterator<Usuario> it= listaUsuarios.iterator();
        while (it.hasNext())
        {
            Usuario u= it.next();
            if (u.getCodigo() == c)
            {
                Iterator<Exemplar> e= u.getIteratorEmp();
                while (e.hasNext()) //emprestimos
                {
                    Exemplar aux= e.next();
                    System.out.println("Titulo do Exemplar: " + aux.getTitulo());
                    System.out.println("Data do Emprestimo: " + aux.getDataEmprestimo());
                    System.out.println("Status:  " + aux.getStatus());
                    System.out.println("Data da Devolucao:  " + aux.getDataDevolucao());
                }
                /*Iterator<Livro> l= u.getIteratorRes(); como era a iteracao de reservas antes caso de algum problema
                while (l.hasNext()) // reservas
                {
                    Livro aux= l.next();
                    System.out.println("Titulo do Livro Reservado: " + aux.getTitulo());
                    System.out.println("Data da Reserva: " + aux.getDataSolicitacaoReserva());
                }*/
                Iterator<Reserva> r= u.getIteratorRes();
                while (r.hasNext()) // reservas            esse metodo todo pode dar problema
                {
                    Reserva aux= r.next();
                    System.out.println("Titulo do Livro Reservado: " + aux.getTituloLivro());
                    System.out.println("Data da Reserva: " + aux.getDataReserva());
                }
            }
        }
    }

    public void ConsultarNotificacoes() {

    }

    public void Sair() {

    }

}
