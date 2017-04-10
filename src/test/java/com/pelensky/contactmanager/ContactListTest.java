package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactListTest {

    private ContactList contactList;
    private Contact danPelensky;

    @Before
    public void setUp() {
        contactList = new ContactList();
        danPelensky = new Contact("Dan", "Pelensky", "1 Commercial Street", "London", "E16LT", "07000 000 000");
    }

    @Test
    public void addContact() {
        contactList.addContact(danPelensky);
        assertEquals(contactList.getContacts().get(0), danPelensky);
    }



}
