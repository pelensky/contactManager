package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainServices.ManipulateContacts;
import com.pelensky.contactmanager.Find.*;
import com.pelensky.contactmanager.CommandLineApp.IO;

import java.util.Arrays;
import java.util.List;

public class Find implements Option {

    private IO io;
    private ManipulateContacts manipulateContacts;

    public Find(IO io, ManipulateContacts manipulateContacts) {
        this.io = io;
        this.manipulateContacts = manipulateContacts;
    }
    @Override
    public void execute() {
        if (isContactListEmpty()){
            io.displayText("No contacts");
        } else {
            int number = getChoiceForSearch();
            findForManipulation(number);
        }
    }

    @Override
    public String instruction() {
        return "Find a contact";
    }

    private boolean isContactListEmpty() {
        return manipulateContacts.isContactListEmpty();
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
                new Search(io, manipulateContacts),
                new Show(io, manipulateContacts)
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

