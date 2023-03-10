package uk.ac.rgu.cm2116;

public class Person {

    private String surname;
    private String firstname;
    private String address;

    public Person(String surname, String firstname, String address) {
        this.surname = surname;
        this.firstname = firstname;
        this.address = address;
    }

    public String getFullName() {
        return this.firstname + " " + this.surname;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return "Name: " + this.getFullName() + "; Address: " + this.address;
    }

    @Override
    public int hashCode() {
        /*
         * This hashCode implementation simply adds the hashcodes from the three String
         * fields
         */
        return this.surname.hashCode() + this.firstname.hashCode() + this.address.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        Person otherPerson = (Person) o;
        /*
         * Start your implementation below this line,
         * comparing this Person object to otherPerson
         */

         /* Check if the surnames, firstnames, addresses, and also hashcodes are equal */
        if (otherPerson.surname.equals(this.surname)
                && otherPerson.firstname.equals(this.firstname)
                && otherPerson.address.equals(this.address)
                && otherPerson.hashCode() == this.hashCode()) {
            return true;
        } else {
            return false;
        }
    }
}
