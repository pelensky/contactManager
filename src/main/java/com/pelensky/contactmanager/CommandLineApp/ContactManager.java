package com.pelensky.contactmanager.CommandLineApp;

import com.pelensky.contactmanager.DomainModels.ContactList;

import java.io.PrintStream;
import java.util.Scanner;

public class ContactManager {

  public static void main(String[] args) {
    ContactList contactList = new ContactList();
    AppRunner appRunner = new AppRunner(contactList, new IO(new Scanner(System.in), new PrintStream(System.out)));
    appRunner.runApp();
  }
}
