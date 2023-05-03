/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.controller;

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

import TA27_E1.dto.Suministro;
import TA27_E1.service.SuministroService;

@RestController // Rest controller
@RequestMapping("/api")
public class SuministroController {

	// Implement service
	@Autowired
	SuministroService suministroService;

	// Assigns roles needed to access endpoint
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/suministros")
	public List<Suministro> listSuministros() {
		return suministroService.listSuministros();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/suministros/{id}")
	public Suministro suministroById(@PathVariable(name = "id") Long id) {
		Suministro suministroxID = new Suministro();

		suministroxID = suministroService.suministroById(id);

		return suministroxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/suministros")
	public Suministro saveSuministro(@RequestBody Suministro suministro) {
		return suministroService.saveSuministro(suministro);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/suministros/{id}")
	public Suministro updateSuministro(@PathVariable(name = "id") Long id, @RequestBody Suministro suministro) {
		Suministro selectedSuministro = new Suministro(id, suministro.getPieza(), suministro.getProveedor(),
				suministro.getPrecio());
		Suministro updatedSuministro = new Suministro();

		updatedSuministro = suministroService.updateSuministro(selectedSuministro);
		return updatedSuministro;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/suministros/{id}")
	public void deleteSuministro(@PathVariable(name = "id") Long id) {
		suministroService.deleteSuministro(id);
	}

}
