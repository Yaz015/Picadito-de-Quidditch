package main;

public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;

    Jugador(Integer peso, Escoba escobaDelJugador){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
    }

    public Escoba escobaDelJugador() {
        return this.escobaDelJugador;
    }

    public Integer nivelManejoDeEscoba() {
        return (this.skill / this.peso);
    }

    public Integer velocidadDelJugador() {
        return this.velocidadDeEscoba() * this.nivelManejoDeEscoba();
    }

    public Integer velocidadDeEscoba() {
        return this.escobaDelJugador().velocidadEscoba();
    }
    public Boolean lePasaElTrapo(Jugador jugador){ return jugador.habilidad()<=this.habilidad()/2;}

    /**Si un jugador es groso, que se cumple si su habilidad es mayor al promedio de su
 equipo y su velocidad mayor a un valor arbitrario(KEEEEEEEEJAJA) que a medida que el mercado de
 escobas mejora se actualiza para todos por igual.**/

    public Boolean esGroso() { return
            this.habilidad() > jugadores.stream()
                    .map( j -> j.habilidad()).reduce( 0, Integer::sum );

    }}

}

