package com.pelensky.contactmanager;

import java.util.ArrayList;

class ContactList {

  ArrayList<Contact> getContacts() {
    return contacts;
  }

  private ArrayList<Contact> contacts = new ArrayList<>();

  void addContact(Contact contact) {
    contacts.add(contact);
  }

  String formatContact() {
      Contact contact = getContacts().get(0);
      return (contact.getFirstName() + " " + contact.getLastName() + "\n" + contact.getAddress() + "\n" + contact.getCity() + " " + contact.getPostCode() + "\n" + contact.getPhoneNumber());
     }
}
