/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cientificos")
public class Cientifico {

	// Attributes
	@Id
	private String dni;

	private String nombre_apellidos;

	@OneToMany(mappedBy=("cientifico"))
	private List<Asignado_A> asignado_a;

	// Constructors
	public Cientifico() {
	}

	public Cientifico(String dni, String nombre_apellidos) {
		this.dni = dni;
		this.nombre_apellidos = nombre_apellidos;
	}

	// Getters
	public String getDni() {
		return dni;
	}

	public String getNombre_apellidos() {
		return nombre_apellidos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado_A")
	public List<Asignado_A> getAsignado_a() {
		return asignado_a;
	}

	// Setters
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre_apellidos(String nombre_apellidos) {
		this.nombre_apellidos = nombre_apellidos;
	}

	public void setAsignado_a(List<Asignado_A> asignado_a) {
		this.asignado_a = asignado_a;
	}

}
