package com.pelensky.contactmanager;

import java.io.PrintStream;
import java.util.Scanner;

public class ContactManager {

  public static void main(String[] args) {
    CLInterface clInterface = new CLInterface(new ContactList(), new IO(new Scanner(System.in), new PrintStream(System.out)));
    clInterface.runApp();
  }
}
