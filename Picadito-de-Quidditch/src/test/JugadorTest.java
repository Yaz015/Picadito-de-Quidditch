package test;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {
    private Guardián guardianEquipoAzul;
    private Jugador cazadorEquipoAzul1;
    private Cazador cazadorEquipoAzul2;
    private Cazador cazadorEquipoAzul3;
    private SaetaDeFuego saetaDeFuegoA;
    private Nimbus nimbusA;
    private Nimbus nimbusB;
    //private Jugador guardianEquipoAzul;
    private Equipo griffindor;

    @BeforeEach
    void setUp() {
        saetaDeFuegoA = mock(SaetaDeFuego.class);// new SaetaDeFuego();
        nimbusA = mock(Nimbus.class); // new Nimbus(1970,80);
        nimbusB = mock(Nimbus.class); //new Nimbus(1990,90);
        cazadorEquipoAzul1 = mock(Cazador.class); //new Cazador(12,12,70.0, saetaDeFuegoA);
        cazadorEquipoAzul2 = mock(Cazador.class);//new Cazador(11,10,65.0, nimbusA);
        cazadorEquipoAzul3 = mock(Cazador.class);//new Cazador(10,11,65.0,nimbusB);
        guardianEquipoAzul = mock(Guardián.class);//new Guardián(8,6,70.0,nimbusA);

    }

    @Test
    void lePasaElTrapo(){
        //cazadorEquipoAzul1=new Cazador(5,5,50.0,saetaDeFuegoA);
        //saetaDeFuegoA=new SaetaDeFuego();
        //guardianEquipoAzul=new Guardián(5,6,65.0,nimbusA);
        //nimbusA=new Nimbus(1970, 80);
        when(cazadorEquipoAzul1.habilidad()).thenReturn(200.0);
        when(guardianEquipoAzul.habilidad()).thenReturn(50.0);
        assertTrue(cazadorEquipoAzul1.lePasaElTrapo(guardianEquipoAzul));}
    @Test
    void habilidad(){
       /* cazadorEquipoAzul1=new Cazador(5,5,50.0,saetaDeFuegoA);
        saetaDeFuegoA=new SaetaDeFuego();
       assertEquals(400,cazadorEquipoAzul1.habilidad());*/

       guardianEquipoAzul=new Guardián(5,5,100.0,nimbusA,griffindor);
       nimbusA=new Nimbus(1989,80);
       assertEquals(guardianEquipoAzul.habilidad(),424.0);

   }
   @Test
   void nivelDeManejoEscoba(){
       cazadorEquipoAzul1=new Cazador(5,5,50.0,saetaDeFuegoA, griffindor);
       assertEquals(cazadorEquipoAzul1.nivelManejoDeEscoba(),4.0);
       guardianEquipoAzul=new Guardián(5,5,100.0,nimbusA,griffindor);
       assertEquals(guardianEquipoAzul.nivelManejoDeEscoba(),2.0);

   }
   @Test
    void velocidadDelJugador() {
        nimbusA=new Nimbus(1989,80);
        guardianEquipoAzul=new Guardián(5,5,50.0,nimbusA, griffindor);
        assertEquals(guardianEquipoAzul.velocidadDelJugador(), 224.0);
        saetaDeFuegoA=new SaetaDeFuego()    ;
        cazadorEquipoAzul1=new Cazador(5,5,50.0,saetaDeFuegoA, griffindor);
        assertEquals(cazadorEquipoAzul1.velocidadDelJugador(),400);}
    @Test
   void velocidadEscoba(){
      saetaDeFuegoA=new SaetaDeFuego();
       assertEquals(saetaDeFuegoA.velocidadDeLaEscoba(),100.0);
      nimbusA=new Nimbus(1989,80);
       assertEquals(nimbusA.velocidadDeLaEscoba(), 56.0);}
    }



