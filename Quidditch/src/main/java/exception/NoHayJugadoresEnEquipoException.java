package exception;

public class NoHayJugadoresEnEquipoException extends RuntimeException {
    public NoHayJugadoresEnEquipoException(String mensaje) {
        super(mensaje);
    }
}
