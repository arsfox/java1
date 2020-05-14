package ru.progwards.java2.lessons.basetypes;
import java.util.Iterator;

public class BiDirList<T> implements Iterable<T>{

    class BiDirItem<T> {

        private T item;
        private BiDirItem<T> next;
        private BiDirItem<T> prev;

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

    public void addLast(T item) { // - добавить в конец списка
        BiDirItem<T> bdItem = new BiDirItem<T>(item);
    }

    public void addFirst(T item) { //- добавить в начало списка

    }

    public void remove(T item){ // - удалить

    }

    public void at(int i){ // - получить элемент по индексу

    }

    public int size(){ // - получить количество элементов

    }

    public static<T> BiDirList<T> from(T[] array){  //- конструктор из массива

    }

    public static<T> BiDirList<T> of(T...array){  //-  конструктор из массива

    }

    public void toArray(T[] array) {// - скопировать в массив

    }

    public Iterator<BiDirList<T>> getIterator(){ // - получить итератор

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
