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

import TA27_E3.dto.Maquina_Registradora;
import TA27_E3.service.Maquina_RegistradoraService;

@RestController // Rest controller
@RequestMapping("/api")
public class Maquina_RegistradoraController {

	// Implement service
	@Autowired
	Maquina_RegistradoraService maquina_RegistradoraService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/maquinas_registradoras")
	public List<Maquina_Registradora> listMaquinas_Registradoras() {
		return maquina_RegistradoraService.listMaquinas_Registradoras();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/maquinas_registradoras/{id}")
	public Maquina_Registradora maquina_RegistradoraById(@PathVariable(name = "id") Long id) {
		Maquina_Registradora maquina_RegistradoraxID = new Maquina_Registradora();

		maquina_RegistradoraxID = maquina_RegistradoraService.maquina_registradoraById(id);

		return maquina_RegistradoraxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/maquinas_registradoras")
	public Maquina_Registradora saveMaquina_Registradora(@RequestBody Maquina_Registradora maquina_Registradora) {
		return maquina_RegistradoraService.saveMaquina_Registradora(maquina_Registradora);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/maquinas_registradoras/{id}")
	public Maquina_Registradora updateMaquina_Registradora(@PathVariable(name = "id") Long id,
			@RequestBody Maquina_Registradora maquina_Registradora) {
		Maquina_Registradora selectedMaquina_Registradora = new Maquina_Registradora(id,
				maquina_Registradora.getPiso());
		Maquina_Registradora updatedMaquina_Registradora = new Maquina_Registradora();

		updatedMaquina_Registradora = maquina_RegistradoraService
				.updateMaquina_Registradora(selectedMaquina_Registradora);
		return updatedMaquina_Registradora;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/maquinas_registradoras/{id}")
	public void deleteMaquina_Registradora(@PathVariable(name = "id") Long id) {
		maquina_RegistradoraService.deleteMaquina_Registradora(id);
	}

}
