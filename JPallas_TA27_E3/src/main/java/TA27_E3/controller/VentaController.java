/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TA27_E3.dto.Venta;
import TA27_E3.service.VentaService;

@RestController // Rest controller
@RequestMapping("/api")
public class VentaController {

	// Implement service
	@Autowired
	VentaService ventaService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/ventas")
	public List<Venta> listVentas() {
		return ventaService.listVentas();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/ventas/{id}")
	public Venta ventaById(@PathVariable(name = "id") Long id) {
		Venta ventaxID = new Venta();

		ventaxID = ventaService.ventaById(id);

		return ventaxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/ventas")
	public Venta saveVenta(@RequestBody Venta venta) {
		return ventaService.saveVenta(venta);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/ventas/{id}")
	public Venta updateVenta(@PathVariable(name = "id") Long id, @RequestBody Venta venta) {
		Venta selectedVenta = new Venta(id, venta.getCajero(), venta.getProducto(), venta.getMaquina_registradora());
		Venta updatedVenta = new Venta();

		updatedVenta = ventaService.updateVenta(selectedVenta);
		return updatedVenta;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/ventas/{id}")
	public void deleteVenta(@PathVariable(name = "id") Long id) {
		ventaService.deleteVenta(id);
	}

}
