package com.pelensky.contactmanager;

import java.io.PrintStream;
import java.util.Scanner;

public class IO {

  private Scanner input;
  private PrintStream output;

  IO(Scanner input, PrintStream output) {
    this.input = input;
    this.output = output;
  }

  String getUserInput() {
    return input.nextLine().trim();
  }

  void printText(String text) {
    output.println(text);
  }
}
