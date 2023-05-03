/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "investigadores")
public class Investigador {

	// Attributes
	@Id
	private String dni;

	private String nombre;

	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;

	@OneToMany(mappedBy=("investigador"))
	private List<Reserva> reserva;

	// Constructors
	public Investigador() {
	}

	public Investigador(String dni, String nombre, Facultad facultad) {
		this.dni = dni;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	// Getters
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	// Setters
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

}
