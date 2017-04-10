package com.pelensky.contactmanager;

import java.io.*;


class CLInterface {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintStream output;


    CLInterface(BufferedReader input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    void runApp() {
        output.println("Contact Manager");
        while (true) {
           getUserInput();
        }
    }


}



