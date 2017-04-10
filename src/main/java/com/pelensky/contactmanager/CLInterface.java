package com.pelensky.contactmanager;

import java.io.*;
import java.util.Scanner;


class CLInterface {

    Scanner input;
    PrintStream output;


    CLInterface(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    void runApp() {
        output.println("Contact Manager");
    }

}





