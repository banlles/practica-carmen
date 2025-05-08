package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la entidad Reserva.
 * <p>
 * Prueba los métodos de establecimiento y validación del nombre del huésped en una reserva.
 * </p>
 */
public class ReservaTest {

    /** Instancia de Reserva utilizada en las pruebas. */
    private Reserva reserva;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Crea una nueva instancia de Reserva.
     * </p>
     */
    @BeforeEach
    public void setUp() {
        reserva = new Reserva();
    }

    /**
     * Verifica que setNombreHuesped asigna correctamente un nombre válido.
     */
    @Test
    public void setNombreHuesped_Valido() {
        reserva.setNombreHuesped("Ana María");
        assertEquals("Ana María", reserva.getNombreHuesped());
    }

    /**
     * Verifica que setNombreHuesped lanza IllegalArgumentException si el nombre contiene números.
     */
    @Test
    public void setNombreHuesped_ContieneNumero() {
        assertThrows(IllegalArgumentException.class, () -> {
            reserva.setNombreHuesped("Ana1");
        });
    }
}
