/** Proyecto: Juego de la vida.
 *  Implementa el concepto de ClaveAcceso del modelo  
 *  @since: prototipo1.1
 *  @source: ClaveAcceso.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package modelo;

public class ClaveAcceso {
	private String texto;

	public ClaveAcceso(String texto) {
		setTexto(texto);
	}

	public ClaveAcceso() {
		this("Miau#0");
	}

	public ClaveAcceso(ClaveAcceso claveacceso) {
		this.texto = new String(claveacceso.texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		assert texto != null;
		if (claveAccesoValida(texto)) {
			this.texto = encriptarCesar(texto);
		}
		// Todavía no se gestionan errores
		if (this.texto == null) {
			this.texto = new ClaveAcceso().texto; // Construyo un objeto por defecto  ( Tiempo de construccion ).
		}
	}

	static String encriptarCesar(String texto) {
		StringBuilder result = new StringBuilder();
		int desplazamiento = 400;
		for (int i = 0; i < texto.length(); i++) {
			result.append((char)(texto.charAt(i) + desplazamiento));
		}
		return result.toString();
	}
	
	static String desencriptarCesar(String texto) {
		StringBuilder result = new StringBuilder();
		int desplazamiento = 400;
		for (int i = 0; i < texto.length(); i++) {
			result.append((char)(texto.charAt(i) - desplazamiento));
		}
		return result.toString();
	}
	

	private boolean claveAccesoValida(String texto) {
		return texto.matches(".{4,32}");

	}

	@Override
	public String toString() {
		return texto;
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
		ClaveAcceso other = (ClaveAcceso) obj;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public ClaveAcceso clone() {
		return new ClaveAcceso(this);

	}

}
