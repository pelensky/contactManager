package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CLInterfaceTest {

  private CLInterface clInterface;
  private BufferedReader inputQuit;
  private PrintStream output;
  private ByteArrayOutputStream out;


  @Before
  public void setup() {
    inputQuit = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("quit".getBytes())));
    out = new ByteArrayOutputStream();
    output = new PrintStream(out);
  }

  @Test
  public void interfaceTakesABufferedReader() {
    clInterface = new CLInterface(inputQuit, output);
    assertEquals(inputQuit, clInterface.input);
  }

  @Test
  public void interfacesTakesAPrintStream() {
    clInterface = new CLInterface(inputQuit, output);
    assertEquals(output, clInterface.output);
  }

  @Test
  public void welcomesUser() {
    clInterface = new CLInterface(inputQuit, output);
    clInterface.runApp();
    assertThat(out.toString(), containsString("Contact Manager\n"));
  }

  @Test
  public void quitsAppWhenUserTypesQuit(){
    clInterface = new CLInterface(inputQuit, output);
    clInterface.runApp();
    assertThat(out.toString(), containsString("See you next time!\n"));
  }
}
