package org.grupo04;

import java.util.ArrayList;

public class GestionReservas {
    private ArrayList<Reserva> reservas;

    public GestionReservas() {
        reservas = new ArrayList<Reserva>();
    }

    /**
     * Para dar la info de una reserva en concreto
     * @param posicion La posición de la que se devolvera la información
     * @return Devolvera la información de la reserva
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
    public boolean cambiarFechaEntrada(int posicion, String nuevaFechaEntrada) {
        Reserva reserva = get(posicion);
        if (reserva == null) {
            return false;
        }
        reserva.setFechaEntrada(nuevaFechaEntrada);
        return true;
    }

    /**
     * Cambiar la fecha de salida de una reserva
     */
    public boolean cambiarFechaSalida(int posicion, String nuevaFechaSalida) {
        Reserva reserva = get(posicion);
        if (reserva == null) {
            return false;
        }
        reserva.setFechaSalida(nuevaFechaSalida);
        return true;
    }

    /**
     * Listar todas las reservas
     */
    public ArrayList<Reserva> listarTodas() {
        return reservas;
    }
}
