package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;

public class PostCode extends EditOption{

    private Contact contact;

    public PostCode(IO io, Contact contact) {
        super(io);
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setPostCode(text);
        return "Post code set to " + text;
    }

    @Override
    public String get() {
        return contact.getPostCode();
    }
}
