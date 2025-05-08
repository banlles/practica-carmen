// src/test/java/org/grupo04/ReservaTest.java
package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
    private Reserva reserva;

    @BeforeEach
    public void setUp() {
        reserva = new Reserva();
    }

    @Test
    public void setNombreHuesped_Valido() {
        reserva.setNombreHuesped("Ana María");
        assertEquals("Ana María", reserva.getNombreHuesped());
    }

    @Test
    public void setNombreHuesped_ContieneNumero() {
        assertThrows(IllegalArgumentException.class, () -> {
            reserva.setNombreHuesped("Ana1");
        });
    }
}

