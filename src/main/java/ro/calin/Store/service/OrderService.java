package ro.calin.Store.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.calin.Store.models.Order;
import ro.calin.Store.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public boolean createOrder(Order order){
        orderRepository.save(order);
        return true;
    }

    public boolean deleteOrder(Long idOrder){
        orderRepository.deleteById(idOrder);
        return true;
    }
}
