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
    static HashMap<String, Statistic> sections = new HashMap<>();
    static List<String> sectionsNameStack = new ArrayList<>();

    public static void enterSection(String name) {
        Statistic s = new Statistic();
        s.sectionName = name;
        s.startTime = (int) System.currentTimeMillis();
        s.parentName = getParent();
        sections.putIfAbsent(name, s);
        sectionsNameStack.add(name);
    }

    public static void exitSection(String name) {
        int time = (int) (System.currentTimeMillis() - sections.get(name).startTime);

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

        sections.remove(name);
        sectionsNameStack.remove(name);
    }

    public static List<StatisticInfo> getStatisticInfo() {
        return new ArrayList<>();
    }

    private static String getParent() {
        if(sectionsNameStack.size() > 0){
            return sectionsNameStack.get(sectionsNameStack.size()-1);
        }
        return null;
    }

    private static void addChildrenTime(String name, int time) {
        Statistic s = sections.get(name);
        s.childrenSumTime += time;
        sections.put(name, s);
    }

}


class Statistic {
    public String sectionName;
    int startTime;
    int childrenSumTime;
    String parentName;
}

class StatisticInfo {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;
}
