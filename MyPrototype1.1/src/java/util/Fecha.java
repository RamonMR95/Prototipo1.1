/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Fecha del modelo  
 *  @since: prototipo1.1
 *  @source: Fecha.java 
 *  @version: 1.1 - 2019/01/22 
 *  @author: Ramon Moñino
 */
package util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	/*
	 * Objecto de la clase Calendar que utilizaremos para registrar una marca de
	 * tiempo
	 */
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
		this.tiempo = (Calendar) fecha.tiempo.clone();
	}

	/* Metodos de establecimiento / obtencion de datos */

//	public Calendar getFecha() {
//		return (Calendar)tiempo;
//	}

	public int getYear() {
		return tiempo.get(Calendar.YEAR);
	}

	public void setYear(int year) {
		tiempo.set(Calendar.YEAR, year);
	}

	public int getMonth() {
		return tiempo.get(Calendar.MONTH) + 1;
	}

	public void setMonth(int month) {
		tiempo.set(Calendar.MONTH, month);
	}

	public int getDay() {
		return tiempo.get(Calendar.DAY_OF_MONTH);
	}

	public void setDay(int day) {
		tiempo.set(Calendar.DAY_OF_MONTH, day);
	}

	public int getSec() {
		return tiempo.get(Calendar.SECOND);
	}

	public void setSecs(int second) {
		tiempo.set(Calendar.SECOND, second);
	}

	public int getMin() {
		return tiempo.get(Calendar.MINUTE);
	}

	public void setMin(int minute) {
		this.tiempo.set(Calendar.MINUTE, minute);
	}

	public int getHour() {
		return tiempo.get(Calendar.HOUR_OF_DAY);
	}

	public void setHour(int hour) {
		this.tiempo.set(Calendar.HOUR_OF_DAY, hour);
	}

	public long difSegundos(Fecha fecha) {
		return ((this.tiempo.getTimeInMillis() - fecha.tiempo.getTimeInMillis()) / 1000);
	}

	public long difHoras(Fecha fecha) {
		return ((this.tiempo.getTimeInMillis() - fecha.tiempo.getTimeInMillis()) / (60 * 60 * 1000));
	}

	public long difDias(Fecha fecha) {
		return ((this.tiempo.getTimeInMillis() - fecha.tiempo.getTimeInMillis()) / (24 * 60 * 60 * 1000));
	}

	public Fecha addSegundos(int segundos) {
		this.tiempo.add(Calendar.SECOND, segundos);
		return this;
	}

	public Fecha addMinutos(int minutos) {
		this.tiempo.add(Calendar.MINUTE, minutos);
		return this;
	}

	public Fecha addHoras(int horas) {
		this.tiempo.add(Calendar.HOUR_OF_DAY, horas);
		return this;
	}

	public Fecha addDias(int dias) {
		this.tiempo.add(Calendar.DAY_OF_MONTH, dias);
		return this;
	}

	public Fecha addMeses(int meses) {
		this.tiempo.add(Calendar.MONTH, meses);
		return this;
	}

	public Fecha addAños(int años) {
		this.tiempo.add(Calendar.YEAR, años);
		return this; //resultado se devuelve asi mismo
	}

	public GregorianCalendar toGregorianCalendar() {
		return (GregorianCalendar) tiempo;
	}

	public Date toDate() {
		return tiempo.getTime();
	}

	public long getMarcaTiempoMilisegundos() {
		return tiempo.getTimeInMillis();
	}

	public String toStringMarcaTiempo() {
		return String.format("%4%02%02%02%02%02", getYear(), getMonth(), getDay(), getHour(), getMin(), getSec());
	}

	public int compareTo(Fecha fecha) {
		return tiempo.compareTo(fecha.tiempo);
	}
	
	public boolean before(Fecha fecha) {
		return this.tiempo.before(fecha.tiempo);
	}
	
	public boolean after(Fecha fecha) {
		return this.tiempo.after(fecha.tiempo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
		return result;
	}

	/**
	 * Dos objetos son iguales si. Son de la misma clase. Tienen los mismos valores
	 * en los atributos o son el mismo objeto.
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
		sb.append("( ");
		sb.append(String.valueOf(getYear()));
		sb.append(", ");
		sb.append(String.valueOf(getMonth()));
		sb.append(", ");
		sb.append(String.valueOf(getDay()));
		sb.append(" )");
		return sb.toString();
	}

	@Override
	public Fecha clone() {
		return new Fecha(this);
	}
}
