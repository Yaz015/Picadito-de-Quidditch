import exceptions.NoEsUtilGolpearGolpeadoresException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    public Golpeador( Integer fuerza, Integer punteria, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }
    public Integer habilidad(){
        return super.skill+ this.velocidadDelJugador()+this.punteria+this.fuerza;
    }
    public Integer velocidadDelJugador(){
        return (int)(super.velocidadDeEscoba() * super.nivelManejoDeEscoba()); }
    /** Si es groso bloquea**/
    public Boolean puedeBloquear(Jugador jugador){
        return this.esGroso();
    }
    /** seteo nivel de reflejos porque es requisito del metodo golpeadoXbudgler**/
    public Integer nivelDeReflejos;
    public Integer nivelDeReflejos() {
        return this.nivelDeReflejos=100;
    }
    /** NO es cazador, para metodo jugadorCazador mas rapido**/
    public Boolean sosCazador(){
        return false;
    }
    /** NO es blanco util**/
    public Boolean esBlancoUtil(){
        return false;//No es útil golpear golpeadores.????
    }
    /** Excepcion porque no es util golpear golpeadores**/
    public void golpeadoPorBludger() {
        if (esBlancoUtil() == false)
            throw new NoEsUtilGolpearGolpeadoresException("No se puede golpear a golpeadores");
    }
    /** Ramdom para metodo si puede golpear a otro**/
    public Integer randomGolpea(){
        List<Integer> rango = IntStream.range(1,11).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    /** Golpea si tiene mayor su punteria que un random de blanco utiles o si sale un random >=8**/
    public Boolean puedeGolpearAotro(Jugador jugador){
        if(this.punteria>this.equipo.getRandomBlancoUtilEquipoContrario().nivelDeReflejos() ||
                this.randomGolpea()>=8){ return true;} else return false; }

    /**Juega contra equipo contrario, elige blanco util, y lo golpea, suma 1 de skill**/
    public void juegaContra(){
        if(this.puedeGolpearAotro(equipo.equipoContrario.getRandomBlancoUtil())); {
            equipo.equipoContrario.blancoUtilDelRandom().golpeadoPorBludger();
            super.skill=super.skill+1;
        }
    }
}
