package geekbrains.offles4;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * 1) Сначала создание поля
 * 2) Ход первого игрока
 * 3) Проверка победы
 * 4) Ход второго игрока
 * 5) Проверка победы
 * 6) Проверка заполнено ли поле(ничья)
 * 7)
 */
public class Main {
    private static final char DOT_EMPTY = '$';
    private static final char DOT_X = 'X';
    private static final char DOT_0='0';
    private static final char SIZE =3;
    private static char[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    public static void main(String[] args) {
        isSizeMoreThanTwo();
        initMap();
        printMap();
        while (true)
        {
            humanTurn();
            aiTurn();
        }
            }


    private static void isSizeMoreThanTwo() {
        if(SIZE < 3)
        {
            System.out.println("Минимальный размер поля 3х3");
            System.exit(1);
        }
    }

    private static void aiTurn()
            {
                int x=-1;
                int y=-1;

                do {

                        System.out.println("Введите координаты X и Y");
                        x = random.nextInt(SIZE);
                        y = random.nextInt(SIZE);

                }while(!isValid(x,y));
                map [y][x] = DOT_0;

            }
    private static void humanTurn()
    {
        int x=-1;
        int y=-1;

        do {
            try {
            System.out.println("Введите координаты X и Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            }catch( NoSuchElementException | IllegalStateException e){
                System.out.println("Введите числа");
                scanner = new Scanner(System.in);
            }
            }while(!isValid(x,y));
        map [y][x] = DOT_X;
    }
    private static boolean isValid(int x, int y)
    {
        return x>=0 && x<SIZE
                && y>=0 && y<SIZE
                && map [y][x] == DOT_EMPTY;
    }
    private static void initMap()
    {
        map = new char[SIZE][SIZE];
        for(int i = 0; i<SIZE; i++)
        {
            for(int j = 0; j<SIZE; j++)
            {
                map[i][j]= DOT_EMPTY;
            }
        }
    }
    private static void printMap()
    {
        System.out.println();
        for(int i = 0; i<SIZE; i++)
        {
            for(int j = 0; j<SIZE; j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
