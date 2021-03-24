public class Product {
    protected int barCode;
    protected String name;
    protected float price;

    public int getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
