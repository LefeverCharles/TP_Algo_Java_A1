public class Assouplissant extends Menager{
    public Assouplissant(int barCode, String name, float price){
        this.barCode=barCode;
        this.name=name;
        this.price=price;
    }

    @Override
    public String getName() {
        return "Assouplissant "+ this.name;
    }
}
