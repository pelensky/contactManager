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
  public void changeSelectedFieldFirstName() {
    editContact.showSelectionNumbers(1);
    editContact.editField(1, "Paul");
    assertEquals("Paul", danPelensky.getFirstName());
  }

  @Test
  public void changeSelectedFieldLastName() {
    editContact.showSelectionNumbers(1);
    editContact.editField(2, "TheMan");
    assertEquals("TheMan", danPelensky.getLastName());
  }

  @Test
  public void changeSelectedFieldAddress() {
    editContact.showSelectionNumbers(1);
    editContact.editField(3, "2 Commercial Street");
    assertEquals("2 Commercial Street", danPelensky.getAddress());
  }

  @Test
  public void changeSelectedFieldCity() {
    editContact.showSelectionNumbers(1);
    editContact.editField(4, "Melbourne");
    assertEquals("Melbourne", danPelensky.getCity());
  }

  @Test
  public void changeSelectedFieldPostCode() {
    editContact.showSelectionNumbers(1);
    editContact.editField(5, "E1100");
    assertEquals("E1100", danPelensky.getPostCode());
  }

  @Test
  public void changeSelectedFieldPhone() {
    editContact.showSelectionNumbers(1);
    editContact.editField(6, "07111 111 111");
    assertEquals("07111 111 111", danPelensky.getPhoneNumber());
  }
}
