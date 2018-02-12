public class Robot extends Member implements Communicate {
    private int _serialNO;
    private String _model;
    private String _location;
    // overload method
    public Robot(){
        super.setMemID(-1);
        this._serialNO = -1;
        this._model = "*** Note define yet***";
        this._location = "*** Note define yet***";
    }
    public Robot(int memID, int serialNO, String model, String location){
        super.setMemID(memID);
        this._serialNO = serialNO;
        this._model = model;
        this._location = location;
    }
    //method
    public void setSerialNO(int serialNO){ this._serialNO = serialNO;}
    public void setModel(String model){ this._model = model;}
    public void setLocation(String location){ this._location = location;}

    // Communicate
    @Override
    public String whoAreYou(){return "I am robot memID : " + super.getmemID()
            + " SerialNO : "+ this._serialNO +" Model :  "+ this._model;}
    @Override
    public String whereAreYou(){return "I live in : "+this._location;}
}
