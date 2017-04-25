package com.pelensky.contactmanager;

import com.pelensky.contactmanager.Edit.EditContact;
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
    assertEquals(
        "1)Dan\n2)Pelensky\n3)1 Commercial Street\n4)London\n5)E16LT\n6)07000 000 000",
        editContact.showSelectionNumbers(1));
  }

  @Test
  public void selectFieldToEdit() {
    editContact.showSelectionNumbers(1);
    assertEquals("Dan", editContact.selectField(1));
    assertEquals("Pelensky", editContact.selectField(2));
    assertEquals("1 Commercial Street", editContact.selectField(3));
    assertEquals("London", editContact.selectField(4));
    assertEquals("E16LT", editContact.selectField(5));
    assertEquals("07000 000 000", editContact.selectField(6));
    assertEquals("Invalid selection", editContact.selectField(45));
  }

  @Test
  public void changeSelectedFieldFirstName() {
    editContact.showSelectionNumbers(1);
    editContact.updateContact(1, "Daniel");
    assertEquals("Daniel", danPelensky.getFirstName());
  }

  @Test
  public void changeSelectedFieldLastName() {
    editContact.showSelectionNumbers(1);
    editContact.updateContact(2, "TheMan");
    assertEquals("TheMan", danPelensky.getLastName());
  }

  @Test
  public void changeSelectedFieldAddress() {
    editContact.showSelectionNumbers(1);
    editContact.updateContact(3, "2 Commercial Street");
    assertEquals("2 Commercial Street", danPelensky.getAddress());
  }

  @Test
  public void changeSelectedFieldCity() {
    editContact.showSelectionNumbers(1);
    editContact.updateContact(4, "Melbourne");
    assertEquals("Melbourne", danPelensky.getCity());
  }

  @Test
  public void changeSelectedFieldPostCode() {
    editContact.showSelectionNumbers(1);
    editContact.updateContact(5, "E1100");
    assertEquals("E1100", danPelensky.getPostCode());
  }

  @Test
  public void changeSelectedFieldPhone() {
    editContact.showSelectionNumbers(1);
    editContact.updateContact(6, "07111 111 111");
    assertEquals("07111 111 111", danPelensky.getPhoneNumber());
  }
}
