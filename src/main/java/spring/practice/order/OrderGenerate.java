package spring.practice.order;

public interface OrderGenerate {
    Order createOrder(String name, String pName, int price, int pNumber);
}
