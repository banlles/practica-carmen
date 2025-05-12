package org.grupo04;

import java.util.ArrayList;


/**
 * Clase que representa una reserva de hotel.
 * Contiene información sobre el huésped, fechas de entrada y salida,
 * número de habitación y métodos para operaciones CRUD en la BBDD.
 */
public class Reserva {

    /**
     * Identificador de la reserva.
     */
    private int reservaId;
    /**
     * Nombre del huésped que realiza la reserva.
     */
    private String nombreHuesped;
    /**
     * Fecha de entrada de la reserva (formato dd-mm-yyyy).
     */
    private String fechaEntrada;
    /**
     * Fecha de salida de la reserva (formato dd-mm-yyyy).
     */
    private String fechaSalida;
    /**
     * Número de habitación asignada.
     */
    private int numeroHabitacion;

    /**
     * Constructor por defecto.
     */
    public Reserva() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param reservaId Identificador de la reserva.
     * @param nombreHuesped Nombre del huésped.
     * @param fechaEntrada Fecha de entrada (dd-mm-yyyy).
     * @param fechaSalida Fecha de salida (dd-mm-yyyy).
     * @param numeroHabitacion Número de habitación a asignar.
     */
    public Reserva(int reservaId, String nombreHuesped, String fechaEntrada, String fechaSalida, int numeroHabitacion) {
        this.reservaId = reservaId;
        this.nombreHuesped = nombreHuesped;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     * Obtiene el identificador de la reserva.
     *
     * @return ID de la reserva.
     */
    public int getReservaId() {
        return reservaId;
    }

    /**
     * Establece el identificador de la reserva.
     *
     * @param reservaId Nuevo ID de la reserva.
     */
    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    /**
     * Obtiene el nombre del huésped.
     *
     * @return Nombre del huésped.
     */
    public String getNombreHuesped() {
        return nombreHuesped;
    }

    /**
     * Establece el nombre del huésped, validando que no contenga números.
     *
     * @param nombreHuesped Nombre a asignar al huésped.
     * @throws IllegalArgumentException Si el nombre contiene dígitos.
     */
    public void setNombreHuesped(String nombreHuesped) {
        if (nombreHuesped.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre del huésped no puede contener números");
        }
        this.nombreHuesped = nombreHuesped;
    }

    /**
     * Obtiene la fecha de entrada.
     *
     * @return Fecha de entrada (formato dd-mm-yyyy).
     */
    public String getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Establece la fecha de entrada.
     *
     * @param fechaEntrada Nueva fecha de entrada (dd-mm-yyyy).
     */
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Obtiene la fecha de salida.
     *
     * @return Fecha de salida (formato dd-mm-yyyy).
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida.
     *
     * @param fechaSalida Nueva fecha de salida (dd-mm-yyyy).
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene el número de habitación.
     *
     * @return Número de habitación asignada.
     */
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     * Establece el número de habitación.
     *
     * @param numeroHabitacion Nuevo número de habitación.
     */
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     * Busca reservas en la base de datos que coincidan con este objeto.
     *
     * @return Lista de reservas encontradas.
     */
    public ArrayList<Reserva> find() {
        return BBDD.find(this);
    }

    /**
     * Persiste esta reserva en la base de datos.
     *
     * @return true si se guardó correctamente, false en caso contrario.
     */
    public boolean persist() {
        return BBDD.persist(this);
    }

    /**
     * Actualiza esta reserva en la base de datos.
     *
     * @return true si se actualizó correctamente, false en caso contrario.
     */
    public boolean merge() {
        return BBDD.merge(this);
    }

    /**
     * Elimina esta reserva de la base de datos.
     *
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean remove() {
        return BBDD.remove(this);
    }

    /**
     * Representación en cadena del objeto Reserva.
     *
     * @return String con los detalles de la reserva.
     */
    @Override
    public String toString() {
        return "Reserva [reservaId=" + reservaId + ", nombreHuesped=" + nombreHuesped + ", fechaEntrada=" + fechaEntrada
                + ", fechaSalida=" + fechaSalida + ", numeroHabitacion=" + numeroHabitacion + "]";
    }
}
