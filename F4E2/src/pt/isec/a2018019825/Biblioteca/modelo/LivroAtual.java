package pt.isec.a2018019825.Biblioteca.modelo;

import java.util.List;

public class LivroAtual extends Livro {
    private static final long serialVersionUID = 1L;
    String ISBN;
    float preco;

    public LivroAtual(String titulo, List<String> autores, String ISBN, float preco) {
        super(titulo, autores);
        this.ISBN = ISBN;
        this.preco = preco;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return super.toString()+ " => LivroAtual{" +
                "ISBN='" + ISBN + '\'' +
                ", preco=" + preco +
                "}";
    }
}
