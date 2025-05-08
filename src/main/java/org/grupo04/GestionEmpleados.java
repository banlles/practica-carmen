package org.grupo04;

import java.util.ArrayList;

public class GestionEmpleados {
    private ArrayList<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<Empleado>();
    }

    /**
     * Da la info del empleadpo en la posiscion indicadda
     */
    public Empleado get(int posicion) {
        if (posicion < 0 || posicion >= empleados.size()) {
            return null;
        }
        return empleados.get(posicion);
    }

    /**
     * Añadi un nuevo empleadpo
     */
    public boolean add(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        return empleados.add(empleado);
    }

    /**
     * Eliminar un empleadpo
     */
    public boolean remove(int posicion) {
        if (posicion < 0 || posicion >= empleados.size()) {
            return false;
        }
        empleados.remove(posicion);
        return true;
    }

    /**
     * Cambiar nombre del empleadpo
     */
    public boolean cambiarNombre(int posicion, String nuevoNombre) {
        Empleado e = get(posicion);
        if (e == null) {
            return false;
        }
        e.setNombre(nuevoNombre);
        return true;
    }

    /**
     * Listar todos los empleadpos
     */
    public ArrayList<Empleado> listarTodos() {
        return empleados;
    }
}
