package com.pelensky.contactmanager;

import java.util.Comparator;

class Contact {

  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String postCode;
  private String phoneNumber;

  Contact(
      String firstName,
      String lastName,
      String address,
      String city,
      String postCode,
      String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.postCode = postCode;
    this.phoneNumber = phoneNumber;
  }

   String getFirstName() {
    return firstName;
  }

  String getLastName() {
    return lastName;
  }

  String getAddress() {
    return address;
  }

  String getCity() {
    return city;
  }

  String getPostCode() {
    return postCode;
  }

  String getPhoneNumber() {
    return phoneNumber;
  }

  void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  void setLastName(String lastName) {
    this.lastName = lastName;
  }

  void setAddress(String address) {
    this.address = address;
  }

  void setCity(String city) {
    this.city = city;
  }

  void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  static Comparator<Contact> contactComparator = (c1, c2) -> {
    String contact1 = c1.getLastName().toUpperCase();
    String contact2 = c2.getLastName().toUpperCase();
    return contact1.compareTo(contact2);
  };


}
