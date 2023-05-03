/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E3.dao.Maquina_RegistradoraDAO;
import TA27_E3.dto.Maquina_Registradora;

@Service // Assign Service
public class Maquina_RegistradoraService {

	// Load DAO
	@Autowired
	Maquina_RegistradoraDAO maquina_registradoraDAO;

	// CRUD functions
	public List<Maquina_Registradora> listMaquinas_Registradoras() {
		return maquina_registradoraDAO.findAll();
	}

	public Maquina_Registradora saveMaquina_Registradora(Maquina_Registradora maquina_registradora) {
		return maquina_registradoraDAO.save(maquina_registradora);
	}

	public Maquina_Registradora maquina_registradoraById(Long id) {
		return maquina_registradoraDAO.findById(id).get();
	}

	public Maquina_Registradora updateMaquina_Registradora(Maquina_Registradora maquina_registradora) {
		return maquina_registradoraDAO.save(maquina_registradora);
	}

	public void deleteMaquina_Registradora(Long id) {
		maquina_registradoraDAO.deleteById(id);
	}

}
