package uk.ac.rgu.cm2116;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HashTableTest {

    @Test
    public void testAdd() {

        HashTable<DummyObject> table = new HashTable<>();

        DummyObject obj1 = new DummyObject(0, 1);

        /* Test adding a single element */
        boolean result1 = table.add(obj1);
        assertTrue(result1);

        assertEquals(1, table.size());
        assertFalse(table.isEmpty());

        /* Test adding the same element */
        boolean result2 = table.add(obj1);
        assertFalse(result2);

        /* Test adding a different element that is equal */
        DummyObject obj2 = new DummyObject(0, 1);
        boolean result3 = table.add(obj2);
        assertFalse(result3);

        /* Test adding a second object that has the same hash code but isn't equal */
        DummyObject obj3 = new DummyObject(0, 2);
        boolean result4 = table.add(obj3);
        assertTrue(result4);

        /* Test adding a completely different object */
        DummyObject obj4 = new DummyObject(3, 4);
        boolean result5 = table.add(obj4);
        assertTrue(result5);
    }

    @Test
    public void testContains() {

        HashTable<DummyObject> table = new HashTable<>();

        DummyObject obj1 = new DummyObject(0, 1);

        /* Test that the table contains the object */
        table.add(obj1);
        boolean result1 = table.contains(obj1);
        assertTrue(result1);

        /*
         * Object with same hashcode but different value - so shouldn't be in the table
         */
        DummyObject obj2 = new DummyObject(0, 2);
        boolean result2 = table.contains(obj2);

        assertFalse(result2);

        /* Object with same hashcode as existing object in table */
        DummyObject obj3 = new DummyObject(0, 3);
        table.add(obj3);
        boolean result3 = table.contains(obj3);

        assertTrue(result3);

    }

    @Test
    public void testRemove() {

        HashTable<DummyObject> table = new HashTable<>();

        DummyObject obj1 = new DummyObject(0, 1);
        DummyObject obj2 = new DummyObject(0, 2);

        table.add(obj1);
        table.add(obj2);

        /* Test the removal of obj1 */
        boolean result = table.remove(obj1);
        assertTrue(result);

        /* Test that obj2 remains in the table */
        boolean result2 = table.contains(obj2);
        assertTrue(result2);

        assertEquals(1, table.size());
        assertFalse(table.isEmpty());

        /* Test that obj1 isn't in the table */
        boolean result3 = table.contains(obj1);
        assertFalse(result3);

    }

    class DummyObject {

        int var1, var2;

        public DummyObject(int var1, int var2) {
            this.var1 = var1;
            this.var2 = var2;
        }

        @Override
        public int hashCode() {
            return this.var1;
        }

        @Override
        public boolean equals(Object o) {
            if (o != null && o.getClass().equals(this.getClass())) {
                return (((DummyObject) o).var2 == this.var2);
            }
            return false;
        }
    }

}
