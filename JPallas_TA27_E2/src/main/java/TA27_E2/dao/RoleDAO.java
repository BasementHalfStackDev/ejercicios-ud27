/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E2.dto.ERole;
import TA27_E2.dto.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
