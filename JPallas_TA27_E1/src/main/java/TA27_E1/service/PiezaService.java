/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E1.dao.PiezaDAO;
import TA27_E1.dto.Pieza;

@Service // Assign Service
public class PiezaService {

	// Load DAO
	@Autowired
	PiezaDAO piezaDAO;

	// CRUD functions
	public List<Pieza> listPiezas() {
		return piezaDAO.findAll();
	}

	public Pieza savePieza(Pieza pieza) {
		return piezaDAO.save(pieza);
	}

	public Pieza piezaById(Long id) {
		return piezaDAO.findById(id).get();
	}

	public Pieza updatePieza(Pieza pieza) {
		return piezaDAO.save(pieza);
	}

	public void deletePieza(Long id) {
		piezaDAO.deleteById(id);
	}

}
