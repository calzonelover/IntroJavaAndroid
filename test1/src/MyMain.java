/// HW : class,  HTML, comhat(web server for write java)///
/* Build class for Find area of
- Triangle, rectangle, circle
 */

import java.awt.*;


/// HW 2 TwoDShape ///
public class MyMain{
    public static void main(String[] args){
        /// Declare
        Circle cir = new Circle("black",10);
        Triangle tri = new Triangle("white",6, 8);
        Rectangle rec = new Rectangle("dark", 6, 8);

        // test
        System.out.printf("Circle Area = %f , Color is %s , Perimeter = %f\n",cir.getArea(), cir.getColor(), cir.getPerimeter());
        System.out.printf("Triangle Area = %f , Color is %s , Perimeter = %f \n",tri.getArea(), tri.getColor(), tri.getPerimeter());
        System.out.printf("Rectangle Area = %f , Color is %s , Perimeter = %f \n",rec.getArea(), rec.getColor(), rec.getPerimeter());
        // Override test
        System.out.println("!! Test overriding function !!");
        cir.displayInfo();
        cir.displayInfo("Blaaa");
    }
}

/*
/// Ex 2 with student ///
public class MyMain{
    public static void main(String[] args){
        /// There is two ways to declare class
        /// first way to declare class
//        Student s1 = new Student();
        /// second way to declare class
        Student s1, s2, s3;
        s1 = new Student();
        s2 = new Student("555");
        s3 = new Student("555", "I dont give");

        ///
        s1.setSid("1234");
        s1.setName("Men fucked up");
        s1.setAge(22); // _age is public, then we can set directly without any capsulation
        s1.increaseAge();

//        s2.setSid("4567");
//        s2.setName("Girl fuck up");

        printInfo(s1);
        printInfo(s2);
        printInfo(s3);

    }

    public static void printInfo(Student student){ // Student=Class student = input variable
        System.out.printf("SID = %s Name = %s Age = %d\n", student.getSid(), student.getName(), student.getAge());
    }
}
*/

/// Ex 1  ////
/*public class MyMain {
    public static void main(String[] args){ // void not return value & ?? String,args
        PrintInfo("java is OOP");
        int z = add(2,3);
        float p = add(200.0f,300.0f);
        System.out.printf("z = %d and p = %f\n", z, p);
//        System.out.printf("args[0] = %s args[1] = %s", args[0], args[1]);
//        System.out.println("Hello Fucking World !!!");
    }
    private static void PrintInfo(String s){
        System.out.printf("Info is %s \n", s);
    }
    private static void PrintNumber(int i){
        System.out.printf("Number = %d", i);
    }
    private static void PrintNumber(float i){
        System.out.printf("Number = %f", i);
    }
    private static int add(int x, int y){
        return x + y;
    }
    private static float add(float x, float y){
        return  x + y;
    }
}*/