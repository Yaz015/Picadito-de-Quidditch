package main;

public class Cazador extends Jugador {
    private Double punteria;
    private Double fuerza;

    Cazador(Double peso, Escoba escobaDelJugador, Double skill) {
        super(peso, escobaDelJugador, skill);
    }
    public Double habilidad(){
        return velocidadDelJugador() + skill + punteria +fuerza;
    }

    public Boolean turnoCazador(Jugador jugador){

        return null;
    }
}
//Cazadores: su velocidad + sus skills + su puntería * su fuerza.
/*
El cazador cuando juega, si tiene la quaffle debe intentar meter gol, que implica:
● Evitar bloqueos: cada uno de los jugadores contrarios intenta bloquear el tiro del cazador, y en
caso de poder bloquearlo (ver 4.a) se interrumpe el tiro. Lógicamente en cuanto uno bloquea,
los jugadores restantes no deben seguir bloqueando.
● El equipo gana 10 puntos por meter gol.
● El cazador gana 5 puntos de skills
Si el tiro se interrumpe por un bloqueo, el cazador pierde 2 puntos de skills y el que bloqueó gana 10.
Independientemente de si pudo meter gol o si fue bloqueado, el cazador pierde la quaffle.
Siempre que un cazador pierde la quaffle, ésta es atrapada por el cazador rival más rápido.
 */