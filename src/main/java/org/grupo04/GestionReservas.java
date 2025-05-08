package org.grupo04;

import java.util.ArrayList;

/**
 * Clase que gestiona una colección de reservas.
 * Proporciona métodos para añadir, eliminar, modificar y listar reservas.
 */
public class GestionReservas {
    /**
     * Lista interna que almacena los objetos Reserva.
     */
    private ArrayList<Reserva> reservas;

    /**
     * Constructor que inicializa la lista de reservas.
     */
    public GestionReservas() {
        reservas = new ArrayList<Reserva>();
    }

    /**
     * Obtiene la información de una reserva en la posición indicada.
     *
     * @param posicion Índice de la lista de donde se obtendrá la reserva.
     * @return El objeto Reserva en la posición dada, o null si el índice es inválido.
     */
    public Reserva get(int posicion) {
        if (posicion < 0 || posicion >= reservas.size()) {
            return null;
        }
        return reservas.get(posicion);
    }

    /**
     * Añade una nueva reserva a la colección.
     *
     * @param reserva Objeto Reserva a añadir; no puede ser null.
     * @return true si se añadió correctamente, false si el parámetro es null.
     */
    public boolean add(Reserva reserva) {
        if (reserva == null) {
            return false;
        }
        return reservas.add(reserva);
    }

    /**
     * Elimina la reserva que se encuentra en la posición indicada.
     *
     * @param posicion Índice de la reserva a eliminar.
     * @return true si se eliminó correctamente, false si el índice es inválido.
     */
    public boolean remove(int posicion) {
        if (posicion < 0 || posicion >= reservas.size()) {
            return false;
        }
        reservas.remove(posicion);
        return true;
    }

    /**
     * Cambia la fecha de entrada de la reserva en la posición indicada.
     *
     * @param posicion Índice de la reserva cuya fecha de entrada se va a cambiar.
     * @param nuevaFechaEntrada Nueva fecha de entrada a asignar.
     * @return true si la fecha se cambió correctamente, false si el índice es inválido.
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
     * Cambia la fecha de salida de la reserva en la posición indicada.
     *
     * @param posicion Índice de la reserva cuya fecha de salida se va a cambiar.
     * @param nuevaFechaSalida Nueva fecha de salida a asignar.
     * @return true si la fecha se cambió correctamente, false si el índice es inválido.
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
     * Devuelve la lista completa de reservas.
     *
     * @return ArrayList con todos los objetos Reserva almacenados.
     */
    public ArrayList<Reserva> listarTodas() {
        return reservas;
    }
}