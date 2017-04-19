package com.pelensky.contactmanager;

public class Add implements Option {

    private CLInterface clinterface;
    ContactList contactList;

    Add(CLInterface clInterface, ContactList contactList){
        this.clinterface = clInterface;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        clinterface.printToConsole("Add a new contact");
        Contact newContact =
                new Contact(
                        addContactInfo("First Name: "),
                        addContactInfo("Last Name: "),
                        addContactInfo("Address (One Line): "),
                        addContactInfo("City: "),
                        addContactInfo("Postcode: "),
                        addContactInfo("Phone number: "));
        contactList.addContact(newContact);
        clinterface.printToConsole(
                newContact.getFirstName()
                        + " "
                        + newContact.getLastName()
                        + " has been added as a contact.");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("add");
    }


    private String addContactInfo(String text) {
        clinterface.printToConsole(text);
        return clinterface.getUserInput();
    }
 }
