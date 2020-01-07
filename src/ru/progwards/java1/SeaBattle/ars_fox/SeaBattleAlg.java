package ru.progwards.java1.SeaBattle.ars_fox;
import java.util.*;

import ru.progwards.java1.SeaBattle.SeaBattle;

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

    enum FieldState {
        EMPTY,
        MISS,
        BOAT,
        LOCK
    }

    private static final int MINUS = 0b01; // стреляем в уменьшение координаьы
    private static final int PLUS = 0b10; // стреляем в увеличение координаты

    public static boolean printField = false; // печатать поле на каждом шаге
    FieldState[][] field; // поле боя. ' ' - пустая ячейка (EMPTY), '*' - выстрел (MISS), 'X' - попали в корабль (BOAT), '.' - отметили, что нет смысла стрелять (LOCK)
    SeaBattle seaBattle; // seaBattle, что бы не таскать его везде параметром
    int direction; // направление стрельбы - PLUS | MINUS
    private ArrayList<Ship> ships;
    private static boolean shipDetectionMode = false; // режим добивания коробля
    private ArrayList<Coordinate> detectedShip;  //координаты коробля по котору идет обстрел

    // процедура инициализации, используется вместо конструктора
    void init(SeaBattle seaBattle) {
        this.seaBattle = seaBattle;
        field = new FieldState[seaBattle.getSizeX()][seaBattle.getSizeY()];
        for (int x = 0; x < seaBattle.getSizeX(); x++)
            Arrays.fill(field[x], FieldState.EMPTY);
        ships = new ArrayList<>();
        detectedShip = new ArrayList<>();
    }

    // печать поля для отладки алгоритмов
    void print(boolean doPrint) {
        if (!doPrint)
            return;
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            String str = "|";
            for (int x = 0; x < seaBattle.getSizeX(); x++) {
                FieldState state = field[x][y];
                if(state == FieldState.EMPTY){
                    str += " " + "|";
                } else
                if(state == FieldState.MISS){
                    str += "*" + "|";
                } else
                if(state == FieldState.BOAT){
                    str += "X" + "|";
                } else
                if(state == FieldState.LOCK){
                    str += "." + "|";
                }
            }
            System.out.println(str);
        }
        System.out.println("---------end----------");
