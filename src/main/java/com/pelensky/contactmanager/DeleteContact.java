package com.pelensky.contactmanager;

class DeleteContact {

    ContactList contactList;

    DeleteContact(ContactList contactList) {
        this.contactList = contactList;
    }

    void delete(int number) {
        contactList.getContacts().remove(number - 1);
    }
}
