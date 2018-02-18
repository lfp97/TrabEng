package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Biblioteca {

    private Date data;
    private ArrayList <Livro> listaLivros;
    private ArrayList <Usuario> listaUsuarios;
    private ArrayList <Reserva> listaReservas;
    private ArrayList <Emprestimo> listaEmprestimos;
    private ArrayList <Usuario> listaObservadores;

    public Biblioteca(Date data, ArrayList<Livro> listaLivros, ArrayList<Usuario> listaUsuarios, ArrayList<Reserva> listaReservas, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Usuario> listaObservadores) {
        this.data = data;
        this.listaLivros = listaLivros;
        this.listaUsuarios = listaUsuarios;
        this.listaReservas = listaReservas;
        this.listaEmprestimos = listaEmprestimos;
        this.listaObservadores = listaObservadores;
    }
    
    public void RealizarEmprestimo1(Usuario user, Exemplar exe)//professor
    {
        Date dataEmp= data;
        Iterator <Livro> it= listaLivros.iterator();
        while (it.hasNext())
        {
            Livro liv= it.next();
            if (liv.getCodigo().equals(exe.getCodLivro())) //testando se o livro e o msm do emprestimo
            {
                if (liv.getQtdExemplares() > 0)//testando se existe pelo menos 1 exemplar disp.
                {   
                    boolean flag= false;
                    Iterator <Exemplar> ite= user.getIteratorEmp(); //rodar a lista de emprestimos do usuario
                    while (ite.hasNext())
                    {
                        Exemplar exem= ite.next();
                        if (exem.getCodLivro().equals(liv.getCodigo()))//se teve algum emprestimo de exemplar do livro
                            if (exem.getStatus().equals("emprestado"))//se ainda esta emprestado
                                flag= true;
                    }
                    if (!flag)
                    {
                        Date dataDev = dataEmp;
                        dataDev.setDate(dataDev.getDate() + user.getDiasEmprestimo());
                        Emprestimo e= new Emprestimo(user, exe, dataEmp, dataDev, "emprestado");
                        listaEmprestimos.add(e);
                        listaUsuarios.get(listaUsuarios.indexOf(user)).adicionarEmprestimoNaLista(e); // aki
                        listaLivros.get(listaLivros.indexOf(liv)).subtrairQtdExemplares();
                        System.out.println("Emprestimo Realizado.");
                    }
                }
                else
                    System.out.println("Emprestimo não Realizado.");
            }
        }
    }
    
    public void RealizarEmprestimo2(Usuario user, Exemplar exe)//aluno e func
    {
        Date dataEmp= data;
        Date dataDev = dataEmp;
        dataDev.setDate(dataDev.getDate() + user.getDiasEmprestimo());
        Emprestimo e= new Emprestimo(user, exe, dataEmp, dataDev, "emprestado");
        Iterator <Livro> it= listaLivros.iterator();
        while (it.hasNext())
        {
            Livro liv= it.next();
            if (liv.getCodigo().equals(exe.getCodLivro())) //testando se o livro e o msm do emprestimo
            {
                if (liv.getQtdExemplares() > 0)//testando se existe pelo menos 1 exemplar disp.
                {
                    int indice= listaUsuarios.indexOf(user); //indice do usuario na listaUsuarios
                    Usuario aux= listaUsuarios.get(indice);
                    if (aux.getListaReservas().get(aux.getListaReservas().indexOf(liv)).getStatus().equals("ativa"))//testa se usuario tem reserva desse livro ativa
                    {
                        if(user.Emprestimo(data)) //testa se o usuario pode realizar emprestimo, testa: se existe emprestimo em aberto, limite empres, reservas.
                        {
                            listaEmprestimos.add(e); //adicionando o novo emprestimo na lista
                            listaUsuarios.get(listaUsuarios.indexOf(user)).adicionarEmprestimoNaLista(e); //adicionar esse emprestimo na lista do usuario
                            listaLivros.get(listaLivros.indexOf(liv)).subtrairQtdExemplares();//IMPORTANTE: DIMINUINDO A QTD DE EXEMPLARES DISPONIVEIS DESTE LIVRO
                            System.out.println("Emprestimo Realizado.");
                        }
                        else
                            System.out.println("Emprestimo não realizado, usuario nao atende requesitos de emprestimo.");
                    }
                    
                    if (listaLivros.get(listaLivros.indexOf(liv)).getNumeroReservas() < listaLivros.get(listaLivros.indexOf(liv)).getQtdExemplares()) //reservas < exemplares
                    {
                        if(user.Emprestimo(data))
                        {
                            listaEmprestimos.add(e);
                            listaUsuarios.get(listaUsuarios.indexOf(user)).adicionarEmprestimoNaLista(e);
                            listaLivros.get(listaLivros.indexOf(liv)).subtrairQtdExemplares();
                            System.out.println("Emprestimo Realizado.");
                        }
                        else
                            System.out.println("Emprestimo não realizado, usuario nao atende requesitos de emprestimo.");
                    }
                    
                    boolean flag= false;
                    String codLiv= liv.getCodigo();
                    Iterator <Exemplar> ite= aux.getIteratorEmp(); //rodar a lista de emprestimos do usuario
                    while (ite.hasNext())
                    {
                        Exemplar exem= ite.next();
                        if (exem.getCodLivro().equals(codLiv))//se teve algum emprestimo de exemplar do livro
                            if (exem.getStatus().equals("emprestado"))//se ainda esta emprestado
                                flag= true;
                    }
                    if (!flag)
                    {
                        if(user.Emprestimo(data))
                        {
                            listaEmprestimos.add(e);
                            listaUsuarios.get(listaUsuarios.indexOf(user)).adicionarEmprestimoNaLista(e);
                            listaLivros.get(listaLivros.indexOf(liv)).subtrairQtdExemplares();
                            System.out.println("Emprestimo Realizado.");
                        }
                        else
                            System.out.println("Emprestimo não realizado, usuario nao atende requesitos de emprestimo.");
                    }
                }
                else
                    System.out.println("Emprestimo não Realizado, ausencia de exemplares.");
            }
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
        Reserva r= new Reserva (user, liv, dataRes, liv.getTitulo(), "ativa");
        listaReservas.add(r);
        if (listaLivros.get(listaLivros.indexOf(liv)).getQtdObservadores() > 2)
            AvisarObservador();
    }

    public void CriarObservador(Usuario user)
    {
        listaObservadores.add(user);
    }

    public void AvisarObservador()
    {
        Iterator <Usuario> it= listaObservadores.iterator();
        while (it.hasNext())
        {
            Usuario us= it.next();
            listaObservadores.get(listaObservadores.indexOf(us)).addNotificacao();
        }
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

    public void ConsultarNotificacoes(Usuario user)
    {
        System.out.println("Notificacoes de " + user.getNome() + ": " + user.getNotificacoes());
    }

    public void Sair()
    {
        //implementar
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
