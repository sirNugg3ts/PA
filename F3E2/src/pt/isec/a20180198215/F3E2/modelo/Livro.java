package pt.isec.a20180198215.F3E2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private static int contador = 0;

    public Livro(int codigo) {
        this.codigo = codigo;
        titulo = null;
        autores = null;
    }

    private static int geraCodigo(){
        return ++contador;
    }

    private int codigo;
    private String titulo;
    private List<String> autores;

    public Livro(String titulo,List<String> autores){
        this.codigo = geraCodigo();
        this.titulo = titulo;
        this.autores = new ArrayList<>(autores);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        return codigo == livro.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
