package uk.ac.rgu.cm2116;

public class Person {
    
    public Person(String surname, String firstname, String address){
        
    }


    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }else if(!o.getClass().equals(this.getClass())){
            return false;
        }

        Person otherPerson = (Person)o;
        /* Start your implementation below this line, 
            comparing this Person object to otherPerson */

        return false;
    }
}
