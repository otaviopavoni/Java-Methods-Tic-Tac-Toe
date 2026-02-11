import java.util.Scanner;
import java.util.Random;

public class Main{

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int row = 0, column = 0;
        int randomRow = 0, randomColumn = 0;

        char[][] array = new char[3][3];

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                array[i][j] = ' ';
            }
        }

        printState(array);
        System.out.println("Welcome to Java Tic Tac Toe!");

        while (true) {

            generateUserShot(array);

            if (checkWhosWinner(array)) break;
            if (isTie(array)) break;

            generateRandomShot(array);

            if (checkWhosWinner(array)) break;
            if (isTie(array)) break;

            printState(array);

        }
    }

    private static boolean checkWhosWinner(char[][] array) {
        char winner = checkWinner(array);
        if (winner == 'X'){
            System.out.println("You won!");
            printState(array);
            return true;
        } else if (winner == 'O'){
            System.out.println("Game over! You lost the game!");
            printState(array);
            return true;
        }
        return false;
    }

    public static char checkWinner(char[][] array) {

            // Linhas
            for (int i = 0; i < 3; i++) {
                if (array[i][0] != ' ' &&
                        array[i][0] == array[i][1] &&
                        array[i][0] == array[i][2]) {
                    return array[i][0];
                }
            }

            // Colunas
            for (int j = 0; j < 3; j++) {
                if (array[0][j] != ' ' &&
                        array[0][j] == array[1][j] &&
                        array[0][j] == array[2][j]) {
                    return array[0][j];
                }
            }

            // Diagonal principal
            if (array[0][0] != ' ' &&
                    array[0][0] == array[1][1] &&
                    array[0][0] == array[2][2]) {
                return array[0][0];
            }

            // Diagonal secundária
            if (array[0][2] != ' ' &&
                    array[0][2] == array[1][1] &&
                    array[0][2] == array[2][0]) {
                return array[0][2];
            }

            return ' ';

    }

    public static void generateUserShot(char[][] array){
        int row, column;
        while (true){
            System.out.println("Type the number of the row you want to play: ");
            row = scanner.nextInt();

            System.out.println("Type the number of the column you want to play: ");
            column = scanner.nextInt();

            if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            row -= 1;
            column -= 1;

            if (array[row][column] == ' ') {
                array[row][column] = 'X';
                break;
            } else {
                System.out.println("There is already something there!");
            }
        }

    }

    public static void generateRandomShot(char[][] array){

        int randomRow, randomColumn;

        if (!isTie(array)){
            while (true){

                randomRow = random.nextInt(3);
                randomColumn = random.nextInt(3);

                if (array[randomRow][randomColumn] == ' ') {
                    array[randomRow][randomColumn] = 'O';
                    break;
                }
            }

        }

    }

    public static boolean isTie(char[][] array){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (array[i][j] == ' '){
                    return false;
                }

            }
        }
        return true;
    }

    public static void printState(char[][] array){
        System.out.print("\n   1   2   3");
        System.out.printf("\n1  %c I %c I %c ", array[0][0], array[0][1], array[0][2]);
        System.out.print("\n  ---+---+---");
        System.out.printf("\n2  %c I %c I %c ", array[1][0], array[1][1], array[1][2]);
        System.out.print("\n  ---+---+---");
        System.out.printf("\n3  %c I %c I %c ", array[2][0], array[2][1], array[2][2]);
    }
}