
/// Ex abstract ///
public class MyMain{
    public static void main(String[] args){
        // Example of declare object from class
        TwoD c;
        TwoD r;
        c = new Circle("black",10);
        r = new Rectangle(2,4);

        // Check session

        System.out.printf("Circle area = %f\n",c.getArea());
        // Check info function
        /// There is two ways to displayInfo
        // test general method in main
        System.out.println("!! Test general method in main !!");
        displayInfo(c);
        // test method display in TwoD class
        System.out.println("\n!! Test method display in class !!");
        c.displayInfo();
    }
    public static void displayInfo(TwoD shape){
        System.out.printf("Color : %s , Area : %f , Perimeter : %f ", shape.getColor(), shape.getArea(), shape.getPerimeter());
    }
}