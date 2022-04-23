package br.com.frosit.hortifrutsj.resources;

import br.com.frosit.hortifrutsj.domain.Order;
import br.com.frosit.hortifrutsj.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin("*")
public class OrderResource {

    @Autowired
    private OrderService orderService;


    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

}
