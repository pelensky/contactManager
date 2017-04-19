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
                        addFirstName(),
                        addLastName(),
                        addAddress(),
                        addCity(),
                        addPostCode(),
                        addPhoneNumber());
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


    private String addFirstName() {
        clinterface.printToConsole("First Name: ");
        return clinterface.input.nextLine().trim();
    }

    private String addLastName() {
        clinterface.printToConsole("Last Name: ");
        return clinterface.input.nextLine().trim();
    }

    private String addAddress() {
        clinterface.printToConsole("Address (One Line):");
        return clinterface.input.nextLine().trim();
    }

    private String addCity() {
        clinterface.printToConsole("City: ");
        return clinterface.input.nextLine().trim();
    }

    private String addPostCode() {
        clinterface.printToConsole("Postcode:");
        return clinterface.input.nextLine().trim();
    }

    private String addPhoneNumber() {
        clinterface.printToConsole("Phone number:");
        return clinterface.input.nextLine().trim();
    }

}
