import java.util.Random;
import java.util.Scanner;

public class Main {


        private static Scanner scanner = new Scanner(System.in);
        private static Random random = new Random();

        private static final int SIZE = 5;
        private static final int DOTS_FOR_WIN = 4;
        private static final char DOT_X = 'X';
        private static final char DOT_O = 'O';
        private static final char DOT_EMPTY = '.';
        private static final char[] players = new char[]{DOT_X, DOT_O};
        private static char[][] map;
        private static int emptyFields;
        private static int lastRow;
        private static int lastCol;




        private static void theGame() {
            System.out.println("Your sign is X");
            while (true) {
                for (char player : players) {
                    if (isFilled()) {
                        System.out.println("Draw");
                        return;
                    } else if (turn(player)) {
                        System.out.println(" The winner is " + player);
                        return;
                    }
                }
            }
        }
    private static void printMap() {

        for (char[] row : map) {
            for (char item : row) {

                System.out.print(" | "  + item);
            }
            System.out.println();
        }
    }
        private static boolean turn(char value) {
            switch (value) {
                case DOT_X:
                    humanStep();
                    break;
                case DOT_O:
                    computerStep();
                    break;
                default:
                    System.out.println("Who are you?");
            }
            printMap();
            --emptyFields;
            return checkWin(value);
        }



        private static void initMap() {
            map = new char[SIZE][SIZE];
            emptyFields = SIZE * SIZE;
            for (int row = 0; row < map.length; row++) {
                for (int column = 0; column < map.length; column++) {
                    map[row][column] = DOT_EMPTY;

                    System.out.print(" | " + DOT_EMPTY);

                }
                System.out.println();
            }
        }

        private static boolean isFilled() {
            return emptyFields <= 0;
        }

        private static void computerStep() {
            int row;
            int column;
            if (onMap(lastRow, lastCol - 1) && map[lastRow][lastCol - 1] == DOT_X) {
                row = lastRow;
                column = lastCol + 1;
                if (validate(row, column)) {
                    doComputerStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow, lastCol + 1) && map[lastRow][lastCol + 1] == DOT_X) {
                row = lastRow;
                column = lastCol - 1;
                if (validate(row, column)) {
                    doComputerStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow - 1, lastCol) && map[lastRow - 1][lastCol] == DOT_X) {
                row = lastRow + 1;
                column = lastCol;
                if (validate(row, column)) {
                    doComputerStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow + 1, lastCol) && map[lastRow + 1][lastCol] == DOT_X) {
                row = lastRow - 1;
                column = lastCol;
                if (validate(row, column)) {
                    doComputerStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow - 1, lastCol - 1) && map[lastRow - 1][lastCol - 1] == DOT_X) {
                row = lastRow + 1;
                column = lastCol + 1;
                if (validate(row, column)) {
                    doComputerStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow + 1, lastCol + 1) && map[lastRow + 1][lastCol + 1] == DOT_X) {
                row = lastRow - 1;
                column = lastCol - 1;
                if (validate(row, column)) {
                    doComputerStep(row, column);
                    return;
                }
            }

            row = column = SIZE / 2;
            if (!validate(row, column)) {
                do {
                    row = random.nextInt(SIZE);
                    column = random.nextInt(SIZE);
                } while (!validate(row, column));
            }
            doComputerStep(row, column);
        }

        private static void doComputerStep(int row, int column) {
            System.out.println("Computer made his step");
            map[row][column] = DOT_O;
        }

        private static void humanStep() {
            int row;
            int column;
            do {
                System.out.println("Please, enter coordinates. For example '1 3' ");
                row = scanner.nextInt() - 1;
                column = scanner.nextInt() - 1;
            } while (!validate(row, column));
            lastRow = row;
            lastCol = column;
            map[row][column] = DOT_X;
        }

        private static boolean validate(int row, int column) {
            return onMap(row, column)
                    && map[row][column] == DOT_EMPTY;
        }

        private static boolean onMap(int row, int column) {
            return row >= 0 && row < SIZE
                    && column >= 0 && column < SIZE;
        }

        private static boolean checkWin(char value) {
            boolean row;
            boolean column;
            boolean diagonalLeft;
            boolean diagonalRight;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j <= SIZE - DOTS_FOR_WIN; j++) {
                    row = true;
                    column = true;
                    diagonalLeft = true;
                    diagonalRight = true;
                    for (int k = 0; k < DOTS_FOR_WIN; k++) {
                        row &= (map[i][j + k] == value);
                        column &= (map[j + k][i] == value);
                        if (i <= SIZE - DOTS_FOR_WIN) {
                            diagonalLeft &= (map[i + k][j + k] == value);
                            diagonalRight &= (map[i + k][SIZE - 1 - j - k] == value);
                        } else {
                            diagonalLeft = false;
                            diagonalRight = false;
                        }
                    }
                    if (row || column || diagonalLeft || diagonalRight) return true;
                }
            }
            return false;
        }
    public static void main(String[] args) {

        initMap();
        theGame();
    }
    }



