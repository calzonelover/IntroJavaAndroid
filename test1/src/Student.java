// Tips :
// if write static
// static variable gets memory only once in class area at the time of class loading.

public class Student {
    /// has private, public, protected(almost use when inherit)
    private String _sid;
    private String _name;
    private int _age;

    /// Constructor : would give a name as class name (just set default value)
    public Student(){
        this._sid = "*** Not put yet ***";
        this._name = "*** Not put yet ***";
        this._age = -1;
    }
    public Student(String sid){
        this._sid = sid;
        this._name = "*** Not put yet ***";
        this._age = -1;
    }
    public Student(String sid, String name){
        this._sid = sid;
        this._name = name;
        this._age = -1;
    }
    /// Increage age
    public void increaseAge(){
        this._age++;
    }
    /// Set function
    public void setSid(String sid){
        this._sid = sid;
    }
    public void setName(String name){
        this._name = name;
    }
    public void setAge(int age){
        this._age = age;
    }

    /// Get function
    public String getName(){
        return this._name;
    }
    public String getSid(){
        return this._sid;
    }
    public int getAge(){
        return this._age;
    }
}
