package com.pelensky.contactmanager.DomainModels;

import java.util.ArrayList;

public class ContactList {

  private ArrayList<Contact> contacts = new ArrayList<>();

  public ArrayList<Contact> getContacts() {
    return contacts;
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  public void deleteContact(Contact contact) {
    getContacts().remove(contact);
  }

  public int countContacts() {
    return contacts.size();
  }

}