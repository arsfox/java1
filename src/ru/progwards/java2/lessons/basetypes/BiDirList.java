package ru.progwards.java2.lessons.basetypes;
import java.util.Iterator;

public class BiDirList<T>  {

    class BiDirItem<T> {

        private T item;
        private BiDirItem<T> next = null;
        private BiDirItem<T> prev = null;

        BiDirItem(T item){
            this.item = item;
        }

        T getItem() {
            return item;
        }

        void setNext(BiDirItem<T> item) {
            next = item;
        }

        BiDirItem<T> getNext() {
            return next;
        }

        void setPrev(BiDirItem<T> item) {
            prev = item;
        }

        BiDirItem<T> getPrev() {
            return prev;
        }
    }

    private BiDirItem<T> head;
    private BiDirItem<T> tail;
    private int size = 0;

    public void addLast(T item) {       // - добавить в конец списка
        BiDirItem<T> bdItem = new BiDirItem<T>(item);
        if(head == null){
            head = bdItem;
            tail = bdItem;
        } else {
            BiDirItem<T> tail_buffer = tail;
            tail.setNext(bdItem);
            tail = bdItem;
            tail.setPrev(tail_buffer);
        }
        size++;
    }

    public void addFirst(T item) {     //- добавить в начало списка
        BiDirItem<T> bdItem = new BiDirItem<T>(item);
        if(head == null){
            head = bdItem;
            tail = bdItem;
        } else {
            BiDirItem<T> head_buffer = head;
            head.setPrev(bdItem);
            head = bdItem;
            head.setNext(head_buffer);
        }
        size++;
    }

    public void remove(T item){ // - удалить
        BiDirItem<T> bditem = head;
        while (bditem != null) {
            if (bditem.item.equals(item)) {
                if(bditem.prev != null) {
                    bditem.prev.setNext(bditem.next);
                }
                if(bditem.next != null) {
                    bditem.next.setPrev(bditem.prev);
                }
                size--;
                break;
            }
            bditem = bditem.next;
        }
    }

    public T at(int i) { // - получить элемент по индексу
        int count = 0;
        BiDirItem<T> bditem = head;
        while (bditem.next != null) {
            if (count == i) {
                return bditem.item;
            }
            count++;
            bditem = bditem.next;
        }
        return bditem.item;
    }

    public int size(){ // - получить количество элементов
        return size;
    }

    public static<T> BiDirList<T> from(T[] array){  //- конструктор из массива
        BiDirList<T> arrays = new BiDirList<T>();
        for (T item : array) {
            arrays.addLast(item);
        }
        return arrays;
    }

    public static<T> BiDirList<T> of(T... array){  //-  конструктор из массива
        BiDirList<T> arrays = new BiDirList<T>();
        for (T item : array) {
            arrays.addLast(item);
        }
        return arrays;
    }

    public void toArray(T[] array) {// - скопировать в массив
        BiDirItem<T> bditem = head;
        int count = 0;
        while (bditem != null) {
            array[count++] = bditem.item;
            bditem = bditem.next;
        }
    }


    public Iterator<BiDirList<T>> getIterator(){ // - получить итератор
        return (Iterator) new Itr();
    }

    private class Itr implements Iterator<T>  {

        private BiDirItem<T> item;

        @Override
        public boolean hasNext() {
            return item.next != null;
        }

        @Override
        public T next() {
            return item.item;
        }
    }

    public static void main(String[] args) {
//        BiDirList<Integer> items = BiDirList.of(3,1,4,6);

        BiDirList<Integer> items = new BiDirList<>();
        items.addLast(1);


        items.addLast(3);

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i);
            System.out.println(items.at(i));
            System.out.println();
        }
    }

}
