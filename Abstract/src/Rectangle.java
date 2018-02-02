public class Rectangle extends TwoD {
    private double _width;
    private double _height;
    public Rectangle(double width, double height){
        this._height = height;
        this._width = width;
    }
    // get method
    public double getArea(){
        return this._width*this._height;
    }
    public double getPerimeter(){
        return (2.0*this._width)+(2.0*this._height);
    }
}
