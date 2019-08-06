package main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;
    private Double kilometros = 0.0;

    Buscador(Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escobaDelJugador, Equipo equipo) {
        super(peso, escobaDelJugador, equipo);
        this.nivelDeReflejos = nivelDeReflejos;
        this.nivelDeVision = nivelDeVision;
    }

    public Integer habilidad() {
        return this.velocidadDelJugador() + this.getSkill() + this.nivelDeReflejos * this.nivelDeVision;
    }

    public Boolean puedeBloquear(Cazador uncazador) {
        return false;

    }

    public Integer randomSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    //no no esta saliendo \

    public Boolean encontroSnitch = false;


    public void tuTurnoBuscador() {
        if (this.kilometros == 5000.0) {
            this.encontroSnitch = true;
        } else
            this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;

    }

    public void encuentraSnitch() {
        if (this.randomSnitch() < this.habilidad()) //+los turnos{
            this.encontroSnitch = true;
        }
    }
}
