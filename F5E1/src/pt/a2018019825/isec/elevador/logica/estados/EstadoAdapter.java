package pt.a2018019825.isec.elevador.logica.estados;

public class EstadoAdapter implements IEstado {

    @Override
    public IEstado sobe() {
        return this;
    }

    @Override
    public IEstado desce() {
        return this;
    }
}
