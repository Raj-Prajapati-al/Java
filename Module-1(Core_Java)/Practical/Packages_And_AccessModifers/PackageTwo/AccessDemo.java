package Module_1.Packages_And_AccessModifers.PackageTwo;
import Module_1.Packages_And_AccessModifers.PackageOne.Student;

public class AccessDemo extends Student
{
    public static void main(String[] args) 
    {
        Student a1 = new Student();
        a1.setMobileNO(903452342);
        a1.city = "Chicago";
        a1.address = "234, fian";

    }
}
