package ru.progwards.java1.lessons.datetime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Arseniy on 25.02.2020.
 */
public class Profiler {

//    public static List<StatisticInfo> statisticInfo = new ArrayList<>();

    static HashMap<String, StatisticInfo> statisticInfoHashMap = new HashMap<>();
    static HashMap<String, Integer> sections = new HashMap<>();

    public static void enterSection(String name) {
        sections.put(name, (int) System.currentTimeMillis());

    }

    public static void exitSection(String name) {
        int time = (int) (System.currentTimeMillis() - sections.get(name));
        sections.remove(name);

        if(statisticInfoHashMap.containsKey(name)){
            StatisticInfo stf = statisticInfoHashMap.get(name);
            stf.fullTime += time;
            stf.selfTime += time;
            stf.count += 1;
        } else {
            StatisticInfo s = new StatisticInfo();
            s.sectionName = name;
            s.fullTime = time;
            s.selfTime = time;
            s.count = 1;
            statisticInfoHashMap.put(name, s);
        }
    }

    public static List<StatisticInfo> getStatisticInfo() {
        return new ArrayList<>();
    }

//    private static boolean haveParent() {
//        if
//    }

}

class StatisticInfoManager {
    Integer time;
    public StatisticInfo statisticInfo;
    public List<StatisticInfoManager> statisticInfoManagerChildren;
}

class StatisticInfo {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;
}
