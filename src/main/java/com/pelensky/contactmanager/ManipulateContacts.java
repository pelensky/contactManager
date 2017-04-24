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
        formattedContact.append(formatContact(i)).append("\n");
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
              + "\n"
              + contact.getAddress()
              + "\n"
              + contact.getCity()
              + " "
              + contact.getPostCode()
              + "\n"
              + contact.getPhoneNumber());
    }

    boolean isContactListEmpty() {
        return getContacts().isEmpty();
    }

    private ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

}
