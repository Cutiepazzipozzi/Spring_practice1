package spring.practice.order;

import spring.practice.member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {

    private static Map<String, Order> store = new HashMap<>();

    @Override
    public void save(Order order) {
        store.put(order.getName(), order);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(store.values());
    }
}
