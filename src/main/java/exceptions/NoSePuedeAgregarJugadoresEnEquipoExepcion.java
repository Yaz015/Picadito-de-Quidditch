package exceptions;

public class NoSePuedeAgregarJugadoresEnEquipoExepcion extends RuntimeException {
    public NoSePuedeAgregarJugadoresEnEquipoExepcion(String msj) {
        super(msj);
    }
}
