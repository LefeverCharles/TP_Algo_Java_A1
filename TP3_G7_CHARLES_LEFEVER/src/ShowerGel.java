public class ShowerGel extends Hygiene {
    public ShowerGel(int barCode, String name, float price){
        this.barCode=barCode;
        this.name=name;
        this.price=price;
    }

    @Override
    public String getName() {
        return "Gel douche " + this.name;
    }
}
