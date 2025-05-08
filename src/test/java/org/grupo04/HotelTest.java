package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la entidad Hotel.
 * <p>
 * Prueba los métodos de establecimiento y validación del nombre del hotel.
 * </p>
 */
public class HotelTest {

    /** Instancia de Hotel utilizada en las pruebas. */
    private Hotel hotel;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Crea una nueva instancia de Hotel.
     * </p>
     */
    @BeforeEach
    public void setUp() {
        hotel = new Hotel();
    }

    /**
     * Verifica que setName asigna correctamente un nombre válido.
     */
    @Test
    public void setName_Valido() {
        hotel.setName("Gran Hotel");
        assertEquals("Gran Hotel", hotel.getName());
    }

    /**
     * Verifica que setName lanza IllegalArgumentException si el nombre contiene números.
     */
    @Test
    public void setName_ContieneNumero() {
        assertThrows(IllegalArgumentException.class, () -> {
            hotel.setName("Hotel123");
        });
    }
}
