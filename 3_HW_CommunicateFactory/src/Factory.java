import java.util.*;

public class Factory {

    // Declare List of communicate
    private List<Member> _employees = new ArrayList<Member>();
    private List<Member> _robots = new ArrayList<Member>();

    // private List<Member> _members = new ArrayList<Member>(); // Just for home work 3

    public void addEmployee(Employee employee){this._employees.add(employee);}
    public void addRobot(Robot robot){this._robots.add(robot);}


    public void displayWorker(){
        System.out.printf("--- Display worker detail --- \n ");
        System.out.printf("--- Employee --- \n");
        for (Member communicate : this._employees){
            System.out.printf("%s %s \n", communicate.whoAreYou()
                    , communicate.whereAreYou());
        }
        System.out.printf("--- Robot --- \n");
        for (Member communicate : this._robots){
            System.out.printf("%s %s \n", communicate.whoAreYou()
                    , communicate.whereAreYou());
        }
    }
}
