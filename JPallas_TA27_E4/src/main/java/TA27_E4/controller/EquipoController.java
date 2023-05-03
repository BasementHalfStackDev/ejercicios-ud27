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

import TA27_E4.dto.Equipo;
import TA27_E4.service.EquipoService;

@RestController // Rest controller
@RequestMapping("/api")
public class EquipoController {

	// Implement service
	@Autowired
	EquipoService equipoService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/equipos")
	public List<Equipo> listEquipos() {
		return equipoService.listEquipos();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/equipos/{id}")
	public Equipo equipoById(@PathVariable(name = "id") String id) {
		Equipo equipoxID = new Equipo();

		equipoxID = equipoService.equipoById(id);

		return equipoxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/equipos")
	public Equipo saveEquipo(@RequestBody Equipo equipo) {
		return equipoService.saveEquipo(equipo);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/equipos/{id}")
	public Equipo updateEquipo(@PathVariable(name = "id") String id, @RequestBody Equipo equipo) {
		Equipo selectedEquipo = new Equipo(id, equipo.getNombre(), equipo.getFacultad());
		Equipo updatedEquipo = new Equipo();

		updatedEquipo = equipoService.updateEquipo(selectedEquipo);
		return updatedEquipo;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/equipos/{id}")
	public void deleteEquipo(@PathVariable(name = "id") String id) {
		equipoService.deleteEquipo(id);
	}

}
