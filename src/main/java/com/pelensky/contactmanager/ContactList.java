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

  private String formatContact(int number) {
      Contact contact = getContacts().get(number);
      return (contact.getFirstName() + " " + contact.getLastName() + "\n" + contact.getAddress() + "\n" + contact.getCity() + " " + contact.getPostCode() + "\n" + contact.getPhoneNumber() + "\n\n");
     }

     String listContacts() {
      StringBuilder formattedContact = new StringBuilder();
      for (int i = 0; i < contacts.size(); i++) {
            formattedContact.append(formatContact(i));
         }
         return formattedContact.toString();
     }
}
