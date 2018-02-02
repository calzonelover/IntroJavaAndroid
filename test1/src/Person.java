public class Person{ // Style not for using "super." due to each class has function it self and subclass do not want to access
    private String _cid;
    private String _name;
    private String _birthDate;
    private String _gender;
    private int _age;
    // Set function
    public void setCid(String cid){
        this._cid = cid;
    }
    public void setName(String name){
        this._name = name;
    }
    public void setBirthDate(String birthDate){
        this._birthDate = birthDate;
    }
    public void setGender(String gender){
        this._gender = gender;
    }
    public void setAge(int age){
        this._age = age;
    }
    // Get function
    public String getCid(){
        return this._cid;
    }
    public String getName(){
        return this._name;
    }
    public String getBirthDate(){
        return this._birthDate;
    }
    public String getGender(){
        return this._gender;
    }
    public int getAge(){
        return this._age;
    }
}

/// Subclass
class Professor extends Person{
    private String _eid;
    private String _hireDate;
    private double _salary;
    private String _degree;
    private String _faculty;
    private String _major;
    // set function
    public void setEid(String eid){
        this._eid = eid;
    }
    public void setHireDate(String hireDate){
        this._hireDate = hireDate;
    }
    public void setSalary(double salary){
        this._salary = salary;
    }
    public void setDegree(String degree){
        this._degree = degree;
    }
    public void setFaculty(String faculty){
        this._faculty = faculty;
    }
    public void setMajor(String major){
        this._major = major;
    }
    // get function
    public String getEid(){
        return this._eid;
    }
    public String getHireDate(){
        return this._hireDate;
    }
    public double getSalary(){
        return this._salary;
    }
    public String getDegree(){
        return this._degree;
    }
    public String getFaculty(){
        return this._faculty;
    }
    public String getMajor(){
        return this._major;
    }
}

/// Student
class Students extends Person{ // Reason "Students" has "s" due to
    private String _sid;
    private String _startDate;
    private String _degree;
    private String _faculty;
    private String _major;
    // set function
    public void setSid(String sid){
        this._sid = sid;
    }
    public void setStartDate(String startDate){
        this._startDate = startDate;
    }
    public void setDegree(String degree){
        this._degree = degree;
    }
    public void setFaculty(String faculty){
        this._faculty = faculty;
    }
    public void setMajor(String major){
        this._major = major;
    }
    // get function
    public String getSid(){
        return this._sid;
    }
    public String getStartDate(){
        return this._startDate;
    }
    public String getFaculty(){
        return this._faculty;
    }
    public String getMajor(){
        return this._major;
    }

}