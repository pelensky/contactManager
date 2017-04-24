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

  int countContacts() {
    return contacts.size();
  }

  boolean isContactListEmpty() {
    return getContacts().isEmpty();
  }

  boolean isNotAValidNumber(int selectedContact) {
    return (selectedContact > countContacts()) || (selectedContact < 1);
  }
}