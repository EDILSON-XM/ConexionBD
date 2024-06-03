package ppal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class PruebaDepartamentos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ConexionBD conexion= new ConexionBD();
		
		
		System.out.println("conectando ala base de datos...");
		//Paso 1. Obtener la conexión
		Connection con= conexion.getConexion();
		
		
		//Objetos nesesarios para hacer una consulta
		
		Statement sentencia=null;
		ResultSet resultado=null;
		
		
		
		//Algun procesamiento con la base de datos
	
		
		
	
		
		try {	
			// Paso 2 .OBTENER EL Statement
			sentencia=con.createStatement();
			
			//Paso 3 . Ejecutar la Sentencia
			
			resultado=sentencia.executeQuery("select * from departamentos");
			
			System.out.println("cod_departamento \t cod_centro \t cod_director \t tipo_dir \t presupuesto \t cod_dpto_jefe \t nombre ");
			
			//Paso 4. RECOGER EL RESULTADO
			while(resultado.next()) {
				int coddepartamento=resultado.getInt("cod_departamento");
				int codcentro=resultado.getInt("cod_centro");
				int coddirector=resultado.getInt("cod_director");
				
				String tipodir=resultado.getString("tipo_dir");
				
				int presupuesto=resultado.getInt("presupuesto");
				int coddptojefe=resultado.getInt("cod_dpto_jefe");
				String nombre=resultado.getString("nombre");
				
			
				
				
				System.out.println(coddepartamento+"\t" +codcentro + "\t"+ coddirector+ "\t" + presupuesto +"\t"+ coddptojefe 
						+"\t"+ nombre+"\t"+ tipodir);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Error al consultar datos."+e.getMessage());
			
		}finally{ try {
			
			resultado.close();
			sentencia.close();
			
		} catch (SQLException e) {
			
			System.out.println("Error al liberar los recursos");
		}
		
		}

			
		
		
		//liberamos la conexión
		System.out.println("Desconectando de la base de datos");
		conexion.desconectar();
	}

}
