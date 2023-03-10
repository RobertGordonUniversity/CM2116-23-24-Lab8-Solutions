package uk.ac.rgu.cm2116;

public interface HashTable<T> {
    
    public boolean add(T element);

    public boolean contains(T element);

    public boolean remove(T element);

    public int size();

    public boolean isEmpty();


}
