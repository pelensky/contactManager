package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.DomainModels.Contact;

public class PostCode implements EditOption{

    private Contact contact;

    public PostCode(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setPostCode(text);
        return "Post code set to " + text;
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 5;
    }
}
