package com.pelensky.contactmanager;

public class DeleteContact {

    ContactList contactList;

    public DeleteContact(ContactList contactList) {
        this.contactList = contactList;
    }

    public void delete(int number) {
        contactList.getContacts().remove(number - 1);
    }
}
