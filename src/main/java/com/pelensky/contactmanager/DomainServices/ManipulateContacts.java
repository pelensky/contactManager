package com.pelensky.contactmanager.DomainServices;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainModels.ContactList;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ManipulateContacts {

    private ContactList contactList;

    public ManipulateContacts(ContactList contactList){
        this.contactList = contactList;
    }

    public String listContacts(ArrayList<Contact> listOfContacts) {
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

    public ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

    private void sortContacts(ArrayList<Contact> listOfContacts) {
        listOfContacts.sort(Contact.contactComparator);
    }

    public ArrayList<Contact> filterContacts(String filter) {
        ArrayList<Contact> filteredContacts = contactList.getContacts().stream().filter(contact -> contact.getFirstName().toUpperCase().equals(filter)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Contact> filteredByLastName = contactList.getContacts().stream().filter(contact -> contact.getLastName().toUpperCase().equals(filter)).collect(Collectors.toCollection(ArrayList::new));
        filteredContacts.removeAll(filteredByLastName);
        filteredContacts.addAll(filteredByLastName);
        return filteredContacts;
    }
}
