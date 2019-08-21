import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GolpeadorTest {
    Golpeador golpeador1;
    Golpeador golpeador2;
    Nimbus nimbus;
    SaetaDeFuego saeta;
    Equipo griffindor;
    Equipo slytheren;
    @BeforeEach
    void setUp(){
        slytheren=new Equipo();
        griffindor= new Equipo();
        saeta= new SaetaDeFuego();
        nimbus=new Nimbus(1989,80);
        golpeador1= new Golpeador(200,100, 100,100, saeta, griffindor);
        golpeador2= new Golpeador(200,10,10, 10, nimbus, slytheren);
    }


    @Test
    void testLepasaElTrapo(){
        assertFalse(golpeador2.lePasaElTrapo(golpeador1));
    }

    @Test
    void testHabilidad(){
        assertEquals(600,golpeador1.habilidad());
        assertEquals(1020,golpeador2.habilidad());
        //su velocidad + sus skills + su puntería + su fuerza.
    }
    @Test
    void testVelocidadGolpeador(){
        assertEquals(200,golpeador1.velocidadDelJugador());
        assertEquals(800,golpeador2.velocidadDelJugador());}
        //La velocidad se calcula como 80 - la cantidad de años desde su fabricación por el porcentaje de salud de la misma.

    @Test
    void testVelocidadEscoba() {
        assertEquals(100, golpeador1.velocidadDeEscoba());
        assertEquals(40, golpeador2.velocidadDeEscoba());
    }
}
