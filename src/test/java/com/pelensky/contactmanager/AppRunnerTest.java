package com.pelensky.contactmanager;

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
    AppRunner appRunner = new AppRunner(contactList, new IO(scanner, output), new DisplayContacts(contactList));
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

//  @Test
//  public void userTriesToEditContact() {
//    setUpAndRun(
//        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n3\n2\n2\n5\n",
//        output,
//        contactList);
//    assertThat(out.toString(), containsString("Contact does not exist"));
//  }

  @Test
  public void userTriesToEditContactsWhenThereAreNone() {
    setUpAndRun("3\n5\n", output, contactList);
    assertThat(out.toString(), containsString("No contacts to edit"));
  }

  @Test
  public void userDeletesContact() {
    setUpAndRun(
        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n4\n1\n5\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Deleted"));
  }

  @Test
  public void userTriesToDeleteContact() {
    setUpAndRun(
        "1\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\n4\n2\n5\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Contact does not exist\nTry again"));
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
    assertThat(out.toString(), containsString("No contacts to deleteContact"));
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
            "2\nPelensky\n5\n",
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

}
