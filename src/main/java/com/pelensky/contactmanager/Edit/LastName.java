package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.Contact;

public class LastName implements EditOption{

    private Contact contact;

    LastName(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setLastName(text);
        return "Last name set to " + text;
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 2;
    }
}
