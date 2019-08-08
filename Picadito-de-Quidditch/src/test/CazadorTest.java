package test;

import main.java.Cazador;
import main.java.Equipo;
import main.java.Nimbus;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CazadorTest {
    Cazador cazador1;
    Cazador cazador2;
    SaetaDeFuego saetaDeFuegoA;
    Nimbus nimbus;
    Equipo griffindor;
    Equipo slytheren;
   @BeforeEach
   void setUp(){
        slytheren=new Equipo();
        griffindor= new Equipo();
        saetaDeFuegoA= new SaetaDeFuego();
        nimbus=new Nimbus(1989,80);
        cazador1= new Cazador(5,5,50.0, saetaDeFuegoA, griffindor);
        cazador2= new Cazador(6,6,200.0, nimbus, slytheren);}
        //cazadorEquipoAzul1.skill=200.0;}
        //saetaDeFuegoA.velocidadDeLaEscoba();

    @Test
    void testLepasaElTrapo(){
       assertTrue(cazador1.lePasaElTrapo(cazador2));

    }
    @Test
    void testHabilidad(){
       assertEquals(625,cazador1.habilidad());
       assertEquals(292,cazador2.habilidad());
    }
    @Test
    void testVelocidadCazador(){
       assertEquals(400,cazador1.velocidadDelJugador());
       assertEquals(56,cazador2.velocidadDelJugador());}


}
