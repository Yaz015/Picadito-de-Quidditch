public class Guardian extends Jugador {
    private Double nivelDeReflejos;
    private Double fuerza;

    Guardian(Double peso, Escoba escobaDelJugador, Double skill) {
        super(peso, escobaDelJugador, skill);
    }
    public Double habilidad(){
        return velocidadDelJugador() + super.skill + nivelDeReflejos + fuerza;
    }
}
//Guardianes: su velocidad + sus skills + su nivel de reflejos + su fuerza.
//El guardián no hace nada en su turno, sólo participa activamente cuando hay que bloquear.