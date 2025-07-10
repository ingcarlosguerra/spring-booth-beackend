package pruebatecnica.server.api.model;

import java.util.Objects;

public class User {
    private String typeId;
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String phone;
    private String address;
    private String city;


    public User(String typeId,
                String id,
                String firstName,
                String middleName,
                String lastName,
                String secondLastName,
                String phone,
                String address,
                String city) {
        this.typeId         = typeId;
        this.id             = id;
        this.firstName      = firstName;
        this.middleName     = middleName;
        this.lastName       = lastName;
        this.secondLastName = secondLastName;
        this.phone          = phone;
        this.address        = address;
        this.city           = city;
    }

    // Getters y setters
    public String getTypeId()        { return typeId; }
    public void   setTypeId(String typeId)           { this.typeId = typeId; }

    public String getId()            { return id; }
    public void   setId(String id)                   { this.id = id; }

    public String getFirstName()     { return firstName; }
    public void   setFirstName(String firstName)     { this.firstName = firstName; }

    public String getMiddleName()    { return middleName; }
    public void   setMiddleName(String middleName)   { this.middleName = middleName; }

    public String getLastName()      { return lastName; }
    public void   setLastName(String lastName)       { this.lastName = lastName; }

    public String getSecondLastName(){ return secondLastName; }
    public void   setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhone()         { return phone; }
    public void   setPhone(String phone)               { this.phone = phone; }

    public String getAddress()       { return address; }
    public void   setAddress(String address)           { this.address = address; }

    public String getCity()          { return city; }
    public void   setCity(String city)                 { this.city = city; }



    @Override
    public String toString() {
        return "User{" +
                "typeId='" + typeId + '\'' +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}