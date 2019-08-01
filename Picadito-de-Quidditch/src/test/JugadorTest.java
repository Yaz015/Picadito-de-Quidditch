package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {
    private Guardián guardianEquipoAzul;
    private Cazador cazadorEquipoAzul1;
    private Cazador cazadorEquipoAzul2;
    private Cazador cazadorEquipoAzul3;
    private Escoba saetaDeFuegoA;
    private Escoba nimbusA;
    private Escoba nimbusB;


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
   /* void escobaDelJUgador(){
        when(cazadorEquipoAzul1.escobaDelJugador()).thenReturn(saetaDeFuegoA);
        }
        assertEquals()*/
    void lePasaElTrapo(){
        when(cazadorEquipoAzul1.habilidad()).thenReturn(80.0);
        when(guardianEquipoAzul.habilidad()).thenReturn(30.0);
        assertFalse(cazadorEquipoAzul1.lePasaElTrapo(guardianEquipoAzul));}}



