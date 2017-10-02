package Homework.Week1_OOPReview;

/**
 * Created by dk on 8/30/2017.
 */
public abstract class Employee {

    private String _fName;
    private String _lName;

    public Employee(String fName, String lName) {
        this._fName = fName;
        this._lName = lName;
    }

    public void set_fName(String fName) {

        this._fName = fName;
    }

    public String get_fName() {

        return _fName;
    }

    public void set_lName(String lName) {

        this._lName = lName;
    }

    public String get_lName() {

        return _lName;
    }

    public String toString() {

        return _fName + " " + _lName;
    }


    public abstract double earnings();
}
