public class Spaghetti extends Food {
    public Spaghetti(int barCode, String name, float price){
        this.barCode=barCode;
        this.name=name;
        this.price=price;
    }

    @Override
    public String getName() {
        return "Spaghetti "+ this.name;
    }
}
