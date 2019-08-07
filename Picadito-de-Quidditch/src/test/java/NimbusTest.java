
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NimbusTest {
    Nimbus nimbusA;
    @BeforeEach
    void setUp() {
        nimbusA= mock(Nimbus.class); }

    @Test
    void velocidadDeLaEscoba() {
        nimbusA=new Nimbus(1989, 80);
        assertEquals( 56, nimbusA.velocidadEscoba());
    }

    @Test
    void getPorcentajeDeSalud(){
        when(nimbusA.getPorcentajeDeSalud()).thenReturn(0.8);
        assertEquals(nimbusA.getPorcentajeDeSalud(), 0.8);
    }
}