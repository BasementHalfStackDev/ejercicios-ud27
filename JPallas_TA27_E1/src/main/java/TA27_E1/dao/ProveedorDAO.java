/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E1.dto.Proveedor;

public interface ProveedorDAO extends JpaRepository<Proveedor, String> {

}
