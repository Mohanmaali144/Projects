package pojopackage;

public class PojoRGPV {

    private String firstname, lastname, lname, course, fname, mname, branch, uv, address, mobile, email, password, userName, sem;
    private int age, roll, year, physics, chemistry, math, hindi, english, total;
    private double per;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PojoRGPV() {
    }

    public PojoRGPV(String course, String branch, String sem, int age, int year, int physics, int chemistry, int math, int hindi, int english, int total, double per, int rgNo) {
        //  public PojoRGPV(String course, String branch, String sem, int age, int roll, int year, int physics, int chemistry, int math, int hindi, int english, int total, double per) {

//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.fname = fname;
//        this.mname = mname;
        this.course = course;
        this.sem = sem;
        this.age = age;
        this.branch = branch;
        //  this.roll = roll;
        this.year = year;
        this.physics = physics;
        this.chemistry = chemistry;
        this.math = math;
        this.hindi = hindi;
        this.english = english;

        this.total = total;
        this.per = per;
        this.roll = rgNo;

//        try {
//            saveData();
//        } catch (Exception r) {
//        }
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PojoRGPV(String name, String fname, String mname, String address, String lname, String mobile, String email, String password, String userName) {
        this.firstname = name;
        this.fname = fname;
        this.mname = mname;
        this.address = address;
        this.lname = lname;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.userName = userName;

//        try {
//            saveData();
//        } catch (Exception r) {
//        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getfirstName() {
        return firstname;
    }

    public void setfirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getHindi() {
        return hindi;
    }

    public void setHindi(int hindi) {
        this.hindi = hindi;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

}
