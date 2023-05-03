/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TA27_E3.dao.VentaDAO;
import TA27_E3.dto.Venta;

@Service // Assign Service
public class VentaService {

	// Load DAO
	@Autowired
	VentaDAO ventaDAO;

	// CRUD functions
	public List<Venta> listVentas() {
		return ventaDAO.findAll();
	}

	public Venta saveVenta(Venta venta) {
		return ventaDAO.save(venta);
	}

	public Venta ventaById(Long id) {
		return ventaDAO.findById(id).get();
	}

	public Venta updateVenta(Venta venta) {
		return ventaDAO.save(venta);
	}

	public void deleteVenta(Long id) {
		ventaDAO.deleteById(id);
	}

}
