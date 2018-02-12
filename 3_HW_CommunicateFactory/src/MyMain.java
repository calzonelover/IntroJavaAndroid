public class MyMain {
    public static void main(String[] args){


        Factory myFactory = new Factory();

        Employee myEmployee1 = new Employee(1, 1, "Jub", "BKK");
        Employee myEmployee2 = new Employee(2, 2, "Jang", "CNX");

        Robot myRobot1 = new Robot(3, 1, "Kakkak", "Repository1");
        Robot myRobot2 = new Robot(4, 2, "HodSus", "Repository2");


        myFactory.addEmployee(myEmployee1);
        myFactory.addEmployee(myEmployee2);

        myFactory.addRobot(myRobot1);
        myFactory.addRobot(myRobot2);

//        myEmployee2.setLocation("Eve and Boy"); // test setLocation function
//
//        myFactory.displayEmployee();
//        myFactory.displayLocation();

        /// Display worker
        myFactory.displayWorker();
    }
}