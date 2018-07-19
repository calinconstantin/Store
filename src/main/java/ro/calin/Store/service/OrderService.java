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
        if(order.getOrderedProducts().size()>0 && order.getOrderedProducts().size()<=20 )
        {
            orderRepository.save(order);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean deleteOrder(Long idOrder){
        if(orderRepository.findById(idOrder).isPresent())
        {
            orderRepository.deleteById(idOrder);
            return true;
        }
        else
            return false;
    }

    public boolean confirmOrder(Long idOrder){
        Order order;
        if(orderRepository.findById(idOrder).isPresent())
             order = orderRepository.findById(idOrder).get();
        else
            return false;
        order.setConfirmed(true);
        orderRepository.save(order);
        return true;
    }

    public boolean orderDelivered(Long idOrder){
        Order order;
        if(orderRepository.findById(idOrder).isPresent())
            order = orderRepository.findById(idOrder).get();
        else
            return false;
        order.setDelivered(true);
        orderRepository.save(order);
        return true;
    }


}
