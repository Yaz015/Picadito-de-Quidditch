import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NimbusTest {
    private SaetaDeFuego saetaDeFuegoA;

    @BeforeEach
    void setUp(){
        saetaDeFuegoA=mock(SaetaDeFuego.class);
    }

    @Test
    void velocidadDeLaEScoba(){
        when(saetaDeFuegoA.velocidadEscoba()).thenReturn(100);
        assertEquals(100,saetaDeFuegoA.velocidadEscoba());
    }
}

