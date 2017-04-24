package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ContactListTest {

  private ContactList contactList;
  private Contact danPelensky;
  private DisplayContacts displayContacts;

  @Before
  public void setUp() {
    contactList = new ContactList();
    danPelensky =
        new Contact("Dan", "Pelensky", "1 Commercial Street", "London", "E16LT", "07000 000 000");
    contactList.addContact(danPelensky);
    displayContacts = new DisplayContacts(contactList);
  }

  @Test
  public void addContact() {
    assertEquals(contactList.getContacts().get(0), danPelensky);
  }

  @Test
  public void showFormattedContact() {
    assertEquals("1) Dan Pelensky\n1 Commercial Street\nLondon E16LT\n07000 000 000", displayContacts.listContacts());
  }

  @Test
  public void showASecondContact() {
    Contact timmyPelensky = new Contact("Timmy", "Pelensky", "2 Commercial Street", "London", "E11AG", "07111 111 111");
    contactList.addContact(timmyPelensky);
    assertThat(displayContacts.listContacts(), containsString("1) Dan Pelensky\n1 Commercial Street\nLondon E16LT\n07000 000 000\n2) Timmy Pelensky\n2 Commercial Street\nLondon E11AG\n07111 111 111"));
  }

  @Test
  public void countNumberOfContacts() {
    assertEquals(1, contactList.countContacts());
  }
}
