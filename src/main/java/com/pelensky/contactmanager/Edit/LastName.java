package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;

public class LastName extends EditOption{

    private Contact contact;

    public LastName(IO io, Contact contact) {
        super(io);
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setLastName(text);
        return "Last name set to " + text;
    }
    @Override
    public String instructions() {
        return contact.getLastName();
    }

}
