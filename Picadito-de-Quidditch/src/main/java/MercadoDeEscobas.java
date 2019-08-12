package main.java;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public  class MercadoDeEscobas {
    private Integer numeroAleatorio=100;
    private int longitud=100;
    private Integer añoDeCreacion=2019;
    // private List<Integer> list= new ArrayList<>(longitud);

    public Integer getNumeroAleatorio(){
        return this.numeroAleatorio;
    }

    public Integer añoActual(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    public Integer difDeAnios(){
        return añoActual()-añoDeCreacion;
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
