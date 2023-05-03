/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E3.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "maquinas_registradoras")
public class Maquina_Registradora {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int piso;

	@OneToMany(mappedBy=("maquina_registradora"))
	private List<Venta> venta;

	// Constructors
	public Maquina_Registradora() {
	}

	public Maquina_Registradora(Long id, int piso) {
		this.id = id;
		this.piso = piso;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public int getPiso() {
		return piso;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

}
