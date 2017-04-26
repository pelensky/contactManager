package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.Contact;
import com.pelensky.contactmanager.ContactList;
import com.pelensky.contactmanager.DisplayContacts;
import com.pelensky.contactmanager.Find.*;
import com.pelensky.contactmanager.IO;

import java.util.Arrays;
import java.util.List;

public class Find implements Option {

    private IO io;
    private ContactList contactList;
    private DisplayContacts displayContacts;

    public Find(IO io, ContactList contactList, DisplayContacts displayContacts) {
        this.io = io;
        this.contactList = contactList;
        this.displayContacts = displayContacts;
    }
    @Override
    public void execute() {
        if (isContactListEmpty()){
            io.displayText("No contacts");
        } else {
            int number = getChoiceForSearch();
            findForView(number);
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("2");
    }

    @Override
    public String instruction() {
        return "2) Find a contact";
    }

    private boolean isContactListEmpty() {
        return displayContacts.isContactListEmpty();
    }

    int getChoiceForSearch() {
        io.displayText("1) Search for contact" + System.lineSeparator() + "2) Show all contacts");
        return Integer.parseInt(io.getUserInput());
    }

    private void findForView(int number) {
        FindOption findOption = chooseFindOption(number);
        assert findOption != null;
        findOption.executeForView();
    }

    Contact findForManipulation(int number) {
        FindOption findOption = chooseFindOption(number);
        assert findOption != null;
        return findOption.executeForManipulation();
    }

    private List<FindOption> listOfFindOptions(){
        return Arrays.asList(
                new Search(io, displayContacts),
                new Show(io,  displayContacts)
        );
    }

    private FindOption chooseFindOption(int number) {
        for (FindOption findOption : listOfFindOptions()) {
            if (findOption.canRespondTo(number)){
                return findOption;
            }
        }
        return null;
    }
}

