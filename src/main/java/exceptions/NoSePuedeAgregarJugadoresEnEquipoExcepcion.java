package exceptions;

public class NoSePuedeAgregarJugadoresEnEquipoExcepcion extends RuntimeException {
    /** No se pueden agregar mas jugadores porque son 7**/
    public NoSePuedeAgregarJugadoresEnEquipoExcepcion(String msj) {
        super(msj);
    }
}
