/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E2.dto.Proyecto;

public interface ProyectoDAO extends JpaRepository<Proyecto, String> {

}
