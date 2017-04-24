package com.pelensky.contactmanager;

import java.util.ArrayList;

class ManipulateContacts {

    ContactList contactList;

    ManipulateContacts(ContactList contactList){
        this.contactList = contactList;
    }

    boolean isNotAValidNumber(int selectedContact) {
      return (selectedContact > contactList.countContacts()) || (selectedContact < 1);
    }


    String listContacts() {
      StringBuilder formattedContact = new StringBuilder();
      for (int i = 0; i < contactList.countContacts(); i++) {
        formattedContact.append(formatContact(i)).append(System.lineSeparator());
      }
      return formattedContact.toString().trim();
    }

    private String formatContact(int number) {
      Contact contact = contactList.getContacts().get(number);
      return (Integer.toString(number + 1)
              + ") "
              + contact.getFirstName()
              + " "
              + contact.getLastName()
              + System.lineSeparator()
              + contact.getAddress()
              + System.lineSeparator()
              + contact.getCity()
              + " "
              + contact.getPostCode()
              + System.lineSeparator()
              + contact.getPhoneNumber());
    }

    boolean isContactListEmpty() {
        return getContacts().isEmpty();
    }

    private ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

}
