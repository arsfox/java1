package ru.progwards.java1.SeaBattle.ars_fox;


import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.FireResult;

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

    private SeaBattle seaBattle;
    private int  counterRightShoot = 0;
    private final int CounterMaxRightShoot = 20;
    private ArrayList<Coordinate> coordinateForShoot = new ArrayList<>();
    private ArrayList<Coordinate> shootingDownCell = new ArrayList<>();

    FireResult fire(int x, int y) {
        if(isValidCoordsToFier(new Coordinate(x, y))){
            SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
            System.out.println(seaBattle);
            if(fireResult != SeaBattle.FireResult.MISS){
                this.counterRightShoot++;
            }
            shootingDownCell.add(new Coordinate(x, y));
            return fireResult;
        }
        return FireResult.MISS;
    }

    private boolean isValidCoordsToFier(Coordinate cc){
        if(shootingDownCell.contains(cc)) return false;
        if(this.counterRightShoot >= this.CounterMaxRightShoot) return false;
        return (cc.getX() >= 0)&&(cc.getX() <= 9)&&(cc.getY() >= 0)&&(cc.getY() <= 9);
    }

    private Direction trackingDirection(Coordinate cc) {

        if(fire(cc.getX(), cc.getY()-1)!=FireResult.MISS) return Direction.NORTH;
        if(fire(cc.getX(), cc.getY()+1)!=FireResult.MISS) return Direction.SOUTH;
        if(fire(cc.getX()-1, cc.getY())!=FireResult.MISS) return Direction.WEST;
        if(fire(cc.getX()+1, cc.getY())!=FireResult.MISS) return Direction.EAST;
        return null;
    }

    private void trackingShip(Coordinate cc) {
        int x = 0, y = 0;
        if(trackingDirection(cc) == Direction.NORTH){
            shootingDownCell.add(new Coordinate(cc.getX(), cc.getY()-1));
            y = -1;
        } else
        if(trackingDirection(cc) == Direction.SOUTH) {
            shootingDownCell.add(new Coordinate(cc.getX(), cc.getY()+1));
            y = 1;
        } else
        if(trackingDirection(cc) == Direction.WEST) {
            shootingDownCell.add(new Coordinate(cc.getX()-1, cc.getY()));
            x = -1;
        } else
        if(trackingDirection(cc) == Direction.EAST) {
            shootingDownCell.add(new Coordinate(cc.getX()+1, cc.getY()));
            x = 1;
        }

        while (true) {
            SeaBattle.FireResult fireResult = fire(cc.getX() + x, cc.getY() + y);
            if(fireResult != FireResult.HIT){
                break;
            }

        }
    }

    void outline(Coordinate cc) {
        shootingDownCell.add(new Coordinate(cc.getX(), cc.getY()-1));
        shootingDownCell.add(new Coordinate(cc.getX(), cc.getY()+1));
        shootingDownCell.add(new Coordinate(cc.getX()+1, cc.getY()));
        shootingDownCell.add(new Coordinate(cc.getX()-1, cc.getY()));
        shootingDownCell.add(new Coordinate(cc.getX()-1, cc.getY()-1));
        shootingDownCell.add(new Coordinate(cc.getX()+1, cc.getY()+1));
        shootingDownCell.add(new Coordinate(cc.getX()-1, cc.getY()+1));
        shootingDownCell.add(new Coordinate(cc.getX()+1, cc.getY()-1));
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        this.seaBattle = seaBattle;

        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                this.coordinateForShoot.add(new Coordinate(x, y));
            }
        }

        for (Coordinate cc : coordinateForShoot) {
            SeaBattle.FireResult fireResult = fire(cc.getX(), cc.getY());
            if(fireResult == FireResult.DESTROYED){
                outline(new Coordinate(cc.getX(), cc.getY()));
            }
            if(fireResult == SeaBattle.FireResult.HIT){
                trackingShip(new Coordinate(cc.getX(), cc.getY()));
            }
        }
    }




    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle);
        System.out.println(seaBattle.getResult());

//        for (int i = 0; i < 1000; i++) {
//            SeaBattle seaBattle = new SeaBattle(true);
//            new SeaBattleAlg().battleAlgorithm(seaBattle);
////            System.out.println(seaBattle);
//            System.out.println(seaBattle.getResult());
//        }
    }

    public enum Direction{
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
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
            return x + " " + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate сoordinate = (Coordinate) o;
            if (Integer.compare(this.getX(), сoordinate.getX()) == 0) {
                if (Integer.compare(this.getY(), сoordinate.getY()) == 0) {
                    return true;
                }
            }
            return false;
        }
    }
}


