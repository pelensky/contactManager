package com.pelensky.contactmanager.DomainServices;

import com.pelensky.contactmanager.Edit.*;
import com.pelensky.contactmanager.DomainModels.Contact;

import java.util.Arrays;
import java.util.List;

public class EditContact {

    private Contact contact;

    public EditContact(Contact contact) {
        this.contact = contact;
    }

    private String formatContactForSelection() {
        return "1)"
                + contact.getFirstName()
                + System.lineSeparator()
                + "2)"
                + contact.getLastName()
                + System.lineSeparator()
                + "3)"
                + contact.getAddress()
                + System.lineSeparator()
                + "4)"
                + contact.getCity()
                + System.lineSeparator()
                + "5)"
                + contact.getPostCode()
                + System.lineSeparator()
                + "6)"
                + contact.getPhoneNumber();
    }

    public String showNumbersToEditOnContact(Contact contact) {
        this.contact = contact;
       return formatContactForSelection();
    }

    public String editField(int number, String text) {
        EditOption editOptions = chooseEditOption(number);
        return editOptions.execute(text);
    }

    private List<EditOption> listOfEditOptions() {
        return Arrays.asList(
                new FirstName(contact),
                new LastName(contact),
                new Address(contact),
                new City(contact),
                new PostCode(contact),
                new PhoneNumber(contact));
    }

    private EditOption chooseEditOption(int number) {
        for (EditOption editOption : listOfEditOptions()) {
            if (editOption.canRespondTo(number)) {
                return editOption;
            }
        }
        return new DefaultEditOption();
    }
}
