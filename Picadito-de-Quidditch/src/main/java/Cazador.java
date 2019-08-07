
public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    Pelota pelota;

    public Cazador(Integer skill, Integer punteria, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return super.habilidad()+this.punteria*fuerza;
    }

    public void juega(){
        if(this.pelota.getTipo().equals("Quaffle")){
            this.intentarMeterGol();
        }
    }

    public void intentarMeterGol(){
    }

    public Boolean puedeBloquear(Jugador jugador){
        return this.lePasaElTrapo(jugador);
    }

    public void pierdeBloqueo(){
        this.skill=skill-2;
    }
}
