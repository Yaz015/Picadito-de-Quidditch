import java.util.Random;
public class Guardian extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;
    private Integer randomNumber = 3;


    public Guardian(Integer skill, Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo) {
        super(peso, escoba, skill, equipo);
        this.setNivelDeReflejos(nivelDeReflejos);
        this.fuerza = fuerza;
    }

    public Integer habilidad() {
        return super.habilidad() + this.getNivelDeReflejos() + this.fuerza;
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

    ///Metodos Sos
    public Boolean sosCazador(){
        return false;
    }
    public Boolean sosBuscador() { return false;}
    public Boolean sosGuardian(){return true;}
    public Boolean sosGolpeador() { return false;}
    ///

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Boolean esBlancoUtil(){
        return !this.equipo.tenesQuaffle();
    }

    public void juega(){ }

    public void eligeUnBlancoUtil(){
        this.equipo.getRandomBlancoUtilEquipoContrario();
    }

    public Integer getNivelDeReflejos() {
        return nivelDeReflejos;
    }

    public void setNivelDeReflejos(Integer nivelDeReflejos) {
        this.nivelDeReflejos = nivelDeReflejos;
    }
}

