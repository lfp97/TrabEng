package trabalhoeng;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TrabalhoEng
{
    public static void main(String[] args)
    {
        ArrayList <Aluno> listaAlunos= new ArrayList<Aluno> ();
        ArrayList <Professor> listaProfessor= new ArrayList<Professor> ();
        ArrayList <Funcionario> listaFuncionarios = new ArrayList<Funcionario> ();
        ArrayList <Livro> listaLivros= new ArrayList<Livro> ();
        ArrayList <Exemplar> listaExemplar= new ArrayList<Exemplar> ();
        ArrayList <Reserva> listaReservas= new ArrayList<Reserva> ();
        ArrayList <Emprestimo> listaEmprestimos= new ArrayList<Emprestimo> ();
        Date dataAux= new Date(2018, 01, 01);
        Calendar dataSys= Calendar.getInstance();
        dataSys.set(Calendar.YEAR, 2018);
        dataSys.set(Calendar.MONTH, 1);
        dataSys.set(Calendar.DAY_OF_MONTH, 1);
        
        ArrayList <Usuario> listaUsuarios=new ArrayList<Usuario> ();
        
        Funcionario joao= new Funcionario("Joao da Silva", 123, null, null); listaFuncionarios.add(joao); listaUsuarios.add(joao);
        Aluno luiz= new Aluno("Luiz Fernando Rodrigues", 456, null, null); listaAlunos.add(luiz); listaUsuarios.add(luiz);
        Funcionario pedro= new Funcionario("Pedro Paulo", 789, null, null); listaFuncionarios.add(pedro); listaUsuarios.add(pedro);
        Professor carlos= new Professor("Carlos Lucena", 100, null, null, 0); listaProfessor.add(carlos); listaUsuarios.add(carlos);
        
        Livro eng= new Livro ("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6", "2000", null, 2, null, 0); listaLivros.add(eng);
        Livro uml= new Livro ("101", "UML – Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7", "2000", null, 1, null, 0); listaLivros.add(uml);
        Livro code= new Livro ("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2", "2014", null, 1, null, 0); listaLivros.add(code);
        Livro agile= new Livro ("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", "1", "2002", null, 1, null, 0); listaLivros.add(agile);
        Livro refactoring= new Livro ("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1", "1999", null, 2, null, 0); listaLivros.add(refactoring);
        Livro software= new Livro ("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3", "2014", null, 0, null, 0); listaLivros.add(software);
        Livro design= new Livro ("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional",
                "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1", "1994", null, 2, null, 0); listaLivros.add(design);
        Livro umldis= new Livro ("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", "Martin Fowler", "3", "2003", null, 0, null, 0); listaLivros.add(umldis);
        
        Exemplar eng1= new Exemplar("100", "01", "disponivel"); listaExemplar.add(eng1);
        Exemplar eng2= new Exemplar("100", "02", "disponivel"); listaExemplar.add(eng2);
        Exemplar uml1= new Exemplar("101", "03", "disponivel"); listaExemplar.add(uml1);
        Exemplar code1= new Exemplar("200", "04", "disponivel"); listaExemplar.add(code1);
        Exemplar agile1= new Exemplar("201", "05", "disponivel"); listaExemplar.add(agile1);
        Exemplar refactoring1= new Exemplar("300", "06", "disponivel"); listaExemplar.add(refactoring1);
        Exemplar refactoring2= new Exemplar("300", "07", "disponivel"); listaExemplar.add(refactoring2);
        Exemplar design1= new Exemplar("400", "08", "disponivel"); listaExemplar.add(design1);
        Exemplar design2= new Exemplar("400", "09", "disponivel"); listaExemplar.add(design2);
        
        Biblioteca bib= new Biblioteca (dataSys, listaLivros, listaExemplar, listaUsuarios, listaReservas, listaEmprestimos, listaUsuarios);
        Facade f= new Facade (listaAlunos, listaProfessor, listaFuncionarios, bib, listaLivros, listaExemplar, listaReservas, listaEmprestimos, listaUsuarios, dataSys);
        
        Scanner s= new Scanner (System.in);
        String comando, op, arg2;
        int arg1Num=0;
        
        System .out.println("Digite um comando: ");
        comando= s.nextLine();
        op= comando.substring(0, 3);
        String aux= comando.substring(4, 7);
        while (! op.equalsIgnoreCase("sai"))
        {//1 - emprestimo, 2- devolucao, 3-reserva, 4-regObs, 5-conLiv, 6-conUsu, 7-consNoti
            if (op.equalsIgnoreCase("liv"))
                f.consultarLivro(aux);
            if (op.equalsIgnoreCase("usu"))
            {
                arg1Num= Integer.parseInt(aux);
                f.consultarUsuario(arg1Num);
            }
            if (op.equalsIgnoreCase("ntf"))
            {
                arg1Num= Integer.parseInt(aux);
                f.consultarNotificacoes(arg1Num);
            }
            else
            {
                arg1Num= Integer.parseInt(aux);
                arg2= comando.substring(8, 11);
                if (comando.contains("emp"))
                    f.RealizarEmprestimo(arg1Num, arg2);
                if (comando.contains("dev"))
                    f.RealizarDevolucao(arg1Num, arg2);
                if (comando.contains("res"))
                    f.realizarReserva(arg1Num, arg2);
                if (comando.contains("obs"))
                    f.criarObservador(arg1Num, arg2);
                /*if (comando.contains("usu"))
                    f.consultarUsuario(arg1Num);
                if (comando.contains("ntf"))
                    f.consultarNotificacoes(arg1Num);*/
            }
            System .out.println("Digite um comando: ");
            comando= s.nextLine();
            op= comando.substring(0, 3);
            aux= comando.substring(4, 7);
        }
    }
}