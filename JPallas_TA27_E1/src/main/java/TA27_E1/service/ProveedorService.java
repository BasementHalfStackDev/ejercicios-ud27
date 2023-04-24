/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E1.dao.ProveedorDAO;
import TA27_E1.dto.Proveedor;

@Service // Assign Service
public class ProveedorService {

	// Load DAO
	@Autowired
	ProveedorDAO proveedorDAO;

	// CRUD functions
	public List<Proveedor> listProveedores() {
		return proveedorDAO.findAll();
	}

	public Proveedor saveProveedor(Proveedor proveedor) {
		return proveedorDAO.save(proveedor);
	}

	public Proveedor proveedorById(String id) {
		return proveedorDAO.findById(id).get();
	}

	public Proveedor updateProveedor(Proveedor proveedor) {
		return proveedorDAO.save(proveedor);
	}

	public void deleteProveedor(String id) {
		proveedorDAO.deleteById(id);
	}

}
