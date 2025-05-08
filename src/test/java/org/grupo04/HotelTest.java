// src/test/java/org/grupo04/HotelTest.java
package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelTest {
    private Hotel hotel;

    @BeforeEach
    public void setUp() {
        hotel = new Hotel();
    }

    @Test
    public void setName_Valido() {
        hotel.setName("Gran Hotel");
        assertEquals("Gran Hotel", hotel.getName());
    }

    @Test
    public void setName_ContieneNumero() {
        assertThrows(IllegalArgumentException.class, () -> {
            hotel.setName("Hotel123");
        });
    }
}
