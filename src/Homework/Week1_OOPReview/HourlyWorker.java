package Homework.Week1_OOPReview;

/**
 * Created by dk on 8/30/2017.
 */
public class HourlyWorker extends Employee{

    double _wagePerHours;
    int _hoursWorkedPerWeek;

    public HourlyWorker(String fName, String lName, double wage, int hours) { //constructor for the hourly worker
        super(fName, lName);
        set_wagePerHours(wage);
        set_hoursWorkedPerWeek(hours);
        this._hoursWorkedPerWeek = hours;
    }

    //getter and setter methods for the set wage per hour
    public void set_wagePerHours(double wagePerHours){
        if (wagePerHours < 25 || wagePerHours > 50)
            set_wagePerHours(35);
        else
            this._wagePerHours = wagePerHours;
    }

    public double get_wagePerHours(){

        return _wagePerHours;
    }

    //getter and setter methods for the set hours worked per week
    public void set_hoursWorkedPerWeek(int hoursWorkedPerWeek){
        if (hoursWorkedPerWeek > 60)
            set_hoursWorkedPerWeek(60);
        else
            this._hoursWorkedPerWeek = hoursWorkedPerWeek;
    }

    public int get_hoursWorkedPerWeek(){

        return _hoursWorkedPerWeek;
    }

    //toString method to print out the hourly worker name and his/her earnings
    public String toString(){
        super.toString();

        return "Hourly Worker : " + super.toString() + "\n\tEarned: " + earnings();
    }

    //earnings method to calculate how many hours overtime, and total wage
    @Override
    public double earnings() {
        int overTime;
        double totalEarnings;
        if (get_hoursWorkedPerWeek() > 40) {
            overTime = get_hoursWorkedPerWeek() - 40;
            return ((get_wagePerHours() * 40) + (1.5 * get_wagePerHours() * overTime));
        }
        else
            return (get_wagePerHours() * 40);
    }
}
