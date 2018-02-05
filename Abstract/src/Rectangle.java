public class Rectangle extends TwoD {
    private double _width;
    private double _height;
    //
    public Rectangle(double width, double height){
        this._height = height;
        this._width = width;
    }
    public Rectangle(String color, double width, double height){
        super.setColor(color);
        this._height = height;
        this._width = width;
    }
    // get method
    public void setHeight(double height){
        this._height = height;
    }
    public void setWidth(double width){
        this._width = width;
    }
    public double getArea(){
        return this._width*this._height;
    }
    public double getPerimeter(){
        return (2.0*this._width)+(2.0*this._height);
    }
}
