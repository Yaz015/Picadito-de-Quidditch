package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public  class MercadoDeEscobas {
        private Integer numeroAleatorio=100;
        private int longitud=100;
        private Integer anioDeCreacion=2019;
       // private List<Integer> list= new ArrayList<>(longitud);

        public Integer getNumeroAleatorio(){
            return this.numeroAleatorio;
        }

       // public int getRandomElement(List<Integer> list)
        {
          //  Random rand = new Random();
         //   return list.get(rand.nextInt(list.size()));
        }
     //Los intervalos de números (rangos) son colecciones que pueden crearse como:
       // List<Integer> rango = IntStream.range(1, numeroAleatorio).boxed().collect(Collectors.toList());


       // public void actualizarMercado() {
           // this.numeroAleatorio=getRandomElement(this.list);
    //
    public Integer añoActual(){
           return Calendar.getInstance().get(Calendar.YEAR);

       }

       public Integer difDeAnios(){
        return añoActual()-anioDeCreacion;
       }
    public Integer actualizarMercadoDeEscobas(){
        return numeroAleatorio+difDeAnios();
    }

    public boolean debeActualizarMercadodeEscobas(){
       return difDeAnios()>0;


    }
    public Integer numeroArbitrario(){
        return getNumeroAleatorio()+difDeAnios();
    }


}





