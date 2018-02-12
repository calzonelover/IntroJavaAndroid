public class MyMain {
    public static void main(String[] args){
        Factory myFactory = new Factory();

        Employee myEmployee1 = new Employee("Guy","Gym");
        Employee myEmployee2 = new Employee("Girl", "Beauty shop");

        myFactory.addEmployee(myEmployee1);
        myFactory.addEmployee(myEmployee2);

        myEmployee2.setLocation("Eve and Boy"); // test setLocation function

        myFactory.displayEmployee();
        myFactory.displayLocation();
    }
}
