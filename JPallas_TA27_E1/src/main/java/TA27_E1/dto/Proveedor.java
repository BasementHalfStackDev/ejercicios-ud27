/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {

	// Attributes
	@Id
	private String id;

	private String nombre;

	@OneToMany
	@JoinColumn(name = "FK_proveedor")
	private List<Suministro> suministro;

	// Constructors
	public Proveedor() {
	}

	public Proveedor(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// Getters
	public String getId() {
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
	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSuministro(List<Suministro> suministro) {
		this.suministro = suministro;
	}

}
