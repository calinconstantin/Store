package ro.calin.Store.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.calin.Store.models.Product;
import ro.calin.Store.modelsDTO.CreateProductDTO;
import ro.calin.Store.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value="/product")
public class ProductEndpoints {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/create", method =RequestMethod.POST)
    public ResponseEntity<?> CreateProduct (@RequestBody CreateProductDTO product){
        return ResponseEntity.ok(productService.CreateProduct(product));
    }

    @RequestMapping(value="/delete", method =RequestMethod.GET)
    public ResponseEntity<?> DeleteProduct (@RequestParam Long idProduct){
        return ResponseEntity.ok(productService.DeleteProduct(idProduct));
    }

    @RequestMapping(value="/update", method =RequestMethod.POST)
    public ResponseEntity<?> UpdateProduct (@RequestBody Product product){
        return ResponseEntity.ok(productService.UpdateProduct(product));
    }

    @RequestMapping(value="/viewAll", method =RequestMethod.POST)
    public ResponseEntity<?> viewAllProduct (){
        return ResponseEntity.ok(productService.ViewAll());
    }
}
