public class Employee extends Member implements Communicate{
    private int _CID;
    private String _name;
    private String _location;
    // overload method
    public Employee(){
        super.setMemID(-1);
        this._CID = -1;
        this._name = "*** Note define yet***";
        this._location = "*** Note define yet***";
    }
    public Employee(int memID, int CID, String name, String location){
        super.setMemID(memID);
        this._CID = CID;
        this._name = name;
        this._location = location;
    }
    // method
    public void setCID(int CID){ this._CID = CID; }
    public void setName(String name){ this._name = name; }
    public void setLocation(String location){ this._location = location;}


    // Communicate

    @Override
    public String whoAreYou(){return "I am employee memID : "+ super.getmemID()
            + " name : "+ this._name + " and CID : "+ this._CID;}
    @Override
    public String whereAreYou(){return "I live in : "+this._location;}

}