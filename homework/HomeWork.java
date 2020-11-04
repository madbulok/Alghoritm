package homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();
    private static char[][] map;
    private static int SIZE = 3;
    private static int DOTS_TO_WIN = 3;
    private static char DOT_EMPTY  = '•';
    private static char DOT_X  = 'X';
    private static char DOT_O = 'O';


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true){
            humanTurn();
            if (checkWin    (DOT_X)){
                System.out.println("Human winner");
                break;
            }
            if (isMapFull()){
                System.out.println("Map is full!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)){
                System.out.println("ИИ победил!");
            }
            if (isMapFull()){
                System.out.println("Map is full!");
                break;
            }
        }
        System.out.println("Игра закончена!");
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static  void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты Х У: ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x,y));
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x > SIZE || y < 0 || y > SIZE) return  false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);

        } while (!isCellValid(x,y));
        System.out.println("компьютер ходил в точку " + (x+1) + " " + (y+1));
        map[x][y] = DOT_O;
    }

    public static boolean checkWin(char symb) {
        // check rows winner
        for (int row = 0; row < SIZE; row++) {
            boolean isWin = false;
            for (int column = 0; column < SIZE; column++) {
                if (map[row][column] == symb){
                    isWin = true;
                } else {
                    isWin = false;
                    break;
                }
            }
            if (isWin) return true;
        }

        // check column winner
        for (int row = 0; row < SIZE; row++) {
            boolean isWin = false;
            for (int column = 0; column < SIZE; column++) {
                if (map[column][row] == symb){
                    isWin = true;
                } else {
                    isWin = false;
                    break;
                }

            }
            if (isWin) return true;
        }

        // check diagonal winner
        boolean isWin = false;
        for (int y = 0; y < SIZE; y++) {
            if (map[y][y] == symb){
                isWin = true;
            } else {
                isWin = false;
                break;
            }
        }

        for (int x = SIZE-1, y = 0; x >= 0; x--) {
            if (map[y][x] == symb){
                isWin = true;
            } else {
                isWin = false;
                break;
            }
        }
        return isWin;
    }

}

