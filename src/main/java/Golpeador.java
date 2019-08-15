import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


    public Boolean sosBuscador() {
        return false;
    }

    public Boolean sosGuardian(){return false;}

    public Boolean sosGolpeador() {
        return true;
    }
    ///

    public Boolean esBlancoUtil(){
        return false;//No es útil golpear golpeadores.????
    }

    public void juega(){
        //cuando juega elige un blanco útil
    }

    public Jugador blancoUtilRandomDeGuardian(){
      return  this.equipo.getRandomBlancoUtilEquipoContrario();
    }

    public Boolean puedeGolpearBlanco(){
        return this.punteria>this.blancoUtilRandomDeGuardian().getNivelDeReflejos() || 8>=this.randomNumber();
    }

    public Integer getNivelDeReflejos(){
        return 0;
    }

    public Integer randomNumber(){
        List<Integer> rango = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
}
