package Homework.Week1_OOPReview;

/**
 * Created by dk on 8/30/2017.
 */
public class Manager extends Employee {

    private double _weeklySalary;


    public Manager(String fName, String lName, double weeklySalary) { //manager constructor

        super(fName, lName);
        if (weeklySalary >= 800 && weeklySalary <= 2000)
            this._weeklySalary = weeklySalary;
        else
            this._weeklySalary = 0;
    }

    //setter and getter methods for weekly salary found from read data text file
    public void set_weeklySalary(double weeklySalary) {

        this._weeklySalary = weeklySalary;
    }

    public double get_weeklySalary() {

        return _weeklySalary;
    }

    //prints out the name of the manager and earnings
    public String toString() {
        super.toString();

        return "Manager : "+ super.toString() + "\n\tEarned: " + earnings();
    }

    @Override
    public double earnings() {//earnings method found from data text

        return _weeklySalary;
    }
}
