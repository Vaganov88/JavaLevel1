public class Main {
    public static void feedingCats(){
        System.out.println("We have 3 little balls of fur:");
        Cat[] x = {new Cat("Babalenkiy", 7), new Cat("Simba", 5), new Cat("Sofia", 15)};
        Plate plate = new Plate(100);
        for (Cat c : x) {

            System.out.println(c);
        }
        System.out.println("\n" + plate);

        System.out.println("increase food by 80");
        plate.increaseFood(80);
        System.out.println(plate);
        System.out.println("----NEXT MEAL---");
        System.out.println("Cats eating:");
        for (Cat c : x) {
            c.eat(plate);
            System.out.println(c);
            System.out.println(plate);
        }
    }

    public static void main(String[] args) {

       feedingCats();
    }
}
