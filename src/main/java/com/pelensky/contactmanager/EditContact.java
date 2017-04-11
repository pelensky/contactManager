package com.pelensky.contactmanager;


class EditContact {

    private ContactList contactList;

    EditContact(ContactList contactList){
        this.contactList = contactList;
    }

    Contact getContact(int number) {
        return contactList.getContacts().get(number - 1);
    }
}
