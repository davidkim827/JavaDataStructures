package Homework.Week1;

/**
 * Created by dk on 8/30/2017.
 */
public class Manager extends Employee {

    private double _weeklySalary;


    public Manager(String fName, String lName, double weeklySalary) {

        super(fName, lName);
        if (weeklySalary >= 800 && weeklySalary <= 2000)
            this._weeklySalary = weeklySalary;
        else
            this._weeklySalary = 0;
    }

    public void set_weeklySalary(double weeklySalary) {

        this._weeklySalary = weeklySalary;
    }

    public double get_weeklySalary() {

        return _weeklySalary;
    }

    public String toString() {
        super.toString();

        return "Manager : "+ super.toString() + "\n\tEarned: " + earnings();
    }

    @Override
    public double earnings() {

        return _weeklySalary;
    }
}
