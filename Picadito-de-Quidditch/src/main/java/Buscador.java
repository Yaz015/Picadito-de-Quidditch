
public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;
    private static String Clase="Buscador";

    public Buscador(Integer skill, Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba,skill, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.nivelDeVision=nivelDeVision;
    }

    public Integer habilidad(){
        return super.habilidad()+this.nivelDeReflejos*this.nivelDeVision;
    }

    public Boolean puedeBloquear(){
        return false;
    }

    public Boolean sosCazador(){
        return false;
    }
}
