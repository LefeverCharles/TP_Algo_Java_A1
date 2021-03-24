public class LiquideVaisselle extends Menager {
    public LiquideVaisselle(int barCode, String name, float price){
        this.barCode=barCode;
        this.name=name;
        this.price=price;
    }

    @Override
    public String getName() {
        return "Liquide Vaisselle " + this.name;
    }
}
