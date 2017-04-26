package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.Contact;

public class PhoneNumber implements EditOption{

    private Contact contact;

    public PhoneNumber(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setPhoneNumber(text);
        return "Phone number set to " + text;
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 6;
    }
}
