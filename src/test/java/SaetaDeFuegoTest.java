import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaetaDeFuegoTest {
    private SaetaDeFuego saetaDeFuegoA;

    @BeforeEach
    void setUp(){
        saetaDeFuegoA= new SaetaDeFuego();
    }

    @Test
    void velocidadDeLaEScoba(){
        assertEquals(100,saetaDeFuegoA.velocidadEscoba());
    }
}