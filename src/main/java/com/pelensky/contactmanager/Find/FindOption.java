package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.Contact;

public interface FindOption {
    void executeForView();

    boolean canRespondTo(int number);

    Contact executeForManipulation();
}
