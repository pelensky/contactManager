package com.pelensky.contactmanager;

import java.util.ArrayList;

public class ContactList {

  private ArrayList<Contact> contacts = new ArrayList<>();

  ArrayList<Contact> getContacts() {
    return contacts;
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  public void deleteContact(Contact contact) {
    getContacts().remove(contact);
  }

  int countContacts() {
    return contacts.size();
  }

}