package com.krakedev.product;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoControllerr {
	private ProductoServicee productoService;

    public ProductoControllerr(ProductoServicee productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Productoo crear(@RequestBody Productoo producto) {
        return productoService.crear(producto);
    }

    @GetMapping
    public ArrayList<Productoo> listar() {
        return productoService.listar();
    }

    @GetMapping("/{codigo}")
    public Productoo buscarPorCodigo(@PathVariable int codigo) {
        return productoService.buscarPorCodigo(codigo);
    }

    @PutMapping("/{codigo}")
    public Productoo actualizar(
            @PathVariable int codigo,
            @RequestBody Productoo productoActualizado) {

        return productoService.actualizar(codigo, productoActualizado);
    }

    @DeleteMapping("/{codigo}")
    public boolean eliminar(@PathVariable int codigo) {
        return productoService.eliminar(codigo);
    }

}
