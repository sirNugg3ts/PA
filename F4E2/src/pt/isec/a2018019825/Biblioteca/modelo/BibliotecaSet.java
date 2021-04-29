package pt.isec.a2018019825.Biblioteca.modelo;

import java.io.*;
import java.util.*;

public class BibliotecaSet implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nome;
    private Set<Livro> livros;

    public BibliotecaSet(String nome) {
        this.nome = nome;
        livros = new HashSet<>();
    }

    public BibliotecaSet(File file){
        this("sem nome");
        lerFicheiro(file);

    }

    void lerFicheiro(File f){

            //livros.clear();

        try {
            Scanner sc = new Scanner(f);

            nome = sc.nextLine();
            while(sc.hasNextLine()){
                Livro l = new Livro(sc);
                livros.add(l);
            }
            sc.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escreveFichTxt(File f){

        try {
            FileWriter fr = new FileWriter(f);
            fr.write(toString());
            fr.flush();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String toStringPorTitulo() {
        StringBuilder sb = new StringBuilder(String.format("Biblioteca %s:",nome));
        List<Livro> lista = new ArrayList<>();
        lista.addAll(livros);
        Collections.sort(lista,new Livro.ComparaTitulo());
        Iterator<Livro> it = lista.iterator();
        while (it.hasNext()) {
            Livro livro= it.next();
            sb.append("\n\t- ");
            sb.append(livro.toStringFormatdo());
        }
        return sb.toString();
    }

    public String toStringPorCodigo() {
        StringBuilder sb = new StringBuilder(String.format("Biblioteca %s:",nome));
        List<Livro> lista = new ArrayList<>();
        lista.addAll(livros);
        Collections.sort(lista,new Livro.ComparaCodigo());
        Iterator<Livro> it = lista.iterator();
        while (it.hasNext()) {
            Livro livro= it.next();
            sb.append("\n\t- ");
            sb.append(livro.toStringFormatdo());
        }
        return sb.toString();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder(nome);
        sb.append('\n');
        for(Livro l : livros) {
            sb.append(l.toString());
            sb.append('\n');
        }
        return sb.toString();
    }


    public int acrescentaLivro(String titulo, List<String> autores) {
        Livro novo = new Livro(titulo,autores);
        if (!livros.add(novo))
            return -1;
        return novo.getCodigo();
    }


    public int acrescentaLivro(Livro livro) {
        if (!livros.add(livro))
            return -1;
        return livro.getCodigo();
    }


    public Livro pesquisaLivro(int codigo) {
        //Livro base = new Livro(codigo);
        Iterator<Livro> it = livros.iterator();
        while (it.hasNext()) {
            Livro livro = it.next();
            //if (livro.equals(base))
            //    return livro;
            if (livro.getCodigo() == codigo)
                return livro;
        }
        //for (Livro livro : livros)
        //    if (livro.getCodigo() == codigo)
        //        return livro;

        return null;
    }


    public boolean eliminaLivro(int codigo) {
        return livros.remove(new Livro(codigo));
    }

    private static final String FILENAME = "biblio.dat";

    public boolean gravar(){

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
            //oos.writeObject(nome);
            //oos.writeObject(livros);

            oos.writeObject(this);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static BibliotecaSet lerGenerico(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));

            BibliotecaSet obj = (BibliotecaSet) ois.readObject();

            ois.close();

            for (Livro l : obj.livros)
                l.verificaContador();

            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean ler(){
        BibliotecaSet obj = BibliotecaSet.lerGenerico();
        if (obj != null){
            this.nome = obj.nome;
            this.livros = obj.livros;
            return true;
        }
        return false;
    }


}
