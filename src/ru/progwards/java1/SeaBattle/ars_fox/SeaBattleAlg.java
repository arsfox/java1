package ru.progwards.java1.SeaBattle.ars_fox;

/**
 * Created by Arseniy on 22.12.2019.
 */
import ru.progwards.java1.SeaBattle.SeaBattle;

public class SeaBattleAlg {

    public void battleAlgorithm(SeaBattle seaBattle) {
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
            }
        }
    }

    // функция для отладки
    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
    }
}
