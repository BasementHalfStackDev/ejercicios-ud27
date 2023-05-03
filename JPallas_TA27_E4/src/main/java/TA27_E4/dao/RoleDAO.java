/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E4.dto.ERole;
import TA27_E4.dto.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
