package sy.tech.space.AddressManager_Backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Address implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private long id;
    private String firstname;
    private String lastname;
    private String street;
    private String city;
    private String telNumber;
    private long zip;

    public long getId() {
        return id;
    }

    public Address() {

    }

    public Address(String firstname, String lastname, String street, String city, String telNumber, long zip) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.telNumber = telNumber;
        this.zip = zip;
    }

    public Address(long id, String firstname, String lastname, String street, String city, String telNumber, long zip) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.telNumber = telNumber;
        this.zip = zip;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public long getZip() {
        return zip;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    // Update existing address fields with values from updatedAddress
    public void updateAll(Address address) {
        this.setFirstname(address.getFirstname());
        this.setLastname(address.getLastname());
        this.setStreet(address.getStreet());
        this.setCity(address.getCity());
        this.setTelNumber(address.getTelNumber());
        this.setZip(address.getZip());
    }
}
