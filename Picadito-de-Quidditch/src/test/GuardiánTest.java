package test;

import main.java.Equipo;
import main.java.Guardián;
import main.java.Jugador;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.BeforeEach;

//import static org.junit.jupiter.api.Assertions.*;

class GuardiánTest {
    Jugador guardianEquipoAzul;
    SaetaDeFuego saetaDeFuegoA;
    Equipo griffindor;

    @Test
    void testVelocidadDelJugador(){
        guardianEquipoAzul=new Guardián(100,100,100.0, saetaDeFuegoA,griffindor);
        saetaDeFuegoA=new SaetaDeFuego();
        guardianEquipoAzul.skill=200.0;
        guardianEquipoAzul.velocidadDeEscoba();
        guardianEquipoAzul.nivelManejoDeEscoba();
        assertEquals(100, guardianEquipoAzul.velocidadDelJugador());}
    @Test
    void velocidadDeEscoba(){
        saetaDeFuegoA=new SaetaDeFuego();
        guardianEquipoAzul=new Guardián(100,100,100.0, saetaDeFuegoA,griffindor);
        assertEquals(saetaDeFuegoA.velocidadDeLaEscoba(),100.0);}
    }


    /*void habilidad(){
    assertEquals(400.0, guardianEquipoAzul.habilidad());
}}*/
