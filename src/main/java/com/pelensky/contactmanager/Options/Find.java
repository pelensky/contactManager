package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.ContactList;
import com.pelensky.contactmanager.DisplayContacts;
import com.pelensky.contactmanager.Find.FindOption;
import com.pelensky.contactmanager.Find.Search;
import com.pelensky.contactmanager.Find.Show;
import com.pelensky.contactmanager.Find.DefaultFindOption;
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
            io.displayText("1) Search for contact" + System.lineSeparator() + "2) Show all contacts");
            chooseHowToFind(Integer.parseInt(io.getUserInput()));
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

    private void chooseHowToFind(int number) {
        FindOption findOption = chooseFindOption(number);
        findOption.execute();
    }

    private List<FindOption> listOfFindOptions(){
        return Arrays.asList(
                new Search(io, displayContacts),
                new Show(io, contactList, displayContacts)
        );
    }

    private FindOption chooseFindOption(int number) {
        for (FindOption findOption : listOfFindOptions()) {
            if (findOption.canRespondTo(number)){
                return findOption;
            }
        }
        return new DefaultFindOption();
    }
}

