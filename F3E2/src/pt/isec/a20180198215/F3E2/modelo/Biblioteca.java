package pt.isec.a20180198215.F3E2.modelo;

import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    ArrayList<Livro> livros;

    public Biblioteca(String nome){
        this.nome = nome;
        livros = new ArrayList<Livro>();
    }

    public int acrescentaLivro(String titulo, ArrayList<String> autores) {
        Livro novo = new Livro(titulo,autores);
        livros.add(novo);
        return novo.getCodigo();
    }

    public Livro pesquisaLivro(int codigo) {
        int indice = livros.indexOf(new Livro(codigo));
        if(indice <0)
            return null;
        return livros.get(indice);
    }

    public boolean eliminaLivro(int codigo) {
        int indice = livros.indexOf(new Livro(codigo));
        if(indice <0)
            return false;
        livros.remove(indice);
        return true;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", livros=" + livros +
                '}';
    }
}
