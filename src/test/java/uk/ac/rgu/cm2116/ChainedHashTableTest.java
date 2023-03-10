package uk.ac.rgu.cm2116;

public class ChainedHashTableTest extends HashTableTest{

    @Override
    public HashTable<DummyObject> getInstance() {
        return new ChainedHashTable<>();
    }
    
}
