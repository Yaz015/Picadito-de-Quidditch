package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {
    private Guardián guardianEquipoAzul;
    private Cazador cazadorEquipoAzul1;
    private Cazador cazadorEquipoAzul2;
    private Cazador cazadorEquipoAzul3;
    private SaetaDeFuego saetaDeFuegoA;
    private Nimbus nimbusA;
    private Nimbus nimbusB;
    //private Jugador guardianEquipoAzul;

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
        //cazadorEquipoAzul1=new Cazador(5,8,70.0,saetaDeFuegoA, 100.0);
        //saetaDeFuegoA=new SaetaDeFuego();
        //guardianEquipoAzul=new Guardián(5,6,55.0,nimbusA,100.0);
        //nimbusA=new Nimbus(1989, 80);
        when(cazadorEquipoAzul1.habilidad()).thenReturn(200.0);
        when(guardianEquipoAzul.habilidad()).thenReturn(50.0);
        assertTrue(cazadorEquipoAzul1.lePasaElTrapo(guardianEquipoAzul));}
    @Test
    void habilidad(){
       cazadorEquipoAzul1=new Cazador(5,5,50.0, saetaDeFuegoA, 100.0);
        saetaDeFuegoA=new SaetaDeFuego();
       //when(cazadorEquipoAzul1.velocidadDelJugador()).thenReturn(100.0);
       assertEquals(cazadorEquipoAzul1.habilidad(), 125.0);
     /* guardianEquipoAzul=new Guardián(5,5,50.0,nimbusA,200.0);
       nimbusA=new Nimbus(1989,80);
       assertEquals(guardianEquipoAzul.habilidad(),424.0);*/

   }
   @Test
    void velocidadDelJugador() {
        nimbusA=new Nimbus(1989,80);
        guardianEquipoAzul=new Guardián(5,5,50.0,nimbusA, 200.0);
        assertEquals(guardianEquipoAzul.velocidadDelJugador(), 112.0);}
    @Test
   void velocidadEscoba(){
      saetaDeFuegoA=new SaetaDeFuego();
       assertEquals(saetaDeFuegoA.velocidadDeLaEscoba(),100.0);
      nimbusA=new Nimbus(1989,80);
       assertEquals(nimbusA.velocidadDeLaEscoba(), 56.0);}
    }



