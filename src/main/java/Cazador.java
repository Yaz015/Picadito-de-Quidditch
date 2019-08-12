public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    Pelota quaffle;


    public Cazador(Integer skill, Integer punteria, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return super.habilidad()+this.punteria*fuerza;
    }

    public void juega(){
        if(this.equipo.tenesQuaffle()){
            this.intentarMeterGol();
        }
    }

    public void intentarMeterGol(){
        if(this.equipo.equipoContrarioEvitaBloqueo(this)){
            this.pierdeBloqueo();
        }
        else this.meteGol();//evitar bloqueo
    }

    public Boolean puedeBloquear(Jugador jugador){
        return this.lePasaElTrapo(jugador);
    }

    public void pierdeBloqueo(){
        this.skill=skill-2;
    }

    public Boolean sosCazador(){
        return true;
    }

    public Boolean esBlancoUtil(){
        return !this.equipo.tenesQuaffle();
    }

    public void meteGol() {
        this.skill = this.skill + 5;
        this.equipo.puntosEquipo = equipo.puntosEquipo + 10;}

    public void noMeteGol() {
        this.skill = this.skill - 2;
    }
    public void jugaContra(Equipo equipoContrario){
        equipo.getPelota();
        if(this.equipo.tenesQuaffle().equals(true) && !equipoContrario.puedenBloquear(this)){
            this.meteGol();
            equipoContrario.getPelota();
        } else
            this.noMeteGol();
        equipoContrario.getPelota();
        equipoContrario.jugadorQueBloquea(this);} }