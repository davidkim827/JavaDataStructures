package Homework.Week8_SortedNameList;

/**
 * Created by dk on 10/15/2017.
 */
public class Name implements Comparable<Name>{

    private String firstName;
    private String lastName;

    public Name(){
        this.firstName = "";
        this.lastName = "";
    }

    public Name(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public int compareTo(Name n){
        return lastName.compareTo(n.getLastName());
    }
    public String toString(){
        return String.format("%15s%15s", firstName, lastName);
    }
}
