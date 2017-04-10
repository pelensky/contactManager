package com.pelensky.contactmanager;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;


class CLInterface {

    ByteArrayInputStream input;
    PrintStream output;


    CLInterface(ByteArrayInputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    void runApp(){
        output.println("Contact Manager");
    }
}
