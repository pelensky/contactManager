package com.pelensky.contactmanager.App;

import com.pelensky.contactmanager.AppRunner;
import com.pelensky.contactmanager.ContactList;
import com.pelensky.contactmanager.DisplayContacts;
import com.pelensky.contactmanager.IO;

import java.io.PrintStream;
import java.util.Scanner;

public class ContactManager {

  public static void main(String[] args) {
    ContactList contactList = new ContactList();
    AppRunner appRunner = new AppRunner(contactList, new IO(new Scanner(System.in), new PrintStream(System.out)), new DisplayContacts(contactList));
    appRunner.runApp();
  }
}
