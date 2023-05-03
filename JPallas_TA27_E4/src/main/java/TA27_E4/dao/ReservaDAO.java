/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E4.dto.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Long> {

}
