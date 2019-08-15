import exceptions.NoHayJugadoresEnEquipoException;
import exceptions.NoSePuedeAgregarJugadoresEnEquipoExepcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EquipoTest {
    Equipo griffindor;
    Equipo slytheren;
    Cazador cazadorA;
    Cazador cazadorB;
    Cazador cazadorC;
    Cazador cazadorD;
    Buscador buscador;
    Guardian guardian;
    Golpeador golpeadorA;
    Golpeador golpeadorB;


    @BeforeEach
    void setUp(){
        griffindor = new Equipo();
        slytheren = new Equipo();
        cazadorA=mock(Cazador.class);
        cazadorB=mock(Cazador.class);
        cazadorC=mock(Cazador.class);
        cazadorD=mock(Cazador.class);
        buscador=mock(Buscador.class);
        guardian =mock(Guardian.class);
        golpeadorA=mock(Golpeador.class);
        golpeadorB=mock(Golpeador.class);
    }

    @Test
    void testSumadeHabilidades(){
        griffindor.agregarJugador(buscador);
        griffindor.agregarJugador(cazadorA);
        when(buscador.habilidad()).thenReturn(50);
        when(cazadorA.habilidad()).thenReturn(10);
        assertEquals(60 ,griffindor.sumaDeHabilidadesDeJugadores());
    }

    @Test
    void testPromedioDeHabilidades(){
        griffindor.agregarJugador(buscador);
        griffindor.agregarJugador(cazadorA);
        when(cazadorA.habilidad()).thenReturn(50);
        when(buscador.habilidad()).thenReturn(10);
        assertEquals(30, griffindor.promedioDeHabilidades());
    }

    @Test
    void testTieneJugadorEstrella(){
        griffindor.agregarJugador(cazadorA);
        slytheren.agregarJugador(buscador);
        when(cazadorA.lePasaElTrapo(slytheren.mejorJugador())).thenReturn(true);
        assertTrue(griffindor.tieneJugadorEstrella(slytheren));
    }

    @Test
    void testCantJugadoresEnEquipo(){
        griffindor.agregarJugador(cazadorA);
        griffindor.agregarJugador(buscador);
        assertEquals(2, griffindor.cantDeJugadoresEnEquipo());
    }

    @Test
    void testListaDeCazadores(){
        when(cazadorA.sosCazador()).thenReturn(true);
        when(cazadorB.sosCazador()).thenReturn(true);
        when(cazadorC.sosCazador()).thenReturn(true);
        slytheren.agregarJugador(cazadorC);
        slytheren.agregarJugador(cazadorB);
        slytheren.agregarJugador(cazadorA);
        assertEquals(3, slytheren.listaDeCazadores().size());
    }

    //Exepciones
    @Test
    void testForListaVacia(){
        assertThrows(NoHayJugadoresEnEquipoException.class,() ->griffindor.cantDeJugadoresEnEquipo());
    }
    @Test
    void testNoSePuedeAgrgarGuardian(){
        when(guardian.sosGuardian()).thenReturn(true);
        griffindor.agregarJugador(guardian);
        assertThrows(NoSePuedeAgregarJugadoresEnEquipoExepcion.class, ()-> griffindor.agregarJugador(guardian));
    }

    @Test
    void testForNoSePuedeAgregarCazadores() {
        when(cazadorA.sosCazador()).thenReturn(true);
        when(cazadorB.sosCazador()).thenReturn(true);
        when(cazadorC.sosCazador()).thenReturn(true);
        when(cazadorD.sosCazador()).thenReturn(true);
        griffindor.agregarJugador(cazadorA);
        griffindor.agregarJugador(cazadorB);
        griffindor.agregarJugador(cazadorC);
        assertThrows(NoSePuedeAgregarJugadoresEnEquipoExepcion.class,() ->griffindor.agregarJugador(cazadorD));
    }

}