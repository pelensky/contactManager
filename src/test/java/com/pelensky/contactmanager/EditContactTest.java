package com.pelensky.contactmanager;

import com.pelensky.contactmanager.CommandLineApp.Menu;
import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainModels.ContactList;
import com.pelensky.contactmanager.Options.Edit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditContactTest {
  private ContactList contactList;
  private Contact danPelensky;
  private Edit editContact;

  @Before
  public void setUp() {
    contactList = new ContactList();
    danPelensky =
        new Contact("Dan", "Pelensky", "1 Commercial Street", "London", "E16LT", "07000 000 000");
    contactList.addContact(danPelensky);
    editContact = new Edit(danPelensky);
  }

  @Test
  public void showSelectionNumbers() {
    editContact.contact = danPelensky;
    Menu menu = new Menu(editContact.io, editContact.listOfEditOptions());
    menu.selectAndExecute();
    assertEquals(
        "1)Dan\n2)Pelensky\n3)1 Commercial Street\n4)London\n5)E16LT\n6)07000 000 000",
        editContact.showNumbersToEditOnContact(danPelensky));
  }


  @Test
  public void changeSelectedFieldFirstName() {
    editContact.contact = danPelensky;
    Menu menu = new Menu(editContact.io, editContact.listOfEditOptions());
    menu.selectAndExecute();
    editContact.editField(1, "Paul");
    assertEquals("Paul", danPelensky.getFirstName());
  }

  @Test
  public void changeSelectedFieldLastName() {
    editContact.contact = danPelensky;
    Menu menu = new Menu(editContact.io, editContact.listOfEditOptions());
    menu.selectAndExecute();
    editContact.editField(2, "TheMan");
    assertEquals("TheMan", danPelensky.getLastName());
  }

  @Test
  public void changeSelectedFieldAddress() {
    editContact.contact = danPelensky;
    Menu menu = new Menu(editContact.io, editContact.listOfEditOptions());
    menu.selectAndExecute();
    editContact.editField(3, "2 Commercial Street");
    assertEquals("2 Commercial Street", danPelensky.getAddress());
  }

  @Test
  public void changeSelectedFieldCity() {
    editContact.contact = danPelensky;
    Menu menu = new Menu(editContact.io, editContact.listOfEditOptions());
    menu.selectAndExecute();
    editContact.editField(4, "Melbourne");
    assertEquals("Melbourne", danPelensky.getCity());
  }

  @Test
  public void changeSelectedFieldPostCode() {
    editContact.contact = danPelensky;
    Menu menu = new Menu(editContact.io, editContact.listOfEditOptions());
    menu.selectAndExecute();
    editContact.editField(5, "E1100");
    assertEquals("E1100", danPelensky.getPostCode());
  }

  @Test
  public void changeSelectedFieldPhone() {
    editContact.contact = danPelensky;
    Menu menu = new Menu(editContact.io, editContact.listOfEditOptions());
    menu.selectAndExecute();
    editContact.editField(6, "07111 111 111");
    assertEquals("07111 111 111", danPelensky.getPhoneNumber());
  }
}
