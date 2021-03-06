package com.pelensky.contactmanager;

import com.pelensky.contactmanager.CommandLineApp.AppRunner;
import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.ContactList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AppRunnerTest {

  private PrintStream output;
  private ByteArrayOutputStream out;
  private ContactList contactList;

  @Before
  public void setup() {
    out = new ByteArrayOutputStream();
    output = new PrintStream(out);
    contactList = new ContactList();
  }

  private void setUpAndRun(String source, PrintStream output, ContactList contactList) {
    Scanner scanner = new Scanner(source);
    AppRunner appRunner = new AppRunner(contactList, new IO(scanner, output));
    appRunner.runApp();
  }

  @Test
  public void welcomesUser() {
    setUpAndRun("5", output, contactList);
    assertThat(out.toString(), containsString("Contact Manager"));
  }

  @Test
  public void quitsAppWhenUserTypesQuit() {
    setUpAndRun("5", output, contactList);
    assertThat(out.toString(), containsString("Contact Manager Quitting"));
  }

  @Test
  public void askUserAgainIfInvalidSelection() {
    setUpAndRun("asdfg\n5", output, contactList);
    assertThat(out.toString(), containsString("Invalid selection\n"));
  }

  @Test
  public void userAddsANewContact() {
    setUpAndRun(
        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n5\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Dan Pelensky has been added as a contact."));
  }

  @Test
  public void userListsContacts() {
    setUpAndRun(
        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n2\n2\n5\n",
        output,
        contactList);
    assertThat(
        out.toString(),
        containsString("1) Dan Pelensky\n1 Commercial Street\nLondon E16LT\n07000 000 000"));
  }

  @Test
  public void userTriesToListContacts() {
    setUpAndRun("2\n5\n", output, contactList);
    assertThat(out.toString(), containsString("No contacts"));
  }

  @Test
  public void userEditsContact() {
    setUpAndRun(
        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n3\n2\n1\n2\nTheMan\n2\n2\n5\n",
        output,
        contactList);
    assertThat(
        out.toString(),
        containsString("1) Dan TheMan\n1 Commercial Street\nLondon E16LT\n07000 000 000"));
  }

  @Test
  public void userTriesToEditContactsWhenThereAreNone() {
    setUpAndRun("3\n5\n", output, contactList);
    assertThat(out.toString(), containsString("No contacts to edit"));
  }

  @Test
  public void userDeletesContact() {
    setUpAndRun(
        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n4\n2\n1\n5\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Deleted"));
  }

  @Test
  public void userTriesToDeleteContact() {
    setUpAndRun(
        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n4\n2\n2\n5\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Invalid selection"));
  }

  @Test
  public void userSelectsDefault() {
    setUpAndRun(
            "default\n5\n",
            output,
            contactList);
    assertThat(out.toString(), containsString("Invalid selection"));
  }

  @Test
  public void userTriesToDeleteContactWhenThereAreNone() {
    setUpAndRun("4\n5\n", output, contactList);
    assertThat(out.toString(), containsString("No contacts to delete"));
  }

  @Test
  public void userSearchesForContact() {
    setUpAndRun(
            "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n2\n1\nPelensky\n5\n",
            output,
            contactList);
    assertThat(out.toString(), containsString("1 Contact(s) Found"));
  }

  @Test
  public void userSearchesForContactThatDoesntExist() {
    setUpAndRun(
            "2\n5\n",
            output,
            contactList);
    assertThat(out.toString(), containsString("No contacts"));
  }

  @Test
  public void userSearchesForContactNotInList() {
    setUpAndRun(
            "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n2\n1\nTimmy\n5\n",
            output,
            contactList);
    assertThat(out.toString(), containsString("No match"));
  }

  @Test
  public void userTriesToEditContactNotInList() {
    setUpAndRun(
            "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n3\n1\nTimmy\n5\n",
            output,
            contactList);
    assertThat(out.toString(), containsString("No match"));
  }

  @Test
  public void userSelectsWrongOptionWhenEditing() {
    setUpAndRun(
            "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n3\n1\nDan\n1\n10\n10\n5",
            output,
            contactList);
    assertThat(out.toString(), containsString("Invalid Selection"));
  }

  @Test
  public void userSearchesForContactToEdit() {
    setUpAndRun(
            "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n3\n1\nDan\n1\n1\nDaniel\n5\n",
            output,
            contactList);
    assertThat(out.toString(), containsString("First name set to Daniel"));
  }


}
