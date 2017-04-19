package com.pelensky.contactmanager;

public class Add implements Option {

    private IO io;
    ContactList contactList;

    Add(IO io, ContactList contactList){
        this.io = io;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        io.printText("Add a new contact");
        Contact newContact =
                new Contact(
                        addContactInfo("First Name: "),
                        addContactInfo("Last Name: "),
                        addContactInfo("Address (One Line): "),
                        addContactInfo("City: "),
                        addContactInfo("Postcode: "),
                        addContactInfo("Phone number: "));
        contactList.addContact(newContact);
        io.printText(
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
        io.printText(text);
        return io.getUserInput();
    }
 }
