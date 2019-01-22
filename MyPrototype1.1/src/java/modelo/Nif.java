/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Nif del modelo  
 *  @since: prototipo1.1
 *  @source: Nif.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package modelo;

public class Nif {
	private String texto;

	public Nif(String texto) {
		this.texto = texto;
	}

	public Nif() {
		this.texto = "00000000T";
	}

	public Nif(Nif nif) {
		this.texto = new String(nif.texto);
	}

	public String getnif() {
		return texto;
	}

	public void setNif(String texto) {
		assert texto != null;
		if (nifValido(texto)) {
			this.texto = texto;
		}
		// Todavía no se gestionan errores
		if (this.texto == null) {
			this.texto = new Nif().texto; // Construyo un objeto por defecto evito NULL ( Tiempo de construccion ).
		}
	}

	private boolean nifValido(String texto) {
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
		Nif other = (Nif) obj;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return texto;
	}

	@Override
	public Nif clone() {
		return new Nif(this);
	}

}
