import java.util.HashMap;
import java.util.Scanner;

public class Manager {

    //Nous stockerons les différents produits du magasin en tant que clés dans différentes HashMaps
    //qui correspondront aux différents rayons étudiés, la valeur stockée en vis à vis de chaque clé correspondant à la
    //quantité en stock de chaque article
    private HashMap<Food,Integer> stockFood = new HashMap<>();
    private HashMap<Menager,Integer> stockMenager = new HashMap<>();
    private HashMap<Hygiene,Integer> stockHygiene = new HashMap<>();

    public Manager(){
        /*Initialisation des différentes marques proposées par le magasin*/
        stockFood.put(new Water(0,"Evian", (float) 0.99),0);
        stockFood.put(new Water(1,"Vittel", (float) 1.5),0);
        stockFood.put(new Spaghetti(2,"De Cecco", (float) 2.3),0);
        stockFood.put(new Spaghetti(3,"Rummo", (float) 1.8),0);
        stockMenager.put(new LiquideVaisselle(4,"Paic", (float) 3.4),0);
        stockMenager.put(new LiquideVaisselle(5,"Mir", (float) 2.9),0);
        stockMenager.put(new Assouplissant(6,"Soupline", (float) 4.1),0);
        stockMenager.put(new Assouplissant(7,"Lenor", (float) 3.5),0);
        stockHygiene.put(new Toothpaste(8,"Sensodyne",(float) 2.5),0);
        stockHygiene.put(new Toothpaste(9,"Colgate",(float) 2.7),0);
        stockHygiene.put(new ShowerGel(10,"Dove",(float) 6.4),0);
        stockHygiene.put(new ShowerGel(11,"Ushuaia",(float) 7.6),0);
    }

    /**public void start()
     * Fonction de lancement du logiciel de gestion de stock du magasin
     * Elle lance un menu console qui permet à l'utilisateur d'accéder aux différentes fonctions du programme
     */
    public void start(){

        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        //On utilise cette boucle pour que l'utilisateur revienne sur le menu tant qu'il n'a pas demandé ostensiblement
        //à quitter le logiciel
        while (choice != 0){
            System.out.println("----------------------------------------------------------");
            System.out.println("Bienvenue sur le logiciel de gestion de SuperIsep !\n");
            System.out.println("Faites votre choix :");
            System.out.println("(1) Afficher le stock de tous les produits alimentaires.\n" +
                    "(2) Afficher le stock de tous les produits ménagers.\n" +
                    "(3) Afficher le stock de tous les produits d’hygiène.\n" +
                    "(4) Afficher le stock de tous les produits du supermarché.\n" +
                    "(5) Mettre à jour le stock d’un produit en particulier.\n" +
                    "(0) Quitter le logiciel.\n" +
                    "----------------------------------------------------------");
            choice = scanner.nextInt();

            //Ce switch permet de proposer à l'utilisateur la fonctionnalité qu'il a appelé grâce au nombre indiqué
            //Et reboucle sur le menu si le choix de l'utilisateur n'a pas choisi un nombre correct tout en lui
            // précisant que sa saisie est incorrecte
            switch (choice){
                case 1:
                    this.printStockFood();
                    break;
                case 2:
                    this.printStockMenager();
                    break;
                case 3:
                    this.printStockHygiene();
                    break;
                case 4:
                    this.printStockAll();
                    break;
                case 5:
                    this.updateProduct(scanner);
                    break;
                case 0:
                    System.out.println("Etes-vous sûr de vouloir quitter ce logiciel?(0= Oui, 1= Non)");
                    choice=scanner.nextInt();
                    break;
                default:
                    System.out.println("Votre saisie n'est pas correcte!");
                    break;
            }
        }
    }

    /**public void printStockFood()
     * Fonction qui affiche les différents produits alimentaires vendus par le magasin ainsi que la quantité en stock
     */
    public void printStockFood(){
        System.out.println("--------------------------------\n" +
                "Produits alimentaires\n" +
                "\tNom \t\t\t\t\tQuantité");
        for (Food food: stockFood.keySet()){
            System.out.println("\t"+food.getName()+"\t".repeat(6-food.getName().length()/4)+stockFood.get(food));
            //"\t".repeat(6-food.getName().length()/4)
            //permet d' aligner la quantité avec le titre quantité
        }
        System.out.println("--------------------------------");
    }

