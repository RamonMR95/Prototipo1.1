package modelo;
/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo1.
 *  En esta versión sólo se ha aplicado un diseño OO básico.
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Obsesión por los tipos primitivos.
 *  	- Clase demasiado grande.
 *  	- Clase acaparadora, que delega poca responsabilidad.  
 *  @since: prototipo1.1
 *  @source: Usuario.java 
 *  @version: 1.1 - 2018/11/21 
 *  @author: Ramon Moñino
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Usuario {

	private Nif nif;
	private String nombre;
	private String apellidos;
	private DireccionPostal direccionpostal;
	private Correo correo;
	private Calendar fechaNacimiento;
	private Calendar fechaAlta;
	private ClaveAcceso claveAcceso;
	private String rol;
	public final static String[] ROLES = { "INVITADO", "NORMAL", "ADMINSTRADOR" };

	/**
	 * Constructor convencional. Utiliza métodos set...()
	 * 
	 * @param nif
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param correo
	 * @param fechaNacimiento
	 * @param fechaAlta
	 * @param claveAcceso
	 * @param rol
	 */
	public Usuario(Nif nif, String nombre, String apellidos, DireccionPostal direccionpostal, Correo correo,
			Calendar fechaNacimiento, Calendar fechaAlta, ClaveAcceso claveAcceso, String rol) {
		setNif(nif);
		setNombre(nombre);
		setApellidos(apellidos);
		setDireccionPostal(direccionpostal);
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setFechaAlta(fechaAlta);
		setClaveAcceso(claveAcceso);
		setRol(rol);
	}

	/**
	 * Constructor por defecto. Reenvía al constructor convencional.
	 */
	public Usuario() {
		this(new Nif(), "Nombre", "Apellido Apellido", new DireccionPostal(), new Correo(), new GregorianCalendar(),
				new GregorianCalendar(), new ClaveAcceso(), ROLES[1]);
	}

	/**
	 * Constructor copia.
	 * 
	 * @param usr
	 */
	public Usuario(Usuario usr) {
		this.nif = new Nif(usr.nif);
		this.nombre = new String(usr.nombre);
		this.apellidos = new String(usr.apellidos);
		this.direccionpostal = new DireccionPostal(usr.direccionpostal);
		this.correo = new Correo(usr.correo);
		this.fechaNacimiento = new GregorianCalendar(usr.fechaNacimiento.get(Calendar.YEAR),
				usr.fechaNacimiento.get(Calendar.MONTH), usr.fechaNacimiento.get(Calendar.DATE));
		this.fechaAlta = new GregorianCalendar(usr.fechaAlta.get(Calendar.YEAR), usr.fechaAlta.get(Calendar.MONTH),
				usr.fechaAlta.get(Calendar.DATE));
		this.claveAcceso = new ClaveAcceso(usr.claveAcceso);
		this.rol = new String(usr.rol);
	}

	public Nif getNif() {
		return nif;
	}

	public void setNif(Nif nif) {
		assert nif != null;
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		assert nombre != null;
		if (nombreValido(nombre)) {
			this.nombre = nombre;
		}
		// Todavía no se gestionan errores de usuario.
		if (this.nombre == null) { // Tiempo de construcción.
			this.nombre = new Usuario().nombre; // Defecto.
		}
	}

	/**
	 * Comprueba validez del nombre.
	 * 
	 * @param nombre.
	 * @return true si cumple.
	 */
	private boolean nombreValido(String nombre) {
		return !nombre.matches("[ ]+"); // Que no sea en blanco.
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		assert apellidos != null;
		if (apellidosValidos(apellidos)) {
			this.apellidos = apellidos;
		}
		// Todavía no se gestionan errores de usuario.
		if (this.apellidos == null) { // Tiempo de construcción.
			this.apellidos = new Usuario().apellidos; // Defecto.
		}
	}

	/**
	 * Comprueba validez de los apellidos.
	 * 
	 * @param apellidos.
	 * @return true si cumple.
	 */
	private boolean apellidosValidos(String apellidos) {
		return !apellidos.matches("[ ]+"); // Que no sea en blanco.
	}

	public DireccionPostal getDireccionPostal() {
		return direccionpostal;
	}

	public void setDireccionPostal(DireccionPostal direccionpostal) {
		assert direccionpostal != null;
		this.direccionpostal = direccionpostal;

	}

	public Correo getCorreo() {
		return correo;
	}

	public void setCorreo(Correo correo) {
		assert correo != null;
		this.correo = correo;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		assert fechaNacimiento != null;
		if (fechaNacimientoValida(fechaNacimiento)) {
			this.fechaNacimiento = fechaNacimiento;
		}
		// Todavía no se gestionan errores de usuario.
		if (this.fechaNacimiento == null) { // Tiempo de construcción.
			this.fechaNacimiento = new Usuario().fechaNacimiento; // Defecto.
		}
	}

	/**
	 * Comprueba validez de una fecha de nacimiento.
	 * 
	 * @param fechaNacimiento.
	 * @return true si cumple.
	 */
	private boolean fechaNacimientoValida(Calendar fechaNacimiento) {
		return fechaNacimiento.before(new GregorianCalendar());
	}

	public Calendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Calendar fechaAlta) {
		assert fechaAlta != null;
		if (fechaAltaValida(fechaAlta)) {
			this.fechaAlta = fechaAlta;
		}
		// Todavía no se gestionan errores de usuario.
		if (this.fechaAlta == null) { // Tiempo de construcción.
			this.fechaAlta = new Usuario().fechaAlta; // Defecto.
		}
	}

	/**
	 * Comprueba validez de una fecha de alta.
	 * 
	 * @param fechaAlta.
	 * @return true si cumple.
	 */
	private boolean fechaAltaValida(Calendar fechaAlta) {
		return !fechaAlta.after(new GregorianCalendar()); // Que no sea en blanco.
	}

	public ClaveAcceso getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(ClaveAcceso claveAcceso) {
		assert claveAcceso != null;
		this.claveAcceso = claveAcceso;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		assert rol != null;
		if (rolValido(rol)) {
			this.rol = rol;
		}
		// Todavía no se gestionan errores de usuario.
		if (this.rol == null) { // Tiempo de construcción.
			this.rol = new Usuario().rol; // Defecto.
		}
	}

	/**
	 * Comprueba validez de un rol.
	 * 
	 * @param rol.
	 * @return true si cumple.
	 */
	private boolean rolValido(String rol) {
		return ROLES[0].equals(rol) || ROLES[1].equals(rol) || ROLES[2].equals(rol);
	}

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * 
	 * @return el texto formateado del estado -valores de atributos- de objeto de la
	 *         clase Usuario.
	 */
	@Override
	public String toString() {
		return String.format(
				"%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n" + "%-16s %s\n"
						+ "%-16s %s\n" + "%-16s %s\n",
				"nif:", nif, "nombre:", this.nombre, "apellidos:", this.apellidos, "domicilio:", this.direccionpostal,
				"correo:", this.correo, "fechaNacimiento:",
				this.fechaNacimiento.get(Calendar.YEAR) + "." + this.fechaNacimiento.get(Calendar.MONTH) + "."
						+ this.fechaNacimiento.get(Calendar.DATE),
				"fechaAlta:", this.fechaAlta.get(Calendar.YEAR) + "." + this.fechaAlta.get(Calendar.MONTH) + "."
						+ this.fechaAlta.get(Calendar.DATE),
				"claveAcceso:", this.claveAcceso, "rol:", this.rol);
	}

} // class
