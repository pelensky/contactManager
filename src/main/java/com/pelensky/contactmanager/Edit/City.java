package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.Contact;

public class City implements EditOption{

    private Contact contact;

    City(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setCity(text);
        return "City set to " + text;
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 4;
    }
}
