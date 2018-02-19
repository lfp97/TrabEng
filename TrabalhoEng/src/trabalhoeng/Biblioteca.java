package trabalhoeng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Biblioteca {

    private Date data;
    private ArrayList<Livro> listaLivros;
    private ArrayList<Exemplar> listaExemplares;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Reserva> listaReservas;
    private ArrayList<Emprestimo> listaEmprestimos;
    private ArrayList<Usuario> listaObservadores;

    public Biblioteca(Date data, ArrayList<Livro> listaLivros, ArrayList<Exemplar> listaExemplares, ArrayList<Usuario> listaUsuarios, ArrayList<Reserva> listaReservas, ArrayList<Emprestimo> listaEmprestimos, ArrayList<Usuario> listaObservadores) {
        this.data = data;
        this.listaLivros = listaLivros;
        this.listaExemplares = listaExemplares;
        this.listaUsuarios = listaUsuarios;
        this.listaReservas = listaReservas;
        this.listaEmprestimos = listaEmprestimos;
        this.listaObservadores = listaObservadores;
    }

    public void realizarEmprestimo(Usuario user, Livro liv)
    {
        Date dataEmp = data;
        boolean resp = false;
        Exemplar exe= null;
        if (liv.getQtdExemplares() > 0)
        {
            exe = getExemplarDisponivel(liv);
            resp = user.Emprestimo(liv, data, exe); //teste das condicoes de emprestimo do usuario
        }
        else
            System.out.println("Emprestimo não Realizado, sem exemplar disponivel.");
        if (resp)
        {
            Date dataDev = dataEmp;
            dataDev.setDate(dataDev.getDate() + user.getDiasEmprestimo());
            Emprestimo e = new Emprestimo(user, exe, dataEmp, dataDev, liv.getTitulo(), "emprestado");
            listaEmprestimos.add(e);
            listaUsuarios.get(listaUsuarios.indexOf(user)).adicionarEmprestimoNaLista(e);
            listaLivros.get(listaLivros.indexOf(liv)).subtrairQtdExemplares();
            System.out.println("Emprestimo Realizado.");
            if (isReservaAtiva(user, liv))
                listaReservas.get(listaReservas.indexOf(getReservaAtiva(user, liv))).setStatus("inativa"); //transforma a reserva desse livro em inativa
        }
    }

    public Exemplar getExemplarDisponivel(Livro l) {
        Iterator<Exemplar> it = listaExemplares.iterator();
        while (it.hasNext()) {
            Exemplar exe = it.next();
            if (exe.getCodLivro().equals(l.getCodigo()) && exe.getStatus().equalsIgnoreCase("disponivel")) //teste se o exemplar e do livro && se esta diponivel
            {
                return exe;
            }
        }
        return null;
    }

    public Exemplar getExemplarIndisponivel(Livro l, Emprestimo e) {
        Iterator<Exemplar> it = listaExemplares.iterator();
        while (it.hasNext()) {
            Exemplar exe = it.next();
            //teste se o exemplar eh do livro && se esta indiponivel && importante: se o exemplar do emprestimo(mandado) eh igual ao exemplar da vez no iterator
            //impede que devolva o exemplar que esta emprestado a outra pessoa
            if (exe.getCodLivro().equals(l.getCodigo()) && exe.getStatus().equalsIgnoreCase("indisponivel") && e.getCodExemplar().equals(exe.getCodExemplar()))
                return exe;
        }
        return null;
    }

    public Reserva getReservaAtiva(Usuario user, Livro l) {
        Iterator<Reserva> it = listaReservas.iterator();
        while (it.hasNext()) {
            Reserva res = it.next();
            if (res.getCodUsuario() == user.getCodigo() && res.getLivro().getCodigo().equals(l.getCodigo()) && res.getStatus().equals("ativa")) {
                return res;
            }
        }
        return null;
    }

    public boolean isReservaAtiva(Usuario user, Livro l) {
        Iterator<Reserva> it = listaReservas.iterator();
        while (it.hasNext()) {
            Reserva res = it.next();
            if (res.getCodUsuario() == user.getCodigo() && res.getLivro().getCodigo().equals(l.getCodigo()) && res.getStatus().equals("ativa")) {
                return true;
            }
        }
        return false;
    }

    public void RealizarDevolucao(Usuario user, Livro liv)
    {
        boolean flag = false;
        Exemplar exe = null;
        Iterator<Emprestimo> it = user.getIteratorEmp();
        while (it.hasNext())
        {
            Emprestimo emp = it.next();
            if (emp.getCodLivroDoExemplar().equals(liv.getCodigo()) && emp.getCodUsuario() == user.getCodigo())//testando se e o emprestimo do livro certo && pertence ao usuario
                if (emp.getStatus().equals("emprestado"));//testando se o emprestimo existente esta ativo
                {
                    flag = true;
                    exe = getExemplarIndisponivel(liv, emp);
                }
        }
        if (flag) {
            listaLivros.get(listaLivros.indexOf(liv)).adicionarQtdExemplares();//adicionando 1 exemplar na biblioteca
            listaExemplares.get(listaExemplares.indexOf(exe)).setStatus("disponivel");
            System.out.println("Devolução realizada com sucesso.");
        }
        else
            System.out.println("Não existe emprestimo em aberto deste livro para este usuario.");
    }

    public void RealizarReserva(Usuario user, Livro liv, Date dataRes) {
        Reserva r = new Reserva(user, liv, dataRes, liv.getTitulo(), "ativa");
        listaReservas.add(r);
        if (listaLivros.get(listaLivros.indexOf(liv)).getQtdObservadores() > 2) //se o livro que acabou de ganhar reserva tiver apartir de 3 observadores
        {
            AvisarObservador(liv);
        }
    }
    
    public void CriarObservador(Usuario user, Livro liv) {
        listaObservadores.add(user);
        listaLivros.get(listaLivros.indexOf(liv)).addObservadorNaLista(user);
        listaLivros.get(listaLivros.indexOf(liv)).addObservador();
    }

    public void AvisarObservador(Livro l) { //mudar esse metodo caso queria q mostre algo na tela ou n
        Iterator<Usuario> it = listaObservadores.iterator();
        while (it.hasNext()) {
            Usuario us = it.next();
            Professor resp= (Professor) listaUsuarios.get(listaUsuarios.indexOf(us));
            resp.addNotificacao();
            //listaUsuarios.get(listaUsuarios.indexOf(us)).addNotificacao();
            //System.out.println("" + us.getNome() + "!, o livro: " + l.getTitulo() + " tem " + l.getQtdReservas() + " reservas ativas!");
        }
    }

    public void ConsultarLivro(String codigo) 
    {
        Iterator<Livro> it = listaLivros.iterator();
        while (it.hasNext()) {
            Livro l = it.next();
            if (l.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Título: " + l.getTitulo());
                System.out.println("Quantidade de Reservas: " + l.getQtdReservas());
                if (l.getQtdReservas() != 0) {
                    Iterator<Reserva> itRes = l.getIteratorReservas();
                    while (itRes.hasNext()) {
                        Reserva auxre = itRes.next();
                        System.out.println("Reservado por: " + auxre.getNomeUsuario());
                    }
                }
                Iterator<Exemplar> ite = l.getIteratorListaExemplares();
                while (ite.hasNext()) {
                    Exemplar e = ite.next();
                    System.out.println("Exemplar de Código: " + e.getCodExemplar());
                    System.out.println("Status: " + e.getStatus());
                    if (!(e.getStatus().equalsIgnoreCase("disponível"))) // se >indisponivel<
                    {
                        Emprestimo em = getEmprestimoAtivo(e);
                        System.out.println("Emprestado a: " + em.getNomeUsuario());
                        System.out.println("Emprestado em: " + em.getDataEmprestimo());//data do emprestimo
                        System.out.println("Devolucao deste exemplar prevista para: " + em.getDataDevolucao());
                    }
                }
            }
        }
    }

    public Emprestimo getEmprestimoAtivo(Exemplar exe) {
        Iterator<Emprestimo> it = listaEmprestimos.iterator();
        while (it.hasNext()) {
            Emprestimo emp = it.next();
            if (emp.getCodExemplar().equals(exe.getCodExemplar()) && emp.getStatus().equals("emprestado")) {
                return emp;
            }
        }
        return null;
    }

    public Emprestimo getEmprestimoUsuario(Usuario user, Exemplar exe) {
        Iterator<Emprestimo> it = listaEmprestimos.iterator();
        while (it.hasNext()) {
            Emprestimo emp = it.next();
            if (emp.getUser().getCodigo() == user.getCodigo() && emp.getCodExemplar().equals(exe.getCodExemplar())) {
                return emp;
            }
        }
        return null;
    }

    public Livro getLivroFromCodigo(String codigoLivro) {
        Livro livResp = null;
        Iterator<Livro> l = listaLivros.iterator();
        while (l.hasNext()) {
            Livro liv = l.next();
            if (liv.getCodigo().equals(codigoLivro)) {
                return livResp;
            }
        }
        return null;
    }

    public void ConsultarUsuario(int c) //se puder, enviar o obj 
    {
        Iterator<Usuario> it = listaUsuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getCodigo() == c) {
                Iterator<Emprestimo> e = u.getIteratorEmp();
                while (e.hasNext()) //emprestimos
                {
                    Emprestimo emp = e.next();
                    System.out.println("Titulo do Livro deste exemplar: " + emp.getTituloExemplar());
                    System.out.println("Data do Emprestimo: " + emp.getDataEmprestimo());
                    System.out.println("Status:  " + emp.getStatus());
                    System.out.println("Data da Devolucao:  " + emp.getDataDevolucao());
                }
                Iterator<Reserva> r = u.getIteratorRes();
                while (r.hasNext()) // reservas            
                {
                    Reserva res = r.next();
                    System.out.println("Titulo do Livro Reservado: " + res.getTituloLivro());
                    System.out.println("Data da Reserva: " + res.getDataReserva());
                    System.out.println("Status da Reserva: " + res.getStatus());
                }
            }
        }
    }

    public void ConsultarNotificacoes(Usuario user) {
        
        System.out.println("Notificacoes de " + user.getNome() + ": " + user.getNotificacoes());
    }
    

    public void Sair() {
        //implementar
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(ArrayList<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }
    
    public Usuario getUsuarioFromCodigo (int cod)
    {
        Iterator <Usuario> it= listaUsuarios.iterator();
        Usuario resp=null;
        while (it.hasNext())
        {
            Usuario user= it.next();
            if (user.getCodigo() == cod)
                resp= user;
        }
        return resp;
    }
    
    public Exemplar getExemplarFromCodigo (String cod)
    {
        Iterator <Exemplar> it= listaExemplares.iterator();
        Exemplar resp=null;
        while (it.hasNext())
        {
            Exemplar exe= it.next();
            if (exe.getCodExemplar().equalsIgnoreCase(cod))
                resp= exe;
        }
        return resp;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

    public ArrayList<Usuario> getListaObservadores() {
        return listaObservadores;
    }

    public void setListaObservadores(ArrayList<Usuario> listaObservadores) {
        this.listaObservadores = listaObservadores;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Exemplar> getListaExemplares() {
        return listaExemplares;
    }

    public void setListaExemplares(ArrayList<Exemplar> listaExemplares) {
        this.listaExemplares = listaExemplares;
    }

}
