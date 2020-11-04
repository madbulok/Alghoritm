package homework.logic;

import java.util.Random;

public class Logic {
    private static Random random = new Random();
    private char[][] map;
    private boolean finishedGame;
    private int SIZE;
    private int DOTS_TO_WIN;
    private char DOT_EMPTY  = '•';
    private char DOT_X  = 'X';
    private char DOT_O = 'O';
    public static String statusGame = "";

    public char getDOT_X() {
        return DOT_X;
    }

    public char getDOT_O() {
        return DOT_O;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public boolean isFinishedGame() {
        return finishedGame;
    }

    public void setFinishedGame(boolean finishedGame) {
        this.finishedGame = finishedGame;
    }

    public int getSIZE() {
        return SIZE;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }

    public int getDOTS_TO_WIN() {
        return DOTS_TO_WIN;
    }

    public void setDOTS_TO_WIN(int DOTS_TO_WIN) {
        this.DOTS_TO_WIN = DOTS_TO_WIN;
    }

    private void go() {
        finishedGame = true;
        if (checkWin(DOT_X)){
            statusGame = "Победил человек!";
            return;
        }
        if (isMapFull()){
            statusGame = "Ничья!";
            return;
        }
        aiTurn();
        if (checkWin(DOT_O)){
            statusGame = "ИИ победил!";
            return;
        }
        if (isMapFull()){
            statusGame = "Ничья!";
            return;
        }
        finishedGame = false;
    }

    private boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public void humanTurn(int y, int x) {
        System.out.println(x+ "  " + y);
        statusGame = "Ходит человек!";
        if (isCellValid(y,x)){
            map[y][x] = DOT_X;
            go();
        }
    }

    private boolean isCellValid(int y, int x) {
        if (x < 0 || x > SIZE || y < 0 || y > SIZE){
            return  false;
        }
        if (map[y][x] == DOT_EMPTY){
            return true;
        }
        return false;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);

        } while (!isCellValid(y,x));
        System.out.println("компьютер ходил в точку " + (y+1) + " " + (x+1));
        map[y][x] = DOT_O;
    }

    private boolean checkWin(char symb) {
        // check rows winner
        if (checkRowsWinner(symb)) return true;

        // check column winner
        if (checkColumnWinner(symb)) return true;

        // check diagonal winner
        if (checkLeftDiagonalWinner(symb)) return true;
        return checkRightDiagonalWinner(symb);
    }

    private boolean checkRightDiagonalWinner(char symb) {
        for (int y = 0, x = SIZE - 1; y < SIZE; y++, x--) {
            if (map[y][x] != symb){
                return false;
            }
        }
        return true;
    }

    private boolean checkLeftDiagonalWinner(char symb){
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] != symb){
                return false;
            }
        }
        return true;
    }

    private boolean checkColumnWinner(char symb) {
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
        return false;
    }

    private boolean checkRowsWinner(char symb) {
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
        return false;
    }

}
