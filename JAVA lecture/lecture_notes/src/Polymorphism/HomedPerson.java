package Polymorphism;

public class HomedPerson extends LocatedPerson {

    private String contactInstuctions = "home";
    private String phoneNumber;
    public HomedPerson(String name, int age, String phoneNumber){
        super(name,age);
        this.phoneNumber = phoneNumber;

    }

    @Override
    // realize abstract method
    public String contactInstructions(){
        return this.contactInstuctions;
    }
    //新增的method
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
