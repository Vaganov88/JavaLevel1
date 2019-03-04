public class Main {
    byte t = 127;
    short u = 32767;
    int v = 12999769;
    float w = 23.28f;
    double x = 257.698;
    char y = '1';
    boolean z = false; // 2. Создать переменные всех пройденных типов данных и инициализировать их значения.


    public static int calculate (int a, int b, int c, int d){
        return a * (b + (c / d)); /*3. Написать метод вычисляющий выражение a * (b + (c / d))
    и возвращающий результат,где a, b, c, d – входные параметры этого метода.*/
    }


    public static boolean task10and20(int g, int h){
        boolean i = false;
        int j = g + h;
        if (10 <= j && j <= 20) {
          i = true;
            }else {
             i = false;
        }
        return (i);
        } /* 4. Написать метод, принимающий на вход два числа и проверяющий, что их сумма лежит в
пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.*/


    public static void positive_negative (int k){

        if (k < 0) {
            System.out.println("Negative number");
        } else {
            System.out.println("Positive number");
        } /*5. Написать метод, которому в качестве параметра передается целое число, метод должен
напечатать в консоль, положительное ли число передали или отрицательное. Замечание:
ноль считаем положительным числом.*/

    }


    public static boolean negative (int m){
        boolean i = false;
        if (m < 0){
            i = true;
        } else {
            i = false;
        } return (i);
    } /*6. Написать метод, которому в качестве параметра передается целое число. Метод должен
вернуть true, если число отрицательное.*/


    public static void sayName(String name){
        System.out.println("Hello, " + name);

    }/*7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
Метод должен вывести в консоль сообщение «Привет, указанное_имя!».*/


    public static void leapOrdinaryYear (int year){
        int x = 4;
        int y = 100;
        int z = 400;
        if (year % x == 0 && year % y != 0 || year % z == 0) {
            System.out.println("Leap year!");
        } else {
            System.out.println ("ordinary year");
        }

    }

    public static void main(String[] args) { //1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
        System.out.println (calculate(5, 5, 6, 2));
        System.out.println (task10and20(15, 5));
        positive_negative(-5);
        System.out.println(negative(-5));
        sayName("Julia");
        leapOrdinaryYear(1980);
        }

	}
