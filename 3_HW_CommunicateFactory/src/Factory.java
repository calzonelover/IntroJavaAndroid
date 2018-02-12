import java.util.*;

public class Factory {

    // Declare List of communicate
    private List<Communicate> _employees = new ArrayList<Communicate>();
    private List<Communicate> _robots = new ArrayList<Communicate>();

    // private List<Member> _members = new ArrayList<Member>(); // Just for home work 3

    public void addEmployee(Employee employee){this._employees.add(employee);}
    public void addRobot(Robot robot){this._robots.add(robot);}

    public void displayEmployee(){
        System.out.printf("--- Display employees ---\n");
        for (Communicate communicate : _employees){
            System.out.printf("%s \n", communicate.whoAreYou());
        }
        for (Communicate communicate : _robots){
            System.out.printf("%s \n", communicate.whoAreYou());
        }
    }

    public void displayLocation(){
        System.out.printf("--- Display locations ---\n");
        for (Communicate communicate : this._employees){
            System.out.printf("%s \n", communicate.whereAreYou()); // Just optional
            communicate.whereAreYou();
        }
        for (Communicate communicate : this._robots){
            System.out.printf("%s \n", communicate.whereAreYou());
        }
    }
    /// More general
    public void displayWorker(){
        System.out.printf("--- Display worker detail --- \n ");
        System.out.printf("--- Employee --- \n");
        for (Communicate communicate : this._employees){
            System.out.printf("%s %s \n", communicate.whoAreYou()
                    , communicate.whereAreYou());
        }
        System.out.printf("--- Robot --- \n");
        for (Communicate communicate : this._robots){
            System.out.printf("%s %s \n", communicate.whoAreYou()
                    , communicate.whereAreYou());
        }
    }
}
