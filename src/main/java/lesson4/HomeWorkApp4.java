/*package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {
    public static final String HEADER_FIRST_SYMBOL = "*";
    public static final String SPACE_MAP_SYMBOL = " ";
    private static final int SIZE = 3; //размер игрового поля

    private static final char DOT_EMPTY = '.';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';

    private static final char[][] MAP = new char[SIZE][SIZE];

    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {      //структура игры
        initMap();
        printMap();
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i + 1 + SPACE_MAP_SYMBOL);
            for (int j = 0; j < SIZE; j++) {
                printMapNumber(MAP[i][j] + SPACE_MAP_SYMBOL);
            }
            System.out.println();
        }
    }

    private static void printHeaderMap() {
        printMapNumber(HEADER_FIRST_SYMBOL + SPACE_MAP_SYMBOL);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i + 1 + SPACE_MAP_SYMBOL);
        }
        System.out.println();
    }

    private static void printMapNumber(String i) {
        System.out.print(i);
    }

    private static void playGame() {         //логика игры
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }
            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static void humanTurn() {            //ход человека
        System.out.println("\nХод человека!");
        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.print("Введите координату строки: ");
            rowNumber = in.nextInt() - 1;

            System.out.println("Введите координату столбца: ");
            columnNumber = in.nextInt() - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ошибка! Ячейка с координатами %s:%s уже используется%n", rowNumber + 1, columnNumber + 1);
        }

        MAP[rowNumber][columnNumber] = DOT_HUMAN;

    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void aiTurn() {                       //ход компа
        System.out.println("\nХод компьютера!");

        int rowNumber;
        int columnNumber;

        do {
            rowNumber = random.nextInt(SIZE);

            columnNumber = random.nextInt(SIZE);

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
    }

    private static boolean checkEnd(char symbol) {            //проверка на окончание игры
        if (checkWin(symbol)) {
        }
        return false;
    }

    private static boolean checkWin(char symbol) {      //проверка на победу
        int h, v;  //h - горизонталь, v - вертикаль
        int diagMain, diagReverse;
        for (int i = 0; i < SIZE; i++) {
            h = 0;
            v = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == symbol) {
                    h++;
                } else if (MAP[i][j] != symbol && h < SIZE) {
                    h = 0;
                }
                if (MAP[i][j] == symbol) {
                    v++;
                } else if (MAP[i][j] != symbol && v < SIZE) {
                    v = 0;
                }
            }
            if (h >= SIZE || v >= SIZE) {
                System.out.println("По горизонтали или вертикали " + h + " " + v);
                return true;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            diagMain = 0;
            for (int j = 0; j < SIZE; j++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[i][j] == symbol) {
                        diagMain++;
                    } else if (MAP[j][k] != symbol && diagMain < SIZE) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= SIZE) {
                    System.out.println("По главной диагонали от центральной оси вправо " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[k][i] == symbol) {                      // проверяем главную диагональ от центральной оси вниз на возможную победу
                        diagMain++;
                    } else if (MAP[k][i] != symbol && diagMain < SIZE) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= SIZE) {
                    System.out.println("По главной диагонали от центральной оси вниз " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 0; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < SIZE) {
                    if (MAP[l][k] == symbol) {                     // проверяем побочную диагональ от центральной оси вниз на возможную победу
                        diagReverse++;
                    } else if (MAP[l][k] != symbol && diagReverse < SIZE) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= SIZE) {
                    System.out.println("По побочной диагонали от центральной оси вниз " + diagReverse);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - j - i;
                if (k >= 0) {
                    if (MAP[i][k] == symbol) {     // проверяем побочную диагональ от центральной оси влево на возможную победу
                        diagReverse++;
                    } else if (MAP[i][k] != symbol && diagReverse < SIZE) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= SIZE) {
                    System.out.println("По побочной диагонали от центральной оси влево " + diagReverse);
                    return true;
                }
            }
        }
        return false;

       if (checkWin (DOT_HUMAN)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Вы победили!");
            } else {
                System.out.println("Победил комп!");
            }
            return true;
        }

 /*       if (checkDraw()) {                        //проверка на ничью
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        for (char[] chars : MAP) {
            for (char symbol : chars) {
                if (symbol == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
*/