//        System.out.println(Arrays.toString(ships.toArray()));
//        System.out.println("--");
//        System.out.println(getMaxFloatingShip());
//        System.out.println("----------------------");
    }

    String printVar() {
        String result = "";
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            String str = "|";
            for (int x = 0; x < seaBattle.getSizeX(); x++) {
                FieldState state = field[x][y];
                if(state == FieldState.EMPTY){
                    str += " " + "|";
                } else
                if(state == FieldState.MISS){
                    str += "*" + "|";
                } else
                if(state == FieldState.BOAT){
                    str += "X" + "|";
                } else
                if(state == FieldState.LOCK){
                    str += "." + "|";
                }
            }
            result += str;
            result += "\n";
        }
        return result;
    }

    int getMaxFloatingShip() {
        ArrayList<Ship> etalonShips = new Ship(0).getShipSquadron();
        ArrayList<Ship> nowShips = new ArrayList<>(ships);
        for (int i = 4; i > 0; i--) {
            int result = 0;
//            for (Ship s : ships) {
//                if(s.size != i) {
//                    result = i;
//                }
//            }
            if(!nowShips.contains(i)){
                System.out.println("true");
                return i;
            }
        }

//        return Collections.max(etalonShips).size;
        return 0;
    }

    // добить корабль горизонтально; возвращает true если корабль убит
    boolean killHorisontal(int x, int y) {
        int i = 1;
        boolean destroyed = false;
        direction = PLUS | MINUS;
        do {
            if ((direction&MINUS) != 0)
                destroyed = checkHit(fire(x-i, y), MINUS);
            if ((direction&PLUS) != 0)
                destroyed = checkHit(fire(x+i, y), PLUS);
            i++;
        } while(direction != 0);
        return destroyed;
    }

    // добить корабль вертикально; возвращает true если корабль убит
    boolean killVertical(int x, int y) {
        int i = 1;
        boolean destroyed = false;
        direction = MINUS | PLUS;
        do {
            if ((direction&MINUS) != 0)
                destroyed = checkHit(fire(x, y-i), MINUS);
            if ((direction&PLUS) != 0)
                destroyed = checkHit(fire(x, y+i), PLUS);
            i++;
        } while(direction != 0);
        return destroyed;
    }

   //  добить корабль, вызывается только после попадания
    void killShip(int x, int y) {
        boolean destroyed = killVertical(x, y);
        if (!destroyed)
            killHorisontal(x, y);
    }

    // проверить попадание при добивании; возвращает true если корабль убит
    boolean checkHit(SeaBattle.FireResult result, int fireDirection) {
        switch(result) {
            case DESTROYED :
                direction = 0;
                return true;
            case HIT:
                return false;
            case MISS:
                direction &= ~fireDirection;
                return false;
        }
        return false;
    }

    // пометить ячейку корабль или мимо
    void markFire(int x, int y, SeaBattle.FireResult result) {
        if (result != SeaBattle.FireResult.MISS)
            field[x][y] = FieldState.BOAT;
        else
            field[x][y] = FieldState.MISS;
    }

    // пометить ячейку как не не имеющую смысл для стрельбы
    void markDot(int x, int y) {
        if(x<0 || y<0 || x>=seaBattle.getSizeX() || y>=seaBattle.getSizeY())
            return;
        if (field[x][y] == FieldState.EMPTY)
            field[x][y] = FieldState.LOCK;
    }

    // пометить попадание в корабль "по кругу"
    void markHit(int x, int y) {
        markDot(x-1, y-1);
        markDot(x-1, y);
        markDot(x-1, y+1);
        markDot(x+1, y-1);
        markDot(x+1, y);
        markDot(x+1, y+1);
        markDot(x, y-1);
        markDot(x, y+1);
    }

    int getHits() {
        int count = 0;
        for (Ship s : ships) {
            count += s.size;
        }
//        if(count > 19) {
//            print(printField);
//        }
        return count;
    }

    void countShips(ArrayList<Coordinate> ship) {
        int count = 0;
        for (Coordinate cc : ship){
            markHit(cc.x, cc.y);
            count++;
        }
        ships.add(new Ship(count));
    }

    // "интеллектуальный" выстрел - проверяет попадание в границы поля и что имеет смысл стрелять в ячейку
    SeaBattle.FireResult fire(int x, int y) {
        if(x<0 || y<0 || x>=seaBattle.getSizeX() || y>=seaBattle.getSizeY() ||
                getHits() >= 20 || field[x][y] != FieldState.EMPTY)
            return SeaBattle.FireResult.MISS;

        SeaBattle.FireResult result = seaBattle.fire(x, y);
        markFire(x, y, result);
        if (result != SeaBattle.FireResult.MISS) {
            detectedShip.add(new Coordinate(x, y));
        }
        if (result == SeaBattle.FireResult.DESTROYED) {
            countShips(detectedShip);
            detectedShip = new ArrayList<>();
        }
        print(printField);
        return result;
    }



    // выстрел с добиванием корабля. Используется из основного алгоритма для избегания рекурсии
    SeaBattle.FireResult fireAndKill(int x, int y) {
        SeaBattle.FireResult result = fire(x, y);
        if (result == SeaBattle.FireResult.HIT) {
            killShip(x, y);
        }
        return result;
    }

    Random random = new Random();
    int getRandom() {
        double d = random.nextDouble();
        return (int)Math.floor(d*10);
    }

    // пример алгоритма:
    // стрельба по всем квадратам поля полным перебором
    void algorithm1() {
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            for (int x = 0; x < seaBattle.getSizeX(); x++) {
                fireAndKill(x, y);
            }
        }
    }

    void algorithm2() {
        while(getHits() < 20)
            fireAndKill(getRandom(), getRandom());
    }

    void stepFire(int offset) {
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            for (int x = y+offset; x < seaBattle.getSizeX(); x+=4)
                fireAndKill(x, y);

            for (int x = y-offset; x >= 0; x-=4)
                fireAndKill(x, y);
        }
    }

    void algorithm3() {
        stepFire(3);
        stepFire(1);
        stepFire(0);
        stepFire(2);
    }

    void stepFireArea(ArrayList<Coordinate> cca) {
        for(Coordinate cc : cca) {
            int x = cc.x;
            int y = cc.y;
            if(x<0 || y<0 || x>=seaBattle.getSizeX() || y>=seaBattle.getSizeY()){
                continue;
            }
            fireAndKill(x, y);
        }
    }

    void algorithm4() {
        for (int i = 4; i > 0; i--) {
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(0,0)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(4,0)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(8,0)));

            stepFireArea(getFourArenaCoordinate(i, new Coordinate(0,4)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(4,4)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(8,4)));

            stepFireArea(getFourArenaCoordinate(i, new Coordinate(0,8)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(4,8)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(8,8)));
        }
    }

    void algorithm5() {
        ArrayList<Coordinate> ccr = new ArrayList<>();


        stepFireArea(new Coordinate(0,0));

        for (int i = 4; i > 3; i--) {
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(0,0)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(4,0)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(8,0)));

            stepFireArea(getFourArenaCoordinate(i, new Coordinate(0,4)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(4,4)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(8,4)));

            stepFireArea(getFourArenaCoordinate(i, new Coordinate(0,8)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(4,8)));
            stepFireArea(getFourArenaCoordinate(i, new Coordinate(8,8)));
        }


        ccr.add(new Coordinate(0,4));
        ccr.add(new Coordinate(0,8));
        ccr.add(new Coordinate(1,0));
        ccr.add(new Coordinate(1,4));
        ccr.add(new Coordinate(2,2));
        ccr.add(new Coordinate(2,7));
        ccr.add(new Coordinate(3,3));
        ccr.add(new Coordinate(3,6));
        ccr.add(new Coordinate(4,1));
        ccr.add(new Coordinate(4,5));
        ccr.add(new Coordinate(4,9));
        ccr.add(new Coordinate(5,0));
        ccr.add(new Coordinate(5,4));
        ccr.add(new Coordinate(5,8));
        ccr.add(new Coordinate(6,3));
        ccr.add(new Coordinate(6,7));
        ccr.add(new Coordinate(7,2));
        ccr.add(new Coordinate(7,6));
        ccr.add(new Coordinate(8,1));
        ccr.add(new Coordinate(8,5));
        ccr.add(new Coordinate(8,9));
        ccr.add(new Coordinate(9,0));
        ccr.add(new Coordinate(9,4));

        ccr.add(new Coordinate(0,1));
        ccr.add(new Coordinate(1,2));
        ccr.add(new Coordinate(1,5));
        ccr.add(new Coordinate(1,6));
        ccr.add(new Coordinate(1,8));
        ccr.add(new Coordinate(1,9));
        ccr.add(new Coordinate(2,4));
        ccr.add(new Coordinate(3,1));
        ccr.add(new Coordinate(4,4));
        ccr.add(new Coordinate(4,7));
        ccr.add(new Coordinate(5,2));
        ccr.add(new Coordinate(5,6));
        ccr.add(new Coordinate(8,3));
        ccr.add(new Coordinate(8,7));
        ccr.add(new Coordinate(9,1));
        ccr.add(new Coordinate(9,5));
        ccr.add(new Coordinate(9,8));

        stepFireArea(ccr);

        algorithm1();
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);
        algorithm5();
    }

    static void fullTest() {
        SeaBattleAlg.printField = false;
        double result = 0;
        SeaBattleAlg alg = new SeaBattleAlg();
        ArrayList<Double> resultarr = new ArrayList<>();
        for(int i=0; i<10000; i++) {
            SeaBattle seaBattle = new SeaBattle();
            alg.battleAlgorithm(seaBattle);
            resultarr.add(seaBattle.getResult());
//            System.out.println(seaBattle.getResult());
            result += seaBattle.getResult();
        }
        System.out.println("----------");
        System.out.println(Collections.max(resultarr));
        System.out.println(Collections.min(resultarr));
        System.out.println(result/10000);
    }

    static void oneTest() {
        SeaBattleAlg.printField = true;
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
    }

    // функция для отладки
    public static void main(String[] args) {
        System.out.println("Sea battle");
        fullTest();
//        oneTest();
    }

    class Ship implements Comparable<Ship> {

        int size;

        Ship(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return String.valueOf(size);
        }

        @Override
        public int compareTo(Ship ship) {
            if (this.size < ship.size) {
                return -1;
            }
            else if (this.size > ship.size){
                return 1;
            }
            else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ship s = (Ship) o;
            if (this.size == s.size) {
                    return true;
            }
            return false;
        }

        public ArrayList<Ship> getShipSquadron() {
            ArrayList<Ship> ships = new ArrayList<Ship>(){};
            ships.add(new Ship(4));
            ships.add(new Ship(3));
            ships.add(new Ship(3));
            ships.add(new Ship(2));
            ships.add(new Ship(2));
            ships.add(new Ship(2));
            ships.add(new Ship(1));
            ships.add(new Ship(1));
            ships.add(new Ship(1));
            ships.add(new Ship(1));
            return ships;
        }
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

    ArrayList<Coordinate> getFourArenaCoordinate(int step, Coordinate start) {
        ArrayList<Coordinate> cc = new ArrayList<>();
        switch (step) {
            case (1):
                cc.add(new Coordinate(start.x, start.y));
                cc.add(new Coordinate(start.x + 2, start.y));
                cc.add(new Coordinate(start.x + 1, start.y + 1));
                cc.add(new Coordinate(start.x + 3, start.y + 2));
                break;
            case (2):
                cc.add(new Coordinate(start.x + 3, start.y + 1));
                cc.add(new Coordinate(start.x + 1, start.y + 2));
                cc.add(new Coordinate(start.x, start.y + 3));
                cc.add(new Coordinate(start.x + 2, start.y + 3));
                break;
            case (3):
                cc.add(new Coordinate(start.x + 1, start.y));
                cc.add(new Coordinate(start.x, start.y + 1));
                cc.add(new Coordinate(start.x + 2, start.y + 2));
                cc.add(new Coordinate(start.x + 3, start.y + 3));
                break;
            case (4):
                cc.add(new Coordinate(start.x,start.y + 2));
                cc.add(new Coordinate(start.x + 1,start.y + 3));
                cc.add(new Coordinate(start.x + 2,start.y + 1));
                cc.add(new Coordinate(start.x + 3, start.y));
                break;
        }
        return cc;
    }

}


