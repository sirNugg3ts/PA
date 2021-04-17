package pt.a2018019825.isec.elevador.logica.estados;

public class RC extends EstadoAdapter {
    @Override
    public IEstado sobe() {
        return new Piso1();
    }
}
