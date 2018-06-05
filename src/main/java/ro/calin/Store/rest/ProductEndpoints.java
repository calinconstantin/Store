package ro.calin.Store.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.calin.Store.models.Product;
import ro.calin.Store.service.ProductService;
import ro.calin.Store.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/product")
public class ProductEndpoints {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/create", method =RequestMethod.POST)
    public ResponseEntity<?> CreateProduct (@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @RequestMapping(value="/delete", method =RequestMethod.POST)
    public ResponseEntity<?> DeleteProduct (@RequestBody Product product){
        return ResponseEntity.ok(productService.deleteProduct(product));
    }
}
