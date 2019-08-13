public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;
    protected Equipo equipo;
    static MercadoDeEscobas mercadoDeEscobas=new MercadoDeEscobas();

    public Jugador(Integer peso, Escoba escobaDelJugador, Equipo equipo){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
        this.skill=200;
        this.equipo=equipo;
    }

    public Boolean lePasaElTrapo(Jugador jugador){ return (jugador.habilidad()*2.0)<this.habilidad();}

    public Boolean esGroso() {
        return this.habilidad()> this.equipo.promedioDeHabilidades()
               && this.velocidadDelJugador()> mercadoDeEscobas.getNumeroAleatorio();
    }

    public  Escoba escobaDelJugador() { return this.escobaDelJugador; }

    public Double nivelManejoDeEscoba() {
        return (double)this.skill / this.peso;
    }

    public abstract Integer velocidadDelJugador();
    //{ return (int)(this.velocidadDeEscoba() * this.nivelManejoDeEscoba()); }

    public Integer velocidadDeEscoba() {
        return this.escobaDelJugador().velocidadEscoba();
    }

    public abstract Integer habilidad();
    //{return this.velocidadDelJugador()+this.skill;}

    public abstract Boolean puedeBloquear(Jugador jugador);

    public abstract Boolean sosCazador();

    public abstract Boolean esBlancoUtil();

    public void golpeadoPorBludger(){
        this.skill=this.skill-2;
        if (this.escobaDelJugador.getTipo().equals("Nimbus")){
            this.escobaDelJugador.pierdeSalud();
        }
    }

}

