package com.pelensky.contactmanager;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainModels.ContactList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteContactTest {
    private ContactList contactList;
    private Contact danPelensky;
    private Contact timmyPelensky;

    @Before
    public void setUp() {
        contactList = new ContactList();
        danPelensky =
                new Contact("Dan", "Pelensky", "1 Commercial Street", "London", "E16LT", "07000 000 000");
        timmyPelensky = new Contact("Timmy", "Pelensky", "2 Commercial Street", "London", "E16LT", "07111 111 111");
        contactList.addContact(danPelensky);
        contactList.addContact((timmyPelensky));
    }

    @Test
    public void deleteContact() {
        contactList.deleteContact(timmyPelensky);
       assertFalse(contactList.getContacts().contains(timmyPelensky));
    }


}
