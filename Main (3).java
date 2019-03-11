import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void guessNumber() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Your have 3 attempts to guess the number from 0 to 9");
        Random random = new Random();
        int number = random.nextInt(10);

        for (int attempts = 0; attempts <= 2; attempts++) {
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Great, you won!" + " " + "The right number was" + " " + number);
                break;
                    }else if (attempts >= 2) {
                    System.out.println("Sorry, you loose");
                        }else if (input_number > number) {
                    System.out.println("The right number is smaller");

                            }else {

                    System.out.println("The right number is bigger");
           }
        }

    }


    public static void chooseOption() {
        while (true) {
        System.out.println("Press '1' if you want to try again. Press '0' if you want to quit");
        Scanner scanner = new Scanner (System.in);
        int option = scanner.nextInt();

             if (option == 1) {
                 guessNumber();
             } else {
                 System.out.println("See you soon!");
                 break;
             }
         }
    }// 1. First task.

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        Random random = new Random();
        int pos = random.nextInt(words.length);
        String word = words[pos];
        System.out.println("Guess the word");

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your answer:");
            String answer = scanner.nextLine();
                if (word.equals(answer)) {
                    System.out.println("Congratulations! You're right!");
                break;
            }
            char[] charsAnswer = answer.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                if (i >= charsAnswer.length) {
                    break;
                }
                else if (word.charAt(i) != charsAnswer[i]){
                    charsAnswer[i] = '#';
                }
            }
            StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
            for (int i = comment.length(); i < 15; i++) comment.append("#");
            System.out.println(comment);
        }
        while (true);
    }// 2. Second task

    public static void main(String[] args) {
        guessNumber();
        chooseOption();
        guessWord();

    }
}
