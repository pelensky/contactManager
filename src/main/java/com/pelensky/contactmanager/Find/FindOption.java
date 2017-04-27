package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.DomainModels.Contact;

public interface FindOption {
    boolean canRespondTo(int number);
    Contact execute();
}
