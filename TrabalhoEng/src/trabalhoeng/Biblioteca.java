package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Biblioteca {

    private ArrayList <Livro> listaLivros;
    private ArrayList <Usuario> listaUsuarios;
    private ArrayList <Reserva> listaReservas;
    private ArrayList <Emprestimo> listaEmprestimos;
    private ArrayList <Usuario> listaObservadores;
    
    public void RealizarEmprestimo(Usuario user, Exemplar exe, Date dataEmp, Date dataDev, String state)
    {
        Emprestimo e= new Emprestimo(user, exe, dataEmp, dataDev, state);
        listaEmprestimos.add(e); //adicionando o novo emprestimo na lista
        listaUsuarios.get(listaUsuarios.indexOf(user)).adicionarEmprestimoNaLista(e); //adicionar esse emprestimo na lista do usuario
        
        //remover 1 exemplar do livro
        Iterator <Livro> ite= listaLivros.iterator();
        while (ite.hasNext())
        {
            Livro liv= ite.next();
            if (liv.getCodigo().equals(exe.getCodLivro())) //testando se o livro e o msm do emprestimo
                listaLivros.get(listaLivros.indexOf(liv)).subtrairQtdExemplares();//IMPORTANTE: DIMINUINDO A QTD DE EXEMPLARES DISPONIVEIS DESTE LIVRO
        }
    }

    public void RealizarDevolucao(Usuario user, Livro liv)
    {
        boolean flag= false;
        Iterator <Emprestimo> it= user.getIteratorEmp();
        while (it.hasNext())
        {
            Emprestimo emp= it.next();
            if (emp.getCodLivroDoExemplar().equals(liv.getCodigo()))//testando se existe o emprestimo
                if (emp.getStatus().equals("emprestado"));//testando se o emprestimo existente esta ativo
                    flag= true;
        }
        if (flag)
            {
                listaLivros.get(listaLivros.indexOf(liv)).adicionarQtdExemplares();//adicionando 1 exemplar na biblioteca
                System.out.println("Devolução realizada com sucesso.");
            }
        else
            System.out.println("Não existe emprestimo em aberto deste livro para este usuario.");
    }

    public void RealizarReserva(Usuario user, Livro liv, Date dataRes)
    {
        //implementar
    }

    public void CriarObservador(Usuario user)
    {
        listaObservadores.add(user);
    }

    public void AvisarObservador()
    {
        
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

    
    
    
    
    
    public ArrayList <Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(ArrayList <Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public ArrayList <Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList <Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList <Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList <Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList <Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList <Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

    public ArrayList <Usuario> getListaObservadores() {
        return listaObservadores;
    }

    public void setListaObservadores(ArrayList <Usuario> listaObservadores) {
        this.listaObservadores = listaObservadores;
    }

}
