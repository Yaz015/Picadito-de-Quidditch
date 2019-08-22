import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {
        protected Integer nivelDeReflejos;
        protected Integer nivelDeVision;
        protected Double kilometros = 0.0;
        protected Boolean encontroSnitch=false;
        private Integer turnosBuscando=0;
        private Boolean estaAturdido=false;



    public Buscador(Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escobaDelJugador, Equipo equipo) {
            super(peso, escobaDelJugador, equipo);
            this.nivelDeReflejos = nivelDeReflejos;
            this.nivelDeVision = nivelDeVision;
        }
        public Integer nivelDeReflejos() {
            return this.nivelDeReflejos();
        }

        public Integer habilidad() {
            return super.velocidadDelJugador() + super.getSkill() + this.nivelDeReflejos * this.nivelDeVision;
        }

        public Boolean puedeBloquear(Jugador uncazador) {
            return false;

        }

        public Integer randomSnitch() {
            List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
            Random rand = new Random();
            return rango.get(rand.nextInt(rango.size()));
        }
        public void persiguiendoLaSnitch() {
            this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;
            if (this.kilometros >= 5000.0) {
                this.atrapoSnitch();
            }
        }
        //no no esta saliendo \ ver la idea de turno como el momento de jugar

        public void buscandoSnitch(){
            if (this.encontroSnitch==false){
                if( this.randomSnitch() < (this.habilidad()+ this.turnosBuscando))
                    this.setTurno(this.turnosBuscando + 1);{
                    this.encontroSnitch=true;

                }
            }
        }
        public void juega(){
            if(this.estaAturdido){
                System.out.println("Este jugador pierde su turno porque está aturdidio");
                this.estaAturdido=false;
            }else if(this.estaAturdido=false&&this.encontroSnitch==false) {
                this.buscandoSnitch();
                this.setTurnosBuscando(this.getTurnosBuscando()+1);}
            else if(this.encontroSnitch==true){
                this.persiguiendoLaSnitch();
            }
        }

        public Boolean atrapoSnitch(){
            return this.encontroSnitch&&this.getKilometros()>=5000;

        }

        public void GolpeadoPorBludger(){
            super.skill=skill-2 ;
            this.getEscobaDelJugador().escobaGolpeada();
            this.kilometros=0.0;
        }

        public Boolean puedeBloquear(){
            return false;
        }


        public Boolean esBlancoUtil(){
            return !this.encontroSnitch||this.kilometros>4001;
        }

        public Double getKilometros() {
            return kilometros;
        }

        public void setKilometros(Double kilometros) {
            this.kilometros = kilometros;
        }

        public Integer getTurnosBuscando() {
            return turnosBuscando;
        }

        public void setTurnosBuscando(Integer turnosBuscando) {
            this.turnosBuscando = turnosBuscando;
        }
    }


