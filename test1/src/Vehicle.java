public class Vehicle {
    protected String _licensePlate;
    protected int _cc;
    protected String _color;
}

class MotorCycle extends Vehicle{
    private String _type;
    public void displatInfo(){
        System.out.printf(super._licensePlate); // "super" use as "this" but from its mother
    }
}