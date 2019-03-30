package batch.entity;

public class PriceEntity {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PriceEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
