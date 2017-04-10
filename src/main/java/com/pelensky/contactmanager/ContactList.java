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







}
