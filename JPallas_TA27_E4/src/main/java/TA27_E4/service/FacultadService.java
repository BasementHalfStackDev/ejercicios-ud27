/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E4.dao.FacultadDAO;
import TA27_E4.dto.Facultad;

@Service // Assign Service
public class FacultadService {

	// Load DAO
	@Autowired
	FacultadDAO facultadDAO;

	// CRUD functions
	public List<Facultad> listFacultades() {
		return facultadDAO.findAll();
	}

	public Facultad saveFacultad(Facultad facultad) {
		return facultadDAO.save(facultad);
	}

	public Facultad facultadById(Long id) {
		return facultadDAO.findById(id).get();
	}

	public Facultad updateFacultad(Facultad facultad) {
		return facultadDAO.save(facultad);
	}

	public void deleteFacultad(Long id) {
		facultadDAO.deleteById(id);
	}

}
