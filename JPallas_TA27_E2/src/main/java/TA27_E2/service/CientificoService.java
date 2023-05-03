/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E2.dao.CientificoDAO;
import TA27_E2.dto.Cientifico;

@Service // Assign Service
public class CientificoService {

	// Load DAO
	@Autowired
	CientificoDAO cientificoDAO;

	// CRUD functions
	public List<Cientifico> listCientificos() {
		return cientificoDAO.findAll();
	}

	public Cientifico saveCientifico(Cientifico cientifico) {
		return cientificoDAO.save(cientifico);
	}

	public Cientifico cientificoById(String id) {
		return cientificoDAO.findById(id).get();
	}

	public Cientifico updateCientifico(Cientifico cientifico) {
		return cientificoDAO.save(cientifico);
	}

	public void deleteCientifico(String id) {
		cientificoDAO.deleteById(id);
	}

}
