import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CazadorTest {
    Cazador cazador1;
    Cazador cazador2;
    SaetaDeFuego saeta;
    Nimbus nimbus;
    Equipo griffindor;
    Equipo slytheren;
    List<Jugador>cazadoresSlytheren= new ArrayList<>();

    @BeforeEach
    void setUp() {
        slytheren = new Equipo();
        griffindor = new Equipo();
        saeta = new SaetaDeFuego();
        nimbus = new Nimbus(1989, 80);
        cazador1 = new Cazador(5, 5, 50, saeta, griffindor);
        cazador2 = new Cazador(6, 6, 200, nimbus, slytheren);
        cazadoresSlytheren.add(cazador2);

    }

    @Test
    void testNoTenesQuaffle(){
        assertFalse(griffindor.pierdeQuaffle());
    }

    @Test
    void testMeteGol() {
        cazador1.meteGol();
        assertEquals(10, griffindor.puntosEquipo);
        assertEquals(205, cazador1.skill);
        assertFalse(griffindor.pierdeQuaffle());
    }
    @Test
    void testNoMeteGol(){
        cazador1.noMeteGol();
        assertEquals(198, cazador1.skill);
        assertFalse(griffindor.pierdeQuaffle());
    }

    @Test
    void testGolpeadoPorBludger(){
        cazador1.golpeadoPorBludger();
        assertEquals(198, cazador1.skill);
        assertFalse(griffindor.pierdeQuaffle());
        cazador2.golpeadoPorBludger();
        assertEquals(198, cazador2.skill);
        assertEquals(0.7, nimbus.getPorcentajeDeSalud());

    }

    @Test
    void testPuedeBloquear() {
        assertTrue(cazador1.puedeBloquear(cazador2));
    }

    @Test
    void testLepasaElTrapo() {
        assertTrue(cazador1.lePasaElTrapo(cazador2));
    }

    @Test
    void testHabilidad() {
        assertEquals(625, cazador1.habilidad());
        assertEquals(292, cazador2.habilidad());
    }
    @Test
    void testVelocidadCazador() {
        assertEquals(400, cazador1.velocidadDelJugador());
        assertEquals(56, cazador2.velocidadDelJugador());
    }

}
