
/** 
Proyecto: Juego de la vida.
 * Implementa el control de inicio de sesión y ejecución de la simulación por defecto. 
 * En esta versión sólo se ha aplicado un diseño OO básico.
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Obsesión por los tipos primitivos.
 *      - Exceso de métodos estáticos.
 *  	- Clase acaparadora, que delega poca responsabilidad. 
 *  	- Clase demasiado grande.
 * @since: prototipo1.0
 * @source: JVPrincipal.java 
 * @version: 1.0 - 2018/11/21
 * @author: ajp
 */

import accesoDato.Datos;
import accesoUsr.Presentacion;
import modelo.Simulacion;

public class JVPrincipal {

	/**
	 * Secuencia principal del programa.
	 */
	public static void main(String[] args) {

		Datos.cargarUsuariosPrueba();
		Datos.mostrarTodosUsuarios();
		
		if (Presentacion.inicioSesionCorrecto()) {
			Datos.registrarSesion();
			System.out.println("Sesión: " + Datos.getSesionesRegistradas() + '\n' + "Iniciada por: " + Presentacion.usrEnSesion.getNombre()
					+ " " + Presentacion.usrEnSesion.getApellidos());

			new Simulacion().lanzarDemo();
		} else {
			System.out.println("\nDemasiados intentos fallidos...");
		}
		System.out.println("Fin del programa.");
	}

} // class
