package com.employeeApplication;

public class Company {
    //Variabler
   private String companyName;
   private String city;
   private String address;
   private String telephoneNumber;

    //konstruktor för företagsinformation
    public Company(String companyName, String city, String address,String telephoneNumber) {
        this.companyName = companyName;
        this.city = city;
        this.address = address;
        this.telephoneNumber = telephoneNumber;

    }
    //getter and setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}