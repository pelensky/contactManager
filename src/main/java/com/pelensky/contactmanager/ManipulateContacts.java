package com.pelensky.contactmanager;

import java.lang.reflect.Array;
import java.util.ArrayList;

class ManipulateContacts {

    ContactList contactList;

    ManipulateContacts(ContactList contactList){
        this.contactList = contactList;
    }

    boolean isNotAValidNumber(int selectedContact) {
      return (selectedContact > contactList.countContacts()) || (selectedContact < 1);
    }


    String listContacts(ArrayList<Contact> listOfContacts) {
      StringBuilder formattedContact = new StringBuilder();
      sortContacts(listOfContacts);
      for (int i = 0; i < listOfContacts.size(); i++) {
        formattedContact.append(formatContact(i, listOfContacts)).append(System.lineSeparator());
      }
      return formattedContact.toString().trim();
    }

    private String formatContact(int number, ArrayList<Contact> listOfContacts) {
      Contact contact = listOfContacts.get(number);
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

    private void sortContacts(ArrayList<Contact> listOfContacts) {
        listOfContacts.sort(Contact.contactComparator);
    }

}
