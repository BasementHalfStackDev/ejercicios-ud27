/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignado_a")
public class Asignado_A {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cientifico")
	private Cientifico cientifico;

	@ManyToOne
	@JoinColumn(name = "proyecto")
	private Proyecto proyecto;

	// Constructors
	public Asignado_A() {
	}

	public Asignado_A(Long id, Cientifico cientifico, Proyecto proyecto) {
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public Cientifico getCientifico() {
		return cientifico;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setCientifico(Cientifico cientifico) {
		this.cientifico = cientifico;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
