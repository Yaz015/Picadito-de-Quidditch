import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cazador extends Jugador {
        private Integer punteria;
        private Integer fuerza;
        private Pelota quaffle;
        protected Integer nivelDeReflejos=100;//se le asigna un valor igual 0 para poder codear golpeador

    public Cazador( Integer punteria, Integer fuerza, Integer peso, Escoba escobaDelJugador,Equipo equipo){
            super(peso, escobaDelJugador,equipo);
            this.setFuerza(fuerza);
            this.setPunteria(punteria);
        }
        public Integer nivelDeReflejos() {
            return this.nivelDeReflejos=100;
        }

        public Integer habilidad(){
            return super.velocidadDelJugador()+ super.getSkill() + this.getPunteria() * getFuerza();
        }

        public Boolean puedeBloquear(Cazador uncazador){
            return this.lePasaElTrapo(uncazador);
        }
// decidimos que si sale 1 tiene la pelota, sino no.
// Para eso hacemos un boolean  que responda a eso , llamando a un método que responde a un random

        public Integer randomPelota(){
            List<Integer> rango = IntStream.range(1,3).boxed().collect(Collectors.toList());
            Random rand = new Random();
            return rango.get(rand.nextInt(rango.size()));
        }
        public void setPelota(Pelota quaffle) {
            this.quaffle=quaffle ;
        }

        public void haceGol(){
            this.skill=skill+10;
            this.getEquipo().cazadorHaceGol();
        }

        public Boolean tenesQuaffle(){
            return super.equipo.tenesQuaffle();

        }

        public Boolean turnoCazador(){
            return this.getEquipo().jugadorRandom().equals(this);
        }

        public Boolean pierdeQuaffle()
        { return !super.equipo.tenesQuaffle() ;}

        /** Si es golpeado pierde 2 de skill y %de salud si tiene nimbus,en clase padre. En cazador tmb pierde la Pelota**/
        public void golpeadoPorBludger(){
            super.golpeadoPorBludger();
            this.pierdeQuaffle();
        }
        /** ES blanco util si pierde Pelota**/

        public Boolean esBlancoUtil(){
            return pierdeQuaffle();
        }

        /** metodos para que juegue si mete o no mete gol**/
        public void meteGol(Equipo equipoContrario) {
            super.skill = super.skill + 5;
            super.equipo.puntos= super.equipo.getPuntos()+ 10;
            this.pierdeQuaffle();
            equipoContrario.tenesQuaffle();
        }
        public void noMeteGol(Equipo equipoContrario) {
            this.skill = this.skill - 2;
            this.pierdeQuaffle();
            equipoContrario.tenesQuaffle();   }

        /** Juega contra un Equipo contrario, tiene la Pelota y si no es bloqueado, mete gol(sumando 5 de skill y 10 puntos a su equipo
         * si es bloqueado no mete gol, el bloqueador gana 2 de skill. El jugador que juega pierde pelota
         * y la gana el Cazador mas rapido contrario**/


        public void juega(){
        /*this.tenesQuaffle();
        if(!equipoContrario.puedenBloquear(this)){
            this.meteGol(equipoContrario);}
        else this.noMeteGol(equipoContrario);
        equipoContrario.jugadorQueBloquea(this);*/

        }

        public Boolean sosCazador(){
            return true;
        }

        public Integer getPunteria() {
            return punteria;
        }

        public void setPunteria(Integer punteria) {
            this.punteria = punteria;
        }

        public Integer getFuerza() {
            return fuerza;
        }

        public void setFuerza(Integer fuerza) {
            this.fuerza = fuerza;
        }




    }
