/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reservas")
public class Reserva {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "equipo")
	private Equipo equipo;

	@ManyToOne
	@JoinColumn(name = "investigador")
	private Investigador investigador;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime comienzo;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fin;

	// Constructors
	public Reserva() {
	}

	public Reserva(Long id, Equipo equipo, Investigador investigador, LocalDateTime comienzo, LocalDateTime fin) {
		this.id = id;
		this.equipo = equipo;
		this.investigador = investigador;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public LocalDateTime getComienzo() {
		return comienzo;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public void setComienzo(LocalDateTime comienzo) {
		this.comienzo = comienzo;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

}
