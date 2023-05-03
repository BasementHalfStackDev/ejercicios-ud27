/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E2.dto.Cientifico;

public interface CientificoDAO extends JpaRepository<Cientifico, String> {

}
