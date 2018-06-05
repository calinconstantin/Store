package ro.calin.Store.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.calin.Store.models.Order;
import ro.calin.Store.models.Product;
import ro.calin.Store.service.OrderService;

@CrossOrigin
@RequestMapping
@RestController
public class OrderEndpoints {

    @Autowired
    OrderService orderService;

    @RequestMapping(value="/create", method =RequestMethod.POST)
    public ResponseEntity<?> CreateProduct (@RequestBody Order order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @RequestMapping(value="/delete", method =RequestMethod.POST)
    public ResponseEntity<?> DeleteProduct (@RequestBody Order order){
        return ResponseEntity.ok(orderService.deleteOrder(order.getId()));
    }


}
