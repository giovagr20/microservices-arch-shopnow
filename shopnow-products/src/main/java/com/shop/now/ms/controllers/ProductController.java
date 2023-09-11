package com.shop.now.ms.controllers;

import com.shop.now.ms.exceptions.NotFoundException;
import com.shop.now.ms.models.dtos.ProductDto;
import com.shop.now.ms.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Controller to handle operation of products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Endpoint to create a new product")
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody @Valid ProductDto productDto) {
        if (ObjectUtils.anyNull(productDto)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok()
                .body(productService.createProduct(productDto)
                        .orElseThrow(NotFoundException::new));
    }

    @GetMapping
    @Operation(summary = "Endpoint to obtain all products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok()
                .body(productService.getProducts()
                        .orElseThrow(NotFoundException::new));
    }

    @GetMapping("/{idProduct}")
    @Operation(summary = "Endpoint to obtain product by id")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable("idProduct") String idProduct) {
        return ResponseEntity.ok()
                .body(productService.getProductByName(idProduct)
                        .orElseThrow(NotFoundException::new));
    }

    @PutMapping
    @Operation(summary = "Endpoint to update product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok()
                .body(productService.updateProduct(productDto)
                        .orElseThrow(NotFoundException::new));
    }

    @DeleteMapping
    @Operation(summary = "Endpoint to delete a product")
    public ResponseEntity<Boolean> deleteProduct(@RequestBody ProductDto productDto) {
        productService.deleteProduct(productDto);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
