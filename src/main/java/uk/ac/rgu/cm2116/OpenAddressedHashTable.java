package uk.ac.rgu.cm2116;

public class OpenAddressedHashTable<T> implements HashTable<T> {

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    
}
