package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.DomainModels.Contact;

public class Address implements EditOption{

    private Contact contact;

    public Address(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setAddress(text);
        return "Address set to " + text;
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 3;
    }
}
