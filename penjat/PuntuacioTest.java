package penjat;

import com.jaume.penjat.Puntuacio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PuntuacioTest {
    
    private Puntuacio intents;

    public PuntuacioTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        this.intents = new Puntuacio();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void getParaulaSecretaDificultat1(){
        int dificultat = 1;
        intents.getParaulaSecretaDificultat(dificultat);
        assertEquals(5,this.intents.getIntents());
    }

    @Test
    void getParaulaSecretaDificultat2(){
        int dificultat = 2;
        intents.getParaulaSecretaDificultat(dificultat);
        assertEquals(4,this.intents.getIntents());
    }

    @Test
    void getParaulaSecretaDificultat3(){
        int dificultat = 3;
        intents.getParaulaSecretaDificultat(dificultat);
        assertEquals(3,this.intents.getIntents());
    }

    @Test
    void calcularPuntuacio(){
        //No se per on agafar aquest Test
    }
}
