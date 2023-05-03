/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import TA27_E2.dto.User;

public interface UserDAO extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
