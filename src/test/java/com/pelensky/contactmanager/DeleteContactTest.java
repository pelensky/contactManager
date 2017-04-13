package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteContactTest {
    private DeleteContact deleteContact;
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
        deleteContact = new DeleteContact(contactList);
    }

    @Test
    public void deleteContact() {
        deleteContact.delete(2);
       assertFalse(deleteContact.contactList.getContacts().contains(timmyPelensky));
    }


}
