/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E4.dao.EquipoDAO;
import TA27_E4.dto.Equipo;

@Service // Assign Service
public class EquipoService {

	// Load DAO
	@Autowired
	EquipoDAO equipoDAO;

	// CRUD functions
	public List<Equipo> listEquipos() {
		return equipoDAO.findAll();
	}

	public Equipo saveEquipo(Equipo equipo) {
		return equipoDAO.save(equipo);
	}

	public Equipo equipoById(String id) {
		return equipoDAO.findById(id).get();
	}

	public Equipo updateEquipo(Equipo equipo) {
		return equipoDAO.save(equipo);
	}

	public void deleteEquipo(String id) {
		equipoDAO.deleteById(id);
	}

}
