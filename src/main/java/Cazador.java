public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    private Integer nivelDeReflejos;
    Pelota quaffle;


    public Cazador(Integer skill, Integer punteria, Integer fuerza, Integer peso,Integer nivelDeReflejos, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
        this.nivelDeReflejos=nivelDeReflejos;
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

    ///Metodos Sos
    public Boolean sosCazador(){
        return true;
    }
    public Boolean sosBuscador() { return false; }
    public Boolean sosGuardian(){return false;}
    public Boolean sosGolpeador() { return false; }
    ///

    public Boolean esBlancoUtil(){
        return !this.equipo.tenesQuaffle();
    }

    public void meteGol(){
        this.skill=this.skill+5;
    }

    public Integer getNivelDeReflejos(){
        return this.nivelDeReflejos;
    }
}
