import java.util.*;

public class Factory {

    // Declare List of communicate
    private List<Communicate> _employees = new ArrayList<Communicate>();

    // private List<Member> _members = new ArrayList<Member>(); // Just for home work 3

    public void addEmployee(Employee employee){this._employees.add(employee);}

    public void displayEmployee(){
        System.out.printf("--- Display employees ---\n");
        for (Communicate communicate : _employees){
            System.out.printf("%s \n", communicate.whoAreYou());
        }
    }

    public void displayLocation(){
        System.out.printf("--- Display locations ---\n");
        for (Communicate communicate : this._employees){
            System.out.printf("%s \n", communicate.whoAreYou()); // Just optional
            communicate.whereAreYou();
        }
    }
}
