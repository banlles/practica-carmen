// src/test/java/org/grupo04/EmpleadoTest.java
package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
    private Empleado emp;

    @BeforeEach
    public void setUp() {
        emp = new Empleado();
    }

    @Test
    public void setNombre_Valido() {
        emp.setNombre("Maria");
        assertEquals("Maria", emp.getNombre());
    }

    @Test
    public void setNombre_ContieneNumero() {
        assertThrows(IllegalArgumentException.class, () -> {
            emp.setNombre("Maria2");
        });
    }
}

