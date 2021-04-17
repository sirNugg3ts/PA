package pt.a2018019825.isec.elevador.logica.estados;

public class Piso1 extends EstadoAdapter {
    @Override
    public IEstado sobe() {
        return new Piso2();
    }

    @Override
    public IEstado desce() {
        return new RC();
    }
}
