package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Product;
import com.example.mscatalogo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/producto")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping("/{id}/reduce-stock")
    public ResponseEntity<Product> reducirStock(@PathVariable Integer id, @RequestParam Integer stock) {
        Product productoActualizado = productService.reducirStock(id, stock);
        return ResponseEntity.ok(productoActualizado);
    }

    @PostMapping("/{id}/increase-stock")
    public ResponseEntity<Product> incrementarStock(@PathVariable Integer id, @RequestParam Integer stock) {
        Product updatedProduct  = productService.incrementarStock(id, stock);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id,
                                          @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.ok(productService.list());
    }
}
