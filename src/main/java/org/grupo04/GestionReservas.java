package org.grupo04;

import java.util.ArrayList;

public class GestionReservas {
    private ArrayList<Reserva> reservas;

    public GestionReservas() {
        reservas = new ArrayList<Reserva>();
    }

    /**
     * Da la info de la reserva en la posicion indicadda
     */
    public Reserva get(int posicion) {
        if (posicion < 0 || posicion >= reservas.size()) {
            return null;
        }
        return reservas.get(posicion);
    }

    /**
     * Añadir una nueva reserva
     */
    public boolean add(Reserva reserva) {
        if (reserva == null) {
            return false;
        }
        return reservas.add(reserva);
    }

    /**
     * Eliminar una reserva
     */
    public boolean remove(int posicion) {
        if (posicion < 0 || posicion >= reservas.size()) {
            return false;
        }
        reservas.remove(posicion);
        return true;
    }

    /**
     * Cambiar la fecha de entrada de una reserva
     */
    //null
}
