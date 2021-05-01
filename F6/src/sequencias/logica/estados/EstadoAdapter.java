package sequencias.logica.estados;


import sequencias.logica.Situacao;
import sequencias.logica.dados.JogoDados;

import java.io.Serializable;

public abstract class EstadoAdapter implements IEstado {
    protected JogoDados jogoDados;

    protected EstadoAdapter(JogoDados j) {
        this.jogoDados = j;
    }

    @Override
    public IEstado comecar() {
        return this;
    }

    @Override
    public IEstado recolher(int indice) {
        return this;
    }

    @Override
    public IEstado relancar() {
        return this;
    }

    @Override
    public IEstado avaliar() {
        return this;
    }

    @Override
    public IEstado terminar() {
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return this.getSituacaoAtual();
    }

    //Implementacoes por omissao dos metodos
}
