package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CLInterfaceTest {

  private CLInterface clInterface;
  private BufferedReader input;
  private PrintStream output;
  private ByteArrayOutputStream out;

  @Before
  public void setup() {
    input = new BufferedReader(new InputStreamReader(System.in));
    out = new ByteArrayOutputStream();
    output = new PrintStream(out);
  }

  @Test
  public void interfaceTakesAnInputStream() {
    clInterface = new CLInterface(input, output);
    assertEquals(input, clInterface.input);
  }
}
