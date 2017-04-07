package com.pelensky.contactmanager;

import java.io.BufferedReader;
import java.io.PrintStream;


class CLInterface {

    BufferedReader input;
    PrintStream output;


    CLInterface(BufferedReader input, PrintStream output) {
        this.input = input;
        this.output = output;
    }
}
