package test;

import main.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaetaDeFuegoTest {
    private SaetaDeFuego saetaDeFuegoA;

    @BeforeEach
    void setUp(){
        saetaDeFuegoA=mock(SaetaDeFuego.class);
    }
    @Test
    void velocidadDeLaEScoba(){
        when(saetaDeFuegoA.velocidadDeLaEscoba()).thenReturn(100.0);
        assertEquals(saetaDeFuegoA.velocidadDeLaEscoba(),100.0);
    }

}
