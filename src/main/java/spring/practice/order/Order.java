package spring.practice.order;

public class Order {
    private String name;
    private String pName;
    private int price;
    private int pNumber;
    private int discountPrice;

    public Order(String name, String pName, int price, int pNumber, int discountPrice) {
        this.name = name;
        this.pName = pName;
        this.price = price;
        this.pNumber = pNumber;
        this.discountPrice = discountPrice;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getpNumber() {
        return pNumber;
    }

    public void setpNumber(int pNumber) {
        this.pNumber = pNumber;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int TotalPrice() {
        return price*pNumber;
    }


}
