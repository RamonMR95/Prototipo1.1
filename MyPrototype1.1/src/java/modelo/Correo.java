/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Correo del modelo  
 *  @since: prototipo1.1
 *  @source: Correo.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package modelo;

public class Correo {
	private String texto;

	public Correo(String texto) {
		this.texto = texto;
	}
	
	public Correo() {
		this.texto = "correo@correo.es";
	}
	
	public Correo(Correo correo) {
		this.texto = new String(correo.texto);
	}
	
	public String getCorreo() {
		return texto;
	}
	
	public void setCorreo(String texto) {
		assert texto != null;
		if (correoValido(texto)) {
			this.texto = texto;
		}
		// Todavía no se gestionan errores
		if (this.texto == null) {
			this.texto = new Correo().texto; // Construyo un objeto por defecto evito NULL ( Tiempo de construccion
													// ).
		}
	}
	private boolean correoValido(String texto) {
		return !texto.matches("[ ]+");

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Correo other = (Correo) obj;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}
	
	@Override
	public Correo clone() {
		return new Correo(this);
	}
	
	@Override
	public String toString() {
		return texto;
	}

}
