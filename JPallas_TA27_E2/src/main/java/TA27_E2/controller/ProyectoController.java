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

import TA27_E2.dto.Proyecto;
import TA27_E2.service.ProyectoService;

@RestController // Rest controller
@RequestMapping("/api")
public class ProyectoController {

	// Implement service
	@Autowired
	ProyectoService proyectoService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proyectos")
	public List<Proyecto> listProyectos() {
		return proyectoService.listProyectos();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoById(@PathVariable(name = "id") String id) {
		Proyecto proyectoxID = new Proyecto();

		proyectoxID = proyectoService.proyectoById(id);

		return proyectoxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/proyectos")
	public Proyecto saveProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.saveProyecto(proyecto);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/proyectos/{id}")
	public Proyecto updateProyecto(@PathVariable(name = "id") String id, @RequestBody Proyecto proyecto) {
		Proyecto selectedProyecto = new Proyecto(id, proyecto.getNombre(), proyecto.getHoras());
		Proyecto updatedProyecto = new Proyecto();

		updatedProyecto = proyectoService.updateProyecto(selectedProyecto);
		return updatedProyecto;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/proyectos/{id}")
	public void deleteProyecto(@PathVariable(name = "id") String id) {
		proyectoService.deleteProyecto(id);
	}

}
