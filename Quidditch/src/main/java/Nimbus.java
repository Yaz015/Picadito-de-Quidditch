import java.util.Calendar;

public class Nimbus implements Escoba {
    private Double Salud=100.00;
    @Override
    public Double velocidadDeLaEscoba() {
        return (80-Salud)*Calendar.getInstance().get(Calendar.YEAR);
    }



}
