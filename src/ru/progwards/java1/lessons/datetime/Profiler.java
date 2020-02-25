package ru.progwards.java1.lessons.datetime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arseniy on 25.02.2020.
 */
public class Profiler {

    public static void enterSection(String name) {

    }

    public static void exitSection(String name) {

    }

    public static List<StatisticInfo> getStatisticInfo() {
        return new ArrayList<>();
    }

}

class StatisticInfo {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;
}
