package org.grupo04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java.io.InputStream;
import java.io.IOException;

public class BBDD {
    private Connection conn;
    
    public static PreparedStatement selectEmpleados;

    public boolean init() {
        try {
        	
            Properties p = loadPropertiesFile();
            if (p == null) return false;

            String strConn = (String) p.get("db.string_connection");
            System.out.println(strConn);
            conn = DriverManager.getConnection(strConn);
            selectEmpleados = conn.prepareStatement("SELECT empleado_id, nombre, puesto, salario FROM empleados WHERE empleado_id = ? AND nombre = ? AND puesto = ? ");
            
            return true;
        } catch (SQLException e) {
            showError(e);
            unLoad();
            return false;
        }
    }

    public static void showError(SQLException e) {
        System.out.println("Mensaje de error: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }

    public void unLoad() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Properties loadPropertiesFile() {
        Properties p = new Properties();
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            p.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    /**
     * Retorna aquellos jobs que coinciden con los criterios de búsqueda
     * @param job Contiene los criterios de búsqueda
     * @return Retorna un array con todos los jobs encontrados.
     * Null, no hay hay resultados. Siempre hay 20 casillas,
     * cuando llegamos a la primera casilla null, ya no hay más resultados.
     */
    public static Empleado[] find(Empleado filtroBusqueda) {
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        try {
        	BBDD.selectEmpleados.setInt(1, filtroBusqueda.getEmpleadoId());
        	BBDD.selectEmpleados.setString(2, filtroBusqueda.getNombre());
        	BBDD.selectEmpleados.setString(3, filtroBusqueda.getPuesto());
        	BBDD.selectEmpleados.setDouble(4, filtroBusqueda.getSalario());

        	ResultSet rs = BBDD.selectEmpleados.executeQuery();
			while (rs.next()) {
	        	Empleado empleado = new Empleado();
	        	empleado.setEmpleadoId(rs.getInt("empleado_id"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setPuesto(rs.getString("puesto"));
				empleado.setSalario(rs.getDouble("salario"));
				lista.add(empleado);
			}
        } catch (SQLException e) {
        	BBDD.showError(e);
		}
        

        return (Empleado[])lista.toArray();
    }

    private static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Inserta los datos del Job que se pasa como parámetro
     * @param job Job a insertar
     * @return True si la operación ha ido bien. False, en caso contrario.
     */
    public static boolean Persist(Job job) {
        return false;
    }

    /**
     * Actualiza los datos del Job que se pasa como parámetro.
     * Para simplificar, actualizaremos todo excepto lo que corresponde con la PK
     * @param job Job a actualizar
     * @return True si la operación ha ido bien. False, en caso contrario.
     */
    public static boolean Merge(Job job) {
        return false;
    }

    /**
     * Elimina el Job que se pasa como parámetro.
     * Para simplificar, se elimina a partir de la PK
     * @param job Job a eliminar
     * @return True si la operación ha ido bien. False, en caso contrario.
     */
    public static boolean Remove(Job job) {
        return false;
    }
}
