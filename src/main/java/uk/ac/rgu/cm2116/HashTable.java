package uk.ac.rgu.cm2116;

import java.util.LinkedList;

public class HashTable<T> {

    private LinkedList<T>[] table;

    public HashTable(){
        this.table = new LinkedList[20];
    }

    public boolean add(T element){
        return false;
    }

    public boolean contains(T element){
        return false;
    }

    public boolean remove(T element){
        return false;
    }

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        return false;
    }
}
