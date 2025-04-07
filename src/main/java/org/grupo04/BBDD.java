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
    public static PreparedStatement insertEmpleados;
    public static PreparedStatement updateEmpleados;
    public static PreparedStatement deleteEmpleados;



    public boolean init() {
        try {
        	
            Properties p = loadPropertiesFile();
            if (p == null) return false;

            String strConn = (String) p.get("db.string_connection");
            System.out.println(strConn);
            conn = DriverManager.getConnection(strConn);
            selectEmpleados = conn.prepareStatement("SELECT empleado_id, nombre, puesto, salario FROM empleados WHERE empleado_id = ? AND nombre = ? AND puesto = ? ");
            insertEmpleados = conn.prepareStatement("INSERT INTO empleados (nombre, puesto, salario) VALUES (?, ?, ?");
            updateEmpleados = conn.prepareStatement("UPDATE empleados SET nombre = ?, puesto = ?, salario = ? WHERE empleado_id = ?");
			deleteEmpleados = conn.prepareStatement("DELETE FROM empleados WHERE nombre = ?");

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


    public static boolean Persist(Empleado usuarioInsertar) {
    	try {
        	BBDD.insertEmpleados.setString(1, usuarioInsertar.getNombre());
        	BBDD.insertEmpleados.setString(2, usuarioInsertar.getPuesto());
        	BBDD.insertEmpleados.setDouble(3, usuarioInsertar.getSalario());
        	BBDD.insertEmpleados.executeUpdate();
        	return true;
        } catch (SQLException e) {
        	BBDD.showError(e);
    		return false;
		}
    }

  
    public static boolean Merge(Empleado usuarioEditar) {
    	try {
        	BBDD.updateEmpleados.setString(1, usuarioEditar.getNombre());
        	BBDD.updateEmpleados.setString(2, usuarioEditar.getPuesto());
        	BBDD.updateEmpleados.setDouble(3, usuarioEditar.getSalario());
        	BBDD.insertEmpleados.setDouble(4, usuarioEditar.getEmpleadoId());
        	BBDD.updateEmpleados.executeUpdate();
        	return true;
        } catch (SQLException e) {
        	BBDD.showError(e);
    		return false;
		}
    }

   
    public static boolean Remove(Empleado usuarioEliminar) {
    	try {
        	BBDD.deleteEmpleados.setString(1, usuarioEliminar.getNombre());
        	BBDD.deleteEmpleados.executeUpdate();
        	return true;
        } catch (SQLException e) {
        	BBDD.showError(e);
    		return false;
		}
    }
}
