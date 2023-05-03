/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TA27_E3.dto.Cajero;
import TA27_E3.service.CajeroService;

@RestController // Rest controller
@RequestMapping("/api")
public class CajeroController {

	// Implement service
	@Autowired
	CajeroService cajeroService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/cajeros")
	public List<Cajero> listCajeros() {
		return cajeroService.listCajeros();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/cajeros/{id}")
	public Cajero cajeroById(@PathVariable(name = "id") Long id) {
		Cajero cajeroxID = new Cajero();

		cajeroxID = cajeroService.cajeroById(id);

		return cajeroxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/cajeros")
	public Cajero saveCajero(@RequestBody Cajero cajero) {
		return cajeroService.saveCajero(cajero);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/cajeros/{id}")
	public Cajero updateCajero(@PathVariable(name = "id") Long id, @RequestBody Cajero cajero) {
		Cajero selectedCajero = new Cajero(id, cajero.getNombre_apellidos());
		Cajero updatedCajero = new Cajero();

		updatedCajero = cajeroService.updateCajero(selectedCajero);
		return updatedCajero;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/cajeros/{id}")
	public void deleteCajero(@PathVariable(name = "id") Long id) {
		cajeroService.deleteCajero(id);
	}

}
