public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    public Golpeador(Integer skill, Integer fuerza, Integer punteria, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return super.habilidad()+this.punteria+this.fuerza;
    }

    public Boolean puedeBloquear(Jugador jugador){
        return this.esGroso();
    }

    ///Metodos Sos
    public Boolean sosCazador(){
        return false;
    }
    public Boolean sosGuardian(){return false;}
    ///

    public Boolean esBlancoUtil(){
        return false;//No es útil golpear golpeadores.????
    }

    public void juega(){
        //cuando juega elige un blanco útil
    }
}
