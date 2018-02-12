public abstract class Member implements Communicate{
    private int _memID;
    public void setMemID(int memID){
        this._memID = memID;
    }
    public int getmemID(){ return this._memID; }

    /// No need these two method due to abstract class already call abstract methods from interface
//    public abstract String whoAreYou();
//    public abstract String whereAreYou();
}



