package ppal;

import java.sql.Connection;

import conexion.ConexionBD;

public class PruebaConexion {

	public static void main(String[] args) {
		
		ConexionBD conexion= new ConexionBD();
		
		System.out.println("conectando ala base de datos...");
		
		Connection con= conexion.getConexion();
		
		//Algun procesamiento con la base de datos
		//liberamos la conexión
		
		conexion.desconectar();

	}

}
