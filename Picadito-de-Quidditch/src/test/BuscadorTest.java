package test;

import main.Buscador;
import main.Equipo;
import main.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuscadorTest {

        public Buscador buscador;
        private Buscador buscador1;
        private Equipo griffindor;
        private Equipo slitheryn;
        private SaetaDeFuego saeta;

        @BeforeEach
        void setUp() {
            saeta = new SaetaDeFuego();
            griffindor = new Equipo();
            buscador = new Buscador(100, 110, 150,  saeta, griffindor);
            buscador1 = new Buscador(10, 10, 10,  saeta, griffindor);
            slitheryn= new Equipo();
        }

       /* @Test
        void testManejoDeEscoba() {
            assertEquals(1.1111111111111112, buscador.nivelManejoDeEscoba());
            //skills del jugador / su peso.
        }*/

        @Test
        void testVelocidadDelJugador() {
            assertEquals(111, buscador.velocidadDelJugador());
        }

        @Test
        void testHabilidad() {
            assertEquals(16711, buscador.habilidad());
            //su velocidad + sus skills + su nivel de reflejos * nivel de visión
        }

        @Test
        void testLePasaElTrapo() {
            assertTrue(buscador.lePasaElTrapo(buscador1));
        }

        @Test
        void testEsGroso() {
            griffindor.agregarJugador(buscador);
            griffindor.agregarJugador(buscador1);
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
        void testTurnos(){
            buscador.juegaContra(slitheryn);
            assertEquals(1, buscador.getTurnosBuscando());
        }
    }

