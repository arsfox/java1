package ru.progwards.java1.SeaBattle.ars_fox;

import ru.progwards.java1.SeaBattle.SeaBattle;

import java.util.ArrayList;

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

    static ArrayList<Coordinate> shootDownCell = new ArrayList<>();

    static ArrayList<Coordinate> coordinateToShoot = new ArrayList<>();

    int counterRightShoot = 0;
    final int CounterMaxRightShoot = 20;

    public static void generateMatrixCoordinate() {
        // четырёхпалубный
        moveSightDiagonally(0, 3);
        moveSightDiagonally(0, 7);
        moveSightDiagonally(2, 9);
        moveSightDiagonally(6, 9);
        // трёхпалубные и двухпалубные
//        moveSightDiagonally(0, 1);
//        moveSightDiagonally(0, 5);
//        moveSightDiagonally(0, 9);
//        moveSightDiagonally(4, 9);
//        moveSightDiagonally(8, 9);
        // однопалубные
        // - перебор всего за исключением
    }

    // form left bottom to right top
    public static void moveSightDiagonally(int x, int y){
        while ((x < 10)&(y > -1)) {
            coordinateToShoot.add(new Coordinate(x, y));
            y--;
            x++;
        }
    }

    public static boolean isValidCoordsToFier(Coordinate cc){
        if(shootDownCell.contains(cc)) return false;
        return (cc.getX() > 0)&&(cc.getX() < 9)&&(cc.getY() > 0)&&(cc.getY() < 9);
    }

    public static Coordinate trackingShip(Coordinate cc, SeaBattle seaBattle) {

        //north
        int i = 0;
        while (true) {
            i++;
            if(!isValidCoordsToFier(new Coordinate(cc.getX() + i, cc.getY()))) break;
            if(seaBattle.fire(cc.getX() + i, cc.getY()) == SeaBattle.FireResult.DESTROYED){

            }
        }


        }

        return new Coordinate(1, 1);
    }

    // функция для отладки
    // по линкорам 0:3 - 3:0, 0:7 - 7:0, 2:9 - 9:2, 6:9 - 9:6
    // 1 - проверить не сделанно ли максимальное колличество HIT или DESTROYED выстрелов
    // 2 - проверить был би выстрел по этой клетке
    // 3 - выстрелить
    // 4 - если выстрел неусешный, записать все точки и идти дальше - continue - >
    // 5 - если выстрел успешный и != DESTROYED, записать место, записать все точки по диагонали, сократить счетчик выстрелов по короблям
    // 6 - поиск направления
    // 7 - направление найдено стрелять по нему пока выстрел не будет DESTROYED и не будет больше 4х раз, и сокращять счетчик выстрелов
    // 8 - записать все точки вокруг что бы не стрелять по ним

    public void battleAlgorithm(SeaBattle seaBattle) {
        generateMatrixCoordinate();
        // min 20 shooters
        for (Coordinate cc: coordinateToShoot) {
            if(counterRightShoot <= CounterMaxRightShoot) {
                if(!shootDownCell.contains(cc)) {

                    SeaBattle.FireResult fireResult = seaBattle.fire(cc.getX(), cc.getY());

                    if (fireResult.equals(SeaBattle.FireResult.DESTROYED) || fireResult.equals(SeaBattle.FireResult.HIT)) {
                        counterRightShoot++;
                    }

                    if (fireResult.equals(SeaBattle.FireResult.DESTROYED)) {
                        shootDownCell.add(cc);
                    }

                    if(fireResult.equals(SeaBattle.FireResult.HIT)) {

                        trackingShip(cc, seaBattle);

                    }
                }
            }
            System.out.println(cc.getX()+" "+cc.getY());
//            SeaBattle.FireResult fireResult = seaBattle.fire(cc.getX(), cc.getY());
//            System.out.println(fireResult);
        }

//        for (int y = 0; y < seaBattle.getSizeX(); y++) {
//            for (int x = 0; x < seaBattle.getSizeY(); x++) {
//                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
//                System.out.println(fireResult);
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle);
        System.out.println(seaBattle.getResult());


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

    @Override
    public String toString() {
        return x+ " "+y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate сoordinate = (Coordinate) o;
        if(Integer.compare(this.getX(), сoordinate.getX()) == 0) {
            if(Integer.compare(this.getY(), сoordinate.getY()) == 0) {
                return true;
            }
        }
        return false;
    }

}