    /**public void printStockMenager()
     * Fonction qui affiche les différents produits ménagers vendus par le magasin ainsi que la quantité en stock
     */
    public void printStockMenager(){
        System.out.println("--------------------------------\n" +
                "Produits ménagers\n" +
                "\tNom \t\t\t\t\tQuantité");
        for (Menager menager: stockMenager.keySet()){
            String nameMenager= menager.getName();
            System.out.println("\t"+nameMenager+"\t".repeat(6-nameMenager.length()/4)+stockMenager.get(menager));
        }
        System.out.println("--------------------------------");
    }

    /**public void printStockHygiene()
     * Fonction qui affiche les différents produits d'hygiène vendus par le magasin ainsi que la quantité en stock
     */
    public void printStockHygiene(){
        System.out.println("--------------------------------\n" +
                "Produits d'hygiène\n" +
                "\tNom \t\t\t\t\tQuantité");
        for (Hygiene hygiene: stockHygiene.keySet()){
            String nameHygiene = hygiene.getName();
            System.out.println("\t"+nameHygiene+"\t".repeat(6-nameHygiene.length()/4)+stockHygiene.get(hygiene));
        }
        System.out.println("--------------------------------");
    }

    /**public void printStockHygiene()
     * Fonction qui affiche l'ensemble des produits vendus par le magasin ainsi que la quantité en stock
     */
    public void printStockAll(){
        System.out.println("----------------------------------------\n" +
                "Produits");
        System.out.println("\tProduits alimentaires\n" +
                "\t\tNom \t\t\t\t\tQuantité");
        for (Food food: stockFood.keySet()){
            System.out.println("\t\t"+food.getName()+"\t".repeat(6-food.getName().length()/4)+stockFood.get(food));
        }
        System.out.println("\tProduits ménagers\n" +
                "\t\tNom \t\t\t\t\tQuantité");
        for (Menager menager: stockMenager.keySet()){
            String nameMenager = menager.getName();
            System.out.println("\t\t"+nameMenager+"\t".repeat(6-nameMenager.length()/4)+stockMenager.get(menager));
        }
        System.out.println("\tProduits d'hygiène\n" +
                "\t\tNom \t\t\t\t\tQuantité");
        for (Hygiene hygiene: stockHygiene.keySet()){
            String nameHygiene = hygiene.getName();
            System.out.println("\t\t"+nameHygiene+"\t".repeat(6-nameHygiene.length()/4)+stockHygiene.get(hygiene));
        }
    }

    /**public void updateProduct()
     * Fonction qui permet de mettre à jour la quantité en stock d'un produit
     * @param scanner est un scanner dont la fonction nécessite l'utilisation
     */
    public void updateProduct(Scanner scanner){
        Product productToUpdate=null;
        String typeProduct = "";
        int barCodeToFind;
        System.out.println("Veuillez saisir le code-barre du produit à mettre à jour.");
        barCodeToFind=scanner.nextInt();

        //On cherche le produit correspondant au code-barre indiqué.
        for (Food food: stockFood.keySet()){
            if (food.getBarCode()==barCodeToFind){
                productToUpdate=food;
                typeProduct="Food";
            }
        }
        for (Menager menager: stockMenager.keySet()){
            if (menager.getBarCode()==barCodeToFind){
                productToUpdate=menager;
                typeProduct="Menager";
            }
        }
        for (Hygiene hygiene: stockHygiene.keySet()){
            if (hygiene.getBarCode()==barCodeToFind){
                productToUpdate=hygiene;
                typeProduct="Hygiene";
            }
        }

        //On vérifie que l'on a bien trouvé un produit correspondant au code-barre donné
        if(productToUpdate==null){
            System.out.println("Ce produit ne fait pas partie des produits vendus par le magasin!");
        }


        else{
            System.out.println("Quelle est la nouvelle quantité de ce produit en magasin?");
            int newQuantity = scanner.nextInt();

            //On vérifie que la quantité donnée soit un entier positif ou nul
            if (newQuantity<0){
                System.out.println("La quantité disponible d'un produit ne peut pas être négative!");
            }
            else{
                //Ensuite on met à jour la quantité en stock dans la HashMap qui convient.
                switch(typeProduct){
                    case "Food":
                        stockFood.put((Food) productToUpdate,newQuantity);
                        break;
                    case "Menager":
                        stockMenager.put((Menager) productToUpdate,newQuantity);
                        break;
                    case "Hygiene":
                        stockHygiene.put((Hygiene) productToUpdate,newQuantity);
                        break;
                }
                System.out.println("La quantité de ce produit a bien été mise à jour.");
            }
        }
    }
}
