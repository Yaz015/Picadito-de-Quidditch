import java.util.Random;
public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;
    private Integer randomNumber = 3;


    public Guardián(Integer skill, Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo) {
        super(peso, escoba, skill, equipo);
        this.nivelDeReflejos = nivelDeReflejos;
        this.fuerza = fuerza;
    }

    public Integer habilidad() {
        return super.habilidad() + this.nivelDeReflejos + this.fuerza;
    }

    public Boolean puedeBloquear(Jugador jugador) {
        this.setRandomNumber();
       // System.out.println(this.getRandomNumber());//sacar este print
        return 3 == this.getRandomNumber();
    }


    public void setRandomNumber(){
        Random ran=new Random();
        this.setRandomNumber((int)(ran.nextDouble()*3)+1);
    }

    public Boolean sosCazador(){
        return false;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Boolean esBlancoUtil(){
        return !this.equipo.tenesQuaffle();
    }

    public void juega(){

    }

    public void eligeUnBlancoUtil(){
        this.equipo.getRandomBlancoUtilEquipoContrario();
    }
}

