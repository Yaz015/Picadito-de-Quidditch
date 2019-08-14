import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NimbusTest {
    Nimbus nimbusA;
    @BeforeEach
    void setUp() {
        nimbusA= new Nimbus(2001,80); }

    @Test
    void testVelocidadDeLaEscoba() {
        assertEquals( 49, nimbusA.velocidadEscoba());
        //80 - this.cantAñosDesdeFabricacion())*this.getPorcentajeDeSalud()
        //redondea para abajo ?
    }
    @Test
    void testCantAñosDesdeFabricacion(){
        assertEquals(18, nimbusA.cantAñosDesdeFabricacion());
    }
    @Test
    void testGetPorcentajeDeSalud(){
        assertEquals(nimbusA.getPorcentajeDeSalud(), 0.8);
    }
}