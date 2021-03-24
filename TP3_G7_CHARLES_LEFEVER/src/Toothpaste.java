public class Toothpaste extends Hygiene {
    public Toothpaste(int barCode, String name, float price){
        this.barCode=barCode;
        this.name=name;
        this.price=price;
    }

    @Override
    public String getName() {
        return "Dentifrice " + this.name;
    }
}
