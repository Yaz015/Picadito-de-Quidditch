package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MercadoDeEscobas {
    private Integer numeroAleatorio=5;
    private int longitud=100;
    private List<Integer> list= new ArrayList<>(longitud);

    public Integer getNumeroAleatorio(){
        return this.numeroAleatorio;
    }

    public int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public void actualizarMercado(){
        this.numeroAleatorio=getRandomElement(this.list);
    }
}
