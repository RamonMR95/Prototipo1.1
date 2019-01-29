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

import java.util.GregorianCalendar;

import util.Fecha;

public class Usuario {

	private Nif nif;
	private String nombre;
	private String apellidos;
	private String idUsr;
	private DireccionPostal direccionPostal;
	private Correo correo;
	private Fecha fechaNacimiento;
	private Fecha fechaAlta;
	private ClaveAcceso claveAcceso;
	private RolUsuario rol;
	public enum RolUsuario { INVITADO, NORMAL, ADMINSTRADOR };

	/**
	 * Constructor convencional. Utiliza métodos set...()
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
	public Usuario(Nif nif, String nombre, String apellidos, DireccionPostal direccionPostal, Correo correo,
			Fecha fechaNacimiento, Fecha fechaAlta, ClaveAcceso claveAcceso, RolUsuario rol) {
		setNif(nif);
		setNombre(nombre);
		setApellidos(apellidos);
		setIdUsr();
		setDireccionPostal(direccionPostal);
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
		this(new Nif(), "Nombre", "Apellido Apellido", new DireccionPostal(), new Correo(), new Fecha(), new Fecha(),
				new ClaveAcceso(), RolUsuario.NORMAL );
	}

	/**
	 * Constructor copia.
	 * @param usr
	 */
	public Usuario(Usuario usr) {
		this.nif = new Nif(usr.nif);
		this.nombre = new String(usr.nombre);
		this.apellidos = new String(usr.apellidos);
		this.direccionPostal = new DireccionPostal(usr.direccionPostal);
		this.correo = new Correo(usr.correo);
		this.fechaNacimiento = new Fecha(usr.fechaNacimiento.getYear(), usr.fechaNacimiento.getMonth(),
				usr.fechaNacimiento.getDay());
		this.fechaAlta = new Fecha(usr.fechaAlta.getYear(), usr.fechaAlta.getMonth(), usr.fechaAlta.getDay());
		this.claveAcceso = new ClaveAcceso(usr.claveAcceso);
		this.rol = usr.rol;
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
	 * @param apellidos.
	 * @return true si cumple.
	 */
	private boolean apellidosValidos(String apellidos) {
		return !apellidos.matches("[ ]+"); // Que no sea en blanco.
	}
	
	/**
	 * Devuelve el id del usuario
	 * @return isUsr
	 */
	public String getIdUsr() {
		return idUsr;
	}
	
	/**
	 * Metodo que establece el idUsr
	 * @param idUsr
	 */
	public void setIdUsr() {
		this.idUsr = generarIdUsr();
	}
	
	/**
	 * Metodo que genera un ID de usuario
	 * @param idUsr
	 * @return id
	 */
	public String generarIdUsr() {
		StringBuilder id = new StringBuilder();
		id.append(this.nombre.substring(0, 1).toUpperCase());
		String[]divApellidos = this.apellidos.split("\\s+");
		id.append(divApellidos[0].substring(0, 1).toUpperCase());
		id.append(divApellidos[1].substring(0, 1).toUpperCase());
		id.append(this.nif.getnif().substring(8, 10));
		return id.toString();
	}

	public DireccionPostal getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(DireccionPostal direccionPostal) {
		assert direccionPostal != null;
		this.direccionPostal = direccionPostal;

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
		if (fechaNacimientoValida(fechaNacimiento)) {
			this.fechaNacimiento = fechaNacimiento;
		}
		if (this.fechaNacimiento == null) {
			this.fechaNacimiento = new Usuario().fechaNacimiento; // Tiempo de construccion
		}
	}

	private boolean fechaNacimientoValida(Fecha fechaNacimiento) {
		return fechaNacimiento.toGregorianCalendar().before(new GregorianCalendar());
	}

	public Fecha getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Fecha fechaAlta) {
		assert fechaAlta != null;
		if (fechaAltaValida(fechaAlta)) {
			this.fechaAlta = fechaAlta;
		}
		if (this.fechaAlta == null) {
			this.fechaAlta = new Usuario().fechaAlta;
		}
	}

	private boolean fechaAltaValida(Fecha fechaAlta) {
		return fechaAlta.toGregorianCalendar().before(new GregorianCalendar());
	}

	public ClaveAcceso getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(ClaveAcceso claveAcceso) {
		assert claveAcceso != null;
		this.claveAcceso = claveAcceso;
	}

	public RolUsuario getRol() {
		return rol;
	}

	public void setRol(RolUsuario rol) {
		assert rol != null;
			this.rol = rol;
	}

	/**
	 * Redefine el método heredado de la clase Objecto.
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
				"%-16s %s\n" + 
				"%-16s %s\n",
				"nif:", nif, 
				"nombre:", this.nombre, 
				"apellidos:", this.apellidos,
				"idUsr:", this.idUsr, 
				"domicilio:", this.direccionPostal,
				"correo:", this.correo, 
				"fechaNacimiento:",
				this.fechaNacimiento.getYear() + "." + this.fechaNacimiento.getMonth() + "."
						+ this.fechaNacimiento.getDay(),
						
				"fechaAlta:",
				this.fechaAlta.getYear() + "." + this.fechaAlta.getMonth() + "." + this.fechaAlta.getDay(),
				"claveAcceso:", this.claveAcceso, "rol:", this.rol);
	}

} // class
