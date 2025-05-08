package org.grupo04;

import java.util.ArrayList;

/**
 * Clase que representa un empleado
 * Permite manejar datos basicos y operaciones CRUD via BBDD
 */
public class Empleado {
    private int empleadoId;
    private String nombre;
    private String puesto;
    private double salario;

    /**
     * Constructor vacio de Empleado
     */
    public Empleado() {
    }

    /**
     * Constructor con todos los campos del empleado
     * @param empleadoId id unico del empleado
     * @param nombre nombre del empleado
     * @param puesto cargo u oficio del empleado
     * @param salario salario asignado al empleado
     */
    public Empleado(int empleadoId, String nombre, String puesto, double salario) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    /**
     * Devuleve el id del empleado
     * @return id del empleado
     */
    public int getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el id del empleado
     * @param empleadoId id a asignar
     */
    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Devuleve el nombre del empleado
     * @return nombre asignado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre y comprueba que no contenga digitos
     * @param nombre nombre a asignar
     * @throws IllegalArgumentException si nombre incluye numeros
     */
    public void setNombre(String nombre) {
        if (nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede tener numeros");
        }
        this.nombre = nombre;
    }

    /**
     * Devuleve el puesto del empleado
     * @return cargo u posicion en la empresa
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del empleado
     * @param puesto cargo u oficio a asignar
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Devuleve el salario del empleado
     * @return salario actual
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado
     * @param salario valor monetario a asignar
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Busca en BBDD usando este objeto como filtro
     * @return lista de Empleado segun filtro aplicado
     */
    public ArrayList<Empleado> find() {
        return BBDD.find(this);
    }

    /**
     * Inserta este empleado en la base de datos
     * @return true si insercion fue exitosa, false en caso de error
     */
    public boolean persist() {
        return BBDD.persist(this);
    }

    /**
     * Actualiza este empleado en la base de datos
     * @return true si actualizacion exitosa, false en caso contrario
     */
    public boolean merge() {
        return BBDD.merge(this);
    }

    /**
     * Elimina este empleado de la base de datos
     * @return true si eliminacion exitosa, false si hubo fallo
     */
    public boolean remove() {
        return BBDD.remove(this);
    }

    /**
     * Representacion en cadena de los datos del empleado
     * @return texto con valores de todos los campos
     */
    @Override
    public String toString() {
        return "Empleado [empleadoId=" + empleadoId + ", nombre=" + nombre + ", puesto=" + puesto + ", salario="
                + salario + "]";
    }
}