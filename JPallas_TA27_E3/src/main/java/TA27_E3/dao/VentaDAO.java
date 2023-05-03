/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E3.dto.Venta;

public interface VentaDAO extends JpaRepository<Venta, Long> {

}
