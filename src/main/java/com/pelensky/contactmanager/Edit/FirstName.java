package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;

public class FirstName extends EditOption {

    private Contact contact;

    public FirstName(IO io, Contact contact) {
        super(io);
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setFirstName(text);
        return "First name set to " + text;
    }

    @Override
    public String get() {
        return contact.getFirstName();
    }
}
