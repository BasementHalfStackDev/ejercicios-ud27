/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E1.dao.SuministroDAO;
import TA27_E1.dto.Suministro;

@Service // Assign Service
public class SuministroService {

	// Load DAO
	@Autowired
	SuministroDAO suministroDAO;

	// CRUD functions
	public List<Suministro> listSuministros() {
		return suministroDAO.findAll();
	}

	public Suministro saveSuministro(Suministro suministro) {
		return suministroDAO.save(suministro);
	}

	public Suministro suministroById(Long id) {
		return suministroDAO.findById(id).get();
	}

	public Suministro updateSuministro(Suministro suministro) {
		return suministroDAO.save(suministro);
	}

	public void deleteSuministro(Long id) {
		suministroDAO.deleteById(id);
	}

}
