/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Datos del accesoDato  
 *  @since: prototipo1.1
 *  @source: Datos.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package accesoDato;

import modelo.ClaveAcceso;
import modelo.Correo;
import modelo.DireccionPostal;
import modelo.Nif;
import modelo.SesionUsuario;
import modelo.Simulacion;
import modelo.Usuario;
import modelo.Usuario.RolUsuario;
import util.Fecha;

public class Datos {
	/**
	 * Atributos del almacen de datos del prototipo.
	 */
	public static final int MAX_USUARIOS = 10;
	public static final int MAX_SESIONES = 10;
	private static final int MAX_SIMULACIONES = 10;
	private static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	private static SesionUsuario[] datosSesiones = new SesionUsuario[MAX_SESIONES];
	private static Simulacion[] datosSimulaciones = new Simulacion[MAX_SIMULACIONES];
	private static int sesionesRegistradas = 0;

	/**
	 * Metodo get que obtiene el array de Usuarios.
	 * @return datosUsuarios
	 */
	public Usuario[] getDatosUsuarios() {
		return datosUsuarios;
	}

	/**
	 * Metodo get que obtiene el array de sesiones.
	 * @return datosSesiones
	 */
	public SesionUsuario[] getDatosSesiones() {
		return datosSesiones;
	}

	/**
	 * Metodo get que obtiene el contador de sesiones iniciadas en el programa.
	 * @return sesionesRegistradas
	 */
	public int getSesionesRegistradas() {
		return sesionesRegistradas;
	}

	/**
	 * Metodo get que obtiene el array de simulaciones.
	 * @return datosSimulaciones
	 */
	public Simulacion[] getDatosSimulaciones() {
		return datosSimulaciones;
	}

	/**
	 * Metodo que muestra todos los Usuarios.
	 */
	public void mostrarTodosUsuarios() {
		for (Usuario u : datosUsuarios) {
			System.out.println("\n" + u);
		}
	}

	/**
	 * Busca usuario dado su nif.
	 * @param idUsr - el nif del Usuario a buscar.
	 * @return - el Usuario encontrado o null si no existe.
	 */
	public Usuario buscarUsuario(Nif idUsr) {
		for (Usuario usr : datosUsuarios) {
			if (usr.getNif().equals(idUsr)) {
				return usr;
			}
		}
		return null;
	}

	/**
	 * Metodo que registra la sesion en el almacen de sesiones del programa.
	 * @param sesion
	 */
	public void altaSesion(SesionUsuario sesion) {
		datosSesiones[sesionesRegistradas] = sesion;
		sesionesRegistradas++;
	}

	/**
	 * Metodo que realiza una carga los Usuarios de prueba que se van a almacenar en
	 * nuestro programa.
	 */
	public void cargarUsuariosPrueba() {
		for (int i = 0; i < MAX_USUARIOS; i++) {
			datosUsuarios[i] = new Usuario(new Nif("0000000" + i + "K"), "Pepe", "López Pérez",
					new DireccionPostal("C/ Luna", "2" + i, "3013" + i, "Murcia"),
					new Correo("pepe" + i + "@gmail.com"), new Fecha(1999, 11, 12), new Fecha(2018, 01, 03),
					new ClaveAcceso("Miau#" + i), RolUsuario.NORMAL);
		}
	}

	/**
	 * Metodo que realiza un volcado con los datos de los usuarios.
	 * @return String volcadoUsuarios
	 */
	public static String volcarDatosUsuariosTexto() {
		StringBuilder sb = new StringBuilder();
		String delimitadorUsrApertura = "<usr>";
		String delimitadorUsrCierre = "</usr>";
		String delimitadorAtribUsrApertura = "<attrib>";
		String delimitadorAtribUsrCierre = "</attrib>";

		for (Usuario usr : datosUsuarios) {
			sb.append(delimitadorUsrApertura);
			sb.append(delimitadorAtribUsrApertura).append(usr.getNif().getnif()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getNombre()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getApellidos()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getDireccionPostal().toString()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getCorreo().getCorreoTexto()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getFechaNacimiento().toString()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getFechaAlta().toString()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getClaveAcceso().getTexto()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorAtribUsrApertura).append(usr.getRol()).append(delimitadorAtribUsrCierre);
			sb.append(delimitadorUsrCierre);

		}
		return sb.toString();
	}

	/**
	 * Metodo que realiza un volcado de los datos de las sesiones de texto.
	 * @return String volcadoSesiones
	 */
	public static String volcarDatosSesionesTexto() {
		StringBuilder sb = new StringBuilder();
		String delimitadorSesionApertura = "<sesion>";
		String delimitadorSesionCierre = "</sesion>";

		for (SesionUsuario sesionUsr : datosSesiones) {
			if (sesionUsr != null) {
				sb.append(delimitadorSesionApertura);
				sb.append(sesionUsr.getIdSesion());
				sb.append(delimitadorSesionCierre);
			}
			break;

		}
		return sb.toString();
	}

}	// Class
