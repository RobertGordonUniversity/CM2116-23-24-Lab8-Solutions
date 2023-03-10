package uk.ac.rgu.cm2116;

public class OpenAddressedHashTable<T> implements HashTable<T> {

    private Object[] table;
    private int size;

    public OpenAddressedHashTable() {
        this.table = new Object[20];
    }

    @Override
    public boolean add(T element) {

        /* Can only store 20 items in this table */
        if (this.size() == this.table.length || element == null) {
            return false;
        }

        int bucket = element.hashCode() % this.table.length;

        /* If the current bucket contains this element, return false */
        if (element.equals(this.table[bucket])) {
            return false;
        }

        /*
         * Find a suitable bucket - use the modulus operator to loop back round if needs
         * be
         */
        while (this.table[bucket] != null) {
            bucket = (bucket + 1) % this.table.length;
            /* If the current bucket contains this element, return false */
            if (element.equals(this.table[bucket])) {
                return false;
            }
        }

        this.table[bucket] = element;
        this.size++;

        return true;
    }

    @Override
    public boolean contains(T element) {

        /* Shortcut - if the table is empty, it can't contain the element */
        if (this.isEmpty()) {
            return false;
        }

        int bucket = element.hashCode() % this.table.length;

        /*
         * Method 1 - if the element isn't in its expected bucket, just go through the
         * rest of the table
         * in case it's been displaced. Not the most efficient, but is the simplest
         */

        if (element.equals(this.table[bucket])) {
            return true;
        }

        for (int i = 0; i < this.table.length; i++) {
            if (element.equals(this.table[i])) {
                return true;
            }
        }

        /*
         * Method 2 - this only works if the remove() method rehashes the table to move
         * displaced elements
         * We loop through from our expected bucket until we hit null
         */

        // bucket = (bucket + 1) % this.table.length;

        // while (this.table[bucket] != null) {
        //     if (element.equals(this.table[bucket])) {
        //         return true;
        //     }
        //     bucket = (bucket + 1) % this.table.length;
        // }

        return false;
    }

    @Override
    public boolean remove(T element) {

        /* We can't remove from an empty table */
        if(this.isEmpty()){
            return false;
        }

        int bucket = element.hashCode() % this.table.length;

        if(element.equals(this.table[bucket])){
            this.table[bucket] = null;
            this.size--;
            return true;
        }

        /* Method 1 - loop through the whole table  */
        for(int i=0;i<this.table.length;i++){
            if(element.equals(this.table[i])){
                this.table[i] = null;
                this.size--;
                return true;
            }
        }

        /* Method 2 - only probe until we find the elemnt or null;
         * if we do then find it, rehash the whole table to fill the gap
         */
        
        // bucket = (bucket + 1) % this.table.length;

        // while(this.table[bucket] != null){
        //     if(element.equals(this.table[bucket])){
        //         this.table[bucket] = null;
        //         size--;

        //         Object[] temp = this.table;
        //         this.table = new Object[20];

        //         for(int i=0;i<temp.length;i++){
        //             if(temp[i] != null){
        //                 this.add((T)temp[i]);
        //             }
        //         }

        //         return true;
        //     }
        // }

        return false;
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
