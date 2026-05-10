package com.krakedev.product;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ProductoServicee {
	
	private ArrayList<Productoo> productos;

    public ProductoServicee() {
        productos = new ArrayList<>();
    }

    public Productoo crear(Productoo producto) {

        Productoo encontrado = buscarPorCodigo(producto.getCodigo());

        if (encontrado != null) {
            return null;
        }

        productos.add(producto);
        return producto;
    }

    public ArrayList<Productoo> listar() {
        return productos;
    }

    public Productoo buscarPorCodigo(int codigo) {

        for (Productoo producto : productos) {

            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }

        return null;
    }

    public Productoo actualizar(int codigo, Productoo productoActualizado) {

        Productoo encontrado = buscarPorCodigo(codigo);

        if (encontrado != null) {

            encontrado.setNombre(productoActualizado.getNombre());
            encontrado.setPrecio(productoActualizado.getPrecio());
            encontrado.setStock(productoActualizado.getStock());

            return encontrado;
        }

        return null;
    }

    public boolean eliminar(int codigo) {

        Productoo encontrado = buscarPorCodigo(codigo);

        if (encontrado != null) {
            productos.remove(encontrado);
            return true;
        }

        return false;
    }

}
