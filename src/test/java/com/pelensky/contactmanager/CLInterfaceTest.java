package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class CLInterfaceTest {

  private CLInterface clInterface;
  private Scanner input;
  private PrintStream output;
  private ByteArrayOutputStream out;
  private ContactList contactList;

  @Before
  public void setup() {
    input = new Scanner("quit");
    out = new ByteArrayOutputStream();
    output = new PrintStream(out);
    contactList = new ContactList();
  }

  @Test
  public void welcomesUser() {
    clInterface = new CLInterface(input, output, contactList);
    clInterface.runApp();
    assertThat(out.toString(), containsString("Contact Manager\n"));
    assertThat(out.toString(), containsString("Type `quit` to quit.\n"));
  }

  @Test
  public void quitsAppWhenUserTypesQuit(){
    clInterface = new CLInterface(input, output, contactList);
    clInterface.runApp();
    assertThat(out.toString(), containsString("See you next time!\n"));
  }

  @Test
  public void askUserAgainIfInvalidSelection(){
    Scanner invalidInput = new Scanner("asdfg\nquit\n");
    clInterface = new CLInterface(invalidInput, output, contactList);
    clInterface.runApp();
    assertThat(out.toString(), containsString("I didn't quite get that\n"));
  }

  @Test
  public void userAddsANewContact(){
    Scanner newContact = new Scanner("new\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nquit\n");
    clInterface = new CLInterface(newContact, output, contactList);
    clInterface.runApp();
    assertThat(out.toString(), containsString("Dan Pelensky has been added as a contact."));
  }

  @Test
  public void userListsContacts(){
    Scanner createAndListContact = new Scanner("new\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nshow\nquit\n");
    clInterface = new CLInterface(createAndListContact, output, contactList);
    clInterface.runApp();
    assertThat(out.toString(), containsString("1) Dan Pelensky\n1 Commercial Street\nLondon E16LT\n07000 000 000"));
  }

  @Test
  public void userEditsContact(){
    Scanner editContact = new Scanner("new\nDan\nPelensky\n1 Commercial Street\nLondon\nE16LT\n07000 000 000\nedit\n1\n2\nTheMan\nshow\nquit\n");
    clInterface = new CLInterface(editContact, output, contactList);
    clInterface.runApp();
    assertThat(out.toString(), containsString("Dan TheMan\n"));
  }

}
