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

import util.Fecha;


public class Usuario {

	private Nif nif;
	private String nombre;
	private String apellidos;
	private DireccionPostal direccionpostal;
	private Correo correo;
	private Fecha fechaNacimiento;
	private Fecha fechaAlta;
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
			Fecha fechaNacimiento, Fecha fechaAlta, ClaveAcceso claveAcceso, String rol) {
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
		this(new Nif(), "Nombre", "Apellido Apellido", new DireccionPostal(), new Correo(), new Fecha(),
				new Fecha(), new ClaveAcceso(), ROLES[1]);
	}

	/**
	 * Constructor copia.
	 * @param usr
	 */
	public Usuario(Usuario usr) {
		this.nif = new Nif(usr.nif);
		this.nombre = new String(usr.nombre);
		this.apellidos = new String(usr.apellidos);
		this.direccionpostal = new DireccionPostal(usr.direccionpostal);
		this.correo = new Correo(usr.correo);
		this.fechaNacimiento = new Fecha(usr.fechaNacimiento.getAño(),
				usr.fechaNacimiento.getMes(), usr.fechaNacimiento.getDia());
		this.fechaAlta = new Fecha(usr.fechaAlta.getAño(), usr.fechaAlta.getMes(),
				usr.fechaAlta.getDia());
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

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		assert fechaNacimiento != null;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Fecha getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Fecha fechaAlta) {
		assert fechaAlta != null;
		this.fechaAlta = fechaAlta;
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
						"%-16s %s\n" +
						"%-16s %s\n" + 
						"%-16s %s\n" + 
						"%-16s %s\n" + 
						"%-16s %s\n" + 
						"%-16s %s\n" + 
						"%-16s %s\n" + 
						"%-16s %s\n" + 
						"%-16s %s\n",
				"nif:", nif, 
				"nombre:", this.nombre, 
				"apellidos:", this.apellidos, 
				"domicilio:", this.direccionpostal,
				"correo:", this.correo, 
				"fechaNacimiento:", this.fechaNacimiento.getAño() 
						+ "." + this.fechaNacimiento.getMes() + "."
						+ this.fechaNacimiento.getDia(),
				"fechaAlta:", this.fechaAlta.getAño() 
						+ "." + this.fechaAlta.getMes() + 
						"." + this.fechaAlta.getDia(),
				"claveAcceso:", this.claveAcceso, "rol:", this.rol);
	}

} // class
