/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Datos del accesoDato  
 *  @since: prototipo1.1
 *  @source: Datos.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package accesoDato;

import accesoUsr.Presentacion;
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
	public static final int MAX_USUARIOS = 10;
	public static final int MAX_SESIONES = 10;
	private static final int MAX_SIMULACIONES = 10;
	private static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	private static SesionUsuario[] datosSesiones = new SesionUsuario[MAX_SESIONES];
	private static Simulacion[] datosSimulaciones = new Simulacion[MAX_SIMULACIONES];
	private static int sesionesRegistradas = 0;

	/* Metodos get de la clase Datos */
	public static Usuario[] getDatosUsuarios() {
		return datosUsuarios;
	}

	public static SesionUsuario[] getDatosSesiones() {
		return datosSesiones;
	}

	public static int getSesionesRegistradas() {
		return sesionesRegistradas;
	}

	public static Simulacion[] getDatosSimulaciones() {
		return datosSimulaciones;
	}

	/**
	 * Muestra por consola todos los usuarios almacenados.
	 */
	public static void mostrarTodosUsuarios() {
		for (Usuario u : datosUsuarios) {
			System.out.println("\n" + u);
		}
	}

	/**
	 * Busca usuario dado su nif.
	 * @param idUsr - el nif del Usuario a buscar.
	 * @return - el Usuario encontrado o null si no existe.
	 */
	public static Usuario buscarUsuario(Nif idUsr) {
		for (Usuario usr : Datos.getDatosUsuarios()) {
			if (usr.getNif().equals(idUsr)) {
				return usr;
			}
		}
		return null;
	}

	/**
	 * Registro de la sesión de usuario.
	 */
	public static void registrarSesion() {
		SesionUsuario sesion = new SesionUsuario();
		sesion.setUsr(new Presentacion().getUsrEnSesion());
		sesion.setFecha(new Fecha());

		datosSesiones[sesionesRegistradas] = sesion;
		sesionesRegistradas++;
	}

	public static void visualizar() {
		for (SesionUsuario sesionUsuario : datosSesiones) {
			System.out.println(sesionUsuario);
		}

	}

	public static void cargarUsuariosPrueba() {
		for (int i = 0; i < MAX_USUARIOS; i++) {
			datosUsuarios[i] = new Usuario(new Nif("0000000" + i + "K"), "Pepe", "López Pérez",
					new DireccionPostal("C/ Luna", "2" + i, "3013" + i, "Murcia"),
					new Correo("pepe" + i + "@gmail.com"), new Fecha(1999, 11, 12), new Fecha(2018, 01, 03),
					new ClaveAcceso("Miau#" + i), RolUsuario.NORMAL);
		}
	}

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

}
