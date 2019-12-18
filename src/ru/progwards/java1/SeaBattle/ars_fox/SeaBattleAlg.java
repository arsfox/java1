package ru.progwards.java1.SeaBattle.ars_fox;

import ru.progwards.java1.SeaBattle.SeaBattle;

import java.util.HashSet;

public class SeaBattleAlg {


    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|
    //

    static HashSet<Coordinate> coordinateToShoot = new HashSet<>();
    static HashSet<Coordinate> shootDownCell = new HashSet<>();

    int counterRightShoot = 0;
    final int CounterMaxRightShoot = 20;

    public static void killShip() {
        // kill Linkor
        moveSightDiagonally(0, 3);
        moveSightDiagonally(0, 7);
        moveSightDiagonally(2, 9);
        moveSightDiagonally(6, 9);
    }

    // form left bottom to right top
    public static void moveSightDiagonally(int x, int y){
        while ((x < 10)&(y > -1)) {
            coordinateToShoot.add(new Coordinate(x, y));
            y--;
            x++;
        }
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        // min 20 shooters
        System.out.println(coordinateToShoot.isEmpty());
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                System.out.println(fireResult);
            }
        }
    }

    // функция для отладки
    // по линкорам 0:3 - 3:0, 0:7 - 7:0, 2:9 - 9:2, 6:9 - 9:6

    public static void main(String[] args) {
//        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
//        System.out.println(seaBattle);
//        System.out.println(seaBattle.getResult());

    }
}

enum shootStatus {
    DISABLE,
    HIT,
    MISS,
    DESTROYED
}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

