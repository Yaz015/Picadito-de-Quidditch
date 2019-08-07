public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;
    protected Equipo equipo;
    static MercadoDeEscobas mercadoDeEscobas=new MercadoDeEscobas();

    public Jugador(Integer peso, Escoba escobaDelJugador, Integer skill, Equipo equipo){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
        this.skill=skill;
        this.equipo=equipo;
    }

    public Boolean lePasaElTrapo(Jugador jugador){ return (jugador.habilidad()*2.0)<this.habilidad();}

    public Boolean esGroso() {
        return this.habilidad()>this.equipo.promedioDeHabilidades()
               && this.velocidadDelJugador()> mercadoDeEscobas.getNumeroAleatorio();
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

    public Boolean puedeBloquear(Jugador jugador){
      return   this.puedeBloquear(jugador);
    }
}

