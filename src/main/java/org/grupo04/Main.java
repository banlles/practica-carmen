package org.grupo04;

public class Main {
    public static void main(String[] args) {
        BBDD bbdd = new BBDD();
        if(bbdd.init()){
            System.out.println("Conexión a la base de datos exitosa.");
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    }
}
