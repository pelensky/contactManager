package com.pelensky.contactmanager;

import java.util.ArrayList;

class ContactList {

  private ArrayList<Contact> contacts = new ArrayList<>();

  ArrayList<Contact> getContacts() {
    return contacts;
  }

  void addContact(Contact contact) {
    contacts.add(contact);
  }

  String listContacts() {
    StringBuilder formattedContact = new StringBuilder();
    for (int i = 0; i < contacts.size(); i++) {
      formattedContact.append(formatContact(i)).append("\n");
    }
    return formattedContact.toString().trim();
  }

  private String formatContact(int number) {
    Contact contact = getContacts().get(number);
    return (Integer.toString(number + 1)
        + ") "
        + contact.getFirstName()
        + " "
        + contact.getLastName()
        + "\n"
        + contact.getAddress()
        + "\n"
        + contact.getCity()
        + " "
        + contact.getPostCode()
        + "\n"
        + contact.getPhoneNumber());
  }
}
