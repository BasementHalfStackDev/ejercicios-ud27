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

import TA27_E2.dto.Cientifico;
import TA27_E2.service.CientificoService;

@RestController // Rest controller
@RequestMapping("/api")
public class CientificoController {

	// Implement service
	@Autowired
	CientificoService cientificoService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/cientificos")
	public List<Cientifico> listCientificos() {
		return cientificoService.listCientificos();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/cientificos/{DNI}")
	public Cientifico cientificoById(@PathVariable(name = "DNI") String DNI) {
		Cientifico cientificoxID = new Cientifico();

		cientificoxID = cientificoService.cientificoById(DNI);

		return cientificoxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/cientificos")
	public Cientifico saveCientifico(@RequestBody Cientifico cientifico) {
		return cientificoService.saveCientifico(cientifico);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/cientificos/{DNI}")
	public Cientifico updateCientifico(@PathVariable(name = "DNI") String DNI, @RequestBody Cientifico cientifico) {
		Cientifico selectedCientifico = new Cientifico(DNI, cientifico.getNombre_apellidos());
		Cientifico updatedCientifico = new Cientifico();

		updatedCientifico = cientificoService.updateCientifico(selectedCientifico);
		return updatedCientifico;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/cientificos/{DNI}")
	public void deleteCientifico(@PathVariable(name = "DNI") String DNI) {
		cientificoService.deleteCientifico(DNI);
	}

}
