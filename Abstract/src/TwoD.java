abstract class TwoD {
    private String _color;
    public void setColor(String color){
        this._color = color;
    }
    public String getColor(){
        return this._color;
    }
    // Abstract methods
    public abstract double getArea();
    public abstract double getPerimeter();
    // function display
    public void displayInfo() {
        System.out.printf("Color : %s ", this._color);
    }
    //*** Tips : From above abstract => Other inheritance from this class need to have these two methods ***
}