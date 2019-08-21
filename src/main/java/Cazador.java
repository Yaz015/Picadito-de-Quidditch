public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    Pelota quaffle;
    public Cazador( Integer punteria, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }
    public Integer habilidad(){
        return (this.punteria*this.fuerza)+super.skill+ this.velocidadDelJugador(); }
    public Integer velocidadDelJugador(){
        return (int)(super.velocidadDeEscoba() * super.nivelManejoDeEscoba()); }
    /** Seteamos nivel de reflejos, aunq no tenia el cazador, porque es requisito si es golpeado x bludger**/
    public Integer nivelDeReflejos;
    public Integer nivelDeReflejos() {
        return this.nivelDeReflejos=10000;
    }

    public Boolean puedeBloquear(Jugador jugador){
        return this.lePasaElTrapo(jugador);
    }
    /** Si es cazador param etodo jugador mas rápido**/
    public Boolean sosCazador(){
        return true;
    }
    /** Boolean para ver si tiene o no quaffle**/
    //public Boolean pierdeQuaffle(){ return super.equipo.randomPelota().equals(2) ;}
   // public Boolean tenesQuaffle(){ return super.equipo.randomPelota().equals(1);}
    /** Si es golpeado pierde 2 de skill y %de salud si tiene nimbus,en clase padre. En cazador tmb pierde la Quaffle**/
    public void golpeadoPorBludger(){
        super.golpeadoPorBludger();
            this.equipo.pierdeQuaffle();
        }
    /** ES blanco util si pierde Quaffle**/
    public Boolean esBlancoUtil(){
        return equipo.pierdeQuaffle();
    }
    /** metodos para que juegue si mete o no mete gol**/
    public void meteGol() {
        super.skill = super.skill + 5;
        super.equipo.puntosEquipo = super.equipo.puntosEquipo + 10;
        super.equipo.pierdeQuaffle();

    }
    public void noMeteGol() {
        super.skill = super.skill - 2;
        super.equipo.pierdeQuaffle(); }
    /** Juega contra un Equipo contrario, tiene la Quaffle y si no es bloqueado, mete gol(sumando 5 de skill y 10 puntos a su equipo
     * si es bloqueado no mete gol, el bloqueador gana 2 de skill. El jugador que juega pierde pelota
     * y la gana el Cazador mas rapido contrario**/

    public void juegaContra(Equipo equipoContrario){
        if( this.equipo.tenesQuaffle()== true &&!equipoContrario.puedenBloquear(this)){
            this.meteGol();
            equipo.jugadorCazadorMasRapidoEquipoContrario(equipoContrario).tenesQuaffle();}
        else this.noMeteGol();
        this.jugadorQueEsBloqueado(equipoContrario);
        equipo.jugadorCazadorMasRapidoEquipoContrario(equipoContrario).tenesQuaffle();
            }}

