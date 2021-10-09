package com.jasperreport;

/**
 * @Created 09/10/2021 - 13:20
 * @Package com.jasperreport
 * @Project jasperreportspringboot
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;

    public Employee(Long id, String firstName, String lastName, String street, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
