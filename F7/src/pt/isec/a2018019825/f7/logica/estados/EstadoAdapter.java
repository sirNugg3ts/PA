package pt.isec.a2018019825.f7.logica.estados;

import pt.isec.a2018019825.f7.logica.dados.Jogo;

public abstract class EstadoAdapter implements IEstado {

    protected Jogo jogo;

    protected EstadoAdapter(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public IEstado comeca() {
        return this;
    }

    @Override
    public IEstado aposta(int nBolas) {
        return this;
    }

    @Override
    public IEstado tira2BolasDoSaco() {
        return this;
    }

    @Override
    public IEstado removeBolaBrancadaPilha() {
        return this;
    }

    @Override
    public IEstado termina() {
        return this;
    }
}
