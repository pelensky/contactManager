package com.pelensky.contactmanager;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ManipulateContacts {

    ContactList contactList;

    ManipulateContacts(ContactList contactList){
        this.contactList = contactList;
    }

    public boolean isNotAValidNumber(int selectedContact) {
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

    public boolean isContactListEmpty() {
        return getContacts().isEmpty();
    }

    private ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

    private void sortContacts(ArrayList<Contact> listOfContacts) {
        listOfContacts.sort(Contact.contactComparator);
    }

    ArrayList<Contact> filterContacts(String search) {
        ArrayList<Contact> filteredContacts = contactList.getContacts().stream().filter(contact -> contact.getFirstName().toUpperCase().equals(search)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Contact> filteredByLastName = contactList.getContacts().stream().filter(contact -> contact.getLastName().toUpperCase().equals(search)).collect(Collectors.toCollection(ArrayList::new));
        filteredContacts.removeAll(filteredByLastName);
        filteredContacts.addAll(filteredByLastName);
        return filteredContacts;
    }
}
