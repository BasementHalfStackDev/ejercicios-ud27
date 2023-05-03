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

import TA27_E4.dto.Investigador;
import TA27_E4.service.InvestigadorService;

@RestController // Rest controller
@RequestMapping("/api")
public class InvestigadorController {

	// Implement service
	@Autowired
	InvestigadorService investigadorService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/investigadores")
	public List<Investigador> listInvestigadores() {
		return investigadorService.listInvestigadores();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/investigadores/{dni}")
	public Investigador investigadorById(@PathVariable(name = "dni") String dni) {
		Investigador investigadorxID = new Investigador();

		investigadorxID = investigadorService.InvestigadorById(dni);

		return investigadorxID;
	}

	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/investigadores")
	public Investigador saveInvestigador(@RequestBody Investigador investigador) {
		return investigadorService.saveInvestigador(investigador);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/investigadores/{dni}")
	public Investigador updateInvestigador(@PathVariable(name = "dni") String dni,
			@RequestBody Investigador investigador) {
		Investigador selectedInvestigador = new Investigador(dni, investigador.getNombre(), investigador.getFacultad());
		Investigador updatedInvestigador = new Investigador();

		updatedInvestigador = investigadorService.updateInvestigador(selectedInvestigador);
		return updatedInvestigador;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/investigadores/{dni}")
	public void deleteInvestigador(@PathVariable(name = "dni") String dni) {
		investigadorService.deleteInvestigador(dni);
	}

}
