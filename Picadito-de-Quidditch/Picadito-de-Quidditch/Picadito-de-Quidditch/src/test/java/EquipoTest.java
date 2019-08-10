import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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

    }

    @Test
    void testSumadeHabilidades(){
        griffindor.agregarJugador(buscador);
        griffindor.agregarJugador(cazador);
        when(buscador.habilidad()).thenReturn(50);
        when(cazador.habilidad()).thenReturn(10);
        assertEquals(60 ,griffindor.sumaDeHabilidadesDeJugadores());
    }

    @Test
    void testPromedioDeHabilidades(){
        griffindor.agregarJugador(buscador);
        griffindor.agregarJugador(cazador);
        when(cazador.habilidad()).thenReturn(50);
        when(buscador.habilidad()).thenReturn(10);
        assertEquals(30, griffindor.promedioDeHabilidades());
    }

    @Test
    void testTieneJugadorEstrella(){
        griffindor.agregarJugador(cazador);
        slytheren.agregarJugador(buscador);
        when(cazador.lePasaElTrapo(slytheren.mejorJugador())).thenReturn(true);
        assertTrue(griffindor.tieneJugadorEstrella(slytheren));
    }

    @Test
    void testCantJugadoresEnEquipo(){
        griffindor.agregarJugador(cazador);
        griffindor.agregarJugador(buscador);
        assertEquals(2, griffindor.cantDeJugadoresEnEquipo());
    }

    @Test
    void testForListaVacia(){
       griffindor.cantDeJugadoresEnEquipo();
    }
}