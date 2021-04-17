package pt.a2018019825.isec.elevador.logica.estados;

public class Piso2 extends EstadoAdapter {
    @Override
    public IEstado desce() {
        return new Piso1();
    }
}
