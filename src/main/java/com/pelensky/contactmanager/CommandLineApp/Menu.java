package com.pelensky.contactmanager.CommandLineApp;

import com.pelensky.contactmanager.Options.Option;

import java.util.List;

public class Menu {
    private IO io;
    private List<Option> options;

    public Menu(IO io, List<Option> options){
        this.io = io;
        this.options = options;
    }

    public void selectAndExecute(){
        io.displayText(printInstructions());
        executeOption(chooseOption());
    }

    private String printInstructions(){
        StringBuilder instructions = new StringBuilder();
        for (int i=0; i < options.size(); i++){
            instructions.append(i + 1).append(") ").append(options.get(i).instruction()).append(System.lineSeparator());
        }
        return instructions.toString().trim();
    }

    int chooseOption(){
       return Integer.parseInt(io.getUserInput());
    }

    void executeOption(int choice){
        Option option = options.get(choice - 1);
        option.execute();
    }


}
