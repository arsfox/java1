package ru.progwards.java2.lessons.recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HanoiTower {

    private static boolean on = false;

    private static int towers[][]; // x, y

    private int size;

    public HanoiTower(int size, int pos) {
        this.size = size;
        towers = new int[3][size];

        Arrays.fill(towers[0], 0);
        Arrays.fill(towers[1], 0);
        Arrays.fill(towers[2], 0);

        int ring = 1;

        for (int y = 0; y < size; y++) {
            towers[pos][y] = ring;
            ring++;
        }
    }

    public void move(int from, int to) {
        int buffer = getBuffer(from, to);
        reqmove(from, to, buffer, size);
    }

    public void reqmove(int from, int to, int buffer, int offset) {
        if (offset==1){
            ringMover(from, to);
        } else {
            reqmove(from, buffer, to, offset-1);
            ringMover(from, to);
            reqmove(buffer, to, from, offset-1);
        }
    }

    private void ringMover(int from, int to) {
        int ring = takeRing(from);
        if(ring!=0){
            putRing(to, ring);
        }
        print();
    }

    private int takeRing(int pos){
        for(int y = 0; y < size; y++){
            int ring = towers[pos][y];
            if(ring!=0){
                towers[pos][y] = 0;
                return ring;
            }
        }
        return 0;
    }

    private boolean canPut(int pos, int ring) {
        for(int y = 0; y < size; y++) {
            int ringPlace = towers[pos][y];
            if(ringPlace!=0){
                if(ringPlace > ring){
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return true;
    }

    private void putRing(int pos, int ring) {

        for(int y = size-1; y >=0; y--){
            int ringPlace = towers[pos][y];
            if(ringPlace==0){
                towers[pos][y] = ring;
                return;
            }
        }
    }

    private static int getBuffer(int from, int to) {
        ArrayList list = new ArrayList(List.of(0, 1, 2));
        list.removeAll(List.of(from, to));
        return (int) list.get(0);
    }

    void setTrace(boolean on) {
        this.on = on;
    }

    void print() {
        if(on){
            for(int y = 0; y < size; y++) {
                for(int x = 0; x < 3; x++) {
                    int ring = towers[x][y];
                    if(ring==0){
                        System.out.print("      I");
                    } else {
                        System.out.print("   <00"+ring+">");
                    }
                }
                System.out.println("");
            }
        }
        System.out.println("=================");
    }

    public static void main(String[] args) {
        HanoiTower hn = new HanoiTower(3, 0);
        hn.setTrace(true);
        hn.move(0, 1);
    }
}
