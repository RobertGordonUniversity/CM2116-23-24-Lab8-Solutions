package uk.ac.rgu.cm2116;

import java.util.LinkedList;

public class ChainedHashTable<T> implements HashTable<T> {

    private LinkedList<T>[] table;
    private int size;

    public ChainedHashTable() {
        this.table = new LinkedList[20];
        this.size = 0;
    }

    @Override
    public boolean add(T element) {
        boolean result = false;

        if(element == null){
            return result;
        }

        int bucket = element.hashCode() % this.table.length;

        if(this.table[bucket] == null){
            this.table[bucket] = new LinkedList<T>();
        }

        if(!this.table[bucket].contains(element)){
            result = this.table[bucket].add(element);
            size++;
        }

        return result;
    }

    @Override
    public boolean contains(T element) {
        boolean result = false;

        if(element == null){
            return result;
        }

        int bucket = element.hashCode() % this.table.length;

        if(this.table[bucket] != null){
            result = this.table[bucket].contains(element);
        }

        return result;
    }

    @Override
    public boolean remove(T element) {
        boolean result = false;

        if(element == null){
            return result;
        }

        int bucket = element.hashCode() % this.table.length;

        if(this.table[bucket] != null){
            result = this.table[bucket].remove(element);
        }

        if(result){
            this.size--;
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }
}
