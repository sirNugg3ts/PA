package pt.isec.a2018019825.Biblioteca.modelo;

import java.util.List;

public class LivroAntigo extends Livro {
    private static final long serialVersionUID = 1L;
    int nrCopias;

    public LivroAntigo(String titulo, List<String> autores, int copias) {
        super(titulo, autores);
        nrCopias = copias;
    }

    public int getNrCopias() {
        return nrCopias;
    }

    public void setNrCopias(int nrCopias) {
        this.nrCopias = nrCopias;
    }

    @Override
    public String toString() {
        return super.toString()+" => LivroAntigo{" +
                "nrCopias=" + nrCopias +
                "}";
    }
}
