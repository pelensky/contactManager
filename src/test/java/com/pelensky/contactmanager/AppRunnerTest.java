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
    AppRunner appRunner = new AppRunner(contactList, new IO(scanner, output));
    appRunner.runApp();
  }

  @Test
  public void welcomesUser() {
    setUpAndRun("quit", output, contactList);
    assertThat(out.toString(), containsString("Contact Manager"));
    assertThat(out.toString(), containsString("Type `quit` to quit"));
  }

  @Test
  public void quitsAppWhenUserTypesQuit() {
    setUpAndRun("quit", output, contactList);
    assertThat(out.toString(), containsString("Contact Manager Quitting"));
  }

  @Test
  public void askUserAgainIfInvalidSelection() {
    setUpAndRun("asdfg\nquit", output, contactList);
    assertThat(out.toString(), containsString("Invalid selection\n"));
  }

  @Test
  public void userAddsANewContact() {
    setUpAndRun(
        "add\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nquit\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Dan Pelensky has been added as a contact."));
  }

  @Test
  public void userListsContacts() {
    setUpAndRun(
        "add\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nshow\nquit\n",
        output,
        contactList);
    assertThat(
        out.toString(),
        containsString("1) Dan Pelensky\n1 Commercial Street\nLondon E16LT\n07000 000 000"));
  }

  @Test
  public void userTriesToListContacts() {
    setUpAndRun("show\nquit\n", output, contactList);
    assertThat(out.toString(), containsString("No contacts to show"));
  }

  @Test
  public void userEditsContact() {
    setUpAndRun(
        "add\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nedit\n1\n2\nTheMan\nshow\nquit\n",
        output,
        contactList);
    assertThat(
        out.toString(),
        containsString("1) Dan TheMan\n1 Commercial Street\nLondon E16LT\n07000 000 000"));
  }

  @Test
  public void userTriesToEditContact() {
    setUpAndRun(
        "add\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nedit\n2\nquit\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Contact does not exist\nTry again"));
  }

  @Test
  public void userTriesToEditContactsWhenThereAreNone() {
    setUpAndRun("edit\nquit\n", output, contactList);
    assertThat(out.toString(), containsString("No contacts to edit"));
  }

  @Test
  public void userDeletesContact() {
    setUpAndRun(
        "add\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nadd\nTimmy\nPelensky\n2 Commercial Street\nLondon\nE11AG\n07111 111 111\ndelete\n2\nquit\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Deleted"));
  }

  @Test
  public void userTriesToDeleteContact() {
    setUpAndRun(
        "add\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\ndelete\n2\nquit\n",
        output,
        contactList);
    assertThat(out.toString(), containsString("Contact does not exist\nTry again"));
  }

  @Test
  public void userTriesToDeleteContactWhenThereAreNone() {
    setUpAndRun("delete\nquit\n", output, contactList);
    assertThat(out.toString(), containsString("No contacts to delete"));
  }
}
