package ru.progwards.java1.lessons.datetime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * Created by Arseniy on 25.02.2020.
 */
public class Profiler {

    static HashMap<String, StatisticInfo> statisticInfoHashMap = new HashMap<>();
    static HashMap<String, Statistic> sections = new HashMap<>();
    static List<String> sectionsNameStack = new ArrayList<>();
    static List<StatisticInfo> statisticInfo = new ArrayList<>();

    public static void enterSection(String name) {
        Statistic s = new Statistic();
        s.sectionName = name;
        s.startTime = (int) System.currentTimeMillis();
        s.parentName = getParent();
        sections.putIfAbsent(name, s);
        sectionsNameStack.add(name);
    }

    public static void exitSection(String name) {
        Statistic s = sections.get(name);
        int time = (int) (System.currentTimeMillis() - s.startTime);

        if(statisticInfoHashMap.containsKey(name)){
            StatisticInfo stf = statisticInfoHashMap.get(name);
            stf.fullTime += time;
            stf.selfTime += time - s.childrenSumTime;
            stf.count += 1;
        } else {
            StatisticInfo sinfo = new StatisticInfo();
            sinfo.sectionName = name;
            sinfo.fullTime = time;
            sinfo.selfTime = time;
            sinfo.count = 1;
            statisticInfoHashMap.put(name, sinfo);
        }

        addChildrenTime(s.parentName, time);
        sections.remove(name);
        sectionsNameStack.remove(name);
    }

    public static List<StatisticInfo> getStatisticInfo() {
        for (Map.Entry s : statisticInfoHashMap.entrySet()) {
            statisticInfo.add((StatisticInfo) s.getValue());
        }

        return statisticInfo;
    }

    private static String getParent() {
        if(sectionsNameStack.size() > 0) {
            return sectionsNameStack.get(sectionsNameStack.size() - 1);
        }
        return null;
    }

    private static void addChildrenTime(String name, int time) {
        if(sections.containsKey(name)){
            Statistic s = sections.get(name);
            s.childrenSumTime += time;
            sections.put(name, s);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        enterSection("s1");
        sleep(100);
            enterSection("s2");
            sleep(200);
            exitSection("s2");
            enterSection("s2");
            sleep(200);
                enterSection("s3");
                sleep(200);
                    enterSection("s4");
                    sleep(200);
                    exitSection("s4");
                sleep(200);
                exitSection("s3");
            sleep(200);
            exitSection("s2");
            enterSection("s2");
            sleep(200);
            exitSection("s2");
        sleep(100);
        exitSection("s1");
        System.out.println(getStatisticInfo());
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

    @Override
    public String toString() {
        return "\n"+sectionName + " total: " + fullTime + " self: " + selfTime + " count: " + count;
    }
}
