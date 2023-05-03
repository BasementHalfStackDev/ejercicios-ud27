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
@Table(name = "equipos")
public class Equipo {

	// Attributes
	@Id
	private String id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;

	@OneToMany(mappedBy=("equipo"))
	private List<Reserva> reserva;

	// Constructors
	public Equipo() {
	}

	public Equipo(String id, String nombre, Facultad facultad) {
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
	}

	// Getters
	public String getId() {
		return id;
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
	public void setId(String id) {
		this.id = id;
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
