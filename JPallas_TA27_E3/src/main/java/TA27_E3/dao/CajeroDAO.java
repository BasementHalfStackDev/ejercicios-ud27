/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E3.dto.Cajero;

public interface CajeroDAO extends JpaRepository<Cajero, Long> {

}
