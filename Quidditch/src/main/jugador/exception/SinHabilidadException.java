package main.jugador.exception;

public class SinHabilidadException extends RuntimeException {
    public SinHabilidadException(String mensaje) {
        super(mensaje);
    }
}
