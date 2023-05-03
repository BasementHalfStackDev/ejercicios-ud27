/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E2.dao.ProyectoDAO;
import TA27_E2.dto.Proyecto;

@Service // Assign Service
public class ProyectoService {

	// Load DAO
	@Autowired
	ProyectoDAO proyectoDAO;

	// CRUD functions
	public List<Proyecto> listProyectos() {
		return proyectoDAO.findAll();
	}

	public Proyecto saveProyecto(Proyecto proyecto) {
		return proyectoDAO.save(proyecto);
	}

	public Proyecto proyectoById(String id) {
		return proyectoDAO.findById(id).get();
	}

	public Proyecto updateProyecto(Proyecto proyecto) {
		return proyectoDAO.save(proyecto);
	}

	public void deleteProyecto(String id) {
		proyectoDAO.deleteById(id);
	}

}
