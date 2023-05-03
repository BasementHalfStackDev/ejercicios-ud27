/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.controller;

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

import TA27_E4.dto.Facultad;
import TA27_E4.service.FacultadService;

@RestController // Rest controller
@RequestMapping("/api")
public class FacultadController {

	// Implement service
	@Autowired
	FacultadService facultadService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/facultades")
	public List<Facultad> listFacultades() {
		return facultadService.listFacultades();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/facultades/{id}")
	public Facultad facultadById(@PathVariable(name = "id") Long id) {
		Facultad facultadxID = new Facultad();

		facultadxID = facultadService.facultadById(id);

		return facultadxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/facultades")
	public Facultad saveFacultad(@RequestBody Facultad facultad) {
		return facultadService.saveFacultad(facultad);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/facultades/{id}")
	public Facultad updateFacultad(@PathVariable(name = "id") Long id, @RequestBody Facultad facultad) {
		Facultad selectedFacultad = new Facultad(id, facultad.getNombre());
		Facultad updatedFacultad = new Facultad();

		updatedFacultad = facultadService.updateFacultad(selectedFacultad);
		return updatedFacultad;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/facultades/{id}")
	public void deleteFacultad(@PathVariable(name = "id") Long id) {
		facultadService.deleteFacultad(id);
	}

}
