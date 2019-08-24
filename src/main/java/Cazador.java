public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    private Integer nivelDeReflejos;

    public Cazador(Integer skill, Integer punteria, Integer fuerza, Integer peso,Integer nivelDeReflejos, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
        this.nivelDeReflejos=nivelDeReflejos;
    }

    public Integer habilidad(){
        return super.habilidad()+this.punteria*fuerza;
    }
    /** Cazador no mete gol, pierde 2 de skill, y pierde pelota**/
    public void noMeteGol() {
        this.skill = this.skill - 2;
        this.equipo.pierdeQuaffle();
    }
    /**Cazador mete gol y sube 5 skill, su equipo suma 10 puntos, y pierde pelota**/
    public void meteGol(){
        this.skill=this.skill+5;
        this.equipo.setPuntos(equipo.getPuntos()+10);
        this.equipo.pierdeQuaffle();
    }
    /** Cazador juega. Si tiene pelota, intenta meter gol**/
      public void juega(){
      if(this.equipo.tenesQuafflee()){
          this.intentarMeterGol();
      }
    }
    /** Si el equipo contrario puede bloquean al jugador, el cazador no mete gol, y el cazador mas rapido contrario tiene pelota y el que bloquea gana 10 de skill.
     Sino mete gol**/
    public void intentarMeterGol(){
        if ( equipo.equipoContrarioEvitaBloqueo(this)) {//evitar bloqueo
            this.noMeteGol();
            this.equipo.jugadorCazadorMasRapidoEquipoContrario().tenesQuaffle();
            this.equipo.jugadorQueBloqueaGana10(this);
        }else meteGol();
    }
    /** Puede bloquear si le pasa el trapo al otro jugador**/
    public Boolean puedeBloquear(Jugador jugador){ return this.lePasaElTrapo(jugador); }

    /** Jugador pierde pelota, su equipo no la tiene**/
    public Boolean pierdeQuaffle(){ return !this.equipo.tenesQuafflee();}

    /** Metodo sos Jugador**/
    public Boolean sosCazador(){ return true; }
    public Boolean sosBuscador() { return false; }
    public Boolean sosGuardian(){return false;}
    public Boolean sosGolpeador() { return false; }

    /** Es blanco util si no tiene la pelota**/
    public Boolean esBlancoUtil(){ return !this.equipo.tenesQuafflee(); }

    public Integer getNivelDeReflejos(){ return this.nivelDeReflejos; }
    /** Es golpeado por Blidger pierde 2 de skill y % de salud si es nimbus, en clase padre. Y el cazador pierde pelota**/
    public void golpeadoPorBludger(){
        super.golpeadoPorBludger();
        this.pierdeQuaffle();
    }
}
