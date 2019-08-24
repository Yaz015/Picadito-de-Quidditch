package exceptions;

public class NoHayJugadoresEnEquipoException extends RuntimeException {
    /** Si no hay jugadores en equipo**/
    public NoHayJugadoresEnEquipoException(String msj) {
        super(msj);
    }
}
