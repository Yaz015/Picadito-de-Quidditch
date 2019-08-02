package main.java;

    public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;
    protected Equipo equipo;
    protected MercadoDeEscobas mercadoDeEscobas;

    public Jugador(Integer peso, Escoba escobaDelJugador, Integer skill, Equipo equipo){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
        this.skill=skill;
        this.equipo=equipo;
    }

    public Boolean lePasaElTrapo(Jugador jugador){ return jugador.habilidad() <= this.habilidad();}

    public Boolean esGroso() {
        return this.habilidad()>this.equipo.promedioDeHabilidades()
               && this.velocidadDelJugador()> this.mercadoDeEscobas.getNumeroAleatorio();
    }

    public Escoba escobaDelJugador() {
        return this.escobaDelJugador;
    }

    public Double nivelManejoDeEscoba() {
        return (double)this.skill / this.peso;
    }

    public Integer velocidadDelJugador() {
        return (int)(this.velocidadDeEscoba() * this.nivelManejoDeEscoba());
    }

    public Integer velocidadDeEscoba() {
        return this.escobaDelJugador().velocidadEscoba();
    }

    public Integer habilidad(){return velocidadDelJugador()+ skill;}
}

