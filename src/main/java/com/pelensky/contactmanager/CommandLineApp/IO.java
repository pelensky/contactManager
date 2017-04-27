package com.pelensky.contactmanager.CommandLineApp;

import java.io.PrintStream;
import java.util.Scanner;

public class IO {

  private Scanner input;
  private PrintStream output;

  public IO(Scanner input, PrintStream output) {
    this.input = input;
    this.output = output;
  }

  public String getUserInput() {
    return input.nextLine().trim();
  }

  public void displayText(String text) {
    output.println(text);
  }


}
