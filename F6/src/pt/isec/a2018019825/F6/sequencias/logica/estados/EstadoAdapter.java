package pt.isec.a2018019825.F6.sequencias.logica.estados;


import pt.isec.a2018019825.F6.sequencias.logica.dados.JogoDados;

public abstract class EstadoAdapter implements IEstado {
    protected JogoDados jogoDados;

    protected EstadoAdapter(JogoDados j) {
        this.jogoDados = j;
    }
}
