package uk.ac.rgu.cm2116;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testEquals(){
        String surname = "surname";
        String firstname = "firstname";
        String address = "address";

        Person person1 = new Person(surname, firstname, address);
        Person person2 = new Person(surname, firstname, address);

        Person person3 = new Person("surname3", "firstname3", "address3");

        boolean result1 = person1.equals(person2);
        boolean result2 = person2.equals(person1);

        boolean result3 = person1.equals(person3);
        boolean result4 = person2.equals(person3);
        
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertFalse(result4);
    }
    
}
