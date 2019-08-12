package main;

import exception.NoHaceNadaEnSuTurnoException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Guardian extends Jugador {
    private Double nivelDeReflejos;
    private Double fuerza;

    Guardian(Double peso, Escoba escobaDelJugador, Double skill) {
        super(peso, escobaDelJugador, skill);
    }
    public Double habilidad(){
        return velocidadDelJugador() + super.skill + nivelDeReflejos + fuerza;
    }

    public Boolean turnoGuardian( Jugador jugador)  {
        if(turnoGuardian(jugador)==false)
            throw new NoHaceNadaEnSuTurnoException("El guardián no hace nada en su turno");
        return null;
    }
    public Integer randomDeBloqueo(){
        List<Integer> rango = IntStream.range(1,4).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    public Boolean puedeBloquear(Cazador uncazador){
        return this.randomDeBloqueo().equals(3);
    }


    public Boolean esBlancoUtil(){
        return !this.getEquipo().tenesQuaffle();
    }

}
//Guardianes: su velocidad + sus skills + su nivel de reflejos + su fuerza.
//El guardián no hace nada en su turno, sólo participa activamente cuando hay que bloquear.