package main;
public class Buscador extends Jugador { private Double nivelDeReflejos;
    private Double nivelDeVision;

    Buscador(Double peso, Escoba escobaDelJugador, Double skill) {
        super(peso, escobaDelJugador, skill);
    }
    public Double habilidad(){
        return velocidadDelJugador() + super.skill + nivelDeReflejos + nivelDeVision;
    }

    public Boolean turnoBuscador(Jugador jugador){
        return null;
    }
}
//Buscadores: su velocidad + sus skills + su nivel de reflejos * nivel de visión.
/*
El buscador cuando juega intenta obtener la snitch. Cuando comienza el partido los buscadores
arrancan buscando la snitch, si la encuentran deben perseguirla hasta atraparla.
Si el buscador está buscando la snitch, debe hacer un random entre 1 y 1.000 y si el número obtenido
es menor a su habilidad + la cantidad de turnos continuos buscando entonces encontró la snitch.
Si está persiguiendo la snitch, debe recorrer 5.000 kms para poder atraparla. En cada turno recorre
una cantidad de kms igual a su velocidad / 1,6. Una vez que la atrapó, aumenta sus skills 10 puntos y su
equipo gana 150 puntos.
 */