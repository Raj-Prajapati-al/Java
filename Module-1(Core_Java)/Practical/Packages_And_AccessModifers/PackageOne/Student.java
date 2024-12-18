package Module_1.Packages_And_AccessModifers.PackageOne;

public class Student
{
    private long mobileNO; // Only in class
    String name; // Only in Package
    protected String address; // inside package anywhere outside package only by subclasses
    public String city; // Use Anywhere

    public void setMobileNO(long mobileNO) {
        this.mobileNO = mobileNO;
    }   
    public long getMobileNO() {
        return this.mobileNO;
    } 
}