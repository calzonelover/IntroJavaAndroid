public class Employee implements Communicate {
    private String _name;
    private String _location;
    // overload method
    public Employee(){
        this._name = "*** Not define ***";
        this._location = "*** Not define ***";
    }
    public Employee(String name, String location){
        this._name = name;
        this._location = location;
    }
    // methods
    public void setName(String name){this._name = name;}
    public void setLocation(String location){this._location = location;}

    @Override
    public String whoAreYou(){
        return "I am employee name : "+this._name;
    }

    @Override
    public void whereAreYou(){
        System.out.printf("I am in %s \n", this._location);
    }
}
