/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.controller;

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

import TA27_E2.dto.Asignado_A;
import TA27_E2.service.Asignado_AService;

@RestController // Rest controller
@RequestMapping("/api")
public class Asignado_AController {

	// Implement service
	@Autowired
	Asignado_AService asignado_AService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/asignado_as")
	public List<Asignado_A> listAsignado_As() {
		return asignado_AService.listAsignado_As();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/asignado_as/{id}")
	public Asignado_A asignado_AById(@PathVariable(name = "id") Long id) {
		Asignado_A asignado_AxID = new Asignado_A();

		asignado_AxID = asignado_AService.asignado_AById(id);

		return asignado_AxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/asignado_as")
	public Asignado_A saveAsignado_A(@RequestBody Asignado_A asignado_A) {
		return asignado_AService.saveAsignado_A(asignado_A);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/asignado_as/{id}")
	public Asignado_A updateAsignado_A(@PathVariable(name = "id") Long id, @RequestBody Asignado_A asignado_A) {
		Asignado_A selectedAsignado_A = new Asignado_A(id, asignado_A.getCientifico(), asignado_A.getProyecto());
		Asignado_A updatedAsignado_A = new Asignado_A();

		updatedAsignado_A = asignado_AService.updateAsignado_A(selectedAsignado_A);
		return updatedAsignado_A;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/asignado_as/{id}")
	public void deleteAsignado_A(@PathVariable(name = "id") Long id) {
		asignado_AService.deleteAsignado_A(id);
	}

}
