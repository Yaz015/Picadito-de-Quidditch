import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;
    private Jugador blancoUtilElegido;

    public Golpeador(Integer skill, Integer fuerza, Integer punteria, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, skill, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }
    /*** Su habilidad es igual a su skill + velocidad del jugador. Mas la punteria y fuerza**/
    public Integer habilidad(){
        return super.habilidad()+this.punteria+this.fuerza;
    }
    /** Golpeador bloquea si es groso**/
    public Boolean puedeBloquear(Jugador jugador){
        return this.esGroso();
    }
    /** No es util golpear golpeadores, es falo**/
    public Boolean esBlancoUtil(){
        return false;
    }
    /** Golpeador que juega, elije blanco util. Si lo puede golpear, gana 2 de skill, y el blanco util es golpeado**/
    public void juega(){
        this.eligeBlancoUtilRandomDeGolpeador();
        if(this.puedeGolpearBlanco()){
            this.skill++;
            this.blancoUtilElegido.golpeadoPorBludger();
        }
    }
    /** Elije un blanco util**/
    public void eligeBlancoUtilRandomDeGolpeador(){
        this.blancoUtilElegido=this.equipo.getRandomBlancoUtilEquipoContrario();
    }
    /** Puede golpear y su punteria es mayor, al nivel de reflejos del blancoutil o en un randmon sale por lo menos 8**/
    public Boolean puedeGolpearBlanco(){
        return this.punteria>this.blancoUtilElegido.getNivelDeReflejos() || 8>=this.randomNumber();
    }

    public Integer getNivelDeReflejos(){
        return 0;
    }
    /** Random para metodo puedeGolpearBlanco()**/
    public Integer randomNumber(){
        List<Integer> rango = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    /** Metodo sos Jugador**/
    public Boolean sosCazador(){ return false; }
    public Boolean sosBuscador() { return false; }
    public Boolean sosGuardian(){return false;}
    public Boolean sosGolpeador() { return true; }
}
