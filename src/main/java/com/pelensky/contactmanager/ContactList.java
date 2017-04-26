package com.pelensky.contactmanager;

import java.util.ArrayList;

public class ContactList {

  private ArrayList<Contact> contacts = new ArrayList<>();

  public ArrayList<Contact> getContacts() {
    return contacts;
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  public void deleteContact(int number) {
    getContacts().remove(number - 1);
  }

  int countContacts() {
    return contacts.size();
  }

}