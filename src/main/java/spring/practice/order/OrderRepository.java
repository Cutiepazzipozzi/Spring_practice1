package spring.practice.order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
