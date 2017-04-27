package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;

public class PhoneNumber extends EditOption {

    private Contact contact;

    public PhoneNumber(IO io, Contact contact) {
        super(io);
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setPhoneNumber(text);
        return "Phone number set to " + text;
    }

    @Override
    public String instructions() {
        return contact.getPhoneNumber();
    }
}
