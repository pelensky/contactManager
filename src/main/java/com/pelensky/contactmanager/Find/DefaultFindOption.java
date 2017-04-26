package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.Contact;

public class DefaultFindOption implements FindOption {

    @Override
    public void executeForView() {}

    @Override
    public boolean canRespondTo(int number) {
        return false;
    }

    @Override
    public Contact executeForManipulation() {
        return null;
    }

}
