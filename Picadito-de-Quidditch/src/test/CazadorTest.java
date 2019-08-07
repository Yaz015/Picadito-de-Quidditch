package test;

import main.java.Cazador;
import main.java.Equipo;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CazadorTest {
    Cazador cazadorEquipoAzul1;
    SaetaDeFuego saetaDeFuegoA;
    Equipo griffindor;

   @BeforeEach
   void setUp(){
        griffindor= new Equipo();
        cazadorEquipoAzul1= new Cazador(5,5,50.0, saetaDeFuegoA, griffindor);
        saetaDeFuegoA= new SaetaDeFuego();
        cazadorEquipoAzul1.skill=200.0;}

    @Test
    void habilidad(){
        //assertEquals(cazadorEquipoAzul1.nivelManejoDeEscoba(), 4.0);
        assertEquals(saetaDeFuegoA.velocidadDeLaEscoba(), 100.0);
        assertEquals(cazadorEquipoAzul1.velocidadDelJugador(), 224.0);
        //cazadorEquipoAzul1.velocidadDelJugador();
        //saetaDeFuegoA.velocidadDeLaEscoba();
        assertEquals(cazadorEquipoAzul1.habilidad(), 449);
    }

}
