package ru.progwards.java1.SeaBattle.ars_fox;


import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.FireResult;

import java.util.ArrayList;

public class SeaBattleAlgOLD3 {
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
    private int counterRightShoot;
    private final int CounterMaxRightShoot = 20;
    private Integer[][] coordinateForShootArr;
    private ArrayList<Coordinate> coordinateForShoot;
    private ArrayList<Coordinate> shootingDownCell;

    FireResult fireAndKill(int x, int y) {
        FireResult fireResult = fire(x, y);

        if(fireResult == FireResult.DESTROYED) {
            outline(new Coordinate(x, y));
        }

        if(fireResult == SeaBattle.FireResult.HIT){
//            trackingShip(new Coordinate(x, y));
        }

        return fireResult;
    }

    FireResult fire(int x, int y) {
        if(isValidCoordsToFier(new Coordinate(x, y))){
            SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
            if(fireResult != SeaBattle.FireResult.MISS){
                this.counterRightShoot++;
            }
            this.shootingDownCell.add(new Coordinate(x, y));
            return fireResult;
        }
        return FireResult.MISS;
    }

    private boolean isValidCoordsToFier(Coordinate cc){
        if(this.shootingDownCell.contains(cc)) return false;
        if(this.counterRightShoot >= this.CounterMaxRightShoot) return false;
        return (cc.getX() >= 0)&&(cc.getX() <= 9)&&(cc.getY() >= 0)&&(cc.getY() <= 9);
    }

    private Direction trackingDirection(Coordinate cc) {
        FireResult fireResultNORTH = fire(cc.getX(), cc.getY()-1);

        if(fireResultNORTH==FireResult.DESTROYED) {
            outline(cc);
            outline(new Coordinate(cc.getX(), cc.getY()-1));
            return null;
        } else if(fireResultNORTH==FireResult.HIT) {
            return Direction.NORTH;
        }

        FireResult fireResultSOUTH = fire(cc.getX(), cc.getY()+1);

        if(fireResultSOUTH==FireResult.DESTROYED) {
            outline(cc);
            outline(new Coordinate(cc.getX(), cc.getY()+1));
            return null;
        } else if(fireResultSOUTH == FireResult.HIT) {
            return Direction.SOUTH;
        }

        FireResult fireResultWEST = fire(cc.getX()-1, cc.getY());

        if(fireResultWEST==FireResult.DESTROYED) {
            outline(cc);
            outline(new Coordinate(cc.getX()-1, cc.getY()));
            return null;
        } else if(fireResultWEST == FireResult.HIT) {
            return Direction.WEST;
        }

        FireResult fireResultEAST = fire(cc.getX()+1, cc.getY());

        if(fireResultEAST==FireResult.DESTROYED) {
            outline(cc);
            outline(new Coordinate(cc.getX()+1, cc.getY()));
            return null;
        } else if(fireResultEAST == FireResult.HIT) {
            return Direction.EAST;
        }

        return null;
    }

    private void whileKillShip(Coordinate сс, Direction direction) {
//        boolean dere
    }

    void outline(Coordinate cc) {
        this.shootingDownCell.add(new Coordinate(cc.getX(), cc.getY()-1));
        this.shootingDownCell.add(new Coordinate(cc.getX(), cc.getY()+1));
        this.shootingDownCell.add(new Coordinate(cc.getX()+1, cc.getY()));
        this.shootingDownCell.add(new Coordinate(cc.getX()-1, cc.getY()));
        this.shootingDownCell.add(new Coordinate(cc.getX()-1, cc.getY()-1));
        this.shootingDownCell.add(new Coordinate(cc.getX()+1, cc.getY()+1));
        this.shootingDownCell.add(new Coordinate(cc.getX()-1, cc.getY()+1));
        this.shootingDownCell.add(new Coordinate(cc.getX()+1, cc.getY()-1));
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        this.seaBattle = seaBattle;

//        for (int y = 0; y < seaBattle.getSizeX(); y++) {
//            for (int x = 0; x < seaBattle.getSizeY(); x++) {
//                this.coordinateForShoot.add(new Coordinate(x, y));
//            }
//        }
        this.coordinateForShoot = new ArrayList<>();
        this.shootingDownCell = new ArrayList<>();
        this.counterRightShoot = 0;
        this.generateMatrixCoordinate();

        for (Coordinate cc : this.coordinateForShoot) {
            if(this.counterRightShoot <= this.CounterMaxRightShoot) {

                SeaBattle.FireResult fireResult = fireAndKill(cc.getX(), cc.getY());

            }
        }
    }


    public static double fight() {
        SeaBattle b = new SeaBattle();
        SeaBattleAlgOLD2 ba = new SeaBattleAlgOLD2();
        ba.battleAlgorithm(b);
        double result = b.getResult();
        return result;
    }
    public static double fightMany(int count) {
        double sum = 0.0;
        for (int i = count; i > 0; i--) sum += fight();
        return (double) ((int) (sum / (double) count * 100)) / 100;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fightMany(100));
        System.out.println(System.currentTimeMillis() - startTime);
    }


    public enum Direction{
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    class Coordinate {
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
    public void generateMatrixCoordinate() {
        // четырёхпалубный
        moveSightDiagonally(0, 3);
        moveSightDiagonally(0, 7);
        moveSightDiagonally(2, 9);
        moveSightDiagonally(6, 9);
        // трёхпалубные и двухпалубные
        moveSightDiagonally(0, 1);
        moveSightDiagonally(0, 5);
        moveSightDiagonally(0, 9);
        moveSightDiagonally(4, 9);
        moveSightDiagonally(8, 9);
        // однопалубные
        // - перебор всего за исключением
        moveSightDiagonally(0,0 );
        moveSightDiagonally(0,2);
        moveSightDiagonally(0,4);
        moveSightDiagonally(0,6);
        moveSightDiagonally(0,8);
        moveSightDiagonally(1,9);
        moveSightDiagonally(3,9);
        moveSightDiagonally(5,9);
        moveSightDiagonally(7,9);
        moveSightDiagonally(9,9);
    }

    // form left bottom to right top
    void moveSightDiagonally(int x, int y){
        while ((x < 10)&(y > -1)) {
            coordinateForShoot.add(new Coordinate(x, y));
            y--;
            x++;
        }
    }
}


