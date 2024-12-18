package Module_1.Packages_And_AccessModifers.PackageOne;


public class AccessModifierDemoInsidePackage
{
    public static void main(String[] args) 
    {
        Student s1 = new Student();
        s1.setMobileNO(2034523424);
        s1.city = "Ahmedabad";
        s1.name = "Boby";
        s1.address = "212, biswass nagar";

        System.out.println("Mobile: " + s1.getMobileNO());
        System.out.println("City: " + s1.city);
        System.out.println("Name: " + s1.name);
        System.out.println("Address: " + s1.address);
    }
}
