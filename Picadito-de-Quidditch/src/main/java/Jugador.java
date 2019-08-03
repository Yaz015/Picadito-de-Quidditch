package main.java;

public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;
    protected Equipo equipo;
    static Integer numAleatorio=200;

    public Jugador(Integer peso, Escoba escobaDelJugador, Integer skill, Equipo equipo){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
        this.skill=skill;
        this.equipo=equipo;
    }

    public Boolean lePasaElTrapo(Jugador jugador){ return (this.habilidad())>(jugador.habilidad()*2);}

    public Boolean esGroso() {
        return this.habilidad()>this.equipo.promedioDeHabilidades()
               && this.velocidadDelJugador()> this.numAleatorio;
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

    public Integer habilidad(){return this.velocidadDelJugador()+this.skill;}

    public void actualizarMercado(){
        this.numAleatorio++;
    }
}

