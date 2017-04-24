package com.pelensky.contactmanager;

import java.io.PrintStream;
import java.util.Scanner;

public class ContactManager {

  public static void main(String[] args) {
    AppRunner appRunner = new AppRunner(new ContactList(), new IO(new Scanner(System.in), new PrintStream(System.out)), new DisplayContacts(new ContactList()));
    appRunner.runApp();
  }
}
