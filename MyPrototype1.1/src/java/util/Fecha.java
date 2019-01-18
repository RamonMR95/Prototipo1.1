package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	private Calendar tiempo;

	public Fecha() {
		this.tiempo = new GregorianCalendar();
	}

	public Fecha(int year, int month, int day) {
		this.tiempo = new GregorianCalendar(year, month, day);
	}

	public Fecha(int year, int month, int day, int hour, int minute, int second) {
		this.tiempo = new GregorianCalendar(year, month, day, hour, minute, second);
	}

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Fecha other = (Fecha) obj;
		if (getAño() != other.getAño()) {
			return false;
		}
		if (getMes() != other.getMes()) {
			return false;
		}
		if (getDia() != other.getDia()) {
			return false;
		}
		if (getHora() != other.getHora()) {
			return false;
		}
		if (getMinuto() != other.getMinuto()) {
			return false;
		}
		if (getSeg() != other.getSeg()) {
			return false;
		}
		if (tiempo == null) {
			if (other.tiempo != null)
				return false;
		} else if (!tiempo.equals(other.tiempo))
			return false;
		return true;
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

}
