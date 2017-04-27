package com.pelensky.contactmanager.CommandLineApp;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.Options.Option;

import java.util.List;

public class Menu {
    private IO io;
    private List<Option> options;

    Menu(IO io, List<Option> options){
        this.io = io;
        this.options = options;
    }

    public void selectAndExecute(){
        io.displayText(printInstructions());
    }

    public String printInstructions(){
        StringBuilder instructions = new StringBuilder();
        for (int i=0; i < options.size(); i++){
            instructions.append(i + 1).append(") ").append(options.get(i).getClass().getSimpleName()).append(System.lineSeparator());
        }
        return instructions.toString();
    }
}
