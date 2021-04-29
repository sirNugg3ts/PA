package sequencias.logica.estados;


import sequencias.logica.dados.JogoDados;

import java.io.Serializable;

public abstract class EstadoAdapter implements IEstado {
    protected JogoDados jogoDados;

    protected EstadoAdapter(JogoDados j) {
        this.jogoDados = j;
    }
}
