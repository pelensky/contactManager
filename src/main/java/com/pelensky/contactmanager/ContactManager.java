package com.pelensky.contactmanager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(System.out);
        ContactList contactList = new ContactList();
        CLInterface clInterface = new CLInterface(input, output, contactList);
        clInterface.runApp();
    }

}
