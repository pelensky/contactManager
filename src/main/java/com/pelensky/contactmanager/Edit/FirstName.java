package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.Contact;

public class FirstName implements EditOption{

    private Contact contact;

    FirstName(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setFirstName(text);
        return "First name set to " + text;
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 1;
    }
}
