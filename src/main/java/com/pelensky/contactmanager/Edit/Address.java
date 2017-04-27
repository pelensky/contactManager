package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;

public class Address extends EditOption {

    private Contact contact;

    public Address(IO io, Contact contact) {
        super(io);
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setAddress(text);
        return "Address set to " + text;
    }

    @Override
    public String instructions() {
        return contact.getAddress();
    }
}
