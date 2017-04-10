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
    input= new Scanner("quit");
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
  }

  @Test
  public void quitsAppWhenUserTypesQuit(){
    clInterface = new CLInterface(input, output);
    clInterface.runApp();
    assertThat(out.toString(), containsString("See you next time!\n"));
  }
}
