
/// Ex abstract ///
public class MyMain{
    public static void main(String[] args){
        // Example of declare object from class
        TwoD c = new Circle();
        TwoD r;
        c = new Circle("black",10);
        r = new Rectangle(2,4);

        // Check session

        System.out.printf("%f",c.getArea());
        // Check info function

        c.displayInfo();


    }
}