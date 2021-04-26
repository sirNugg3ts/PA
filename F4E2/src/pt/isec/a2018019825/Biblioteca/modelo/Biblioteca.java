package pt.isec.a2018019825.Biblioteca.modelo;

import java.util.List;

public interface Biblioteca {
    @Override
    String toString();
    String toStringPorTitulo();
    String toStringPorCodigo();

    int acrescentaLivro(String titulo, List<String> autores);
    int acrescentaLivro(Livro livro);

    Livro pesquisaLivro(int codigo);

    boolean eliminaLivro(int codigo);
}
