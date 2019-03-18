public class Main {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat(),
                new Dog(),
                new Dog()
        };

        animals[1].setLimitRun(400);
        animals[2].setLimitRun(600);
        animals[2].setLimitJump(2);

        for (Animal animal : animals) {
            String cname = animal.getClass().getName();
            System.out.println(cname + ": run(500):  " + animal.run(200));
            System.out.println(cname + ": swim(5):   " + animal.swim(3));
            System.out.println(cname + ": jump(2):   " + animal.jump(1));
            System.out.println();
        }

    }

}


