public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;
    protected Equipo equipo;
    static MercadoDeEscobas mercadoDeEscobas = new MercadoDeEscobas();

    public Jugador(Integer peso, Escoba escobaDelJugador, Equipo equipo) {
        this.peso = peso;
        this.escobaDelJugador = escobaDelJugador;
        this.skill = 200;
        this.equipo = equipo;
    }

    public Boolean lePasaElTrapo(Jugador jugador) {
        return (jugador.habilidad() * 2.0) < this.habilidad();
    }

    public Boolean esGroso() {
        return this.habilidad() > this.equipo.promedioDeHabilidades()
                && this.velocidadDelJugador() > mercadoDeEscobas.getNumeroAleatorio();
    }

    public Escoba escobaDelJugador() {
        return this.escobaDelJugador;
    }

    public Double nivelManejoDeEscoba() {
        return (double) this.skill / this.peso;
    }
    public Integer velocidadDeEscoba() {
        return this.escobaDelJugador().velocidadEscoba();
    }

    /** Metodos abstractos, para diferenciar en cada jugador**/
    public abstract Integer velocidadDelJugador();

    public abstract Integer habilidad();

    public abstract Boolean puedeBloquear(Jugador jugador);

    public abstract Boolean sosCazador();

    public abstract Boolean esBlancoUtil();

    /** Para todo jugador se cumplem que pierde 2 de skill, y % de salud si es nimbus**/

    public void golpeadoPorBludger() {
        this.skill = this.skill - 2;
        this.escobaDelJugador().escobaGolpeada();
        }

    public abstract void juegaContra(Equipo equipoContrario);

    public abstract Integer nivelDeReflejos();
    public void jugadorQueEsBloqueado(Equipo equipoContrario){
        if (equipoContrario.puedenBloquear(this)) {
            equipoContrario.jugador.skill= equipoContrario.jugador.skill+10;
        }}

    public Boolean tenesQuaffle(){ return this.equipo.tenesQuaffleRandom();}
    }




