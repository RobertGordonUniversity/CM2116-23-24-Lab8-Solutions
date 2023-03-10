package uk.ac.rgu.cm2116;

public class OpenAddressedHashTableTest extends HashTableTest{

    @Override
    public HashTable<DummyObject> getInstance() {
        return new OpenAddressedHashTable<>();
    }
}
