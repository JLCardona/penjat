package test;

import com.jaume.penjat.Tauler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaulerTest {

    private Tauler tauler;

    /**
     * Reinicia la partida.
     */
    @BeforeEach
    void reiniciar(){
        this.tauler = new Tauler();
        this.tauler.inicialitzarPartida("paraula", 4);
    }

    /**
     * Inizialitza la paraula secreta a endevinar.
     */
    @Test
    void inicialitzarPartidaParaulaSecreta() {
        assertArrayEquals(new char[]{'p', 'a', 'r', 'a', 'u', 'l', 'a'}, this.tauler.getParaulaSecreta());
    }

    /**
     * Inizialitza el nombre de intents (vides) que té el jugador per guanyar.
     */
    @Test
    void inicialitzarPartidaNombreIntents() {
        assertEquals(4, this.tauler.getIntents());
    }

    /**
     * Mostra un missatge de error en cas de que el jugador hagi posat més de 1 lletra a la vegada per endevinar.
     */
    @Test
    void verificarEntradaIncorrecte() {
        assertEquals("Lletra incorrecte",this.tauler.verificar("ll"));
    }

    /**
     * En cas de que el jugador acerti una lletra, se mostrarà les lletres endevinades dins la paraula secreta.
     */
    @Test
    void verificarEntradaCorrecteEncertat() {
        this.tauler.verificar("a");
        assertArrayEquals(new String[]{ null,"a",null,"a",null,null,"a" },this.tauler.getPalabraEndevinada());
    }

    /**
     * Indica les vides del jugador després de verificar la lletra que hagi posat.
     */
    @Test
    void verificarEntradaCorrecteErrada() {
        this.tauler.verificar("n");
        assertEquals(3,this.tauler.getIntents());
    }

    /**
     * Mostra la paraula completament amagada en cas de no haver-hi encertat la lletra.
     */
    @Test
    void imprimirCapEncert() {
        assertEquals("_______", this.tauler.imprimir());
    }

    /**
     * Mostra la paraula amb les lletres encertades.
     */
    @Test
    void imprimirAmbLletres() {
        this.tauler.verificar("a");
        assertEquals("_a_a__a", this.tauler.imprimir());
    }

    /**
     * Mostra la paraula cencera al haber-la encertada.
     */
    @Test
    void imprimirTotEncertat() {
        this.tauler.verificar("a");
        this.tauler.verificar("p");
        this.tauler.verificar("r");
        this.tauler.verificar("u");
        this.tauler.verificar("l");
        assertEquals("paraula", this.tauler.imprimir());
    }


    /**
     * Mostra un missatge amb les vides en plural que té el jugador (més de 1).
     */
    @Test
    void imprimirVidesPlural() {
        assertEquals("Et queden 4 vides de 4", this.tauler.imprimirVides());
    }

    /**
     * Mostra un missatge amb la vida que li queda al jugador (1).
     */
    @Test
    void imprimirVidesSingular() {
        this.tauler.verificar("n");
        this.tauler.verificar("n");
        this.tauler.verificar("n");
        assertEquals("Et queda 1 vida de 4", this.tauler.imprimirVides());
    }

    /**
     * Resta les vides que té el jugador cada vegada que no encerta la lletra.
     */
    @Test
    void restarIntents() {
        this.tauler.verificar("n");
        assertEquals(3, this.tauler.getIntents());
    }

    /**
     * En cas de encertar la paraula, el jugador haurà guanyat el joc.
     */
    @Test
    void hasGuanyatTrue() {
        this.tauler.verificar("a");
        this.tauler.verificar("p");
        this.tauler.verificar("r");
        this.tauler.verificar("u");
        this.tauler.verificar("l");
        assertTrue(this.tauler.hasGuanyat());
    }

    /**
     * Si encara no ha endevinat la paraula cencera, no haurà guanyat.
     */
    @Test
    void hasGuanyatFalse() {
        assertFalse(this.tauler.hasGuanyat());
    }
}