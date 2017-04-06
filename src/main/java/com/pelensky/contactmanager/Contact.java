package com.pelensky.contactmanager;

class Contact {

  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String postCode;
  private String phoneNumber;

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
}
