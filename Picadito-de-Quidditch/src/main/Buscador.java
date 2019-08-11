package main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {
    private Integer nivelDeReflejos;
    private Integer nivelDeVision;
    private Double kilometros = 0.0;
    private Boolean encuentraSnitch=false;

    Buscador(Integer nivelDeReflejos, Integer nivelDeVision, Integer peso, Escoba escobaDelJugador, Equipo equipo) {
        super(peso, escobaDelJugador, equipo);
        this.nivelDeReflejos = nivelDeReflejos;
        this.nivelDeVision = nivelDeVision;
    }

    public Integer habilidad() {
        return this.velocidadDelJugador() + this.getSkill() + this.nivelDeReflejos * this.nivelDeVision;
    }

    public Boolean puedeBloquear(Cazador uncazador) {
        return false;

    }

    public Integer randomSnitch() {
        List<Integer> rango = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    //no no esta saliendo \ ver la idea de turno como el momento de jugar

    public void buscandoSnitch(){
        if (this.encuentraSnitch==false){
           if( this.randomSnitch() < (this.habilidad()+ this.getTurno()))
               this.setTurno(this.getTurno() + 1);{
                   this.encuentraSnitch=true;

           }
        }
    }
    public void juegaBuscador(){
        this.buscandoSnitch();
    }

    public Boolean atrapoSnitch(){
        return this.encuentraSnitch&&this.getKilometros()>=5000;
    }

    public void esGolpeadoPorBludger(){
        this.skill=-2 ;
        this.getEscobaDelJugador().escobaGolpeada();
        this.kilometros=5000.0;
    }

  /*  public Boolean encontroSnitch = false;

  public void buscandoSnitch(){
        if (!atrapoSnitch())
        this.setKilometros(this.getKilometros() + velocidadDelJugador() / 1.6);
        if (this.kilometros>=5000) {this.atrapoSnitch();}
    }

    public void buscaSnitch() {
        if (this.kilometros == 5000.0) {
            this.encontroSnitch = true;
        } else
            this.kilometros = this.kilometros + velocidadDelJugador() / 1.6;

    }*/

    public Boolean puedeBloquear(){
        return false;
    }


    public Boolean buscadorBlancoUtil(){
        return !this.encuentraSnitch||this.kilometros<4001;
       }

    public Double getKilometros() {
        return kilometros;
    }

    public void setKilometros(Double kilometros) {
        this.kilometros = kilometros;
    }
}
