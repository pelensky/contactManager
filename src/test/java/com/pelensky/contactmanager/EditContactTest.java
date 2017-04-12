package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditContactTest {
    private EditContact editContact;
    private ContactList contactList;
    private Contact danPelensky;

    @Before
    public void setUp() {
        contactList = new ContactList();
        danPelensky =
                new Contact("Dan", "Pelensky", "1 Commercial Street", "London", "E16LT", "07000 000 000");
        contactList.addContact(danPelensky);
        editContact = new EditContact(contactList);
    }

      @Test
    public void showSelectionNumbers() {
        assertEquals("1)Dan\n2)Pelensky\n3)1 Commercial Street\n4)London\n5)E16LT\n6)07000 000 000", editContact.showSelectionNumbers(1));
    }

    @Test
    public void selectFieldToEdit() {
        editContact.showSelectionNumbers(1);
        assertEquals("Pelensky", editContact.selectField(2));
    }

    @Test
    public void changeSelectedField() {
        editContact.showSelectionNumbers(1);
        editContact.updateContact(2, "TheMan");
        assertEquals("TheMan", danPelensky.getLastName());
    }






}
