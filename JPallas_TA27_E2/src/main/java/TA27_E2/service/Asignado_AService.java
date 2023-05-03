/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E2.dao.Asignado_ADAO;
import TA27_E2.dto.Asignado_A;

@Service // Assign Service
public class Asignado_AService {

	// Load DAO
	@Autowired
	Asignado_ADAO asignado_ADAO;

	// CRUD functions
	public List<Asignado_A> listAsignado_As() {
		return asignado_ADAO.findAll();
	}

	public Asignado_A saveAsignado_A(Asignado_A asignado_A) {
		return asignado_ADAO.save(asignado_A);
	}

	public Asignado_A asignado_AById(Long id) {
		return asignado_ADAO.findById(id).get();
	}

	public Asignado_A updateAsignado_A(Asignado_A asignado_A) {
		return asignado_ADAO.save(asignado_A);
	}

	public void deleteAsignado_A(Long id) {
		asignado_ADAO.deleteById(id);
	}

}
