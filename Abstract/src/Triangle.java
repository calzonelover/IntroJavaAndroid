public class Triangle extends TwoD {
    private double _height;
    private double _base;
    //
    public Triangle(double height, double base){
        this._height = height;
        this._base = base;
    }
    public Triangle(String color, double height, double base){
        super.setColor(color);
        this._base = base;
        this._height = height;
    }
    // methods
    public void setBase(double base){
        this._base = base;
    }
    public void setHeight(double height){
        this._height = height;
    }
    public double getArea(){
        return 0.5*this._height*this._base;
    }
    public double getPerimeter(){
        return this._base+this._height+Math.sqrt(Math.pow(this._height,2)+Math.pow(this._base,2));
    }
}
