package main;

    public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;

    Jugador(Integer peso, Escoba escobaDelJugador, Integer skill){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
        this.skill=skill;
    }

    public Boolean lePasaElTrapo(Jugador jugador){ return jugador.habilidad() <= this.habilidad();}

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

    public Integer habilidad(){
        return this.habilidad();
    }
}

