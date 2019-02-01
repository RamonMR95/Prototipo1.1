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
		setNif(texto);
	}

	public Nif() {
		this.texto = "00000001R";
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
			this.texto = nifGenerado(texto);
		}
	}

	private boolean nifValido(String texto) {
		String numeros = texto.substring(0 ,8);
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		int suma = 0;
		int total = 0;
				
		for (int i = 0; i < numeros.length(); i ++) {
			suma += Character.getNumericValue(numeros.charAt(i));
		}
		
		total = suma % 23;
		
		return texto.substring(8,9).equals(String.valueOf(letrasDNI.charAt(total)));
	}
	
	private String nifGenerado(String texto) {
		String numeros = texto.substring(0 ,8);
		StringBuilder sb = new StringBuilder(numeros);
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		int suma = 0;
		int total = 0;
				
		for (int i = 0; i < numeros.length(); i ++) {
			suma += Character.getNumericValue(numeros.charAt(i));
		}
		
		total = suma % 23;
		sb.append(letrasDNI.charAt(total));
		return sb.toString();
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
