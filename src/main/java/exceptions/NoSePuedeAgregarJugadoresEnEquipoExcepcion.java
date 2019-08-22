package exceptions;

public class NoSePuedeAgregarJugadoresEnEquipoExcepcion extends RuntimeException {
    public NoSePuedeAgregarJugadoresEnEquipoExcepcion(String msj) {
        super(msj);
    }
}
