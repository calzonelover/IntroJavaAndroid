public class TwoDimensionShape{
    protected String _color;
    public TwoDimensionShape(){
    }
    public TwoDimensionShape(String color){
        this._color = color;
    }
    public void setColor(String color){
        this._color = color;
    }
    public String getColor(){
        return this._color;
    }
    // Overriding method in parent
    public void displayInfo(){
        System.out.printf("Color is :%s ", this._color);
    }
}

class Circle extends TwoDimensionShape{
    private double _radius;
    public Circle (String color, double radius){
        super._color = color;
        this._radius = radius;
    }
    // Set function
    public void setRadius(double radius){
        this._radius = radius;
    }
    // Return function
    public double getArea(){
        return 3.14*this._radius*this._radius;
    }
    public double getPerimeter(){
        return 2.0*3.14*this._radius;
    }
    public double getDiameter(){
        return 2.0*this._radius;
    }
    // For override technique
    public void displayInfo(){
        super.displayInfo(); // Override from parent
        System.out.printf("Area : %f ", getArea());
        System.out.printf("Peimeter : %f ", getPerimeter());
    }
    public void displayInfo(String s){
        super.displayInfo();
        System.out.printf("Input : %s ", s);
        System.out.printf("Area %f Perimeter %f", getArea(), getPerimeter());
    }
}

class Triangle extends TwoDimensionShape{
    private double _base;
    private double _height;
    public Triangle(String color, double base, double height){
        super._color = color;
        this._base = base;
        this._height = height;
    }
    // set function
    public void setBase(double base){
        this._base = base;
    }
    public void setHeight(double height){
        this._height = height;
    }
    // Return function
    public double getArea(){
        return 0.5*this._base*this._height;
    }
    public double getPerimeter(){
        return this._base+this._height+Math.sqrt(Math.pow(this._height,2)+Math.pow(this._base,2));
    }

}

class Rectangle extends TwoDimensionShape{
    private double _width;
    private double _height;
    public Rectangle(String color ,double width, double height){
        super._color = color;
        this._width = width;
        this._height = height;
    }
    // set function
    public void setWidth(double width){
        this._width = width;
    }
    public void setHeight(double height){
        this._height = height;
    }
    // get Area
    public double getArea(){
        return this._width*this._height;
    }
    public double getPerimeter(){
        return (2.0*this._width)+(2.0*this._height);
    }

}