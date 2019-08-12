package test;

import main.java.Buscador;
import main.java.Cazador;
import main.java.Equipo;
import main.java.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.omg.CORBA.UserException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

        class EquipoTest {
        Equipo griffindor;
        Equipo slytheren;
        Cazador cazador;
        Buscador buscador;

        @BeforeEach
        void setUp(){
            griffindor = new Equipo();
            slytheren = new Equipo();
            cazador=mock(Cazador.class);
            buscador=mock(Buscador.class);

            griffindor.agregarJugador(cazador);
            slytheren.agregarJugador(buscador);

        }
            @Test
            void testTieneJugadorEstrella(){
                when(cazador.lePasaElTrapo(slytheren.mejorJugador())).thenReturn(true);
                assertTrue(griffindor.tieneJugadorEstrellaContra(slytheren));
            }
            @Test
            void testSumadeHabilidades(){
            griffindor.agregarJugador(buscador);
            griffindor.agregarJugador(cazador);
            when(buscador.habilidad()).thenReturn(50.0);
            when(cazador.habilidad()).thenReturn(10.0);
            assertEquals(60 ,griffindor.sumaDeHabilidadesDeJugadores());
        }

            @Test
             void testPromedioDeHabilidades(){
            griffindor.agregarJugador(buscador);
            griffindor.agregarJugador(cazador);
            when(cazador.habilidad()).thenReturn(50.0);
            when(buscador.habilidad()).thenReturn(10.0);
            assertEquals(30, griffindor.promedioDeHabilidades());
        }



        @Test
        void testCantJugadoresEnEquipo(){
            griffindor.agregarJugador(cazador);
            griffindor.agregarJugador(buscador);
            assertEquals(2, griffindor.cantDeJugadoresEnEquipo());
        }

}