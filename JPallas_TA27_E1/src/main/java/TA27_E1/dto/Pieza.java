/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "piezas")
public class Pieza {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToMany
	@JoinColumn(name = "FK_pieza")
	private List<Suministro> suministro;

	// Constructors
	public Pieza() {
	}

	public Pieza(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministro")
	public List<Suministro> getSuministro() {
		return suministro;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSuministro(List<Suministro> suministro) {
		this.suministro = suministro;
	}

}
