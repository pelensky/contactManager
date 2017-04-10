package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CLInterfaceTest {

  private CLInterface clInterface;
  private Scanner input;
  private PrintStream output;
  private ByteArrayOutputStream out;


  @Before
  public void setup() {
    input = new Scanner("quit");
    out = new ByteArrayOutputStream();
    output = new PrintStream(out);
  }

  @Test
  public void interfaceTakesABufferedReader() {
    clInterface = new CLInterface(input, output);
    assertEquals(input, clInterface.input);
  }

  @Test
  public void interfacesTakesAPrintStream() {
    clInterface = new CLInterface(input, output);
    assertEquals(output, clInterface.output);
  }

  @Test
  public void welcomesUser() {
    clInterface = new CLInterface(input, output);
    clInterface.runApp();
    assertThat(out.toString(), containsString("Contact Manager\n"));
    assertThat(out.toString(), containsString("Type `quit` to quit.\n"));
  }

  @Test
  public void quitsAppWhenUserTypesQuit(){
    clInterface = new CLInterface(input, output);
    clInterface.runApp();
    assertThat(out.toString(), containsString("See you next time!\n"));
  }

  @Test
  public void askUserAgainIfInvalidSelection(){
    Scanner invalidInput = new Scanner("asdfg\n quit");
    clInterface = new CLInterface(invalidInput, output);
    clInterface.runApp();
    assertThat(out.toString(), containsString("I didn't quite get that\n"));
  }

  @Test
  public void userAddsANewContact(){
    Scanner newContact = new Scanner("new\n Dan\n Pelensky\n 1 Commercial Street\n London\n E16LT\n 07000 000 000\n quit\n");
    clInterface = new CLInterface(newContact, output);
    clInterface.runApp();
    assertThat(out.toString(), containsString("Dan Pelensky has been added as a contact."));
  }

}
