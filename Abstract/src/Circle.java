// Build Circle class which would be a concrete class
public class Circle extends TwoD {
    private double _radius;
    // Polymorphism of first call class
    public Circle(){
    }
    public Circle(String color, double radius){
        super.setColor(color);
        this._radius = radius;
    }
    //
    public void setRadius(double radius){
        this._radius = radius;
    }
    public double getArea(){
        return 3.14*this._radius*this._radius;
    }
    public double getPerimeter(){
        return 2.0*3.14*this._radius;
    }
}