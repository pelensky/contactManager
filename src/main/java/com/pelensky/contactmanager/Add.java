package com.pelensky.contactmanager;

public class Add implements Option {

    private IO io;
    ContactList contactList;

    Add(IO io, ContactList contactList){
        this.io = io;
        this.contactList = contactList;
    }

    public String instruction() {
      return "Type `add` to add a new contact";
    }

    @Override
    public void execute() {
        io.displayText("Add a new contact");
        Contact newContact =
                new Contact(
                        addContactInfo("First Name: "),
                        addContactInfo("Last Name: "),
                        addContactInfo("Address (One Line): "),
                        addContactInfo("City: "),
                        addContactInfo("Postcode: "),
                        addContactInfo("Phone number: "));
        addContact(newContact);
        io.displayText(
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
        io.displayText(text);
        return io.getUserInput();
    }

    private void addContact(Contact newContact) {
        contactList.addContact((newContact));
    }
 }
