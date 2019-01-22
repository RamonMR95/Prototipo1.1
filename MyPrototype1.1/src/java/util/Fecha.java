/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Fecha del modelo  
 *  @since: prototipo1.1
 *  @source: Fecha.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	/* Objecto de la clase Calendar que utilizaremos para registrar una marca de tiempo */
	private Calendar tiempo;

	/* Constructores de la clase */
	public Fecha() {
		this.tiempo = new GregorianCalendar();
	}

	public Fecha(int year, int month, int day) {
		this.tiempo = new GregorianCalendar(year, month - 1, day);
	}

	public Fecha(int year, int month, int day, int hour, int minute, int second) {
		this.tiempo = new GregorianCalendar(year, month - 1, day, hour, minute, second);
	}

	public Fecha(Fecha fecha) {
		this.tiempo = fecha.tiempo;
	}

	/* Metodos de establecimiento / obtencion de datos */
	public int getAño() {
		return tiempo.get(Calendar.YEAR);
	}

	public void setAño(int year) {
		tiempo.set(Calendar.YEAR, year);
	}

	public int getMes() {
		return tiempo.get(Calendar.MONTH) + 1;
	}

	public void setMes(int month) {
		tiempo.set(Calendar.MONTH, month);
	}

	public int getDia() {
		return tiempo.get(Calendar.DAY_OF_MONTH);
	}

	public void setDia(int day) {
		tiempo.set(Calendar.DAY_OF_MONTH, day);
	}

	public int getSeg() {
		return tiempo.get(Calendar.SECOND);
	}

	public void setSeg(int second) {
		tiempo.set(Calendar.SECOND, second);
	}

	public int getMinuto() {
		return tiempo.get(Calendar.MINUTE);
	}

	public void setMinuto(int minute) {
		this.tiempo.set(Calendar.MINUTE, minute);
	}

	public int getHora() {
		return tiempo.get(Calendar.HOUR_OF_DAY);
	}

	public void setHora(int hour) {
		this.tiempo.set(Calendar.HOUR_OF_DAY, hour);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
		return result;
	}
/**
 * Dos objetos son iguales si.
 * Son de la misma clase.
 * Tienen los mismos valores en los atributos o son el mismo objeto.
 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (this.tiempo.getTimeInMillis() == ((Fecha) obj).tiempo.getTimeInMillis()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(String.valueOf(getAño()));
		sb.append("/");
		sb.append(String.valueOf(getMes()));
		sb.append("/");
		sb.append(String.valueOf(getDia()));
		sb.append(")");
		return sb.toString();
	}

	@Override
	protected Fecha clone() {
		return new Fecha(this);
	}
}
