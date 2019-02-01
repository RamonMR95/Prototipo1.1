/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Presentacion del accesoUsr  
 *  @since: prototipo1.1
 *  @source: Presentacion.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package accesoUsr;

import java.util.Scanner;

import accesoDato.Datos;
import modelo.ClaveAcceso;
import modelo.Nif;
import modelo.Simulacion;
import modelo.Usuario;

public class Presentacion {

	private static Usuario usrEnSesion;
	private static final int MAX_INTENTOS_FALLIDOS = 3;

	public Usuario getUsrEnSesion() {
		return usrEnSesion;
	}
	/**
	 * Controla el acceso de usuario.
	 * @return true si la sesión se inicia correctamente.
	 */
	public static boolean inicioSesionCorrecto() {
		Scanner teclado = new Scanner(System.in); // Entrada por consola.
		int intentosPermitidos = MAX_INTENTOS_FALLIDOS;

		do {
			System.out.print("Introduce el nif de usuario: \n");
			Nif nif = new Nif(teclado.nextLine());
			System.out.print("Introduce clave acceso: ");
			ClaveAcceso clave = new ClaveAcceso(teclado.nextLine());

			usrEnSesion = Datos.buscarUsuario(nif);

			Usuario aux = new Usuario();
			aux.setClaveAcceso(new ClaveAcceso(clave));
			clave = aux.getClaveAcceso();
			if (usrEnSesion != null && usrEnSesion.getClaveAcceso().equals(clave)) {
				teclado.close();
				return true;
			} else {
				intentosPermitidos--;
				System.out.print("Credenciales incorrectas: ");
				System.out.println("Quedan " + intentosPermitidos + " intentos... ");
			}
		} while (intentosPermitidos > 0);

		teclado.close();
		return false;
	}
	
	/**
	 * Despliega en la consola el estado almacenado, corresponde a una generación
	 * del Juego de la vida.
	 */
	
	
	public void mostrarMundo() {
		Simulacion simulacion = new Simulacion();
		for (int i = 0; i < Simulacion.TAMAÑO_MUNDO; i++) {
			for (int j = 0; j < Simulacion.TAMAÑO_MUNDO; j++) {
				System.out.print(( simulacion.getMundo()[i][j] == 1) ? "|o" : "| ");
			}
			System.out.println("|");
		}
	}
}
