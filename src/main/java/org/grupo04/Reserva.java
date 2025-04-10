package org.grupo04;

import java.util.Date;

public class Reserva {

	private int reservaId;
    private String nombreHuesped;
    private String fechaEntrada;
    private String fechaSalida;
    private int numeroHabitacion;

    public Reserva() {
    }

    public Reserva(int reservaId, String nombreHuesped, String fechaEntrada, String fechaSalida, int numeroHabitacion) {
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

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    
    public Reserva[] find() {
    	return BBDD.find(this);
    }
    
    public boolean persist() {
    	return BBDD.persist(this);
    }
    
    public boolean Merge () {
    	return BBDD.merge(this);
    }
    
    public boolean remove () {
    	return BBDD.remove(this);
    }
    
    @Override
   	public String toString() {
   		return "Reserva [reservaId=" + reservaId + ", nombreHuesped=" + nombreHuesped + ", fechaEntrada=" + fechaEntrada
   				+ ", fechaSalida=" + fechaSalida + ", numeroHabitacion=" + numeroHabitacion + "]";
   	}
}
