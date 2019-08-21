import exceptions.ElJuegoHaTerminadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuscadorTest {
    private Buscador buscador;
    private Buscador buscador1;
    private Equipo griffindor;
    private Equipo slytherin;
    private SaetaDeFuego saeta;
    private Cazador cazador;

    @BeforeEach
    void setUp() {
        saeta = new SaetaDeFuego();
        griffindor = new Equipo();
        slytherin=new Equipo();
        buscador = new Buscador(10000, 110, 150, 90, saeta, griffindor);
        buscador1 = new Buscador(10, 10, 10, 10, saeta, griffindor);
        cazador=new Cazador(100,50, 30, 80,12, saeta, griffindor);
    }

    @Test
    void testManejoDeEscoba() {
        assertEquals(111.11111111111112, buscador.nivelManejoDeEscoba());
        //skills del jugador / su peso.
    }

    @Test
    void testVelocidadDelJugador() {
        assertEquals(11111, buscador.velocidadDelJugador());
    }

    @Test
    void testHabilidad() {
        assertEquals(37611, buscador.habilidad());
        //su velocidad + sus skills + su nivel de reflejos * nivel de visión
    }

    @Test
    void testLePasaElTrapo() {
        assertTrue(buscador.lePasaElTrapo(buscador1));
    }

    @Test
    void testEsGroso() {
        griffindor.agregarJugador(buscador);
        griffindor.agregarJugador(cazador);
        assertTrue(buscador.esGroso());
    }

    @Test
    void testPuedeBloquear() {
        assertFalse(buscador.puedeBloquear(buscador));
    }

    @Test
    void testEsBlancoUtil(){
        assertTrue(buscador.esBlancoUtil());
    }

    @Test
    void testTurnos() throws ElJuegoHaTerminadoException {
        buscador.juega();
        assertEquals(1, buscador.getTurnosBuscando());
    }

    @Test
    void testBuscadorAtrapaSnitch(){
        assertThrows(ElJuegoHaTerminadoException.class,() ->buscador.atrapaSnitch());
    }
}