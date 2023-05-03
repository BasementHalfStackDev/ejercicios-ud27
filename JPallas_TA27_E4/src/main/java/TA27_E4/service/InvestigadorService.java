/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E4.dao.InvestigadorDAO;
import TA27_E4.dto.Investigador;

@Service // Assign Service
public class InvestigadorService {

	// Load DAO
	@Autowired
	InvestigadorDAO InvestigadorDAO;

	// CRUD functions
	public List<Investigador> listInvestigadores() {
		return InvestigadorDAO.findAll();
	}

	public Investigador saveInvestigador(Investigador Investigador) {
		return InvestigadorDAO.save(Investigador);
	}

	public Investigador InvestigadorById(String dni) {
		return InvestigadorDAO.findById(dni).get();
	}

	public Investigador updateInvestigador(Investigador Investigador) {
		return InvestigadorDAO.save(Investigador);
	}

	public void deleteInvestigador(String dni) {
		InvestigadorDAO.deleteById(dni);
	}

}
