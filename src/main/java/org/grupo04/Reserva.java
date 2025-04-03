package org.grupo04;

import java.util.Date;

public class Reserva {

	private int reservaId;
    private String nombreHuesped;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int numeroHabitacion;

    public Reserva() {
    }

    public Reserva(int reservaId, String nombreHuesped, Date fechaEntrada, Date fechaSalida, int numeroHabitacion) {
        this.reservaId = reservaId;
        this.nombreHuesped = nombreHuesped;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    
    @Override
   	public String toString() {
   		return "Reserva [reservaId=" + reservaId + ", nombreHuesped=" + nombreHuesped + ", fechaEntrada=" + fechaEntrada
   				+ ", fechaSalida=" + fechaSalida + ", numeroHabitacion=" + numeroHabitacion + "]";
   	}
}
