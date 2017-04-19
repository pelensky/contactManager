package com.pelensky.contactmanager;

import java.io.PrintStream;
import java.util.Scanner;

public class IO {

    Scanner input;
    private PrintStream output;

    IO(Scanner input, PrintStream output){
        this.input = input;
        this.output = output;
    }

    String getUserInput() {
        return input.nextLine().trim();
    }

    void printToConsole(String text) {
        output.println(text);
    }
    }
