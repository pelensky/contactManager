package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;

public class City extends EditOption{

    private Contact contact;

    public City(IO io, Contact contact) {
        super(io);
        this.contact = contact;
    }

    @Override
    public String execute(String text) {
        contact.setCity(text);
        return "City set to " + text;
    }

    @Override
    public String instructions() {
        return contact.getCity();
    }

}
