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
        //80 - this.cantAniosDesdeFabricacion())*this.getPorcentajeDeSalud()
        //redondea para abajo ?
    }
    @Test
    void testCantAniosDesdeFabricacion(){
        assertEquals(18, nimbusA.cantAniosDesdeFabricacion());
    }
    @Test
    void testGetPorcentajeDeSalud(){ assertEquals(0.8, nimbusA.getPorcentajeDeSalud());
    }
}