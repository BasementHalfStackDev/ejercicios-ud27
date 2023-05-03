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

import TA27_E3.dto.Producto;
import TA27_E3.service.ProductoService;

@RestController // Rest controller
@RequestMapping("/api")
public class ProductoController {

	// Implement service
	@Autowired
	ProductoService productoService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/productos")
	public List<Producto> listProductos() {
		return productoService.listProductos();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/productos/{id}")
	public Producto productoById(@PathVariable(name = "id") Long id) {
		Producto productoxID = new Producto();

		productoxID = productoService.productoById(id);

		return productoxID;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/productos")
	public Producto saveProducto(@RequestBody Producto producto) {
		return productoService.saveProducto(producto);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/productos/{id}")
	public Producto updateProducto(@PathVariable(name = "id") Long id, @RequestBody Producto producto) {
		Producto selectedProducto = new Producto(id, producto.getNombre(), producto.getPrecio());
		Producto updatedProducto = new Producto();

		updatedProducto = productoService.updateProducto(selectedProducto);
		return updatedProducto;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/productos/{id}")
	public void deleteProducto(@PathVariable(name = "id") Long id) {
		productoService.deleteProducto(id);
	}

}
