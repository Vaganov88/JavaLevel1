

public class Main {
    public static void forester() {
        int trees[] = {0, 0, 0, 0, 0};
        int forest[] = {5, 1, 5, 2, 2, 4, 1, 4, 5, 1, 5, 3, 2, 4, 4, 4, 5, 1, 3, 4, 2, 2, 1, 2, 4, 4, 4, 5, 4, 3, 5, 4, 4, 5, 5, 1, 4, 1, 5, 3, 1, 4, 5, 3, 3, 4, 2, 2, 4, 4, 5, 5, 1, 1, 1, 4, 5, 5,
                4, 4, 2, 4, 3, 1, 3, 3, 1, 1, 3, 1, 3, 4, 4, 3, 2, 2, 1, 3, 4, 4, 2, 3, 4, 2, 4, 4, 1, 4, 4, 4, 2, 1, 2, 4, 1, 5, 2, 2, 5, 4, 2, 2, 3, 1, 5, 5, 3, 5, 3, 1, 4, 5, 4, 2, 1, 3,
                1, 2, 1, 4, 1, 3, 4, 2, 2, 5, 2, 3, 1, 1, 2, 3, 3, 4, 4, 2, 4, 1, 2, 2, 2, 5, 1, 5, 1, 2, 2, 1, 3, 3, 4, 3, 5, 3, 5, 1, 2, 1, 3, 3, 2, 4, 1, 4, 3, 5, 1, 2, 1, 2, 3, 2, 1, 3,
                2, 2, 4, 3, 2, 1, 5, 1, 4, 5, 4, 4, 5, 5, 4, 2, 3, 5, 1, 3, 4, 3, 2, 4, 5, 2, 5, 2, 4, 1, 4, 5, 2, 3, 3, 4, 4, 3, 5, 2, 2, 3, 5, 1, 2, 4, 3, 4, 4, 3, 2, 2, 1, 4, 5, 5, 1, 5,
                2,4, 5, 5, 4, 2, 2, 1, 5, 1, 3, 4, 2, 4, 2, 2, 4, 3, 5, 2, 2, 4, 4, 4, 5, 5, 2, 5, 5, 2, 5, 1, 1, 5, 5, 4, 1, 2, 4, 1, 2, 2, 5, 4, 5, 1, 5, 4, 4, 5, 5, 5, 3, 3, 4, 3, 3, 5,
                3, 2, 2, 2, 2, 2, 1, 2, 5, 2, 3, 4, 3, 5, 5, 2, 4, 5, 3, 4, 3, 1, 3, 2, 1, 1, 5, 4, 4, 2, 3, 1, 3, 4, 2, 4, 1, 3, 5, 1, 5, 3, 5, 2, 3, 4, 4, 1, 3, 1, 5, 5, 1, 2, 2, 1, 3, 1,
                5, 1, 2, 2, 1, 5, 1, 3, 3, 2, 1, 3, 2, 5, 1, 1, 2, 3, 5, 5, 4, 3, 1, 3, 3, 1, 5, 4, 2, 3, 4};
        for (int i = 0; i < forest.length; i++) {
            if (forest[i] == 5) {
                trees[4]++;
            } if (forest[i] == 4) {
                trees[3]++;
            } if (forest[i] == 3) {
                trees[2]++;
            } if (forest[i] == 2) {
                trees[1]++;
            } if (forest[i] == 1) {
                trees[0]++;
            }
            }
            System.out.println("Fives: " + trees[4] +" " + "Fours: " + trees[3] +" " + "Threes: " + trees[2] +" " + "Twos: " + trees[1] +" " + "Ones: " + trees[0]);
        }//Additional Task




    public static void main(String[] args) {
        forester();
	Employee[]empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Boss", "ivanoni@ya.ru", 89061234567L, 100000, 50);
        empArray[1] = new Employee("Petrov Petr", "Engineer", "petrovp@ya.ru", 89061234560L, 80000, 38);
        empArray[2] = new Employee("Sidorov Sidr", "Manager", "manager@ya.ru", 89061234565L, 70000, 41);
        empArray[3] = new Employee("Andreev Andrey", "Driver", "andrew88@ya.ru", 89061234564L, 50000, 30);
        empArray[4] = new Employee("Sergeev Sergey", "Mechanic", "mechanic@ya.ru", 89061234561L, 65000, 32);
        System.out.println("Employees older than 40 years age:");
            for (int i=0; i < empArray.length; i++) {
                if (empArray[i].age > 40) {

                    System.out.println(empArray[i].name +" " + empArray[i].post+" " + empArray[i].email+" " + empArray[i].phone+" " +
                            empArray[i].salary+" " + empArray[i].age);
                }//Main task
    }


    }
}
