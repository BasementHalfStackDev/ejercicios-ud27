/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TA27_E1.dto.Pieza;
import TA27_E1.service.PiezaService;

@RestController // Rest controller
@RequestMapping("/api")
public class PiezaController {

	// Implement service
	@Autowired
	PiezaService piezaService;

	@GetMapping("/piezas")
	public List<Pieza> listPiezas() {
		return piezaService.listPiezas();
	}

	@GetMapping("/piezas/{id}")
	public Pieza piezaById(@PathVariable(name = "id") Long id) {
		Pieza piezaxID = new Pieza();

		piezaxID = piezaService.piezaById(id);

		return piezaxID;
	}

	@PostMapping("/piezas")
	public Pieza savePieza(@RequestBody Pieza pieza) {
		return piezaService.savePieza(pieza);
	}

	@PutMapping("/piezas/{id}")
	public Pieza updatePieza(@PathVariable(name = "id") Long id, @RequestBody Pieza pieza) {
		Pieza selectedPieza = new Pieza(id, pieza.getNombre());
		Pieza updatedPieza = new Pieza();

		updatedPieza = piezaService.updatePieza(selectedPieza);
		return updatedPieza;
	}

	@DeleteMapping("/piezas/{id}")
	public void deletePieza(@PathVariable(name = "id") Long id) {
		piezaService.deletePieza(id);
	}

}
