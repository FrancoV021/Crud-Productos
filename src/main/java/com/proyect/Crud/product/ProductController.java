package com.proyect.Crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> pedirProductos(){
        return productService.pedirProductos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product){
        return this.productService.nuevoProducto(product);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarProducto(@RequestBody Product product){
        return this.productService.nuevoProducto(product);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Object> eliminarProducto(@PathVariable("productId") Long id){
        return this.productService.delteProduct(id);
    }
}
