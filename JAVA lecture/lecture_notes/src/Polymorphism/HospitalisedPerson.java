package Polymorphism;

public class HospitalisedPerson extends LocatedPerson{
    private String hospital;
    private String roomNumber;

    public HospitalisedPerson(String name, int age, String hospital, String roomNumber ){
        super(name,age);
        this.hospital = hospital;
        this.roomNumber = roomNumber;
    }

    @Override
    public String contactInstructions(){
        return "contact at "+this.hospital+" room "+this.roomNumber;
    }
}
