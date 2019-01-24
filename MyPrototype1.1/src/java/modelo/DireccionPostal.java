/** Proyecto: Juego de la vida.
 *  Implementa el concepto de DireccionPostal del modelo  
 *  @since: prototipo1.1
 *  @source: DireccionPostal.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package modelo;

public class DireccionPostal {
	private String calle;
	private String numero;
	private String CP;
	private String poblacion;

	public DireccionPostal(String calle, String numero, String CP, String poblacion) {
		setCalle(calle);
		setNumero(numero);
		setCP(CP);
		setPoblacion(poblacion);
	}

	public DireccionPostal() {
		this("Roncal", "10", "30130", "Murcia");
	}

	public DireccionPostal(DireccionPostal direccionpostal) {
		this.calle = new String(direccionpostal.calle);
		this.numero = new String(direccionpostal.numero);
		this.CP = new String(direccionpostal.CP);
		this.poblacion = new String(direccionpostal.poblacion);
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		assert calle != null;
		if (calleValida(calle)) {
			this.calle = calle;
		}
		if (this.calle == null) {
			this.calle = new DireccionPostal().calle;
		}

	}

	private boolean calleValida(String calle) {
		return !calle.matches("[ ]+");
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		assert numero != null;
		if (numeroValido(numero)) {
			this.numero = numero;
		}
		if (this.numero == null) {
			this.numero = new DireccionPostal().numero;
		}
	}

	private boolean numeroValido(String numero) {
		return !numero.matches("[ ]+");
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String CP) {
		assert CP != null;
		if (cpValido(CP)) {
			this.CP = CP;
		}
		if (this.CP == null) {
			this.CP = new DireccionPostal().CP;
		}
	}

	private boolean cpValido(String CP) {
		return !CP.matches("[ ]+");
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		assert poblacion != null;
		if (poblacionValido(poblacion)) {
			this.poblacion = poblacion;
		}
		if (this.poblacion == null) {
			this.poblacion = new DireccionPostal().poblacion;
		}

	}

	private boolean poblacionValido(String poblacion) {
		return !poblacion.matches("[ ]+");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CP == null) ? 0 : CP.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
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
		DireccionPostal other = (DireccionPostal) obj;
		if (CP == null) {
			if (other.CP != null)
				return false;
		} else if (!CP.equals(other.CP))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return calle + ", " + numero + ", " + CP + ", " + poblacion;
	}

	@Override
	public DireccionPostal clone() {
		return new DireccionPostal(this);
	}
}
