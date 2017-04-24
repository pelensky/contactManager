package com.pelensky.contactmanager;

class Search implements Option{

    IO io;
    ContactList contactList;
    private ManipulateContacts manipulateContacts;

    Search(IO io, ContactList contactList, ManipulateContacts manipulateContacts){
        this.io = io;
        this.contactList = contactList;
        this.manipulateContacts = manipulateContacts;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("2");
    }

    @Override
    public String instruction() {
        return "2) Search for contact";
    }
}
