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
    danPelensky =
        new Contact("Dan", "Pelensky", "1 Commercial Street", "London", "E16LT", "07000 000 000");
    contactList.addContact(danPelensky);
  }

  @Test
  public void addContact() {
    assertEquals(contactList.getContacts().get(0), danPelensky);
  }

  @Test
  public void showFormattedContact() {
    assertEquals("Dan Pelensky\n1 Commercial Street\nLondon E16LT\n07000 000 000", contactList.formatContact());
  }
}
