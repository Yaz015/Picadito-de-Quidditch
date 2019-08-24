public abstract class Jugador {
    protected Integer peso;
    protected Escoba escobaDelJugador;
    protected Integer skill;
    protected Equipo equipo;
    static MercadoDeEscobas mercadoDeEscobas=new MercadoDeEscobas();
    /** Constructor para todos los jugadores, con especificaciones en cada jugador**/
    public Jugador(Integer peso, Escoba escobaDelJugador, Integer skill, Equipo equipo){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
        this.skill=skill;
        this.equipo=equipo;
    }
    /** Jugador le pasa el trapo su la habilidad es el doble que el otro jugador**/
    public Boolean lePasaElTrapo(Jugador jugador){ return (jugador.habilidad()*2.0)<this.habilidad();}
    /** Es groso si su habilidad es mayor al promedio de habilidades del equipo contrario y su velocidad es mayor a un numero Arbitrario del mercado de escoba**/
    public Boolean esGroso() {
        return this.habilidad()> this.equipo.promedioDeHabilidades()
               && this.velocidadDelJugador()> this.mercadoDeEscobas.getNumeroArbitrario();
    }
    /** La escoba de cada jugador**/
    public  Escoba escobaDelJugador() { return this.escobaDelJugador; }
    /** Nivel de manejo es cada skill sobre su peso**/
    public Double nivelManejoDeEscoba() {
        return (double)this.skill / this.peso;
    }
    /** Velociad de jugador es igual a la velocidad de la escoba por el nivel de manejo**/
    public Integer velocidadDelJugador() {
        return (int)(this.velocidadDeEscoba() * this.nivelManejoDeEscoba());
    }
    public Integer velocidadDeEscoba() {
        return this.escobaDelJugador().velocidadEscoba();
    }
    /** habilidad del jugador, y en cada jugador tiene especificaciones**/
    public Integer habilidad(){return this.velocidadDelJugador()+this.skill;}

    /** Metodos abstractos especificador en cada jugador**/
    public abstract Boolean puedeBloquear(Jugador jugador);

    public abstract Boolean sosCazador();
    public abstract Boolean sosBuscador();
    public abstract Boolean sosGuardian();
    public abstract Boolean sosGolpeador();
    public abstract Boolean esBlancoUtil();
    public abstract  void juega();
    public abstract Integer getNivelDeReflejos();

    /** Golpeado por bludger el jugador pierde 2 de skill y la escoba si es nimbus pierde porcentaje de salud**/
    public void golpeadoPorBludger(){
        this.skill=this.skill-2;
        this.escobaDelJugador.pierdeSalud();
    }
    /** Si jugador tiene pelota**/
    public Boolean tenesQuaffle(){ return true;}}

